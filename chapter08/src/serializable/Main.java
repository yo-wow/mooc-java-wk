package serializable;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("obj.dat"));
            Demo outObj = new Demo("No.1", "yo-wow");
            out.writeObject(outObj);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("obj.dat"));
            Demo inObj = (Demo) in.readObject();
            in.close();
            System.out.println(inObj);
            System.out.println(outObj == inObj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

//class Demo { // java.io.NotSerializableException: serializable.Demo
class Demo implements Serializable {
    private String id;
    private String name;

    public Demo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
