package entregable;

import game.components.Monster;
public class MonsterComparatorDamage implements java.util.Comparator<Monster> {
	@Override
	public int compare(Monster monsterA, Monster monsterB) {
		return (monsterA.getDamage()-monsterB.getDamage());
	}
}