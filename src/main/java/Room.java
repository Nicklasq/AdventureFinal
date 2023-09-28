import java.util.ArrayList;

public class Room {

    //need iteam arraylist
    private String name;
    private String description;
    private Room east;
    private Room north;
    private Room south;
    private Room west;

    private ArrayList<Item> items;


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.east = null;
        this.north = null;
        this.south = null;
        this.west = null;
        items = new ArrayList<>();
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
    public void addItem(Item i){
            items.add(i);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
