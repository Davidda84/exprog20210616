package fp.daw.exprog20210616.Ejercicio5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import fp.daw.exprog20210616.Ejercicio4.Ejercicio3;

public class Ejercicio5 extends JFrame implements ActionListener{
	

	private static final long serialVersionUID = 1L;
	static JFrame window = new JFrame("Ejercicio 3 de ficheros");
	JPanel panel;
    JButton boton;
    static JMenuBar barra;
 
    public Ejercicio5() {
        setWindows();
        startComponents();
    }
 
    public void setWindows() {
        this.setBounds(250, 50, 900, 600);;
        this.setTitle("Examen Final – Ejercicio 5");
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
 
    private void startComponents() {
    	setPanel();
        boton();
        barra = new JMenuBar();
		JMenu archivo = new JMenu("Archivo");
		JMenuItem abrir = new JMenuItem("Abrir");
		abrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		abrir.addActionListener(e->abrir(null));
		JMenuItem intercalar = new JMenuItem("Intercalar");
		intercalar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		intercalar.addActionListener(this);
		archivo.add(abrir);
		archivo.add(intercalar);
		
		archivo.setMnemonic(KeyEvent.VK_R);
		barra.add(archivo);
    }
 
    private void setPanel() {
        panel = new JPanel();
		panel.setPreferredSize(new Dimension(900,600));
		panel.setLayout(new BorderLayout());
 
        this.getContentPane().add(panel);
    }
 
    private void boton() {
 
        boton = new JButton();
        JButton boton = new JButton("Intercalar");
 
        panel.add(boton);
 
        boton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
		//Ejercicio3.intercalar();
    }
    
    public static void abrir (ActionEvent a) {
    	File f = null;
		JFileChooser jc = new JFileChooser();
		if(jc.showOpenDialog(window) == JFileChooser.APPROVE_OPTION) {
			f=jc.getSelectedFile();
		}
		try (DataInputStream in = new DataInputStream(
				new BufferedInputStream(new FileInputStream(f)))) {
			StringBuilder sb = new StringBuilder();
			try {
				while (true) {
					sb.append(in.readUTF() + "\n");
					sb.append(String.valueOf(in.readInt()) + "\n");
					sb.append(String.valueOf(in.readInt()) + "\n");
					sb.append(String.valueOf(in.readInt()) + "\n");
				}
			} catch (EOFException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
 
    public static void main(String[] args) {
    	Ejercicio5 v = new Ejercicio5();
        v.setVisible(true);
        v.setJMenuBar(barra);
    }
}
