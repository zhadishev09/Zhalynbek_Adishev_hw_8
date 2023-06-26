package kg.geeks.game.players;

public class Wither extends Hero {

    public Wither(int health, int damage, String name) {
        super(health, damage, SuperAbility.SELF_SACRIFICE, name);
    }


    @Override
    public int applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()<=0 && this.getHealth()>0) {
                heroes[i].setHealth(this.getHealth());
                this.setHealth(0);
                System.out.println("Чародей оживил: " + heroes[i]);

            }

        }

        return 0;
    }
}
