public class LinkedList<T> implements Cloneable{

	private class Node<T> {
		private T data;
		private Node<T> next, previous;

		public Node() {
			data=null;
			next=null;
			previous=null;
		}

		public Node(T newData, Node<T> nextValue, Node<T> previousValue) {
			data = newData;
			next= nextValue;
			previous = previousValue;
		}

		public String toString() {
			return data.toString();
		}
	}

	public class NodeIterator{
		private Node<T> position, previous;

		public NodeIterator() {
			position = head;
			previous = null;
		}

		public void restart() {
			position = head;
			previous=null;
		}

		public T next() throws Exception {
			if(!hasNext()) {
				throw new Exception();
			}

			T toReturn = position.data;
			previous = position;
			position = position.next;
			return toReturn;
		}

		public boolean hasNext() {
			return (position!=null);
		}

		public T peek() {
			if(!hasNext()) {
				throw new IllegalStateException();
			}

			return position.data;
		}

		public void add(T newData) {
			Node<T> newNode = new Node(newData, position.next, position);
			position.next = newNode;
			newNode.next.previous = newNode;
		}

		public void delete() {
			if(position.previous!=null) {
				position.previous.next = position.next;
				position.next.previous = position.previous;
			}
		}
	}

	public NodeIterator iterator() {
		return new NodeIterator();
	}

	private Node<T> head, tail;

	public LinkedList() {
		head = null;
		tail = null;
	}

	public LinkedList(T initialHead, T initialTail) {
			head = new Node<T>(initialHead, null, null);
			tail = new Node<T>(initialTail, null, head);
			head.next = tail;
	}

	public LinkedList(LinkedList otherList) {
		if(otherList==null) {
			throw new NullPointerException();
		}

		if(otherList.head==null) {
			head=null;
		} else {
			head = copyOf(otherList.head);
			Node<T> position = head;
			while(position.next!=null) {
				position = position.next;
			}

			tail = position;
		}
	}

	private Node copyOf(Node<T> otherHead) {
		Node<T> position = otherHead;
		Node<T> newHead;
		Node<T> end = null;

		newHead = new Node<T>(position.data, null, null);
		end = newHead;

		position = position.next;

		while(position!=null) {
			end.next = new Node<T>(position.data, null, null);
			end.next.previous = end;
			end = end.next;
			position = position.next;
		}

		return newHead;
	}

	public Object clone() {
		try{
			LinkedList copy = (LinkedList) super.clone();
			copy.head = copyOf(this.head);
			return copy;
		} catch(CloneNotSupportedException e) {
			return null;
		}
	}

	public void addToStart(T itemData) {
		head = new Node<T>(itemData, head, null);

		if(head.next!=null) {
			head.next.previous = head;
		}

		if(tail==null && head.next!=null) {
			tail = head.next;
		}
	}

	public boolean deleteHeadNode() {
		if(head!=null) {
			head = head.next;
			head.previous = null; // removes reference to old head
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		int count = 0;
		Node<T> position = head;

		while(position!=null) {
			count++;
			position = position.next;
		}

		return count;
	}

	public boolean contains(T item) {
		return (find(item)!=null);
	}

	private Node<T> find(T target) {
		Node<T> position = head;
		T itemAtPosition;

		while(position!=null) {
			itemAtPosition = position.data;
			if(itemAtPosition.equals(target))
				return position;
			position = position.next;
		}

		return null;
	}

	public T findData(T target) {
		return find(target).data;
	}

	public String toString() {
		if(head==null && tail==null) {
			return "This list is empty";
		}

		Node<T> position = head;
		String tempString = "";
		while(position!=null) {
			tempString = tempString + "\n" + "Data: " + position.data + ". Previous Node: " + position.previous
			+ ". Next Node: " + position.next;
			position = position.next;
		}
		tempString = tempString + "\nHead = " + head + "\nTail = " + tail;
		return tempString;
	}

	public String outputBackwards() {
		Node<T> position = tail;
		String tempString = "";

		while(position!=null) {
			tempString = tempString + "\n" + "Data: " + position.data + ". Previous Node: " + position.previous
			+ ". Next Node: " + position.next;
			position = position.previous;
		}
		tempString = tempString + "\nHead = " + head + "\nTail = " + tail;

		return tempString;
	}

	public boolean isEmpty() {
		return (head==null);
	}

	public void clear() {
		head=null;
		tail=null;
	}

	public boolean equals(Object otherObject) {
		if(otherObject == null) {
			return false;
		} else if(getClass() != otherObject.getClass() ) {
			return false;
		} else {
			LinkedList<T> otherList = (LinkedList<T>)otherObject;
			if(size()!= otherList.size()) {
				return false;
			}

			Node<T> position = head;
			Node<T> otherPosition = otherList.head;
			while(position!=null) {
				if(!(position.data.equals(otherPosition.data)))
					return false;
				position = position.next;
				otherPosition = otherPosition.next;
			}

			return true;
		}
	}

}