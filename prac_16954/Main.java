package prac_16954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static String[][] map;
	static boolean[][] visited;
	static List<Dot> wall = new LinkedList<>();
	static int[] dx = { 0, 0, -1, 1, 1, -1, 1, -1, 0 };
	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1, 0 };
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new String[8][8];
		visited = new boolean[8][8];
		String[] tmp;
		for (int i = 0; i < 8; i++) {
			tmp = br.readLine().split("");
			for (int j = 0; j < 8; j++) {
				map[i][j] = tmp[j];
				if (map[i][j].equals("#"))
					wall.add(new Dot(i, j));
			}
		}

		if (wall.size() > 0) {
			bfs();
		} else
			result = 1;
		System.out.println(result);

		br.close();
	}

	public static void bfs() {
		Queue<Dot> user = new LinkedList<Dot>();
		user.add(new Dot(7, 0));

		while (!user.isEmpty()) {
			Dot dot = user.poll();
			int x = dot.x;
			int y = dot.y;

			if (x == 7 && y == 0) {
				result = 1;
				continue;
			}

			if (map[y][x].equals("#")) {
				result = 0;
				continue;
			}

			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8)
					continue;
				
				if (map[ny][nx].equals("#"))
					continue;

				if (map[ny][nx].equals(".") && !visited[ny][nx]) {
					visited[ny][nx] = true;
					user.add(new Dot(ny, nx));
				}

			}

			// ∫Æ¿Ãµø
			for (int i = 0; i < wall.size(); i++) {
				int wx = wall.get(i).x;
				int wy = wall.get(i).y;

				map[wy][wx] = ".";
				if (wy + 1 < 8)
					map[wy + 1][wx] = "#";
			}

			System.out.println();
			for (int k = 0; k < 8; k++) {
				for (int t = 0; t < 8; t++)
					System.out.print(map[k][t]);
				System.out.println();
			}

		}

	}
}

class Dot {
	int x, y;

	public Dot(int y, int x) {
		this.x = x;
		this.y = y;
	}
}