import java.util.Scanner;
import java.util.Random;

public class BattleSequence {

    public static void main(String args[]) {

// Allows for user input. //
        Scanner input = new Scanner(System.in);

// Instances of new objects that allow us to use variables from other classes. //
        Player player = new Player();
        Enemy enemy = new Enemy();
        Potion potion = new Potion();

// Allows us to use the randomizer. //
        Random rand = new Random();

// Code that will welcome the user and spawn a new enemy to get the game started before the loop. //
        System.out.println("Welcome to the dungeon!");

        enemy.randomEnemy = enemy.enemyType[rand.nextInt(enemy.enemyType.length)];
        System.out.println("# A " + enemy.randomEnemy + " appears! #");

// This is our game loop that will control the entire battle sequence. //
        while (player.start == 0) {
            player.playerStats();

            System.out.println("What would you like to do?\n");
            System.out.println("Type 1 to attack, 2 to use health potion, and 3 to run\n");

            String Input = input.nextLine();
            if (Input.equals("1")) {
                player.damagingEnemy(enemy); // Method that allows the player to damage the enemy. //

                if (enemy.enemyHealth >= player.playerAttackDamage) {
                    System.out.println("The " + enemy.randomEnemy + " has " + enemy.enemyHealth + " health remaining.\n");
                }
            }

             else if (Input.equals("2")) {
                // Condition that prevents the user from exceeding the maximum health value. //
                if (player.playerHealthPotions > 0 && player.playerHealth < player.maxPlayerHealth && player.playerHealth + potion.potionHealAmount > player.maxPlayerHealth) {
                        player.healToMaxHealth(player);
                    }

                else if(player.playerHealth >= player.maxPlayerHealth) {
                    System.out.println("Your health is full. You cannot use any potions at this time.\n");
                }

                else if(player.playerHealth + potion.potionHealAmount <= player.maxPlayerHealth) {
                    player.playerHealing(potion);
                }

                else if(player.playerHealthPotions < 1){
                    System.out.println("You have no more potions available, fight enemies for a chance to receive more.\n");
                }

            }
            else if (Input.equals("3")) {
                enemy.randomizeEnemy(); // Method that will allow the player to run away from the current enemy and encounter a new one. //
            }
            else
                System.out.println("Invalid Input!\n" + "Please make sure to type in 1, 2, or 3.\n");


            if (enemy.enemyHealth < 1) {
                enemy.enemyDefeated(); // Method that will spawn a new enemy with full health each time an enemy is defeated. //

            }
            else {
                if (Input.equals("1") || Input.equals("2")) {
                    enemy.enemyRetaliation(player); // Method that allows the enemies that are alive to attack the player after each turn unless they run away. //
                }
            }
            if(player.playerHealth < 1) {
                player.gameOver(); // Method that will end the game if the player runs out of health. //
                break;
            }

            }


        }


    }








