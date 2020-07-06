package com.company.practiceOOP.hero;

import weapon.MagicWeapon;

public class Mage<T extends MagicWeapon> extends Hero<T> {
    public Mage(String name, int damage) {
        super(name, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(getName() + " произнес заклинание на " + enemy.getName());
        enemy.takeDamage(getDamage());
    }
}
