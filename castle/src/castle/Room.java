package castle;

public class Room {
    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    public Room(String description) {
        this.description = description;
    }

    public void setExits(Room north, Room east, Room south, Room west) {
        if (north != null)
            northExit = north;
        if (east != null)
            eastExit = east;
        if (south != null)
            southExit = south;
        if (west != null)
            westExit = west;
    }

    @Override
    public String toString() {
        return description;
    }

    public String getRoomDirection() {
        StringBuilder sb = new StringBuilder();
        if (this.northExit != null)
            sb.append("north ");
        if (this.eastExit != null)
            sb.append("east ");
        if (this.southExit != null)
            sb.append("south ");
        if (this.westExit != null)
            sb.append("west ");
        return sb.toString();
    }

    public Room getNextRoom(String direction) {
        if (direction.equals("north")) {
            return this.northExit;
        }
        if (direction.equals("east")) {
            return this.eastExit;
        }
        if (direction.equals("south")) {
            return this.southExit;
        }
        if (direction.equals("west")) {
            return this.westExit;
        }
        return null;
    }
}
