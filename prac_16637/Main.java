package prac_16637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static LinkedList<Integer> num = new LinkedList<>();
	static LinkedList<Character> op = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);

		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split("");
			if (tmp[i].charAt(0) == '+' || tmp[i].charAt(0) == '-' || tmp[i].charAt(0) == '*') {
				op.add(tmp[i].charAt(0));
			} else
				num.add(Integer.parseInt(tmp[i]));
		}

		br.close();
	}

}
