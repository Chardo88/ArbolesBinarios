package app;

import Queue.Queue;
import Queue.QueueFullException;
import alum.Alumno;
import bTree.bTree;
import node.node;

/*
 * Busqueda profunda
 * Recorrido en profundidad
 * */

public class app {

	public static void main(String[] args) throws Exception {
		bTree<Integer> num = new bTree<Integer>();
/*		
		for (int i = 0; i < 1000; i++) {
			num.add((int)(Math.random()*100));
		}
		for (int i = 0; i < 99; i++) {
			while(num.remove(i));
		}
		while(num.remove(99));
		
		
		num.PrintInorder();
		System.out.println(num.MaxDepth());
		
*/		
		num.add(40);
		num.add(20);
		num.add(10);
		num.add(30);
		num.add(60);
		num.add(50);
		num.add(70);
		
//		System.out.println(num.breadthSearch(70).getValue());
//		num.PrintPostOrder();
//		num.PrintPreOrder();
//		num.PrintInorder();
//		num.Clear();
//		System.out.println(num.isEmpty());
//		System.out.println(num.MaxDepth());
//		System.out.println("hijo : " + num.isChild(9).getValue());
/*		
		Alumno a1 = new Alumno();
		a1.setNombre("Pepe");
		a1.setPromedio(9.99);
		Alumno a2 = new Alumno();
		a2.setNombre("Jose");
		a2.setPromedio(7.99);
		Alumno a3 = new Alumno();
		a3.setNombre("Angel");
		a3.setPromedio(5.99);
		
		bTree<Alumno> Al = new bTree<Alumno>();
		Al.add(a1);
		Al.add(a2);
		Al.add(a3);
		
		Al.PrintInorder();
		
		*/
		
	}

}
