package org.example;

public class Player {
   private String name;
    private int healthPercentage ;
    private Weapon weapon;

    public Player(String name, int healthPercentage, Weapon weapon) {
        this.name=name;
        this.healthPercentage = healthPercentage;
        this.weapon = weapon;
        checkHealth(healthPercentage);
    }

    private void checkHealth(int healthPercentage) {
        if (healthPercentage < 0) {
            this.healthPercentage = 0;
        };

        if (healthPercentage > 100) {
            this.healthPercentage = 100;
        }
    }

    public int healthRemaining() {
        return this.healthPercentage;
    }

    public void loseHealth(int damage) {
        int result = healthPercentage - damage;

        if (result <= 0) {
            System.out.println(name + " player has been knocked out of game");
        }

        healthPercentage = result;
        checkHealth(healthPercentage);
    }

    public void restoreHealth(int healthPotion) {
        this.healthPercentage = this.healthPercentage + healthPotion;
        checkHealth(this.healthPercentage);
        if (this.healthPercentage > 100) {
            this.healthPercentage = 100;
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", healthPercentage=" + healthPercentage +
                ", weapon=" + weapon +
                '}';
    }
}
