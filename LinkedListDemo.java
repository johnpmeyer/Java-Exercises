public class LinkedListDemo{


	public static void main(String[] args) {
		System.out.println("Making a linked list with values apple and orange");
		LinkedList<String> list1 = new LinkedList<String>("Apple", "Orange");
		System.out.println("New List:");
		System.out.println(list1);
		System.out.println("\nAdding a pineapple to the front");
		list1.addToStart("Pineapple");
		System.out.println(list1);

		System.out.println("\nMaking a copy of the first list");
		LinkedList<String> list2 = new LinkedList<String>(list1);
		if(list1==list2) {
					System.out.println("Yay");
				} else {
			System.out.println("Neigh");}
		System.out.println("New List:");
		System.out.println(list2);

		System.out.println("\nLet's print the list backwards");
		System.out.println(list2.outputBackwards());

		System.out.println("\nLet's demonstrate the iterator working by adding a pear after the apple");
		try{
			LinkedList.NodeIterator i = list2.iterator();
			i.next();
			i.add("Pear");
			System.out.println(list2);
			System.out.println("\nFinally, let's delete the pear");
			i.restart();
			i.next();
			i.next();
			i.delete();
			System.out.println(list2);
		} catch(Exception e) {
			System.out.println("Fatal Error");
			System.exit(0);
		}

	}
}