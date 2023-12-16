package entregable;
import game.components.Monster;

public class MonsterComparatorVida implements java.util.Comparator<Monster> {
	@Override
	public int compare(Monster monsterA, Monster monsterB) { //sale el de menos vida primero
		return monsterA.getLife() - monsterB.getLife()	;
				}
}
