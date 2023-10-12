public class RangedWeapon extends Weapon {

    private int ammo;

    public RangedWeapon(String name, int damage, int ammo) {
        super(name);
        this.setDamage(damage);
        this.ammo = ammo;
    }

    @Override
    public int remainingAmmo(){
        return ammo --;
    }
    @Override
    public boolean canUse() {
        if (remainingAmmo() == 0){
            return false;
        } else {
            return true;
        }
    }
}



