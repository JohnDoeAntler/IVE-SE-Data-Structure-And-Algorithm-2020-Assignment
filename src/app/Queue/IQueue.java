package app.Queue;

public interface IQueue {

	public abstract int size();

	public abstract boolean isEmpty();

	public abstract void add(int num);

	public abstract int remove();

	public abstract int peek();

}