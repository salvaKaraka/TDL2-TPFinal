package entregable.ataques;
import entregable.monstruos.Dragon;
import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;
public class Thunderbolt implements Electric { 
	@Override
	public int damage (Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(100, 500);
        if(monster.getTypes().contains(Type.ELECTRIC)) {
            damage = 0;
        }else
        if( monster instanceof Dragon ) {
            damage =(int)(damage * 0.75);
        }
        
        return damage;
	}
}
