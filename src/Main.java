import game.components.Monster;
import game.components.RumbleGame;
import game.monsters.EvilBeast;
import game.monsters.IceBeast;
import game.monsters.Spartan;

import java.util.Arrays;
import java.util.List;

import entregable.monstruos.FireDragon;
import entregable.monstruos.IceDragon;
import entregable.monstruos.Wizard;
import entregable.ordenar;

public class Main {
    public static void main(String[] args) {
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        List<Monster> monstersOne = Arrays.asList(new IceDragon("IceDragon 1"),
        		new FireDragon("FireDragon 1"),
                new Wizard("Mago 1"),
                new Wizard("Mago 2"),
                new Wizard("Mago 3"));

        //TODO ordenar el listado de monstruos que recibe el jugador uno
        rumbleGame.getPlayerOne().setMonsters(ordenar.ordenamientoPorDamage(monstersOne));

        List<Monster> monstersTwo = Arrays.asList();

        //TODO ordenar el listado de monstruos que recibe el jugador dos
        rumbleGame.getPlayerTwo().setMonsters(monstersTwo);

        rumbleGame.startGame();
    }
}