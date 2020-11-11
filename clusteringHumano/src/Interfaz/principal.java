package Interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import Logica.Grafo;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class principal {

	//VARIABLES
	private JFrame frame;
	private JTextField cantidadPersonas;
	private cargaDePersonas carga;
	 
	//CONSTRUYE LA VENTANA
	public principal() {
		initialize();
		
	}

	//INICIALIZA LOS CONTENIDOS DEL FRAME
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(470, 190, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel tituloFrame = new JLabel("CLUSTERING HUMANO");
		tituloFrame.setVerticalAlignment(SwingConstants.TOP);
		tituloFrame.setHorizontalAlignment(SwingConstants.CENTER);
		tituloFrame.setFont(new Font("Adobe Gothic Std B", Font.PLAIN, 33));
		tituloFrame.setBounds(97, 70, 376, 78);
		frame.getContentPane().add(tituloFrame);
		
		JLabel ingresarCant = new JLabel("Ingrese la cantidad de personas a ingresar");
		ingresarCant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ingresarCant.setBounds(171, 107, 273, 165);
		frame.getContentPane().add(ingresarCant);
		
		cantidadPersonas = new JTextField();
		cantidadPersonas.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadPersonas.setBounds(246, 241, 86, 20);
		frame.getContentPane().add(cantidadPersonas);
		cantidadPersonas.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(246, 345, 89, 23);
		frame.getContentPane().add(btnGuardar);
	
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				if(validarInputCantidadPersonas()) {
					Grafo grafo = new Grafo(getCantidadPersonas()); //ASIGNA UNA CANTIDAD DE PERSONAS A ALMACENAR
					carga = new cargaDePersonas(grafo); 
					carga.setVisible(true);
					frame.setVisible(false);
				}
			}
		});
	}
	
	//VERIFICA QUE LA ENTRADA NO SEA VACÍA O LETRAS.
	public boolean validarInputCantidadPersonas() { 

		if (cantidadPersonas.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "No debe de estar vacío.");		
			return false;}
		else {		
			try {
				Integer.parseInt(cantidadPersonas.getText()); }
			catch (NumberFormatException excepcion){
				JOptionPane.showMessageDialog(null, "Ingrese solo números");
				cantidadPersonas.setText(null);
				return false; }
			
			int cant = Integer.parseInt(cantidadPersonas.getText());
			if (cant <= 2 ) {
				JOptionPane.showMessageDialog(null, "La cantidad de personas debe ser al menos 3.");
				return false;
			}
		}
		return true;	
	}

	//GETTERS
	public int getCantidadPersonas() {
		int cant = Integer.parseInt(cantidadPersonas.getText());
		return cant;
	}
	
	public JFrame getFrame() {return frame;}
}

