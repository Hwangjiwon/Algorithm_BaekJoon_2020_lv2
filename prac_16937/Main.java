package prac_16937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int H, W, N;
	static LinkedList<Size> sticker;
	static boolean[] visited;
	static int max, sum;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		H = Integer.parseInt(tmp[0]);
		W = Integer.parseInt(tmp[1]);

		tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);

		sticker = new LinkedList<>();
		visited = new boolean[2 * N];
		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			sticker.add(new Size(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), 0));
			sticker.add(new Size(Integer.parseInt(tmp[1]), Integer.parseInt(tmp[0]), 1));
		}

		dfs(0, 0, "");
		System.out.println(max);

		br.close();
	}

	public static void dfs(int cnt, int idx, String str) {
		if (cnt == 2) {
			String[] tmp = str.split(" ");
//			System.out.println(str);
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			int id = Integer.parseInt(tmp[2]);
			int nx = Integer.parseInt(tmp[3]);
			int ny = Integer.parseInt(tmp[4]);
			int nid = Integer.parseInt(tmp[5]);

			if (x == ny && y == nx && id != nid) {
//				System.out.println("&&&");
			} else {
				
				if (id == 0) {
					int my = Math.max(y, ny);
					if (my <= W && x + nx <= H) {
						sum = x * y + nx * ny;
						max = Math.max(max, sum);
					}
				}

				if (id == 1) {
					int mx = Math.max(x, nx);
					if (mx <= H && y + ny <= W) {
						sum = x * y + nx * ny;
						max = Math.max(max, sum);
					}
				}
			}

//			System.out.println(sum + " " + max);
			return;
		}

		for (int i = idx; i < 2 * N; i++) {
			if (visited[i])
				continue;
			int x = sticker.get(i).R;
			int y = sticker.get(i).C;
			int id = sticker.get(i).idx;

			visited[i] = true;
			dfs(cnt + 1, i, str + x + " " + y + " " + id + " ");
			visited[i] = false;
		}
	}

}

class Size {
	int R, C;
	int idx;

	Size(int R, int C, int idx) {
		this.R = R;
		this.C = C;
		this.idx = idx;
	}
}