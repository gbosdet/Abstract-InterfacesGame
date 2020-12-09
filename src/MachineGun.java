//Make MachineGun a subclass of Gun

public class MachineGun {
    private int burstSize;

    //Create a constructor that takes arguments as follows:
    //String name, int damage, int maxAmmo, int cost, int burstSize
    //Use the superclass constructor to set everything but burst size, then set burstSize


    @Override
    public int getDamage(Character player){
        if(ammo <= 0){
            reload();
            return 0;
        }
        else if(ammo < burstSize){
            ammo = 0;
            return ammo*damage + player.getAccuracy();
        }
        else{
            ammo -= burstSize;
            return burstSize*damage + player.getAccuracy();
        }
    }
    @Override
    public int getPowerLevel(){
        return damage*burstSize;
    }

    //Override the toString Method to print the superclass' toString method followed by "\t Burst Size: " + burstSize;
    //Use the super keyword


}
