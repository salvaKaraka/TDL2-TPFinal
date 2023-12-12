package entregable.ataques;

import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class Wind implements Wings {
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(50, 100);
        if(monster.getTypes().contains(Type.FIRE)) {
            damage = damage * 2;
        }
        return damage;
    }
}
