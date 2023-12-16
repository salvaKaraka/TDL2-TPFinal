package game.attacks;

import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class Slice implements Sword {

    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(90, 150);
        if(monster.getTypes().contains(Type.WINGS)) {
            damage = damage * RandomGenerator.getInstance().calculateDamage(0, 1);
        }else
        if(monster.getTypes().contains(Type.SHIELD)) {
        	damage =(int)(damage * 0.75);
        }
        return damage;
    }
}
