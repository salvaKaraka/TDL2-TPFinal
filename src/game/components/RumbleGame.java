package game.components;
import entregable.VentanaModal.*;
import entregable.excepciones.DrawException;
import game.random.RandomGenerator;

public class RumbleGame {

    private static RumbleGame instance = new RumbleGame();
    private Player playerOne;
    private Player playerTwo;
    private boolean loopGame = true;
    private int round = 0;
    private SegundaEvaluacionUI segundaEvaluacionUI;
    private Player ganador=null;
    
    public static RumbleGame getInstance() {
        return instance;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }
    
    public void setGanador(Player ganador) { //metodo agregado
    	this.ganador= ganador;
    }
    
    public Player getGanador() { //metodo agregado
    	return ganador;
    }

    private RumbleGame() {

    }

    public void init() {
        //playerOne = new Player(1L);
        //playerTwo = new Player(2L);
    	
    	playerOne = new Player(1L,"src/entregable/VentanaModal/castilloRojo-nofondo.png","Rojo");
        playerTwo = new Player(2L,"src/entregable/VentanaModal/castilloAzul-nofondo.png","Azul");

        Castle castleOne = new Castle();
        Castle castleTwo = new Castle();

        Path westPath = new Path();
        Path eastPath = new Path();

        castleOne.setEastPath(eastPath);
        castleOne.setWestPath(westPath);

        castleTwo.setEastPath(eastPath);
        castleTwo.setWestPath(westPath);

        playerOne.setCastle(castleOne);
        playerTwo.setCastle(castleTwo);

        segundaEvaluacionUI = new SegundaEvaluacionUI();
        segundaEvaluacionUI.init().setVisible(true);

        PathBox box15 = new PathBox(segundaEvaluacionUI.getButton(0), "Noroeste");
        PathBox box27 = new PathBox(segundaEvaluacionUI.getButton(2), "Oeste");
        PathBox box39 = new PathBox(segundaEvaluacionUI.getButton(4), "Suroeste");

        box15.setNorthBox(null);
        box15.setSouthBox(box27);

        box27.setNorthBox(box15);
        box27.setSouthBox(box39);

        box39.setNorthBox(box27);
        box39.setSouthBox(null);

        westPath.getPathBoxes().add(box15);
        westPath.getPathBoxes().add(box27);
        westPath.getPathBoxes().add(box39);

        PathBox box17 = new PathBox(segundaEvaluacionUI.getButton(1), "Noreste");
        PathBox box29 = new PathBox(segundaEvaluacionUI.getButton(3), "Este");
        PathBox box41 = new PathBox(segundaEvaluacionUI.getButton(5), "Sureste");

        box17.setNorthBox(null);
        box17.setSouthBox(box29);

        box29.setNorthBox(box17);
        box29.setSouthBox(box41);

        box41.setNorthBox(box29);
        box41.setSouthBox(null);

        eastPath.getPathBoxes().add(box17);
        eastPath.getPathBoxes().add(box29);
        eastPath.getPathBoxes().add(box41);

        castleOne.setLifeLabel(segundaEvaluacionUI.getVidasPlayerOneLabel());
        castleTwo.setLifeLabel(segundaEvaluacionUI.getVidasPlayerTwoLabel());
    }

    
    private void verificarExcepcion(Player playerOne, Player playerTwo) throws DrawException  { //metodo agregado para excepciones
    	//System.out.println("ENTRA A VERIFICAR!!!!!!");
    	if (!(playerOne.getMonsterIterator().hasNext()) && !(playerTwo.getMonsterIterator().hasNext())){
    		if(!playerOne.getCastle().getEastPath().haveMonster(playerOne.getId())  && !playerTwo.getCastle().getEastPath().haveMonster(playerTwo.getId())) {
    			if(!playerOne.getCastle().getWestPath().haveMonster(playerOne.getId())  && !playerTwo.getCastle().getWestPath().haveMonster(playerTwo.getId())) {
    				throw new DrawException ("LOS JUGADORES SE QUEDARON SIN MONSTRUOS");
    			}
    		}	
    	}
    }
    //DPCdmU0tnRSJVPMb4laeRXVK0m556lbdiFo04OYtJyaBub4bCZ+4qkhic8OrMZ/PUfYGKhfJOkbeiTnF8UGkYw
    
    public void nextRound() throws DrawException{
        System.out.println();
        System.out.println();
        System.out.println("Siguiente Ronda numero: " + round);
        
        verificarExcepcion(playerOne, playerTwo); //agregado para excepciones
        
        int jugador = RandomGenerator.getInstance().nextPlayer();
        System.out.println("Mueve primero el Jugador numero " + jugador);
        if(jugador == 1) {
            playerOne.nextRound();
            playerTwo.nextRound();
        } else {
            playerTwo.nextRound();
            playerOne.nextRound();
        }
        segundaEvaluacionUI.refresh();
        round++;
        if(playerOne.getCastle().getCastleLife() <= 0) {
            System.out.println("****         Ganador el Jugador Azul!!!         ****");
            setGanador(playerTwo); //agregado
            loopGame = false;
        }
        if(playerTwo.getCastle().getCastleLife() <= 0) {
            System.out.println("****         Ganador el Jugador Rojo!!!         ****");
            setGanador(playerOne); //agregado
            loopGame = false;
        }
        if(round == 100) {
            loopGame = false;
        }
    }

    public void startGame(){
        while(loopGame) {
            try {
                Thread.sleep(1500);
                this.nextRound();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (DrawException ex) { //catch de empate
            	Ventana ventana= Ventana.getVentana(ganador);
            	ventana.setVisible(true);
            }
        }
    
        Ventana ventana= Ventana.getVentana(ganador);
        ventana.setVisible(true);
        //System.exit(0);
    }
}
