package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commends = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 }, { 1, 7, 3 } };
		int[] answer = new int[commends.length];

		for (int j = 0; j < commends.length; j++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = commends[j][0] - 1; i < commends[j][1]; i++) {
				list.add(array[i]);
			}
			Collections.sort(list);
			answer[j] = list.get(commends[j][2] - 1);
		}

		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i]);
		System.out.println();
	}

}
