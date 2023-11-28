// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Character player1 = new Character("Jordan");
        Sword sw1 = new Sword("Excalibur" ,50);
        Shield sh1 = new Shield("RustyShield",10);
        player1.levelUp();
        player1.levelUp();
        player1.levelUp();
        player1.levelUp();
        player1.levelUp();
        player1.levelUp();
        player1.levelUp();


        player1.displayStats();
        player1.equip(sw1);
        player1.displayStats();
        player1.equip(sh1);
        player1.displayStats();
        player1.unequipShield();
        for (int i = 0; i < 50; i++) { // max level of equipment is 50.
            sh1.levelUp();
        }
        player1.equip(sh1);
        player1.displayStats();
        player1.takeDamage(sw1,sh1);
        player1.unequipSword();
        player1.displayStats();
        Sword sw2 = new Sword("godGloves",80);
        player1.unequipShield();
        player1.displayStats();
        player1.equip(sw2);
        player1.equip(new Shield("LOL",40));
        player1.displayStats();
    }
}