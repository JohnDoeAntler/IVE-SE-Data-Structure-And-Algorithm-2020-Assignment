package app.Queue;

import app.LinkedList.LinkedList;

public class Queue implements IQueue {

	private LinkedList<Integer> list;

	public Queue() {
		this.list = new LinkedList<>();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	public boolean contains(int num) {
		for (int i = 0; i < this.size(); i++) {
			if (list.getItemAt(i).equals(num)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void add(int num) {
		list.addToTail(num);
	}

	@Override
	public int remove() throws QueueEmptyException {
		return list.removeFromHead();
	}

	public int top() throws QueueEmptyException {
		int ret = list.removeFromTail();
		list.addToTail(ret);
		return ret;
	}

	@Override
	public int peek() throws QueueEmptyException {
		int ret = list.removeFromHead();
		list.addToHead(ret);
		return ret;
	}

	@Override
	public String toString() {
		return list.toString();
	}

}