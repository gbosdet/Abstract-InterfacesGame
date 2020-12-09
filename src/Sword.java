import java.util.Random;

//Make Sword implement the Weapon interface
public class Sword {
    private String name;
    private int damage;
    private int cost;
    Random rand;

    public Sword(String name, int damage, int cost) {
        this.name = name;
        this.damage = damage;
        this.cost = cost;
        rand = new Random();
    }

    public int getDamage(Character player){
        return damage + player.getStrength() +rand.nextInt(damage + player.getStrength())/2;
    }
    public int getPowerLevel(){
        return (int) (damage*1.5);
    }

    //Implement your missing method guaranteed by your interface

    @Override
    public int getCost() {
        return cost;
    }

    //implement the method required by the Comparable interface that takes an Object argument
    // You will need to cast the argument object to a Weapon. Base your comparison on the getPowerLevel() method


    public void reload(){

    }

    @Override
    public String toString(){
        return name + "\t\t Damage: " + damage;
    }
}
