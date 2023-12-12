package entregable.ataques;


import game.attacks.Fire;
import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class FireBreath implements Fire {
		
	    @Override
	    public int damage(Monster monster) {
	        int damage = RandomGenerator.getInstance().calculateDamage(90, 150);
	        if(monster.getTypes().contains(Type.COLD)) {
	            damage = damage * 2;
	        }
	        return damage;
	    }
}


