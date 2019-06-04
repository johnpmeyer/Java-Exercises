public class Searches{
	public static <T extends Comparable> int bSearch(T[] a, int first, int last, T key) {
		int result;

		if(first>last) {
			result = -1;
		} else {
			int mid = (first + last)/2;
			System.out.println("Mid= "+a[mid]);

			if(key.compareTo(a[mid])==0) {
				result = mid;
			} else if(key.compareTo(a[mid])<0) {
				result = bSearch(a, first, mid-1, key);
			} else {
				result = bSearch(a, mid+1, last, key);
			}
		}

		return result;
	}

}
