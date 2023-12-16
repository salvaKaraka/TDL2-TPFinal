package entregable.monstruos;


import game.components.Monster;
import game.attacks.*;
import game.types.Type;
import java.util.Arrays;
import java.util.List;
import entregable.ataques.*;



public class Wizard extends Monster{
	final int LIFE = 300;
	private boolean secondChance = true ; //segunda vida para mago
	private List<Attack> skills = Arrays.asList (new Spell(), new Thunderbolt(),new Methylmercury()) ;
	
	public Wizard(String name) {
		this.life = LIFE;
		this.monsterName = name;
		this.activeSkill = skills.get(0);
		this.types = Arrays.asList(Type.MAGIC, Type.ELECTRIC, Type.POISON);
	}
	
	@Override
	public void attack(Monster enemy) {
		if(activeSkill instanceof Spell) {
			this.activeSkill = skills.get(1);
		}
		else if(activeSkill instanceof Thunderbolt) {
			this.activeSkill = skills.get(2);
		}else this.activeSkill = skills.get(0);
		
		
		enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
	
	}
	
	@Override
	public void onDamageReceive(Integer damage, Monster monster) { //modificacion de ondamagereceive
		this.life= this.life - damage;
		if ((this.life < 100) &&(secondChance)) {
			System.out.println("Abadakadabra");
			System.out.println(this.monsterName+ " se curó");
			this.life = (int)(LIFE*0.5);
			secondChance = false;
	}
		else if(this.life < 0) {
			System.out.println(this.monsterName+" ha caido en batalla" );
		}

}
}
