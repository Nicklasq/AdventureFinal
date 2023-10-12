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

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int attack() {
        int damageDealt = 20; // Set the damage dealt by the enemy to 20
        return damageDealt;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}