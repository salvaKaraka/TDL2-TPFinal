package entregable.ordenar;

import java.util.List;
import java.util.Collections;

import game.components.Monster;

public  class ordenar {

    public static List<Monster> ordenamientoPorVida(List<Monster> monstruos){
        Collections.sort(monstruos, new MonsterComparatorVida());
        return monstruos;
    }
    public static List<Monster> ordenamientoPorDamage(List<Monster> monstruos){
        Collections.sort(monstruos, new MonsterComparatorDamage());
        return monstruos;
    }
}