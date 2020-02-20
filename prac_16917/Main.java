package prac_16917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int X, Y;
	static int[] select;
	static int money = Integer.MAX_VALUE;
	static int half;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		select = new int[3];
		for (int i = 0; i < 3; i++) {
			if (i == 2)
				select[i] = 2 * Integer.parseInt(tmp[i]); // C
			else
				select[i] = Integer.parseInt(tmp[i]); // A,B
		}
		X = Integer.parseInt(tmp[3]); // 원하는 양념 마리
		Y = Integer.parseInt(tmp[4]); // 원하는 후라이드 마리

		sol();

		br.close();
	}

	public static void sol() {
		int xcnt = 0, ycnt = 0;
		int sum = 0;

		if (select[0] + select[1] < select[2]) {
			while (true) {
				if (xcnt == X && ycnt == Y) {
					money = Math.min(money, sum);
					break;
				}

				if (xcnt < X) {
					xcnt++;
					sum += select[0];
				}
				if (ycnt < Y) {
					ycnt++;
					sum += select[1];
				}
			}
		} else {
			int half = 0;
			half = Math.min(X, Y);

			xcnt = half;
			ycnt = half;
			sum += (select[2] * half);

			int tmpx = X - xcnt;
			int tmpy = Y - ycnt;
			
			if (tmpx >= 1) {
				if ((select[2] * tmpx) < (select[0] * tmpx)) {
					xcnt += tmpx;
					sum += (select[2] * tmpx);
				} else {
					xcnt += tmpx;
					sum += (select[0] * tmpx);
				}
			}
			if (tmpy >= 1) {
				if ((select[2] * tmpy) < (select[1] * tmpy)) {
					ycnt += tmpy;
					sum += (select[2] * tmpy);
				} else {
					ycnt += tmpy;
					sum += (select[1] * tmpy);
				}
			}
			money = Math.min(money, sum);
		}

		System.out.println(money);

	}
}
