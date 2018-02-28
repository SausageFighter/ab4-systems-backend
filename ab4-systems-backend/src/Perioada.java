
public class Perioada {

	private int ziStart;
	private int lunaStart;
	private int ziFinal;
	private int lunaFinal;

	public Perioada (int ziStart, int lunaStart, int ziFinal, int lunaFinal) {
		this.ziStart = ziStart;
		this.lunaStart = lunaStart;
		this.ziFinal = ziFinal;
		this.lunaFinal = lunaFinal;
	}
	
	public int getZiStart() {
		return ziStart;
	}

	public void setZiStart(int ziStart) {
		this.ziStart = ziStart;
	}

	public int getLunaStart() {
		return lunaStart;
	}

	public void setLunaStart(int lunaStart) {
		this.lunaStart = lunaStart;
	}

	public int getZiFinal() {
		return ziFinal;
	}

	public void setZiFinal(int ziFinal) {
		this.ziFinal = ziFinal;
	}

	public int getLunaFinal() {
		return lunaFinal;
	}

	public void setLunaFinal(int lunaFinal) {
		this.lunaFinal = lunaFinal;
	}

}
