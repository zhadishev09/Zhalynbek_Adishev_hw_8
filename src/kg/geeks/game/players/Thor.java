package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Thor extends Hero {

    public Thor(int health, int damage, String name) {
        super(health, damage, SuperAbility.CHANCE, name);
    }

    private static int thor() {
        boolean check = RPG_Game.random.nextBoolean();
        if (check) {
            return 1;
        } else return 0;
    }

    @Override
    public int applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0 && (thor() == 1) && boss.getDefence()==SuperAbility.CHANCE) {
            boss.setDamage(0);
            System.out.println(" Boss ston  ");
        } else boss.setDamage(100);

        return 0;
    }
}
