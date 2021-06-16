package fp.daw.exprog20210616.Ejercicio4;

import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio3 {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		q.offer(6);
		q.offer(7);
		q.offer(8);
		q.offer(9);
		q.offer(10);
		
		System.out.println(q);
		System.out.println(intercalar(q));

	}

	private static Queue<Integer> intercalar(Queue<Integer> q) {
		if(q.size() % 2 == 0) {
			Queue<Integer> q1 = new LinkedList<Integer>();
			Queue<Integer> qf = new LinkedList<Integer>();
			int n = q.size()/2;
			for(int i = 0; i<n;i++) {
				q1.offer(q.poll());
			}
			for(int i = 0; i<n; i++) {
				qf.offer(q1.poll());
				qf.offer(q.poll());
			}
			return qf;
		}
		else {
			throw new  IllegalArgumentException("El tamaño de la cola no es par");
		}
	}

}
