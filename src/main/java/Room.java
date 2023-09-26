public class Room {

    private String name;
    private String description;
    private Room east;
    private Room north;
    private Room south;
    private Room west;


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.east = null;
        this.north = null;
        this.south = null;
        this.west = null;
    }

    //getter
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getEast() {
        return east;
    }

    public Room getSouth() {
        return south;
    }

    public Room getNorth() {
        return north;
    }

    public Room getWest() {
        return west;
    }

    //Setter
    //public void setName{

    //}

    public void setEast(Room east) {
        this.east = east;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setWest(Room west) {
        this.west = west;
    }


}
