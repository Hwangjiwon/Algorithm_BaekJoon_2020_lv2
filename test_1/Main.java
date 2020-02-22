package test_1;

import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);

		input = br.readLine().split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int min = arr[0];

		for (int i = 0; i < N - 1; i++) {
			if (arr[i + 1] - arr[i] <= min)
				min = arr[i + 1] - arr[i];
		}

		System.out.println(min);
	}
}