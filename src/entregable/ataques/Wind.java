package entregable.ataques;

import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class Wind implements Wings {
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(100, 500);
        if(monster.getTypes().contains(Type.FIRE)) {
            damage = damage * 2;
        }else
        if(monster.getTypes().contains(Type.SHIELD)) {
            damage =(int)(damage * 0.75);
        }
        
        return damage;
    }
}
