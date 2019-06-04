import java.util.Arrays;

public class SearchesDemo{
	public static void main(String[] args) {
		String[] a = new String[] {"Dog", "Cat", "Bat", "Cow", "Pig", "Crow"};
		Integer[] b = new Integer[] {5, 7, 2, 3, 8, 24, 1, 15};

		//Must sort the arrays so we can properly use bsearch
		Arrays.sort(a);
		Arrays.sort(b);

		System.out.println("Integer Test Array Contains: ");
		for (int i=0; i<b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println("\n"+b.length);

		for(int i=2; i<6; i++) {
			int tempResult = Searches.bSearch(b, 0, b.length-1, i);
			if(tempResult>0) {
				System.out.println("" + i + " is in the array integer array at position " + tempResult);
			} else {
				System.out.println("" + i + " is not in the array.");
			}
		}
		System.out.println("\n");

		System.out.println("String Test Array Contains: ");
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");

		System.out.println("Searching for a Dog in the array");
		int tempResultString1 = Searches.bSearch(a, 0, a.length-1, "Dog");
		if(tempResultString1>0) {
			System.out.println("Dog is in the array at position " + tempResultString1);
		} else {
			System.out.println("Dog is not in the array");
		}

		System.out.println("Searching for a Mouse in the array");
		int tempResultString2 = Searches.bSearch(a, 0, a.length-1, "Mouse");
		if(tempResultString2>0) {
			System.out.println("Mouse is in the array at position " + tempResultString2);
		} else {
			System.out.println("Mouse is not in the array");
		}

	}
}