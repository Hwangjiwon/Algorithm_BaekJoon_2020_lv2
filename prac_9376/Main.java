package prac_9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int h, w;
	static char[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		h = Integer.parseInt(input[0]);
		w = Integer.parseInt(input[1]);

		map = new char[h][w];
		visited = new boolean[h][w];
		
		br.close();
	}

}
