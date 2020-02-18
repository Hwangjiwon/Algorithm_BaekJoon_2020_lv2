package prac_3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Dot {
	int x, y;

	Dot(int y, int x) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int R, C;
	static String[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cnt;

	static Queue<Dot> water;
	static Queue<Dot> doche;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		R = Integer.parseInt(tmp[0]); // y За
		C = Integer.parseInt(tmp[1]); // x ї­

		map = new String[R][C];
		visited = new boolean[R][C];
		water = new LinkedList<Dot>();
		doche = new LinkedList<Dot>();

		for (int i = 0; i < R; i++) {
			tmp = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp[j];
				if (map[i][j].equals("*"))
					water.add(new Dot(i, j));
				if (map[i][j].equals("S"))
					doche.add(new Dot(i, j));
			}
		}

		cnt = 0;
		bfs();
		System.out.println(cnt);

		br.close();
	}

	public static void bfs() {
		while (true) {

			cnt++;
			// water
			int size = water.size();
			for (int i = 0; i < size; i++) {
				Dot w = water.poll();
				int wx = w.x;
				int wy = w.y;

				for (int j = 0; j < 4; j++) {
					int nwx = wx + dx[j];
					int nwy = wy + dy[j];

					if (nwx >= 0 && nwy >= 0 && nwx < C && nwy < R) {
						if (!visited[nwy][nwx]) {
							visited[nwy][nwx] = true;
							if (map[nwy][nwx].equals(".")) {
								map[nwy][nwx] = "*";
								water.add(new Dot(nwy, nwx));
							}
						}
					}
				}
			}

			if (doche.size() == 0) {
				System.out.println("KAKTUS");
				System.exit(0);
				;
			}

			// doche
			size = doche.size();
			for (int i = 0; i < size; i++) {
				Dot d = doche.poll();
				int px = d.x;
				int py = d.y;

				for (int j = 0; j < 4; j++) {
					int npx = px + dx[j];
					int npy = py + dy[j];

					if (npx >= 0 && npy >= 0 && npx < C && npy < R) {
						if (map[npy][npx].equals("D")) {
							return;
						}
						if (!visited[npy][npx]) {
							if (map[npy][npx].equals(".")) {
								visited[npy][npx] = true;
								map[npy][npx] = "S";
								doche.add(new Dot(npy, npx));
							}
						}
					}
				}
			}
//			print(map);
//			System.out.println();
		}
	}

	public static void print(String[][] map) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
	}
}
