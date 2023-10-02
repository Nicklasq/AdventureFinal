public class Food extends Item {
    private int healthPoints;

    public Food(String name, String description, int healthPoints) {
        super(name, description); // Call the constructor of the superclass (Item)
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
}