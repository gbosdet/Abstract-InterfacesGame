import java.util.Random;

//Make Player a subclass of Character

public class Player  {

    private int level;


    //Create a Player constructor that takes arguments as follows:
    // String name, int maxHealth, int gold, int strength, int accuracy
    //set most of them using the superclass' constructor along with a starting weapon (probably a Sword), and set level to 1 (Should only have 2 lines in constructor)



    public Player(String name) {
    //Notice this is using the other constructor you made
        this(name, (int) (Math.random() * 11) + 20, (int) (Math.random() * 21) + 20, (int) (Math.random() * 11) + 10,
                (int) (Math.random() * 11) + 10);

    }

    //Implement your talk method and make your character say something appropriate

    public void displayStats() {
        System.out.println("Name: " + name);

        System.out.println("Level: " + level);
        System.out.println("Experience: " + experience);
        System.out.println("HP: " + health + " / " + maxHealth);

        System.out.println("Strength: " + strength);
        System.out.println("Accuracy: " + accuracy);
        System.out.println("Weapon: " + weapon);

        System.out.println("Gold: " + gold);

    }

    public int getLevel() {
        return level;
    }

    public void reroll() {
        if(name.equals("Guile")){
            maxHealth = 30;
            gold = 40;
            strength = 20;
            accuracy = 20;
        }
        else {
            maxHealth = (int) (Math.random() * 11) + 20;
            gold = (int) (Math.random() * 21) + 20;
            strength = (int) (Math.random() * 11) + 10;
            accuracy = (int) (Math.random() * 11) + 10;
        }
        health = maxHealth;
    }

    public void heal() {
        health = maxHealth;
    }

    public void decreaseGold(int purchasePrice) {
        gold -= purchasePrice;
    }

    public void increaseGold(int monsterGold) {
        gold += monsterGold;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void gainExperience(int experience) {
        this.experience += experience;
        if (this.experience >= level * 100) {
            this.experience -= level * 100;
            level++;
            System.out.println("\tLevel up!");

            strength += (int) (Math.random() * 5 + 2);
            accuracy += (int) (Math.random() * 5 + 2);


            maxHealth += level + (int) (Math.random() * 5 + 4);
            System.out.println("\tLevel: " + level);
            System.out.println("\tHit Points: " + health + "/" + maxHealth);
            System.out.println("\tStrength: " + strength);
            System.out.println("\tAccuracy: " + accuracy);


//            if(level == 30){
//                System.out.println();
//                System.out.println("The city is under attack! A great beast has come to the gates");
//                System.out.println("The people cry out for the hero of the arena to defend them.");
//                try {
//                    // wait 1 second for people to see the message
//                    Thread.sleep(5000);
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//            }


        }


    }
}
