package prac_9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int min;

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
			visited = new boolean[h][w];

			for (int i = 0; i < w; i++) {
				map[0][i] = '.';
				map[h - 1][i] = '.';
			}
			for (int i = 0; i < h; i++) {
				map[i][0] = '.';
				map[i][w - 1] = '.';
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
		}

		br.close();
	}

}
