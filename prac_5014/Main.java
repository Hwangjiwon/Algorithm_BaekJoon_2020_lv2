package prac_5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int F, S, G, U, D;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		F = Integer.parseInt(str[0]);
		S = Integer.parseInt(str[1]);
		G = Integer.parseInt(str[2]);
		U = Integer.parseInt(str[3]);
		D = Integer.parseInt(str[4]);

		visited = new int[F + 1];
		Arrays.fill(visited, -1);
		sol();
		br.close();
	}

	public static void sol() {
		Queue<Integer> q = new LinkedList<Integer>();

		visited[S] = 0;
		q.add(S);

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == G) {
				break;
			}

			int up = cur + U;
			int down = cur - D;

			if (up <= F && visited[up] == -1) {
				visited[up] = visited[cur] + 1;
				q.add(up);
			}
			if (down >= 1 && visited[down] == -1) {
				visited[down] = visited[cur] + 1;
				q.add(down);
			}
		}
		
		if (visited[G] == -1)
			System.out.println("use the stairs");
		else
			System.out.println(visited[G]);

	}
}
