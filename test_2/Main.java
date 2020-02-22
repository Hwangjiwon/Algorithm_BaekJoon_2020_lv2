package test_2;

import java.io.*;
import java.util.HashSet;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> s = new HashSet<Integer>();

		int a = 0, b = 0, min = 10001, sum = 0;

		for (int i = 1; i <= 100; i++) {
			s.add(i * i);
		}

		String[] input = br.readLine().split(" ");
		
		a = Integer.parseInt(input[0]);
		b = Integer.parseInt(input[1]);

		for (int i = a; i <= b; i++) {
			if (s.contains(i)) {
				sum += i;
				min = Math.min(min, i);
			}
		}

		System.out.println(min + " " + sum);
	}
}
