package goorm_3;

import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		int T = Integer.parseInt(tmp[0]);
		long cnt;
		long N, M;
		for (int i = 0; i < T; i++) {
			tmp = br.readLine().split(" ");
			N = Long.parseLong(tmp[0]);
			M = Long.parseLong(tmp[1]);
			cnt = 0;

//	         if (N < 5) {
//	            cnt = 0;
//	            System.out.println(cnt);
//	            continue;
//	         }

			long k = N / 5;
			long t = M / 7;

			if (k > 0) {
				if (t > 0) {
					cnt += Math.min(k, t);
					N -= 5 * cnt;
					M -= 7 * cnt;

					if (N >= 5 && (N + M >= 12)) {
						cnt += (N + M) / 12;
					} else {
						cnt += (N / 12);
					}
				} else {
					cnt += ((N + M) / 12);
				}
			} else {
				cnt = 0L;
			}
			System.out.println(cnt);
		}
		br.close();
	}
}