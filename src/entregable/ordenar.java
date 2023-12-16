package entregable;

import java.util.List;
import java.util.Collection;
import java.util.Collections;

import game.components.Monster;

public  class ordenar {
	
	public static List<Monster> ordenamientoPorVida(List<Monster> monstruos){
		   for (int i=0;i<monstruos.size();i++) {
			      
			      System.out.println(monstruos.get(i).getLife());
			    }
		
		Collections.sort(monstruos, new MonsterComparatorVida());
		System.out.println("---------Lista Ordenada-------------");
		 for (int i=0;i<monstruos.size();i++) {
		      
		      System.out.println(monstruos.get(i).getLife());
		    }
		
		return monstruos;
	}
	public static List<Monster> ordenamientoPorDamage(List<Monster> monstruos){
		   for (int i=0;i<monstruos.size();i++) {
			      
			      System.out.println(monstruos.get(i).getDamage());
			    }
		
		Collections.sort(monstruos, new MonsterComparatorDamage());
		System.out.println("---------Lista Ordenada-------------");
		 for (int i=0;i<monstruos.size();i++) {
		      
		      System.out.println(monstruos.get(i).getDamage());
		    }
		
		return monstruos;
	}
}