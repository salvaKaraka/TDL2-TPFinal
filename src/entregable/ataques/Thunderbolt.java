package entregable.ataques;
import game.components.Monster;
import game.random.RandomGenerator;
public class Thunderbolt implements Electric { 
	@Override
	public int damage (Monster monster) {
		return RandomGenerator.getInstance().calculateDamage(1000, 200);
	}
}
