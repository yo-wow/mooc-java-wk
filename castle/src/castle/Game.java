package castle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private Map<String, Handler> handlers = new HashMap<>();

    public Game() {
        handlers.put("go", new Handler() {
            @Override
            void handle(String word) {
                goRoom(word);
            }
        });
        handlers.put("help", new HandlerHelp());
        handlers.put("bye", new HandlerBye());
        createRooms();
    }

    private void createRooms() {
        Room outside, lobby, pub, study, bedroom;

        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");

        //	初始化房间的出口
        outside.setExit("east", lobby);
        outside.setExit("south", study);
        outside.setExit("west", pub);

        lobby.setExit("west", outside);

        pub.setExit("east", outside);

        study.setExit("south", outside);
        study.setExit("east", bedroom);

        bedroom.setExit("west", study);
        bedroom.setExit("down", outside);

        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        showPrompt();
    }

    private void showPrompt() {
        System.out.println("现在你在" + currentRoom);
        System.out.print("出口有：");
        System.out.print(currentRoom.getRoomDirection());
        System.out.println();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.printWelcome();
        game.start();
    }

    public void goRoom(String direction) {
        Room nextRoom = currentRoom.getNextRoom(direction);
        if (nextRoom == null) {
            System.out.println("那里没有门！");
        } else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            String operate = words[0];
            String direction = "";
            if (words.length > 1) {
                direction = words[1];
            }
            Handler handler = this.handlers.get(operate);
            if (null != handler) {
                handler.handle(direction);
                if (handler.bye()) {
                    break;
                }
            }
        }
        in.close();
    }

}
