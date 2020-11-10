package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import Logica.Grafo;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class principal {

	private JFrame frame;
	private JTextField cantidadPersonas;
	private cargaDePersonas carga;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal window = new principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public principal() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		
		frame.setBounds(680, 250, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CLUSTERING HUMANO");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Adobe Gothic Std B", Font.PLAIN, 32));
		lblNewLabel.setBounds(115, 63, 350, 57);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese la cantidad de personas a cargar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(171, 107, 273, 165);
		frame.getContentPane().add(lblNewLabel_1);
		
		cantidadPersonas = new JTextField();
		cantidadPersonas.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadPersonas.setBounds(246, 235, 86, 20);
		frame.getContentPane().add(cantidadPersonas);
		cantidadPersonas.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				if(validarInputCantidadPersonas()) {
					Grafo grafo = new Grafo(getCantidadPersonas()); //le asigna la cantidad de personas
					carga = new cargaDePersonas(grafo); 
					carga.setVisible(true);
					frame.setVisible(false);
				}
			}
		});
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBounds(246, 376, 89, 23);
		frame.getContentPane().add(btnGuardar);
	}
	
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

	public int getCantidadPersonas() {
		int cant = Integer.parseInt(cantidadPersonas.getText());
		return cant;
	}
}

