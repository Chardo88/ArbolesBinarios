package Queue;


public interface iQueue<T> {
	public void enQueue(T value) throws QueueFullException;
	public T deQueue() throws QueueEmptyException;
	public boolean IsEmpty();
	public boolean IsFull();
	public T front() throws QueueEmptyException;
	public nodeQ<T> Search(T value) throws QueueEmptyException;
	public void clear();
	public int size();

}
