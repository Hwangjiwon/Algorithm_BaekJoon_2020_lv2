package prac_1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int K;
	static boolean[] known;
	static boolean[] space;
	static boolean[] chk;
	static String[] input;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		K = Integer.parseInt(tmp[1]);

		input = new String[N];
		for (int i = 0; i < N; i++)
			input[i] = br.readLine();

		known = new boolean[26];
		space = new boolean[26];
		chk = new boolean[26];
		String str = "antatica";
		for (int i = 0; i < str.length(); i++) {
			known[(int) str.charAt(i) - (int) 'a'] = true;
			space[(int) str.charAt(i) - (int) 'a'] = true;
			chk[(int) str.charAt(i) - (int) 'a'] = true;
		}
		K -= 5;

		dfs(0, 0, "");
		System.out.println(cnt);

		br.close();
	}

	public static void dfs(int len, int idx, String result) {
		if (len == K) {
			String[] tmp = result.split(" ");
			for (int i = 0; i < tmp.length; i++) {
				chk[Integer.parseInt(tmp[i])] = true;
			}

			for (int i = 0; i < input.length; i++) {
				boolean flag = true;
				for (int j = 0; j < input[i].length(); j++) {
					if (chk[(int) input[i].charAt(j) - (int) 'a'] == true) {
						//System.out.println(
								//(int) input[i].charAt(j) - (int) 'a' + " " + chk[(int) input[i].charAt(j) - (int) 'a']);
						
						System.out.print(input[i].charAt(j));
					} else {
						//System.out.println(
								//(int) input[i].charAt(j) - (int) 'a' + " " + chk[(int) input[i].charAt(j) - (int) 'a']);
						flag = false;
					}
				}
				if (flag == true)
					cnt++;
				System.out.println();
			}
			return;
		}

		for (int i = idx; i < 26; i++) {
			if (known[i] == false) {
				space[i] = true;
				dfs(len + 1, i + 1, result + i + " ");
				space[i] = false;
			}
		}
	}
}
