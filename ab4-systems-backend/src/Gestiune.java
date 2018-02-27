import java.util.ArrayList;
import java.util.HashMap;

public class Gestiune {

	private ArrayList<Loc> locatii = new ArrayList<>();
	private HashMap<String, HashMap<String, HashMap<String, ArrayList<Loc>>>> tari = new HashMap<>();

	private Gestiune() {
	}

	private static class LazyHolder {
		private static final Gestiune instance = new Gestiune();
	}

	public static Gestiune getInstance() {
		return LazyHolder.instance;
	}

	/*
	 * Setteri si getteri pentru datele private
	 */
	public ArrayList<Loc> getLocatii() {
		return locatii;
	}

	public void setLocatii(ArrayList<Loc> locatii) {
		this.locatii = locatii;
	}

	public HashMap<String, HashMap<String, HashMap<String, ArrayList<Loc>>>> getTari() {
		return tari;
	}

	public void setTari(HashMap<String, HashMap<String, HashMap<String, ArrayList<Loc>>>> tari) {
		this.tari = tari;
	}

	/*
	 * Getteri pentru diferite valori
	 */
	public HashMap<String, HashMap<String, ArrayList<Loc>>> getJudete(String tara) {
		if (tari.containsKey(tara)) {
			return tari.get(tara);
		}
		return null;
	}

	public HashMap<String, ArrayList<Loc>> getOrase(String tara, String judet) {
		if (tari.containsKey(tara)) {
			if (tari.get(tara).containsKey(judet)) {
				return tari.get(tara).get(judet);
			}
		}
		return null;
	}

	public ArrayList<Loc> getLocuri(String tara, String judet, String oras) {
		if (tari.containsKey(tara)) {
			if (tari.get(tara).containsKey(judet)) {
				if (tari.get(tara).get(judet).containsKey(oras)) {
					return tari.get(tara).get(judet).get(oras);
				}
			}
		}
		return null;
	}

	/*
	 * Adderi ai inputului
	 */
	public void addTara(String tara) {
		if (!tari.containsKey(tara)) {
			tari.put(tara, new HashMap<>());
		}
	}

	public void addJudet(String tara, String judet) {
		if (!tari.get(tara).containsKey(judet)) {
			tari.get(tara).put(judet, new HashMap<>());
		}
	}

	public void addOras(String tara, String judet, String oras) {
		if (!tari.get(tara).get(judet).containsKey(oras)) {
			tari.get(tara).get(judet).put(oras, new ArrayList<>());
		}
	}

	public void addLoc(String tara, String judet, String oras, Loc loc) {
		if (!tari.get(tara).get(judet).get(oras).contains(loc)) {
			tari.get(tara).get(judet).get(oras).add(loc);
			locatii.add(loc);
		}
	}

	public void addInfo(String tara, String judet, String oras, Loc loc) {
		if (tari.containsKey(tara)) {
			return;
		}
		this.addTara(tara);
		this.addJudet(tara, judet);
		this.addOras(tara, judet, oras);
		this.addLoc(tara, judet, oras, loc);
	}

	/*
	 * @Override public String toString() { StringBuffer str = new StringBuffer();
	 * for (String tara : tari.keySet()) { for (String judet :
	 * tari.get(tara).keySet()) { for (String oras :
	 * tari.get(tara).get(judet).keySet()) { for (Loc locatie :
	 * tari.get(tara).get(judet).get(oras)) { str.append("Tara: " + tara + "\n" +
	 * "Judet: " + judet + "\n" + "Oras: " + oras + "\n" + locatie); } } } }
	 * 
	 * return str.toString(); }
	 */

	public Loc getLocatie(String loc) {
		for (Loc l : locatii) {
			if (l.getNume().equals(loc)) {
				return l;
			}
		}
		return null;
	}

}
