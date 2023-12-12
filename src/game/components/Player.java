package game.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;

public class Player {
    private Castle castle;
    private List<Monster> monsters = new ArrayList<>();
    private Iterator<Monster> monsterIterator;
    private Long id;
    private ImageIcon icono;
    private String color;

    public Player(Long id) {
        this.id = id;
    }
    
    public Player(Long id, String url, String color) { //constuctor agregado
    	this.id= id;
    	icono= new ImageIcon(url);
    	this.color=color;
    }
    
    public ImageIcon getImagen() { //metodo agregado
    	return icono;
    }
    
    public String getColor() {  //metodo agregado
    	return color;
    }

    public Castle getCastle() {
        return castle;
    }

    public void setCastle(Castle castle) {
        this.castle = castle;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
        this.monsterIterator = monsters.iterator();
        this.monsters.forEach(monster -> monster.setPlayer(this));

    }

    public void nextRound() {
        this.castle.nextRound(id, monsterIterator);
    }

    public Long getId() {
        return id;
    }
}
