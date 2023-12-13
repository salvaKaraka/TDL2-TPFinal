package entregable.ataques;
import game.components.Monster;

public class Methylmercury implements Poison {
	private int dosis = 0;
	
	public int getDosis() {
		return dosis;
	}
	public void setDosis(int dosis) {
		this.dosis = dosis;
	}
	@Override
	public int damage(Monster monster) { //como aplicar la funcion veneno. Sleep descartado por el retorno
		dosis=2;
		return 300;
	}

}
