public class MeleeWeapon extends Weapon {
    public MeleeWeapon(String name, int damage) {
        super(name);
        this.setDamage(damage);
    }


    @Override
    public int remainingAmmo() {
        return 0;
    }

    public boolean canUse(){
        return true;
    }
}
