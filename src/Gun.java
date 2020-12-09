//Make Gun implement the Weapon interface

public class Gun {
    protected String name;
    protected int damage;
    protected int ammo;
    protected int maxAmmo;
    protected int cost;

    public Gun(String name, int damage, int maxAmmo, int cost) {
        this.name = name;
        this.damage = damage;
        this.maxAmmo = maxAmmo;
        ammo = maxAmmo;
        this.cost = cost;
    }


    //implement the method required by the Comparable interface that takes an Object argument
    // You will need to cast the argument object to a Weapon. Base your comparison on the getPowerLevel() method




    //Implement your missing method guaranteed by your interface in a way that makes sense





    public int getDamage(Character player){
        if(ammo <= 0){
            reload();
            return 0;
        }
        else{
            ammo--;
            return damage + player.getAccuracy();
        }
    }

    public String getName() {
        return name;
    }

    public int getAmmo() {
        return ammo;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    @Override
    public int getCost() {
        return cost;
    }

    public int getPowerLevel(){
        return damage;
    }





    @Override
    public String toString(){
        return name + "\t\t Damage: " + damage + "\t\t Max Ammo: " + maxAmmo;
    }
}
