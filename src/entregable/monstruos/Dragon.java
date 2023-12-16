package entregable.monstruos;

import java.util.Arrays;
import java.util.List;

import entregable.ataques.FireBreath;
import game.attacks.Attack;
import game.attacks.ColdBreath;
import game.components.Monster;
import game.components.PathBox;
import game.types.Type;

public class Dragon extends Monster {
    protected List<Attack> skills;

    public Dragon(String name, List<Attack> skills, Type primaryType, Type secondaryType) {
        this.life = 800;
        this.monsterName = name;
        this.activeSkill = skills.get(0);
        this.types = Arrays.asList(Type.BEAST, primaryType, secondaryType);
        this.skills = skills;
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     [" + this + "] ataca a [" + enemy + "] haciéndole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }

    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
        super.move(oldPathBox, newPathBox);
        // Lógica para cambiar la habilidad activa según el tipo de ataque
        if (activeSkill instanceof ColdBreath) {
            this.activeSkill = skills.get(1);
        } else if (activeSkill instanceof FireBreath) {
            this.activeSkill = skills.get(1);
        } else {
            this.activeSkill = skills.get(0);
        }
    }

}
