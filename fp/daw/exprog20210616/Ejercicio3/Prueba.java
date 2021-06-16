package fp.daw.exprog20210616.Ejercicio3;

import java.io.IOException;

public class Prueba {

	public static void main(String[] args) throws NumberFormatException, IOException {
		ParqueMovil parque = new ParqueMovil("archivos", 2018);
		System.out.println(parque.getTipoProvincia("Albacete", "Camiones"));
		System.out.println(parque.getTotalProvincia("Albacete"));
		parque.getBin("archivos\\ejercicio3.bin");
		

	}

}
