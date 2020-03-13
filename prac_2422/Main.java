package prac_2422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Disable {
	int x, y;

	Disable(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N, M;
	static ArrayList<Disable> list = new ArrayList<>();
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		for (int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			list.add(new Disable(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
		}
		dfs(0, 1, "");
		System.out.println(cnt);
		br.close();
	}

	public static void dfs(int len, int idx, String str) {
		if (len == 3) {
			cnt++;
			chk(str);
			return;
		}

		for (int i = idx; i <= N; i++) {
			dfs(len + 1, i + 1, str + i + " ");
		}
	}

	public static void chk(String str) {
		String[] tmp = str.split(" ");
		boolean[] visited = new boolean[tmp.length];

		for (int i = 0; i < tmp.length; i++)
			visited[Integer.parseInt(tmp[i])] = true;

		for (int i = 0; i < M; i++) {
			if (visited[list.get(i).x] && visited[list.get(i).y]) {
				cnt--;
				break;
			}
		}
	}
}
