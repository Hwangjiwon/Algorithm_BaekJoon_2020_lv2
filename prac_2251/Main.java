package prac_2251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Water {
	int a, b, c;

	Water(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

public class Main {
	static int A, B, C;
	static boolean[][][] visited;
	static HashSet<Integer> list = new HashSet<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		A = Integer.parseInt(str[0]); // able
		B = Integer.parseInt(str[1]); // able
		C = Integer.parseInt(str[2]); // able, total

		visited = new boolean[A + 1][B + 1][C + 1];
		sol();

		LinkedList<Integer> tmp = new LinkedList<>(list);
		Collections.sort(tmp);
		for (int i = 0; i < tmp.size(); i++)
			System.out.print(tmp.get(i) + " ");

		br.close();
	}

	public static void sol() {
		Queue<Water> q = new LinkedList<>();
		q.add(new Water(0, 0, C));

		while (!q.isEmpty()) {
			Water w = q.poll();
			int wa = w.a;
			int wb = w.b;
			int wc = w.c;

			if (visited[wa][wb][wc])
				continue;
			visited[wa][wb][wc] = true;
			if (wa == 0)
				list.add(wc);

			// c->a
			if (wc > 0 && wa < A) {
				int ableA = A - wa;

				if (wc > ableA) {
					q.add(new Water(A, wb, wc - ableA));
				} else
					q.add(new Water(wa + wc, wb, 0));
			}

			// c->b
			if (wc > 0 && wb < B) {
				int ableB = B - wb;
				if (wc > ableB) {
					q.add(new Water(wa, B, wc - ableB));
				} else
					q.add(new Water(wa, wb + wc, 0));
			}

			// b->a
			if (wb > 0 && wa < A) {
				int ableA = A - wa;
				if (wb > ableA) {
					q.add(new Water(A, wb - ableA, wc));
				} else
					q.add(new Water(wa + wb, 0, wc));
			}

			// b->c
			if (wb > 0 && wc < C) {
				int ableC = C - wc;
				if (wb > ableC) {
					q.add(new Water(wa, wb - ableC, C));
				} else
					q.add(new Water(wa, 0, wc + wb));
			}

			// a->b
			if (wa > 0 && wb < B) {
				int ableB = B - wb;
				if (wa > ableB) {
					q.add(new Water(wa - ableB, B, wc));
				} else
					q.add(new Water(0, wb + wa, wc));
			}

			// a->c
			if (wa > 0 && wc < C) {
				int ableC = C - wc;
				if (wa > ableC) {
					q.add(new Water(wa - ableC, wb, C));
				} else
					q.add(new Water(0, wb, wc + wa));
			}
		}

	}

}
