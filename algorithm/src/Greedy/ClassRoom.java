package Greedy;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.System.in;

// 백준 11000 강의실 배정
public class ClassRoom {

	static class Class implements Comparable<Class>{
		int start;
		int end;

		public Class(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Class o) {
			if(this.start == o.start) {
				return this.end - o.end;
			}else return this.start - o.start;
		}

	}
	public static void main() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		List<Class> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Class(start, end));
		}

		Collections.sort(list);
		Queue<Integer> q = new PriorityQueue<>();
		int endTime=0;
		for(Class m : list) {
			endTime = m.end;

			if(!q.isEmpty() && q.peek() <= m.start) {
				q.poll();
			}
			q.add(endTime);
		}
		System.out.println(q.size());
	}
}