import java.util.ArrayList;

public class Loc {

	private String nume;
	// private String perioada;
	private Perioada perioada;
	private double pretMediuZi;
	private ArrayList<String> activitati = new ArrayList<>();

	/*
	 * Constructori ai unei locatii
	 */
	public Loc(String nume) {
		this.nume = nume;
	}

	public Loc(String nume, Perioada perioada) {
		this(nume);
		this.perioada = perioada;
	}

	public Loc(String nume, Perioada perioada, double pretMediuZi) {
		this(nume, perioada);
		this.pretMediuZi = pretMediuZi;
	}

	public Loc(String nume, Perioada perioada, double pretMediuZi, ArrayList<String> activitati) {
		this(nume, perioada, pretMediuZi);
		this.activitati.addAll(activitati);
	}

	/*
	 * Getteri si setteri ale datelor private
	 */
	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public Perioada getPerioada() {
		return perioada;
	}

	public void setPerioada(Perioada perioada) {
		this.perioada = perioada;
	}

	public double getPretMediuZi() {
		return pretMediuZi;
	}

	public void setPretMediuZi(double pretMediuZi) {
		this.pretMediuZi = pretMediuZi;
	}

	public ArrayList<String> getActivitati() {
		return activitati;
	}

	public void setActivitati(ArrayList<String> activitati) {
		this.activitati = activitati;
	}

	public boolean checkActivitate(String activitate) {
		if (activitati.contains(activitate)) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Locatie: " + nume + "\n" + "Perioada: " + perioada.getZiStart() + "." + perioada.getLunaStart()
				+ "-" + perioada.getZiFinal() + "." + perioada.getLunaFinal() + "\n" + "Pret Mediu: " + pretMediuZi
				+ "\n" + "Activitati: ");

		for (String s : activitati) {
			str.append(s + ", ");
		}

		return str.toString();
	}
}
