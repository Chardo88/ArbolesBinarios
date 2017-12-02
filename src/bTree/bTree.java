package bTree;

import Queue.Queue;
import Queue.QueueEmptyException;
import Queue.QueueFullException;
import node.node;

public class bTree<T extends Comparable<T>> implements Comparable<T> {

	public node<T> root   = null;
	private int     height = 0;
	private int 	count  = 0;
	private int     size   = 0;
	private Queue<node<T>> q;
	
	public bTree(){
		root = new node<T>();
	}
	
	public bTree(T value){
		this.root = new node<T>(value);
		size++;
	}
	
	public void add(T value){
		if (root.getValue() == null)
			root.setValue(value);
		
		else{
			count= 0;
			add(value, root);
		}
		if (count > height)
			height = count;
		size++;
	}
	
	private void add(T value, node<T> root){
		count++;
		if (root.getValue().compareTo(value) >= 1){
			if(root.getLeft()== null){
				root.setLeft(new node<>(value));
				return;
			}
			else{
				
				add(value, root.getLeft());
			}
		}else if (root.getValue().compareTo(value) <= -1 || root.getValue().compareTo(value) == 0){
			if(root.getRight()== null){
				root.setRight(new node<>(value));
				
				return;
			}
			else{
				
				add(value,root.getRight());
			}
		}
	}
	
	public boolean remove(T value){
		node<T> tmp = DeepSearch(value);
		
		if(tmp !=null){
			size--;
			return remove(value,tmp,isChild(value));
		}
		else
			return false;
	}
	
	private boolean remove(T value, node<T> root, node<T> papu) {
		
		if(isChild(value)== null){
			node<T> min = MinSearch(root.getRight());
			min.setLeft(root.getLeft());
			this.root = root.getRight();
			return true;
		}
		
		if(root.getLeft() == null && root.getRight() == null){
			if( papu.getLeft() != null && papu.getLeft().equals(root)){
				papu.setLeft(null);
			}
			else if(papu.getRight() != null)
				papu.setRight(null);
			return true;
		}
		else if(root.getLeft() != null && root.getRight() == null){
			if(papu.getLeft().equals(root))
				papu.setLeft(root.getLeft());
			else
				papu.setRight(root.getLeft());
			return true;
		}
		else if(root.getLeft() == null && root.getRight() != null){
			if(papu.getLeft().equals(root))
				papu.setLeft(root.getRight());
			else
				papu.setRight(root.getRight());
			return true;
		}
		else{
			if(papu.getLeft().equals(root)){
				node<T> Left = MinSearch(root.getRight());
				Left.setLeft(root.getLeft());
				papu.setLeft(root.getRight());
			}
			else{
				node<T> Left = MinSearch(root.getRight());
				Left.setLeft(root.getLeft());
				papu.setRight(root.getRight());	
			}
			return true;
		}
	}
	

	public void PrintInorder(){
		if(!isEmpty())
			PrintInorder(root);
	}
	
	private void PrintInorder(node<T> root){
		if(root !=  null) {
			PrintInorder(root.getLeft());
			System.out.println(root.getValue().toString());
			PrintInorder(root.getRight());
		}
	}
	
	public void PrintPreOrder(){
		if(!isEmpty())
			PrintPreOrder(root);
	}
	
	public void PrintPreOrder(node<T> root){
		if(root !=  null) {
			System.out.println(root.getValue().toString());
			PrintPreOrder(root.getLeft());
			PrintPreOrder(root.getRight());
		}
	}
	
	public void PrintPostOrder(){
		if(!isEmpty())
			PrintPostOrder(root);
	}
	
	public void PrintPostOrder(node<T> root){
		if(root !=  null) {
			PrintPostOrder(root.getLeft());
			PrintPostOrder(root.getRight());
			System.out.println(root.getValue().toString());
		}
	}
	
	public node<T> isChild(T value){
		if(DeepSearch(value)==null)
			return null;
		return isChild(value,root,null);
	}
	
	private node<T> isChild(T value,node<T> root,node<T>papu) {
		if(root != null){
			if(root.getValue().equals(value)) 
				return papu;
			if(root.getValue().compareTo(value) <= -1)
				return isChild(value,root.getRight(),root);
			else
				return isChild(value,root.getLeft(),root);
		}else
			return null;
	}

	public boolean isEmpty(){
		return (root == null);
	}
	
	public node<T> DeepSearch(T value){
		return DeepSearch(value,root);
	}
	
	private node<T> DeepSearch(T value,node<T> root) {
		if(root != null){
			if(root.getValue().equals(value)) 
				return root;
			if(root.getValue().compareTo(value) <= -1)
				return DeepSearch(value,root.getRight());
			else
				return DeepSearch(value,root.getLeft());
		}else
			return null;
	}
	
	public node<T> breadthSearch(T value) throws Exception{
		int h = height(root);
		int i;
		q = new Queue<node<T>>(size);
		for (i=1; i<=h; i++)
			breadthSearch(root, i);
		while(!q.IsEmpty()){
			if(q.front().getValue().equals(value))
				return q.deQueue();
			else
				q.deQueue();
		}
		return null;
	}
	
	private void breadthSearch(node<T> root,int level) throws Exception{
		if (root == null)
            return;
        if (level == 1)
            q.enQueue(root);
        else if (level > 1)
        {
        	breadthSearch(root.getLeft(), level-1);
        	breadthSearch(root.getRight(), level-1);
        }
	}
	
	private node<T> MinSearch(node<T> root){
		while(root.getLeft() != null)
			root = root.getLeft();
		return root;
	}
	
	private node<T> MaxSearch(node<T> root){
		while(root.getRight() != null)
			root = root.getRight();
		return root;
	}
	
	public int height(node<T> root)
    {
        if (root == null)
           return 0;
        else
        {
            int lheight = height(root.getLeft());
            int rheight = height(root.getRight());
             
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }
    }
	
	public int MaxDepth(){
		return height(root)-1;
	}

	public void Clear(){
		Clear(root);
		this.root = null;
	}
	
	private void Clear(node<T> root){
		if(root !=  null) {
			Clear(root.getLeft());
			Clear(root.getRight());
			root.setLeft(null);
			root.setRight(null);
		}	
	}
	
	private boolean Exists(T value){
		return (DeepSearch(value) != null);
	}
	@Override
	public int compareTo(T o) {
		return 0;
	}

}
