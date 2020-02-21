package goorm_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++)
			set.add(Integer.parseInt(tmp[i]));
		
		if (set.size() >= 3)
			System.out.println("YES");
		else
			System.out.println("NO");

		br.close();
	}

}
