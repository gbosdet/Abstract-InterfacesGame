// Make the class abstract!!!!!!!

public class Character {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int experience;
    protected int gold;
    protected int strength;
    protected int accuracy;
    protected Weapon weapon;

    public Character(String name, int maxHealth, int experience, int gold, int strength, int accuracy, Weapon weapon) {
        this.name = name;
        this.maxHealth = maxHealth;
        health = maxHealth;
        this.experience = experience;
        this.gold = gold;
        this.strength = strength;
        this.accuracy = accuracy;
        this.weapon = weapon;
    }

    //Make an abstract void method called talk that takes no arguments


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getExperience() {
        return experience;
    }

    public int getGold() {
        return gold;
    }

    public int getStrength() {
        return strength;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void takeDamage(int damage){
        health -= damage;
    }
}
