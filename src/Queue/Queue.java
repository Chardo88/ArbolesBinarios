package Queue;

import java.util.Iterator;

public class Queue<T> implements iQueue<T>,Iterable<T> {
	
	private nodeQ<T> start = null, end = null;
	nodeQ<T> back;
	nodeQ<T> front;
	int count = 0;
	int size  = 10;
	
	
	public Queue(){
		start = new nodeQ<T>();
		start.setIndex(-1);
		end = new nodeQ<T>();
		end.setIndex(-1);
		nodeQ<T> n = new nodeQ<T>();
		start.setNext(n);
		n.setBack(start);
		nodeQ<T> tmp = start.getNext();
		for (int i = 1; i< size; i++){
			nodeQ<T> nuevo = new nodeQ<T>();
			tmp.setNext(nuevo);
			nuevo.setBack(tmp);
			tmp=tmp.getNext();
		}
		end.setBack(tmp);
		index();
		front = start.getNext();
		back = start.getNext();
	}
	
	
	public Queue(int size){
		this.size = size;
		start = new nodeQ<T>();
		start.setIndex(-1);
		end = new nodeQ<T>();
		end.setIndex(-1);
		nodeQ<T> n = new nodeQ<T>();
		start.setNext(n);
		n.setBack(start);
		nodeQ<T> tmp = start.getNext();
		for (int i = 1; i< size; i++){
			nodeQ<T> nuevo = new nodeQ<T>();
			tmp.setNext(nuevo);
			nuevo.setBack(tmp);
			tmp=tmp.getNext();
		}
		end.setBack(tmp);
		index();
		front = start.getNext();
		back = start.getNext();
	}
	
	public void index(){
		nodeQ<T> tmp = start;
		int i = 0;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			tmp.setIndex(i);
			i++;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			nodeQ<T> tmp = back.getBack();
			int i = 0;
			@Override
			public boolean hasNext() {
				if(tmp.getNext() == null)
					tmp = start.getNext();
				else
					tmp = tmp.getNext();
				return (i++ != count)?true:false;
			}
			@Override
			public T next() {
				return tmp.getValue();
			}
		};
	}


	@Override
	public void enQueue(T value) throws QueueFullException {
		if(IsFull()) throw new QueueFullException("La cola está llena");
		front.setValue(value);
		count++;
		if(front.getNext() == null)
			front = start.getNext();
		else
			front = front.getNext();
		
	}


	@Override
	public T deQueue() throws QueueEmptyException {
		if(IsEmpty()) throw new QueueEmptyException("La cola está vacía");
		T tmp=back.getValue();
		back.setValue(null);
		count--;
		if(back.getNext() == null)
			back = start.getNext();
		else
			back = back.getNext();
		return tmp;
	}


	@Override
	public boolean IsEmpty() {
		return (count == 0);
	}


	@Override
	public boolean IsFull() {
		return (count == size);
	}


	@Override
	public T front() throws QueueEmptyException {
		if(IsEmpty()) throw new QueueEmptyException("La cola está vacía");
		return back.getValue();
	}


	@Override
	public nodeQ<T> Search(T value) throws QueueEmptyException {
		if(IsEmpty()) throw new QueueEmptyException("Pila vacía");	
		nodeQ<T> tmp = back;
		int i = 0;
		while (i<=count){
			i++;
			if (tmp.getValue().equals(value))
				return tmp;
			if(tmp.getNext() == null)
				tmp = start.getNext();
			else
				tmp = tmp.getNext();
		}
		return null;
	}


	@Override
	public void clear() {
		while(!IsEmpty())
			try {
				deQueue();
			} catch (QueueEmptyException e) {
				e.printStackTrace();
			}
	}


	@Override
	public int size() {
		return count;
	}
}
