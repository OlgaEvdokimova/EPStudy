package weapon;

import com.company.practiceOOP.hero.Archer;
import com.company.practiceOOP.hero.Warrior;

public class WeaponRunner {
    public static void main(String[] args) {
        Archer<Bow> archer = new Archer<Bow>("Леголас", 15);
        archer.setWeapon(new Bow());
        Warrior<Sword> warrior = new Warrior<Sword>("Boromir", 20);
        warrior.setWeapon(new Sword());
    }
}
