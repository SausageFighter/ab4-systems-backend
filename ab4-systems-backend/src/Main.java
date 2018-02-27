import java.util.ArrayList;

/**
 * 
 * @author Mihai Olaru on 27.02.2018
 *
 */
public class Main {

	public static void main(String[] args) {

		ArrayList<String> s = new ArrayList<>();
		s.add("poze");
		s.add("video");
		Gestiune.getInstance().addInfo("Romania", "Teleorman", "Rosiorii", new Loc("Statuie", "23.2-23.9", 23.78, s));

		System.out.println(Gestiune.getInstance().getLocatie("Statuie"));

	}

}
