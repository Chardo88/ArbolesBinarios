package Queue;


public class nodeQ<T> {
     private T value=null;
     private nodeQ<T> next=null;
     private nodeQ<T> back=null;
     private long index = 0;
     
     public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}

	public nodeQ(){
		this.value = null;
    	 
     }
     
     public nodeQ(T value) {
    	 this.value = value;
     }
     
 	@Override
 	public String toString() {
 		// TODO Auto-generated method stub
 		return super.toString();
 	}
 	
 	@Override
 	public boolean equals(Object arg0) {
 		// TODO Auto-generated method stub
 		return super.equals(arg0);
 	}
 	
 	
 	
     
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public nodeQ<T> getNext() {
		return next;
	}
	public void setNext(nodeQ<T> next) {
		this.next = next;
	}
	public nodeQ<T> getBack() {
		return back;
	}
	public void setBack(nodeQ<T> back) {
		this.back = back;
	}
   
}
