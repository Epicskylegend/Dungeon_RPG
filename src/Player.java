import java.util.Random;

public class Player {

    // Variables for the player's stats. //
    int health = 100;
    int maxHealth = 100;
    int attack = 7;
    int level = 1;
    int numHealthPotions = 3;
    int maxNumHealthPotions = 3;
    int currentExp = 0;
    int maxExp = 100;
    int defeatedEnemies = 0; // Keeps track of how many enemies the player has defeated. //
    double shieldHealth = 25;
    int shieldMaxHealth = 25;
    boolean shieldActive;

    // Array and variables for the amount of exp the player will receive. //
    Random rand = new Random();
    int randomExp = rand.nextInt(50);
    int obtainedExp;


    // Method that will hold the values of the player's stats, so they can be displayed after each turn. //
    public void stats() {
        System.out.println("---------------------------");
        System.out.println("Your current health is " + health + "/" + maxHealth + ".\n");
        System.out.println("Your current shield capacity is " + shieldHealth + "/" + shieldMaxHealth + ".\n");
        System.out.println("Your current attack damage is " + attack + ".");
        System.out.println("Your current level is " + level + ".");
        System.out.println("You currently have " + currentExp + "/" + maxExp + " experience.");
        System.out.println("Your currently have " + numHealthPotions + " health potions.");
        System.out.println("---------------------------");
    }

    // Method that will allow you to damage the enemy. Includes enemy parameters, so our function can recognize variables from the "Enemy" class. //
    public void damage(Enemy enemy) {
        System.out.println("---------------------------");
        System.out.println("You strike the " + enemy.random + " for " + attack + " damage.\n");
        System.out.println("---------------------------");
        enemy.health -= attack;
    }

    // Method that allows the player to heal themselves. Include potion parameters, so our function can recognize variables from the "Potion" class. //
    public void heal(Potion potion) {
        health += potion.healAmount;
        numHealthPotions -= 1;
        System.out.println("You drink a health potion healing you for " + potion.healAmount + " health. You now have " + numHealthPotions + " health potion(s) remaining.\n");
    }

    // Method that will heal the player to their maximum health value. //
    public void healToMaxHealth(Player player) {
        player.health = player.maxHealth;
        numHealthPotions -= 1;
        System.out.println("You drink a health potion healing you to " + maxHealth + " health." + " You now have " + numHealthPotions + " health potion(s) remaining.\n");
    }

    // Method that will level up the player and increase their stats. //
    public void levelUp(Potion potion) {
        maxHealth += 25;
        maxNumHealthPotions += 1;
        attack += 5;
        level += 1;
        maxExp += 100;
        shieldMaxHealth *= 1.1;
        potion.healAmount = maxHealth / 2;

        System.out.println("---------------------------");
        System.out.println("## You have leveled up to " + level + "! ##\n");
        System.out.println("Your max health has been increased by 25.\n");
        System.out.println("Your max shield capacity has been increased to " + shieldMaxHealth + ".\n");
        System.out.println("Your attack has been increased by 5.");
        System.out.println("The max number of health potions you can hold increased to " + maxNumHealthPotions + ".");
        System.out.println("---------------------------");
    }

    public void blockAttack(Player player, Enemy enemy){

    }

    public void getExp() {
        obtainedExp = rand.nextInt(50)+25;
        currentExp = currentExp += obtainedExp;
        System.out.println("You received " + obtainedExp + " experience.\n");
    }
}



