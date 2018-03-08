import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Mihai Olaru on 27.02.2018
 *
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileReader(new File("src/input.txt")));
		String[] data;

		while (sc.hasNextLine()) {
			ArrayList<String> activitati = new ArrayList<>();
			String row = sc.nextLine();
			data = row.split(" ");

			String tara = data[0];
			String judet = data[1];
			String oras = data[2];
			String loc = data[3];
			String periaoda = data[4];

			String[] date = periaoda.split("-");
			String[] dataStart = date[0].split("\\.");
			String[] dataFinal = date[1].split("\\.");
			Perioada p = new Perioada(Integer.parseInt(dataStart[0]), Integer.parseInt(dataStart[1]),
					Integer.parseInt(dataFinal[0]), Integer.parseInt(dataFinal[1]));

			String pret = data[5];

			for (int i = 6; i < data.length; i++) {
				activitati.add(data[i]);
			}

			Gestiune.getInstance().addInfo(tara, judet, oras, new Loc(loc, p, Double.parseDouble(pret), activitati));

		}

		// System.out.println(Gestiune.getInstance().getInfo());
		System.out.println(Gestiune.getInstance().getTop("Romania", new Perioada(15, 2, 20, 2)));
		sc.close();
	}

}
