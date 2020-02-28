package prac_16956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	static int R, C;
	static String[][] map;
	static Queue<Dot> sheep;
	static Queue<Dot> wolf;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]); // y
		C = Integer.parseInt(input[1]); // x

		map = new String[R][C];
		sheep = new LinkedList<>();
		wolf = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = input[j];
				if (map[i][j].equals("S")) {
					sheep.add(new Dot(i, j));
				} else if (map[i][j].equals("W")) {
					wolf.add(new Dot(i, j));
				}
			}
		}
		
		sol();

		br.close();
	}

	public static void sol() {
		if (wolf.size() == 0 || sheep.size() == 0) {
			result = 1;
			for (int i = 0; i < R; i++) {
				int flag = 0;
				for (int j = 0; j < C; j++) {
					if (map[i][j].equals(".")) {
						map[i][j] = "D";
						flag = 1;
						break;
					}
				}
				if (flag == 1)
					break;
			}
			print(result);
			return;
		}

		while (!wolf.isEmpty()) {
			Dot w = wolf.poll();
			int x = w.x;
			int y = w.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || ny >= R || nx >= C)
					continue;

				if (map[ny][nx].equals(".")) {
					map[ny][nx] = "D";
					result = 1;
				} else if (map[ny][nx].equals("S")) {
					result = 0;
				}
			}

		}
		print(result);
	}

	public static void print(int result) {
		System.out.println(result);
		if (result == 0)
			return;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
