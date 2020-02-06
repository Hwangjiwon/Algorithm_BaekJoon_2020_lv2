package prac_16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class obj {
		int point; // 현재위치
		int cnt; // 던짐횟수

		obj(int point, int cnt) {
			this.point = point;
			this.cnt = cnt;
		}

	}

	static int N, M;
	static int[] move;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);

		visited = new int[101]; // 해당 칸에 가는 최소횟수저장
		Arrays.fill(visited, 987654321);

		move = new int[101];
		for (int i = 0; i < N + M; i++) {
			tmp = br.readLine().split(" ");
			move[Integer.parseInt(tmp[0])] = Integer.parseInt(tmp[1]);
		}

		bfs();
		System.out.println(visited[100]);
		br.close();
	}

	public static void bfs() {
		Queue<obj> q = new LinkedList<>();
		q.add(new obj(1, 0));
		visited[1] = 0;

		while (!q.isEmpty()) {
			obj o = q.poll();
			int nowPos = o.point, nowCnt = o.cnt;
			int nextPos, nextCnt;

			if (move[nowPos] != 0) {
				nextPos = move[nowPos];
				visited[nextPos] = nowCnt;
				q.add(new obj(nextPos, nowCnt));
				continue;
			}
			for (int j = 1; j <= 6; j++) {
				nextPos = o.point + j;
				nextCnt = o.cnt + 1;
				
				if (nextPos <= 100 && visited[nextPos] > nextCnt) {
					visited[nextPos] = nextCnt;
					q.add(new obj(nextPos, nextCnt));
				}
			}

		}
	}
}
