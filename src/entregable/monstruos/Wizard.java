package entregable.monstruos;


import game.components.Monster;
import game.types.Type;
import java.util.Arrays;
import java.util.List;
import entregable.ataques.*;



public class Wizard extends Monster{
	final int LIFE = 400;
	private boolean secondChance = true ; //segunda vida para mago
	private List<Magic> skills = Arrays.asList (new Spell(), new Thunderbolt(),new Methylmercury()) ;
	
	public Wizard(String name) {
		this.life = LIFE;
		this.monsterName = name;
		this.activeSkill = new Spell();
		this.types = Arrays.asList(Type.MAGIC, Type.ELECTRIC, Type.POISON);
	}
	
	@Override
	public void attack(Monster enemy) {
		enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
	}
	
	@Override
	public void onDamageReceive(Integer damage, Monster monster) { //modificacion de ondamagereceive
		this.life= this.life - damage;
		if ((this.life < 100) &&(secondChance)) {
			System.out.println("Lorem ipsum dolor sit amet consectetur adipisicing elit. Culpa esse expedita, a pariatur ullam illo adipisci iusto, voluptate, nobis ducimus delectus accusantium obcaecati quod assumenda tempora dicta eum similique vitae.");
			System.out.println(this.monsterName+ " se curó");
			this.life = LIFE;
			secondChance = false;
	}
		else if(this.life < 0) {
			System.out.println(this.monsterName+" ha caido en batalla" );
		}

}
}
