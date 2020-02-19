package prac_16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] map;
	static int[][] dir;
	static boolean[][] visited;
	static Queue<Dot> shark = new LinkedList<Dot>();
	static List<Dot> fish = new LinkedList<Dot>();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int time;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				if (map[i][j] == 9) {
					shark.add(new Dot(i, j));
				}
				if (map[i][j] != 0 && map[i][j] != 9)
					fish.add(new Dot(i, j));
			}
		}
		time = 0;
		eat();
		System.out.println(time);
		br.close();
	}

	public static void eat() {
		Dot s = shark.poll();

		int sx = s.x; // 상어 좌표
		int sy = s.y;
		int ss = 2; // 상어 크기
		int se = 0; // 상어가 먹은 물고기 수

		while (true) {
			dir = new int[N][N];
			toFish(sy, sx, ss, dir); // 상어가 도착 가능한 거리 bfs (빈공간,물고기)

			int minDir = Integer.MAX_VALUE; // 물고기까지의 최소 거리
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] >= 1 && map[i][j] < ss && dir[i][j] > 0) {
						minDir = Math.min(minDir, dir[i][j]);
					}
				}
			}

			LinkedList<Dot> eatable = new LinkedList<Dot>(); // 먹을 수 있는 물고기 좌표 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] >= 1 && map[i][j] < ss && dir[i][j] == minDir) {
						eatable.add(new Dot(i, j));
					}
				}
			}

			if (eatable.size() == 0) {
//				System.out.println("End");
				break;
			} else if (eatable.size() == 1) {
				Dot fish = eatable.get(0);
				int fx = fish.x;
				int fy = fish.y;

				time += dir[fy][fx];
				map[fy][fx] = 0; // 물고기 먹은 좌표 비우기
				map[sy][sx] = 0; // 원래 상어 있던 좌표도 비우기
				sx = fx; // 상어 위치 갱신
				sy = fy;
				se++;

				if (se == ss) {
					ss++;
					se = 0;
				}
				continue;
			} else { // 2마리 이상
				// 가장 위에 있는 물고기 (y좌표가 가장 작은 것)
				int uppery = Integer.MAX_VALUE;
				int upperx = Integer.MAX_VALUE;
				for (int i = 0; i < eatable.size(); i++) {
					uppery = Math.min(uppery, eatable.get(i).y);
				}

				// 가장 위에 있는 물고기 개수
				// 가장 왼쪽에 있는 물고기 (x좌표가 가장 작은 것)
				int uppercnt = 0;
				for (int i = 0; i < eatable.size(); i++) {
					if (eatable.get(i).y == uppery) {
						uppercnt++;
						upperx = Math.min(upperx, eatable.get(i).x);
					}
				}

				int fx = 0, fy = 0;
				if (uppercnt == 1) {
					for (int i = 0; i < eatable.size(); i++) {
						if (eatable.get(i).y == uppery) {
							fx = eatable.get(i).x;
							fy = eatable.get(i).y;
							break;
						}
					}
				} else if (uppercnt >= 2) {
					for (int i = 0; i < eatable.size(); i++) {
						if (eatable.get(i).y == uppery && eatable.get(i).x == upperx) {
							fx = eatable.get(i).x;
							fy = eatable.get(i).y;
							break;
						}
					}
				}

				time += dir[fy][fx];
				map[fy][fx] = 0; // 물고기 먹은 좌표 비우기
				map[sy][sx] = 0; // 원래 상어 있던 좌표도 비우기
				sx = fx; // 상어 위치 갱신
				sy = fy;
				se++;

				if (se == ss) {
					ss++;
					se = 0;
				}
				continue;
			}
		}
	}

	public static void toFish(int sy, int sx, int ss, int[][] dir) {
		visited = new boolean[N][N];
		Queue<Dir> q = new LinkedList<Dir>();

		visited[sy][sx] = true;
		q.add(new Dir(sy, sx, 0));

		while (!q.isEmpty()) {
			Dir d = q.poll();
			int dsx = d.x;
			int dsy = d.y;
			int dsv = d.val;

			for (int i = 0; i < 4; i++) {
				int nsx = dsx + dx[i];
				int nsy = dsy + dy[i];
				int nsv = dsv + 1;

				if (nsx < 0 || nsy < 0 || nsx >= N || nsy >= N)
					continue;

				if (map[nsy][nsx] <= ss) {
					if (!visited[nsy][nsx]) { // map[nsy][nsx] == ss면 못먹지만 지나갈수는 있음
						visited[nsy][nsx] = true;
						dir[nsy][nsx] = nsv;
						q.add(new Dir(nsy, nsx, nsv));
					}
				}
			}
		}
	}

	static class Dot { // 상어, 물고기 좌표
		int x, y;

		Dot(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	static class Dir { // 물고기와의 거리
		int x, y, val;

		Dir(int y, int x, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
}
