package prac_14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int max = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]); // 세로 y
		M = Integer.parseInt(input[1]); // 가로 x

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 0, 0);
				visited[i][j] = false;
				shapeT(i, j);
			}
		}

		System.out.println(max);
		br.close();
	}

	public static void dfs(int y, int x, int depth, int sum) {
		if (depth == 4) {
			if (max < sum)
				max = sum;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					dfs(ny, nx, depth + 1, sum + map[ny][nx]);
					visited[ny][nx] = false;
				}
			}
		}
	}

	public static void shapeT(int y, int x) {
		// 가운데 블록이 맵의 꼭지점이면 불가
		if ((x == 0 && y == 0) || (x == M - 1 && y == 0) || (x == 0 && y == N - 1) || (x == M - 1 && y == N - 1))
			return;

		int sum = map[y][x];

		// 가운데 블록이 맵의 꼭지점이 아닌 테두리이면
		if (x == 0) // ㅏ
			sum += map[y + 1][x] + map[y][x + 1] + map[y - 1][x];
		else if (x == M - 1) // ㅓ
			sum += map[y - 1][x] + map[y][x - 1] + map[y + 1][x];
		else if (y == 0) // ㅜ
			sum += map[y][x - 1] + map[y + 1][x] + map[y][x + 1];
		else if (y == N - 1) // ㅗ
			sum += map[y][x - 1] + map[y - 1][x] + map[y][x + 1];
		// 가운데 블록이 맵의 꼭지점도 아니고 테두리도 아니면
		else {
			int one = sum + map[y + 1][x] + map[y][x + 1] + map[y - 1][x];
			int two = sum + map[y - 1][x] + map[y][x - 1] + map[y + 1][x];
			int tree = sum + map[y][x - 1] + map[y + 1][x] + map[y][x + 1];
			int four = sum + map[y][x - 1] + map[y - 1][x] + map[y][x + 1];

			sum = Math.max(one, Math.max(two, Math.max(tree, four)));
		}

		max = Math.max(max, sum);

	}

}
