package app.LinkedList;

public class LinkedList < T > {

	//
	// ─── HEAD NODE ──────────────────────────────────────────────────────────────────
	//
	private ListNode < T > head;

	//
	// ─── TAIL NODE ──────────────────────────────────────────────────────────────────
	//
	private ListNode < T > tail;


	//
	// ─── CONSTRUCTOR ────────────────────────────────────────────────────────────────
	//
	public LinkedList() {
		head = null;
	}


	//
	// ─── IS EMPTY ───────────────────────────────────────────────────────────────────
	//
	public boolean isEmpty() {
		return (head == null);
	}

	//
	// ─── ADD TO HEAD ────────────────────────────────────────────────────────────────
	//
	public void addToHead(T item) {
		if (isEmpty()) {
			head = tail = new ListNode < T > (item);
		} else {
			head = new ListNode < T > (item, head);
		}
	}

	//
	// ─── ADD TO TAIL ────────────────────────────────────────────────────────────────
	//
	public void addToTail(T item) {
		if (isEmpty()) {
			head = tail = new ListNode < T > (item);
		} else {
			tail.next = new ListNode < T > (item);
			tail = tail.next;
		}
	}

	//
	// ─── REMOVE FROM HEAD ───────────────────────────────────────────────────────────
	//
	public T removeFromHead() throws EmptyListException {
		T item = null;

		if (isEmpty()) {
			throw new EmptyListException();
		}

		item = head.data;

		if (head == tail) {
			head = tail = null;
		} else {
			head = head.next;
		}

		return item;
	}

	//
	// ─── REMOVE FROM TAIL ───────────────────────────────────────────────────────────
	//
	public T removeFromTail() throws EmptyListException {

		if (isEmpty()) {
			throw new EmptyListException();
		}

		T item = tail.data;


		if (head == tail) {
			head = tail = null;
			return item;
		}

		ListNode < T > current = head;

		while (current.next != tail) {
			current = current.next;
		}

		tail = current;
		tail.next = null;
		return item;
	}

	//
	// ─── TO STRING ──────────────────────────────────────────────────────────────────
	//
	@Override
	public String toString() {
		String s = "[ ";
		ListNode < T > current = head;

		while (current != null) {
			s += current.data + " ";
			current = current.next;
		}

		return s + "]";
	}

	//
	// ─── GET COUNT ──────────────────────────────────────────────────────────────────
	//
	public int size() {
		int cnt = 0;

		ListNode < T > tmp = head;
		while (tmp != null) {
			tmp = tmp.next;
			++cnt;
		}

		return cnt;
	}

	//
	// ─── GET ITEM AT ────────────────────────────────────────────────────────────────
	//
	public T getItemAt(int n) {
		if (n < 0 || n >= this.size()) {
			// throw exception
			throw new IndexOutOfBoundsException();
		}

		// assign value 0 to currentPos.
		int currentPos = 0;
		// assign value current to current.
		ListNode < T > current = head;
		while (currentPos != n) {
			// assign value current.next to current.
			current = current.next;
			// assign value currentPos+1 to currentPos.
			currentPos++;
		}

		// return current.data
		return current.data;
	}
}