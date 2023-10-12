public class RangedWeapon extends Weapon {

    private int ammo;

    public RangedWeapon(String name, int damage, int ammo) {
        super(name);
        this.setDamage(damage);
        this.ammo = ammo;
    }


    @Override
    public boolean canUse() {
        return ammo > 0;


    }
    @Override
    public void use() {
        if (canUse()) {
            ammo--;
        }
    }
}
