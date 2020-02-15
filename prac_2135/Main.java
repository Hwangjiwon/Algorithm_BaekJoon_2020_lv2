package prac_2135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static class Word {
		String str;
		int cnt;

		public Word(String str, int cnt) {
			this.str = str;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String buf = s;

		LinkedList<Word> list = new LinkedList<>();
		buf = s.substring(0, 1);
		list.add(new Word(buf, 1));

		for (int i = 1; i < s.length(); i++) {
			buf = s.substring(i, i + 1);
			System.out.println(buf);
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).str.equals(buf)) {
					list.get(j).cnt += 1;
				} else {
					list.add(new Word(buf, 1));
					break;
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).str + ":" + list.get(i).cnt);
		}

		br.close();
	}

}
