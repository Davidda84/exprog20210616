package fp.daw.exprog20210616.Ejercicio3;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ParqueMovil {
	static Map<String, Integer> mCamiones = new TreeMap<String, Integer>();
	static Map<String, Integer> mFurgonetas = new TreeMap<String, Integer>();
	static Map<String, Integer> mAutobuses = new TreeMap<String, Integer>();
	static Map<String, Integer> mTurismos = new TreeMap<String, Integer>();
	static Map<String, Integer> mMotocicletas = new TreeMap<String, Integer>();
	static Map<String, Integer> mTractores = new TreeMap<String, Integer>();
	private String archivo;
	static int year;
	private int contador = 0;

	@SuppressWarnings({ "resource", "static-access" })
	public ParqueMovil(String ruta, int año) throws NumberFormatException, IOException {
		if (año == 2018) {
			archivo = ruta + "\\pm2018.csv";
			this.year = año;
		} else if (año == 2019) {
			archivo = ruta + "\\pm2018.csv";
			this.year = año;
		} else {
			System.out.println("Archivo no disponible");
			this.year = año;
		}

		BufferedReader reader1 = new BufferedReader(new FileReader(archivo));
		String line;
		while ((line = reader1.readLine()) != null) {
			if (contador != 0) {
				String[] array = line.split(";");
				mCamiones.put(array[0], Integer.parseInt(array[1]));
				mFurgonetas.put(array[0], Integer.parseInt(array[2]));
				mAutobuses.put(array[0], Integer.parseInt(array[3]));
				mTurismos.put(array[0], Integer.parseInt(array[4]));
				mMotocicletas.put(array[0], Integer.parseInt(array[5]));
				mTractores.put(array[0], Integer.parseInt(array[6]));
			}
			contador++;
		}
	}

	@SuppressWarnings("null")
	public static int getTipoProvincia(String Provincia, String tipo) {
		switch (tipo.toUpperCase()) {
		case "CAMIONES":
			return mCamiones.get(Provincia);
		case "FURGONETAS":
			return mFurgonetas.get(Provincia);
		case "AUTOBUSES":
			return mAutobuses.get(Provincia);
		case "TURISMOS":
			return mTurismos.get(Provincia);
		case "MOTOCICLETAS":
			return mMotocicletas.get(Provincia);
		case "TRACTORES":
			return mTractores.get(Provincia);
		default:
			return (Integer) null;
		}
	}

	public static int getTotalProvincia(String Provincia) {
		return mCamiones.get(Provincia) + mFurgonetas.get(Provincia) + mAutobuses.get(Provincia)
				+ mTurismos.get(Provincia) + mMotocicletas.get(Provincia) + mTractores.get(Provincia);
	}

	@SuppressWarnings("null")
	public static int getTotalTipo(String tipo) {
		switch (tipo.toUpperCase()) {
		case "CAMIONES":
			return getTotal(mCamiones);
		case "FURGONETAS":
			return getTotal(mFurgonetas);
		case "AUTOBUSES":
			return getTotal(mAutobuses);
		case "TURISMOS":
			return getTotal(mTurismos);
		case "MOTOCICLETAS":
			return getTotal(mMotocicletas);
		case "TRACTORES":
			return getTotal(mTractores);
		default:
			return (Integer) null;
		}
	}

	public static int getTotal(Map<String, Integer> mapa) {
		int total = 0;
		for (String key : mapa.keySet()) {
			total = total + mapa.get(key);
		}
		return total;
	}

	public static int getTotalParque() {
		return (getTotal(mCamiones) + getTotal(mFurgonetas) + getTotal(mAutobuses) + getTotal(mTurismos)
				+ getTotal(mMotocicletas) + getTotal(mTractores));
	}

	public static int getYear() {
		return year;
	}

	public static void getBin(String ruta) throws IOException {
		@SuppressWarnings("resource")
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(ruta)));
		dos.writeUTF("Camiones: \n" + mCamiones.toString() + "\nFurgonetas: \n" + mFurgonetas.toString() + "\nAutobuses: \n"
				+ mAutobuses.toString() + "\nTurismos: \n" + mTurismos.toString() + "\nMotocicletas: \n"
				+ mMotocicletas.toString() + "\nTractores: \n" + mTractores.toString());
	}

}
