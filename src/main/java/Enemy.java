public class Enemy {
    private String name;
    private int health;
    private Weapon weapon;

    public Enemy(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int attack() {
        int damageDealt = 20; // Set the damage dealt by the enemy to 30
        return damageDealt;
    }

        public void takeDamage(int damage) {
        // Define the logic for the enemy taking damage here.
        // Reduce the enemy's health by the specified amount of damage.
        // Replace this with your actual damage-taking logic.
        health -= damage;
    }
}