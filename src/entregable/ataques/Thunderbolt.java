package entregable.ataques;
import game.components.Monster;
import game.random.RandomGenerator;
public class Thunderbolt implements Magic { //De que interface lo hago extender para despues poder
	//hacer un arreglo y alternar los ataques
	
	@Override
	public int damage (Monster monster) {
		return RandomGenerator.getInstance().calculateDamage(1000, 200);
	}
	

}
