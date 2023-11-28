public class Character {
    private String name;
    private int level;
    private double hp;
    private double mana;
    private double max_hp;
    private double max_mana;
    private double runSpeed;
    private double max_runSpeed;
    private Sword sword;
    private Shield shield;
    private double tempSword;
    private double tempShield;

    public Character(String name ,int level ,double r) {
        this.name = name;
        this.level = level;
        this.runSpeed = r;
        this.hp = 100 + (10 * level);
        this.mana = 50 + (2 * level);
        this.max_hp = 100 + (10 * level);
        this.max_mana = 50 + (2 * level);
        this.max_runSpeed = r * (0.1 + 0.03 * level);
        this.sword = new Sword();
        this.shield = new Shield();
        this.tempSword = 0;
        this.tempShield = 0;
        System.out.println(name + " join the game!!");

    }

    //overload Character
    public Character(String name) {
        // default stat is level 1 and runSpeed is 10
        this(name,1,200);
    }

    public void levelUp() {
        this.level++;
        this.max_hp = 100 + (10 * level);
        this.max_mana = 50 + (2 * level);
        this.max_runSpeed = runSpeed * (0.1 + 0.03 * level);
        double diff_maxHp = (100 + (10 * level)) - (100 + (10 * (level - 1)));
        double diff_maxMana = (50 + (2 * level)) - (50 + (2 * (level - 1)));
        this.hp = Math.min(this.hp + diff_maxHp, this.max_hp);//heal hp when level up
        this.mana = Math.min(this.mana + diff_maxMana, this.max_mana);//heal mana when level up
        System.out.println("---------------------------");
        System.out.println(name + " Level up to " + level + "!!");
        System.out.println("maxHp up to " + max_hp);
        System.out.println("maxMana up to " + max_mana);
        System.out.println("maxRunSpeed up to " + max_runSpeed);
        System.out.println("---------------------------");
    }

    public void displayStats() {
        System.out.println(name + " - Level: " + level + ", HP: " + hp + "/" + max_hp +
                ", Mana: " + mana + "/" + max_mana + ", Runspeed: " + max_runSpeed + " , " + sword.getName() + "/" + shield.getName() +  " " +sword.levelUpCalculate() + "/" + shield.levelUpCalculate());
    }

    public void takeDamage(Sword sw , Shield sh) {
        double diffDMG = sw.levelUpCalculate();
        if(sh.getName() == "hand") {
            this.hp = Math.max(0, this.hp - diffDMG);
        }else{
            double defenseModifier = 100;
            //formular of reduce damage (stat of shield must not over defenseModifier)
            double dmgFormula = diffDMG * (1 - sh.levelUpCalculate() / defenseModifier);
            if(dmgFormula < 0) dmgFormula = 0;
            this.hp = Math.max(0, this.hp - dmgFormula);
        }
        System.out.println(name + " take " + (max_hp - hp) + " damage!!" );

    }

    public void equip(Sword sw) {
        this.sword = sw;
        adjustRunSpeed(sw);
    }
    public void equip(Shield sh) {
        this.shield = sh;
        adjustRunSpeed(sh);
    }

    public void unequipSword() {
        this.sword = new Sword();
        this.max_runSpeed += tempSword;
        this.tempSword = 0;
    }

    public void unequipShield() {
        this.shield = new Shield();
        this.max_runSpeed += tempShield;
        this.tempShield = 0;
    }

    public void adjustRunSpeed(Sword sw) {
        this.max_runSpeed += tempSword;
        if(sw.getName() != "hand") {
            this.max_runSpeed -= (runSpeed * (0.1 + 0.04 * sw.level));
            this.tempSword = runSpeed * (0.1 + 0.04 * sw.level);
        }else{
//            this.max_runSpeed += tempSword;
        }

    }

    public void adjustRunSpeed(Shield sh) {
        this.max_runSpeed += tempShield;
        if(sh.getName() != "hand") {
            this.max_runSpeed -= (runSpeed * (0.1 + 0.08 * sh.level));
            this.tempShield = runSpeed * (0.1 + 0.08 * sh.level);
        }
    }

}