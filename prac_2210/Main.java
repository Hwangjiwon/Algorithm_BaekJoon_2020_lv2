package prac_2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	static String[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static HashSet<String> result = new HashSet<String>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		map = new String[5][5];

		for (int i = 0; i < 5; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = str[j];
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, 0, "");
			}
		}
		
		System.out.println(result.size());
		br.close();
	}

	public static void dfs(int y, int x, int len, String str) {
		if (len == 6) {
			result.add(str);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
				continue;

			dfs(ny, nx, len + 1, str + map[y][x] + "");
		}
	}
}
