package prac_16236;

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
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Dot> shark;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int time, size = 2, eat;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split("");
		N = Integer.parseInt(tmp[0]);

		map = new int[N][N];
		visited = new boolean[N][N];

		shark = new LinkedList<Dot>();
		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				if (map[i][j] == 9)
					shark.add(new Dot(i, j));
			}
		}

		time = 0;
		bfs();
		System.out.println(time);
		br.close();
	}

	public static void bfs() {
		while (!shark.isEmpty()) {
			time++;
			Dot dot = shark.poll();
			int x = dot.x;
			int y = dot.y;
			System.out.println(x + "--" + y);
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				System.out.println(nx + ":" + ny + "size:" + size + "eat" + eat);

				if (map[ny][nx] <= size) {
					if (!visited[ny][nx]) {
						visited[ny][nx] = true;
						if (map[ny][nx] == 0 || map[ny][nx] == size) { // 빈공간 or 같은 사이즈
							shark.add(new Dot(ny, nx));
						}
						if (map[ny][nx] >= 1 && map[ny][nx] < size) { // 자기보다 작은 물고기
							map[ny][nx] = 0;
							if (eat + 1 == size) {
								size++;
								eat++;
								shark.add(new Dot(ny, nx));
							} else {
								eat++;
								shark.add(new Dot(ny, nx));
							}
						}

					}

				}
			}
		}
	}
}
