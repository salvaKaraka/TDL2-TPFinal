package entregable.VentanaModal;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import game.components.*;

public class Ventana extends JFrame{
	
	private JButton  boton= new JButton("CERRAR");
	private JPanel panel_boton= new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JDialog modal= new JDialog(this,"ventana modal",true);
	private JLabel info= new JLabel();
	JPanel panel_label= new JPanel(new FlowLayout(FlowLayout.CENTER));
	//private int ganador;
	//holaa
	Color ColorVerde = new Color(78, 182, 83);
	Font FuenteEditada = new Font("Felix Titling",Font.BOLD /*| Font.ITALIC*/, 20);
	
	public Ventana(Player ganador){
		super("VENTANA POP-UP");
		//this.ganador=ganador;
		
		this.setearVentana();
		
		this.setearModal(ganador);
		
		this.add(modal);
	}
	
	private void setearVentana() {

        this.setSize(400, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true); 
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
	}
	
	ActionListener activator= new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			//modal.setVisible(false);
		}
	};
	
	public void setearModal(Player ganador) {
		this.setearBoton();
		this.setearLabel(ganador);
		this.setearIconoModal(ganador);
		modal.setSize(400, 500);
		modal.setLocationRelativeTo(null);
		modal.getContentPane().setBackground(ColorVerde);
		modal.setUndecorated(true);
		modal.add(panel_boton, BorderLayout.SOUTH);
		modal.add(panel_label, BorderLayout.NORTH);
		modal.setVisible(true);
	}
	
	private void setearBoton() {
		boton.addActionListener(activator);
		panel_boton.setBackground(ColorVerde);
		panel_boton.add(boton);
	}
	private void setearLabel(Player ganador) {
		panel_label.setBackground(ColorVerde);
		panel_label.add(info);
		if(ganador==null) {
			info.setText("EMPATE");
		} else {
		info.setText("EL JUGADOR "+ ganador.getColor().toUpperCase() +" GANA EL JUEGO");
		}
		info.setFont(FuenteEditada);
		//info.setForeground(Color.RED);
	}	
	
	private void setearIconoModal(Player ganador) {
		ImageIcon icono;
        if(ganador == null) {
        	icono = new ImageIcon("src/entregable/VentanaModal/empate.png"); 
    		icono = new ImageIcon(icono.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
        }else {
        	icono = ganador.getImagen();
        }
        JLabel labelIcono= new JLabel(icono);
        modal.add(labelIcono, BorderLayout.CENTER);
    }
}
