package hashCriptografia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Aplicacion {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplicacion window = new Aplicacion();
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
	public Aplicacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnRipemd = new JButton("RIPEMD");
		btnRipemd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				JOptionPane.showMessageDialog(btnRipemd , new ripemd().getResult(FileChooser()));
			}
		});
		
		btnRipemd.setBackground(SystemColor.info);
		btnRipemd.setBounds(85, 57, 89, 33);
		frame.getContentPane().add(btnRipemd);

		
		
		JButton btnSha = new JButton("SHA-1");
		btnSha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				JOptionPane.showMessageDialog(btnRipemd , new sha1().getResult(FileChooser()));
			}
		});
		
		btnSha.setBackground(SystemColor.info);
		btnSha.setBounds(85, 116, 89, 33);
		frame.getContentPane().add(btnSha);

		
		
		JButton btnSha_1 = new JButton("SHA-256");
		btnSha_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				JOptionPane.showMessageDialog(btnRipemd , new sha256().getResult(FileChooser()));
			}
		});
		
		btnSha_1.setBackground(SystemColor.info);
		btnSha_1.setBounds(85, 174, 89, 33);
		frame.getContentPane().add(btnSha_1);

		
		
		JButton btnMd = new JButton("MD4");
		btnMd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				JOptionPane.showMessageDialog(btnRipemd , new md4().getResult(FileChooser()));
			}
		});
		btnMd.setBackground(SystemColor.info);
		btnMd.setBounds(246, 57, 89, 33);
		frame.getContentPane().add(btnMd);

		
		
		JButton btnMd_1 = new JButton("MD5");
		btnMd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				JOptionPane.showMessageDialog(btnRipemd , new md5().getResult(FileChooser()));
			}
		});
		btnMd_1.setBackground(SystemColor.info);
		btnMd_1.setBounds(246, 116, 89, 33);
		frame.getContentPane().add(btnMd_1);

		
		
		JButton btnHmac = new JButton("HMAC");
		btnHmac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				String path=FileChooser();
				String key=JOptionPane.showInputDialog("Ingrese la llave para autenticar: ");
				hmac ob= new hmac();
				JOptionPane.showMessageDialog(btnRipemd , ob.getResult(path, key));
			}
		});
		btnHmac.setBackground(SystemColor.info);
		btnHmac.setBounds(246, 174, 89, 33);
		frame.getContentPane().add(btnHmac);

		
		
		JLabel lblCalculadoraDeFunciones = new JLabel("CALCULADORA DE FUNCIONES HASH CRIPTOGRAFICAS");
		lblCalculadoraDeFunciones.setFont(new Font("Geometr212 BkCn BT", Font.BOLD, 11));
		lblCalculadoraDeFunciones.setBounds(54, 21, 332, 14);
		frame.getContentPane().add(lblCalculadoraDeFunciones);

		JLabel lblAutorAnyeloGutirrez = new JLabel("Autor: Anyelo Gutierrez");
		lblAutorAnyeloGutirrez.setFont(new Font("Geometr212 BkCn BT", Font.PLAIN, 11));
		lblAutorAnyeloGutirrez.setBounds(153, 236, 145, 14);
		frame.getContentPane().add(lblAutorAnyeloGutirrez);

	}
	public String FileChooser() {
	       Scanner entrada = null;
	       String cadena = null;
	       //Se crea el JFileChooser. Se le indica que la ventana se abra en el directorio actual                    
	        JFileChooser fileChooser = new JFileChooser(".");      
	        
	        //Se crea el filtro. El primer parámetro es el mensaje que se muestra,
	        //el segundo es la extensión de los ficheros que se van a mostrar      
	        FileFilter filtro = new FileNameExtensionFilter("Archivos txt (.txt)", "txt"); 
	        
	        //Se le asigna al JFileChooser el filtro
	        fileChooser.setFileFilter(filtro);
	        
	        //se muestra la ventana
	        int valor = fileChooser.showOpenDialog(fileChooser);
	        
	        if (valor == JFileChooser.APPROVE_OPTION) {
	            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
	            try {
	                File f = new File(ruta);
	                entrada = new Scanner(f);
	                cadena=entrada.nextLine();
	                while (entrada.hasNext()) {
	                    cadena+=entrada.nextLine();
	                }
	            } catch (FileNotFoundException e) {
	                System.out.println(e.getMessage());
	            } finally {
	                if (entrada != null) {
	                    entrada.close();
	                }
	            }
	        } else {
	            System.out.println("No se ha seleccionado ningún fichero");
	        }
	        return cadena;
	    }
	}

