import game.components.Monster;

import game.components.RumbleGame;
import game.monsters.*;

import java.util.Arrays;
import java.util.List;

import entregable.monstruos.*;
import entregable.ordenar.*;

public class Main {
    public static void main(String[] args) {
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        List<Monster> monstersOne = Arrays.asList(new EvilBeast("Demon1"),new FireDragon("FireDragon1"), new EvilBeast("Demon2"), new FireDragon("FireDragon2"));

        //TODO ordenar el listado de monstruos que recibe el jugador uno
        rumbleGame.getPlayerOne().setMonsters(ordenar.ordenamientoPorDamage(monstersOne));

        List<Monster> monstersTwo = Arrays.asList(new EvilBeast("Demon1"),new FireDragon("FireDragon1"), new EvilBeast("Demon2"), new FireDragon("FireDragon2"));

        //TODO ordenar el listado de monstruos que recibe el jugador dos
        rumbleGame.getPlayerTwo().setMonsters(ordenar.ordenamientoPorVida(monstersTwo));

        rumbleGame.startGame();
    }
}