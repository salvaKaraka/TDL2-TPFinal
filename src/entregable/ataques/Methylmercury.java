package entregable.ataques;
import game.components.Monster;
import game.random.RandomGenerator;


public class Methylmercury implements Poison {

    @Override
    public int damage(Monster monster) {
        return RandomGenerator.getInstance().calculateDamage(50, 100);
    }

}
