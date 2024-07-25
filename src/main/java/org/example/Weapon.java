package org.example;

public enum Weapon {
    SWORD(20, 4);

    int damage;
    double attackSpeed;

    Weapon (int damage, double attackSpeed) {
        this.attackSpeed = attackSpeed;
        this.damage = damage;

    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
