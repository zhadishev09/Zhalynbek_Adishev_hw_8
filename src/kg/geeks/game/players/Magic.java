package kg.geeks.game.players;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public int applySuperPower(Boss boss, Hero[] heroes) {
        int boost = 5;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0 && this.getHealth()>0){
                heroes[i].setDamage(heroes[i].getDamage()+boost);

            }


        }
        System.out.println("Magic добавил урон герою на: " + boost );
        return boost;
    }
}
