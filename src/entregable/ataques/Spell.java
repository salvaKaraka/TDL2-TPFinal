package entregable.ataques;

import game.components.Monster;
import game.random.RandomGenerator;

public class Spell implements Magic {
		//que variante se puede meter?
		@Override 
		public int damage(Monster monster) {
			return RandomGenerator.getInstance().calculateDamage(300, 700);
		}
}
