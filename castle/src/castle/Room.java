package castle;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private String description;
    private Map<String, Room> exits = new HashMap<>();

    public Room(String description) {
        this.description = description;
    }

    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    @Override
    public String toString() {
        return description;
    }

    public String getRoomDirection() {
        StringBuilder sb = new StringBuilder();
        for (String direction : exits.keySet()) {
            sb.append(direction);
            sb.append(' ');
        }
        return sb.toString();
    }

    public Room getNextRoom(String direction) {
        return exits.get(direction);
    }
}
