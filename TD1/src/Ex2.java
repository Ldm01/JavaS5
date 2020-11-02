import java.util.ArrayList;

public class Ex2 {
	
	public static ArrayList<Integer> sommeLists(ArrayList<Integer> l1, ArrayList<Integer> l2) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (l1.size() != l2.size()) {
			return new ArrayList<Integer>();
		} else {
			for (int i = 0; i < l1.size(); i++) {
				result.add(l1.get(i) + l2.get(i));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();

		// l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(5);
		l1.add(8);

		l2.add(1);
		l2.add(2);
		l2.add(3);
		l2.add(4);
		l2.add(5);

		if (sommeLists(l1, l2).size() == 0) {
			System.out.println("Les 2 listes rentrées ne sont pas de la même taille !");
		}

		System.out.println(sommeLists(l1, l2));

	}
}
