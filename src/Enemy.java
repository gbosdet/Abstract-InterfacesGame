//Make Enemy a subclass of Character

public class Enemy{
    static int numEnemies = 0;
    private String toSay;

    //Create a Enemy constructor that takes arguments as follows:
    // String name, int maxHealth, int experience, int gold, int strength, int accuracy, Weapon weapon, String toSay
    //set most of them using the superclass' constructor, make numEnemies go up by 1, and set the toSay field



   //Create your void talk() method that just prints out the toSay field



    public static int getNumEnemies(){
        return numEnemies;
    }



    public String getToSay() {
        return toSay;
    }
}
