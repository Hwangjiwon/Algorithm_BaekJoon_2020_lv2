package prac_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Dot {
	int num;
	int r, c;

	Dot(int num, int r, int c) {
		this.num = num;
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static int N, M;
	static int[][] map;
	static ArrayList<Dot> chicken;
	static ArrayList<Dot> home;
	static int hnum, cnum;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		map = new int[N][N];
		chicken = new ArrayList<Dot>();
		home = new ArrayList<Dot>();

		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 1) {
					home.add(new Dot(hnum, i, j));
					hnum++;
				} else if (map[i][j] == 2) {
					chicken.add(new Dot(cnum, i, j));
					cnum++;
				}
			}
		}

		solution();

		br.close();
	}

	static ArrayList<Integer> result = new ArrayList<>();

	public static void solution() {

		combination(0, 0, "");

	}

	public static void combination(int len, int idx, String str) {
		if (len == M) {
			System.out.println(str);
			String[] combi = str.split(" ");
			int[] arr = new int[combi.length];
			for (int i = 0; i < combi.length; i++) {
				arr[i] = Integer.parseInt(combi[i]);
			}

			for (int i = 0; i < combi.length; i++) {
				cal(arr[i]); // cnum
			}
			return;
		}

		for (int i = idx; i < cnum; i++) {
			combination(len + 1, i + 1, str + i + " ");
		}
	}

	static int[] dc = { 0, 0, -1, 1 };
	static int[] dr = { -1, 1, 0, 0 };
	static boolean[][] visited = new boolean[N][N];

	public static void cal(int cnum) {
		int r = 0, c = 0;
		for (int i = 0; i < chicken.size(); i++) {
			if (chicken.get(i).num == cnum) {
//				System.out.println(chicken.get(i).c + ":" + chicken.get(i).r);
				r = chicken.get(i).r;
				c = chicken.get(i).c;
			}
		}
		
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(cnum, r, c));

		while (!q.isEmpty()) {
			Dot d = q.poll();
			int cc = d.c;
			int cr = d.r;

			for (int i = 0; i < 4; i++) {
				int nc = cc + dc[i];
				int nr = cr + dr[i];

				if (nc < 0 || nr < 0 || nc >= N || nr >= N)
					continue;
				if (visited[nr][nc])
					continue;

				visited[nr][nc] = true;
				if (map[nr][nc] == 1) {
					System.out.println(nr + ":" + nc);
				}
				q.add(new Dot(cnum, nr, nc));
				
				

			}

		}
	}

	public static int dist(Dot chicken, Dot home) {
		return Math.abs(chicken.c - home.c) + Math.abs(chicken.r - home.r);
	}
}
