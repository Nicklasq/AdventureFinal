public class Weapon extends Item {

    private int damage;

    public void use(){

    }

    public Weapon(String name) {
        super(name);

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean canUse(){
        return true;
    }

}
