package Hoja4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MaquinaExpendedora extends JFrame {

	private JPanel contentPane;
	private JTextField total;
	private JTextField salida;
	private JTextField precio;
	private ButtonGroup bebidas;
	private JComboBox euros;
	private JComboBox centimos;
	String centimoss;
	String euross;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaquinaExpendedora frame = new MaquinaExpendedora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MaquinaExpendedora() {
		setTitle("Elige producto y pon dinero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBebidas = new JLabel("Bebidas");
		lblBebidas.setBounds(10, 11, 67, 14);
		contentPane.add(lblBebidas);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(135, 11, 46, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblEuros = new JLabel("Euros");
		lblEuros.setBounds(244, 56, 46, 14);
		contentPane.add(lblEuros);
		
		JLabel lblCentimos = new JLabel("Centimos");
		lblCentimos.setBounds(244, 112, 46, 14);
		contentPane.add(lblCentimos);
		
		euros = new JComboBox();
		euros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				euross = (String) euros.getSelectedItem();
				
				total.setText(euross + "." + centimoss);
			}
		});
		euros.setBounds(314, 53, 92, 17);
		contentPane.add(euros);
		
		centimos = new JComboBox();
		centimos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				centimoss = (String) centimos.getSelectedItem();
				
				total.setText(euross + "." + centimoss);
			}
		});
		centimos.setBounds(314, 109, 92, 17);
		contentPane.add(centimos);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setBounds(244, 189, 46, 14);
		contentPane.add(lblTotal);
		
		total = new JTextField();
		total.setText("0.0");
		total.setEditable(false);
		total.setBounds(314, 186, 86, 20);
		contentPane.add(total);
		total.setColumns(10);
		
		JButton btnValidar = new JButton("VALIDAR");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double totall = Double.parseDouble(total.getText());
				double precioo = Double.parseDouble(precio.getText());
				
				if(totall==precioo){
					
					salida.setText("Su bebida, gracias");
					
				}
				
				else if(totall>precioo){
					double resta = totall - precioo;
					
					salida.setText("Le sobran " + resta + " euros.");
				}
				
				else if(totall<precioo){
					double resta = precioo - totall;
					
					salida.setText("Le faltan " + resta + " euros.");
				}
			}
		});
		btnValidar.setBounds(10, 228, 89, 23);
		contentPane.add(btnValidar);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bebidas.clearSelection();
				precio.setText("");
				euros.setSelectedIndex(0);
				centimos.setSelectedIndex(0);
				total.setText("0.0");
				salida.setText("");
			}
		});
		btnLimpiar.setBounds(124, 228, 89, 23);
		contentPane.add(btnLimpiar);
		
		salida = new JTextField();
		salida.setEditable(false);
		salida.setBounds(274, 229, 132, 20);
		contentPane.add(salida);
		salida.setColumns(10);
		
		precio = new JTextField();
		precio.setEditable(false);
		precio.setBounds(109, 53, 86, 20);
		contentPane.add(precio);
		precio.setColumns(10);
		
		JRadioButton agua = new JRadioButton("Agua");
		agua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				precio.setText("0.8");
				salida.setText(null);
			}
		});
		agua.setBounds(10, 52, 89, 23);
		contentPane.add(agua);
		
		JRadioButton coca = new JRadioButton("Coca-Cola");
		coca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				precio.setText("1.2");
				salida.setText(null);
			}
		});
		coca.setBounds(10, 89, 109, 23);
		contentPane.add(coca);
		
		JRadioButton fanta = new JRadioButton("Fanta");
		fanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				precio.setText("2.1");
				salida.setText(null);
			}
		});
		fanta.setBounds(10, 127, 109, 23);
		contentPane.add(fanta);
		
		bebidas=new ButtonGroup();
		bebidas.add(fanta);
		bebidas.add(agua);
		bebidas.add(coca);
		
		init_combo();
	}

	private void init_combo() {
		// TODO Auto-generated method stub
		for(int i=0;i<=99;i++){
				
			
			euros.addItem(String.valueOf(i));
			centimos.addItem(String.valueOf(i));
			
		
	}
}
}
