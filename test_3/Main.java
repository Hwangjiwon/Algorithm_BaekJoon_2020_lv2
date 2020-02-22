package test_3;

import java.io.*;

class Main {
	static double H, U, D, F;
	static double[] result;
	static int day;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		H = Integer.parseInt(input[0]);
		U = Integer.parseInt(input[1]);
		D = Integer.parseInt(input[2]);
		F = Integer.parseInt(input[3]);

		result = new double[4];
		day = 1;
		sol(0, U, U, U - D);
	}

	public static void sol(double start, double up, double end, double down) {
		if (up < 0) {
			System.out.println("Failure " + day);
			return;
		} else if (end >= H) {
			System.out.println("End: " + end);

			System.out.println("Success " + day);
			return;
		}
		System.out.println("초기높이" + start + "올라간 거리" + up + "오른후 높이" + end + "미끌높이" + down);
		start = down;
		up = U - ((U * F / 100) * day);
		end = start + up;
		down = end - D;
		++day;
		sol(start, up, end, down);
	}
}
