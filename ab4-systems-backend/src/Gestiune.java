import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Gestiune {

	private HashMap<String, ArrayList<Loc>> orase = new HashMap<>();
	private HashMap<String, ArrayList<Loc>> judete = new HashMap<>();
	private HashMap<String, ArrayList<Loc>> tari = new HashMap<>();
	private ArrayList<Loc> locatii = new ArrayList<>();
	private HashMap<String, HashMap<String, HashMap<String, ArrayList<Loc>>>> info = new HashMap<>();

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
	public HashMap<String, ArrayList<Loc>> getOrase() {
		return orase;
	}

	public void setOrase(HashMap<String, ArrayList<Loc>> orase) {
		this.orase = orase;
	}

	public HashMap<String, ArrayList<Loc>> getJudete() {
		return judete;
	}

	public void setJudete(HashMap<String, ArrayList<Loc>> judete) {
		this.judete = judete;
	}

	public HashMap<String, ArrayList<Loc>> getTari() {
		return tari;
	}

	public void setTari(HashMap<String, ArrayList<Loc>> tari) {
		this.tari = tari;
	}

	public ArrayList<Loc> getLocatii() {
		return locatii;
	}

	public void setLocatii(ArrayList<Loc> locatii) {
		this.locatii = locatii;
	}

	public HashMap<String, HashMap<String, HashMap<String, ArrayList<Loc>>>> getInfo() {
		return info;
	}

	public void setInfo(HashMap<String, HashMap<String, HashMap<String, ArrayList<Loc>>>> info) {
		this.info = info;
	}

	/*
	 * Getteri pentru diferite valori
	 */
	public HashMap<String, HashMap<String, ArrayList<Loc>>> getJudete(String tara) {
		if (info.containsKey(tara)) {
			return info.get(tara);
		}
		return null;
	}

	public HashMap<String, ArrayList<Loc>> getOrase(String tara, String judet) {
		if (info.containsKey(tara)) {
			if (info.get(tara).containsKey(judet)) {
				return info.get(tara).get(judet);
			}
		}
		return null;
	}

	public ArrayList<Loc> getLocuri(String tara, String judet, String oras) {
		if (info.containsKey(tara)) {
			if (info.get(tara).containsKey(judet)) {
				if (info.get(tara).get(judet).containsKey(oras)) {
					return info.get(tara).get(judet).get(oras);
				}
			}
		}
		return null;
	}

	/*
	 * Adderi ai inputului
	 */
	public void addTara(String tara) {
		if (!info.containsKey(tara)) {
			info.put(tara, new HashMap<>());
			tari.put(tara, new ArrayList<>());
		}
	}

	public void addJudet(String tara, String judet) {
		if (!info.get(tara).containsKey(judet)) {
			info.get(tara).put(judet, new HashMap<>());
			judete.put(judet, new ArrayList<>());
		}
	}

	public void addOras(String tara, String judet, String oras) {
		if (!info.get(tara).get(judet).containsKey(oras)) {
			info.get(tara).get(judet).put(oras, new ArrayList<>());
			orase.put(oras, new ArrayList<>());
		}
	}

	public void addLoc(String tara, String judet, String oras, Loc loc) {
		if (!info.get(tara).get(judet).get(oras).contains(loc)) {
			info.get(tara).get(judet).get(oras).add(loc);
			locatii.add(loc);

			for (String t : tari.keySet()) {
				if (t.equals(tara)) {
					tari.get(tara).add(loc);
				}
			}

			for (String j : judete.keySet()) {
				if (j.equals(judet)) {
					judete.get(judet).add(loc);
				}
			}

			for (String o : orase.keySet()) {
				if (o.equals(oras)) {
					orase.get(oras).add(loc);
				}
			}

		}
	}

	public void addInfo(String tara, String judet, String oras, Loc loc) {
		if (info.containsKey(tara)) {
			return;
		}
		this.addTara(tara);
		this.addJudet(tara, judet);
		this.addOras(tara, judet, oras);
		this.addLoc(tara, judet, oras, loc);
	}

	/*
	 * @Override public String toString() { StringBuffer str = new StringBuffer();
	 * for (String tara : info.keySet()) { for (String judet :
	 * info.get(tara).keySet()) { for (String oras :
	 * info.get(tara).get(judet).keySet()) { for (Loc locatie :
	 * info.get(tara).get(judet).get(oras)) { str.append("Tara: " + tara + "\n" +
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

	public ArrayList<Loc> getTop(String criteriu, String perioada) {
		ArrayList<Loc> top = new ArrayList<>();
		Comparator<Loc> c = new Comparator<Loc>() {

			@Override
			public int compare(Loc arg0, Loc arg1) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		
		if (tari.containsKey(criteriu)) {
			tari.get(criteriu).sort(c);
			for (int i=0; i<5; i++) {
				top.add(tari.get(criteriu).get(i));
			}
		}

		if (judete.containsKey(criteriu)) {
			judete.get(criteriu).sort(c);
			for (int i=0; i<5; i++) {
				top.add(judete.get(criteriu).get(i));
			}
		}

		if (orase.containsKey(criteriu)) {
			judete.get(criteriu).sort(c);
			for (int i=0; i<5; i++) {
				top.add(judete.get(criteriu).get(i));
			}
		}

		return top;
	}

}
