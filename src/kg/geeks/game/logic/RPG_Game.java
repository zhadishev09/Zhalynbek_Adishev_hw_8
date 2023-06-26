package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

/*ДЗ:
        Добавить в проект каждому классу героя свою уникальную способность
        Добавить еще игрока Witcher, не наносит урон боссу, но получает урон от босса. Имеет 1 шанс оживить первого погибшего героя, отдав ему свою жизнь, при этом погибает сам.
                Magic должен увеличивать атаку каждого героя после каждого раунда на n-ное количество
        Добавить еще игрока, Thor, удар по боссу имеет шанс оглушить босса на 1 раунд, вследствие чего босс пропускает 1 раунд и не наносит урон героям.
        System.out.println("Hello world!");

         */

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;


    public static void startGame() {
        Boss boss = new Boss(3000,Boss.getBossDefaultDamage(), "Abraham");

        Warrior warrior = new Warrior(280, 10, "Hercules");
        Medic doc = new Medic(250, 5, 15, "Nebolit");
        Magic magic = new Magic(270, 20, "Potter");
        Berserk berserk = new Berserk(260, 15, "Gatz");
        Medic assistant = new Medic(300, 10, 5, "House");
        Wither wither = new Wither(500, 0, " Чародей");
        Thor thor = new Thor(260, 25,"ТОР");
        Hero[] heroes = {warrior, doc, magic, berserk, assistant, wither, thor};


        printStats(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void printStats(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -----------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && heroes[i].getAbility() != boss.getDefence()) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        printStats(boss, heroes);
    }
}
