package prac_9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Dot {
	int x, y;

	Dot(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int t, h, w;
	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		t = Integer.parseInt(input[0]);

		while (t-- > 0) {
			Dot helper = new Dot(0, 0);
			Dot prisoner1 = null;
			Dot prisoner2 = null;

			input = br.readLine().split(" ");
			h = Integer.parseInt(input[0]) + 2;
			w = Integer.parseInt(input[1]) + 2;

			map = new char[h][w];
			
			for (int i = 0; i < h; i++) {
				Arrays.fill(map[i], '.');
			}
			for (int i = 1; i < h - 1; i++) {
				input = br.readLine().split("");
				for (int j = 1; j < w - 1; j++) {
					map[i][j] = input[j - 1].charAt(0);
					if (map[i][j] == '$') {
						if (prisoner1 == null) {
							prisoner1 = new Dot(i, j);
						} else
							prisoner2 = new Dot(i, j);
					}
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

			// bfs();
			// System.out.println(min);

			int[][] dist1 = bfs(helper);
			int[][] dist2 = bfs(prisoner1);
			int[][] dist3 = bfs(prisoner2);
			int dist = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == '*')
						continue;

					dist = dist1[i][j] + dist2[i][j] + dist3[i][j];
					if (map[i][j] == '#')
						dist -= 2;
					
					min = Math.min(min, dist);
				}
			}
			System.out.println(min);
		}

		br.close();
	}

	public static int[][] bfs(Dot person) {
		int[][] dist = new int[h][w];

		for (int i = 0; i < h; i++)
			Arrays.fill(dist[i], -1);

		Queue<Dot> q = new LinkedList<Dot>();
		q.add(person);
		dist[person.y][person.x] = 0;
		
		while (!q.isEmpty()) {
			Dot dot = q.poll();
			int x = dot.x;
			int y = dot.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= w || ny >= h)
					continue;
				if (map[ny][nx] == '*')
					continue;

				if (map[ny][nx] == '.' || map[ny][nx] == '$') {
					if (dist[ny][nx] == -1 || dist[ny][nx] > dist[y][x]) {
						dist[ny][nx] = dist[y][x];
						q.add(new Dot(ny, nx));
					}
				}

				if (map[ny][nx] == '#') {
					if (dist[ny][nx] == -1 || dist[ny][nx] > dist[y][x] + 1) {
						dist[ny][nx] = dist[y][x] + 1;
						q.add(new Dot(ny, nx));
					}
				}
			}
		}
		return dist;
	}

}
