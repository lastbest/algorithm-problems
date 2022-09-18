package _0617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_23743_김준우 {
	static int N,M;
//	static int[][] warf;
	static ArrayList<ArrayList<Integer>> warf_list = new ArrayList<>();
	static int[] exit, uf;
	
	static class warfc implements Comparable<warfc>{
		int r;
		int c;
		int w;
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		public int getW() {
			return w;
		}
		public void setW(int w) {
			this.w = w;
		}
		
		warfc(int r, int c, int w){
			this.r = r;
			this.c = c;
			this.w = w;
		}
		
		@Override
		public int compareTo(warfc o) {
			return this.w - o.w;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.r + ", " + this.c + " : " + this.w;
		}
	}
	
	static int find(int n) {
		if(uf[n] == n) return n;
		return uf[n] = find(uf[n]);
	}
	
	static void merge(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return;
		uf[y] = x;
	}
	
	static boolean isUnion(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		warf = new int[N][N];
		exit = new int[N];
		uf = new int[N];
		ArrayList<warfc> list = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) -1;
			int b = Integer.parseInt(st.nextToken()) -1;
			int c = Integer.parseInt(st.nextToken());
			
//			if(warf[a][b]==0 || warf[a][b]>c) {
//				warf[a][b] = c;
//				warf[b][a] = c;
//			}
			list.add(new warfc(a,b,c));
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			exit[i] = Integer.parseInt(st.nextToken());
			uf[i] = i;
		}
		
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if(i == j) continue;	//무조건 0나오니까
//				if(i > j) continue;		//중복방지
//				if(warf[i][j] == 0) continue;
//				list.add(new warfc(i,j,warf[i][j]));
//			}
//		}
		
		Collections.sort(list);
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
		

		boolean[] visited = new boolean[N];
		int count = 0;
		int time = 0;
		int minexit = 0;
		for (int i = 0; i < list.size(); i++) {
			warfc temp = list.get(i);
			int a = temp.getC();
			int b = temp.getR();
			if(isUnion(a,b)) continue;
			if(exit[b]<temp.getW()) continue;
			merge(a,b);
			count++;
			time += temp.getW();
			
			visited[a] = true; visited[b] = true;
			if(minexit == 0 || minexit>Math.min(exit[a], exit[b])) minexit = Math.min(exit[a], exit[b]);
			
			if(count == N-1) break;
		}
		
//		System.out.println(Arrays.toString(uf));
//		System.out.println(count);
//		System.out.println(time + minexit);
		
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]) continue;
			/*if(i == list.get(0).getC() || i == list.get(0).getR()) {
				visited[i] = true;
				continue;
			}*/
//			System.out.println("unvisited" + i);
			visited[i] = true;
			time += exit[i];
		}
		
		System.out.println(time + minexit);
	}

}



/*package _0617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_23743_김준우 {
	static int N,M;
//	static int[][] warf;
	static ArrayList<ArrayList<Integer>> warf_list = new ArrayList<>();
	static int[] exit, uf;
	
	static class warfc implements Comparable<warfc>{
		int r;
		int c;
		int w;
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		public int getW() {
			return w;
		}
		public void setW(int w) {
			this.w = w;
		}
		
		warfc(int r, int c, int w){
			this.r = r;
			this.c = c;
			this.w = w;
		}
		
		@Override
		public int compareTo(warfc o) {
			return this.w - o.w;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.r + ", " + this.c + " : " + this.w;
		}
	}
	
	static int find(int n) {
		if(uf[n] == n) return n;
		return uf[n] = find(uf[n]);
	}
	
	static void merge(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return;
		uf[y] = x;
	}
	
	static boolean isUnion(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		warf = new int[N][N];
		exit = new int[N];
		uf = new int[N];
		ArrayList<warfc> list = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) -1;
			int b = Integer.parseInt(st.nextToken()) -1;
			int c = Integer.parseInt(st.nextToken());
			
//			if(warf[a][b]==0 || warf[a][b]>c) {
//				warf[a][b] = c;
//				warf[b][a] = c;
//			}
			list.add(new warfc(a,b,c));
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			exit[i] = Integer.parseInt(st.nextToken());
			uf[i] = i;
		}
		
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if(i == j) continue;	//무조건 0나오니까
//				if(i > j) continue;		//중복방지
//				if(warf[i][j] == 0) continue;
//				list.add(new warfc(i,j,warf[i][j]));
//			}
//		}
		
		Collections.sort(list);
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
		

		boolean[] visited = new boolean[N];
		int count = 0;
		int time = 0;
		int minexit = 0;
		for (int i = 0; i < list.size(); i++) {
			warfc temp = list.get(i);
			int a = temp.getC();
			int b = temp.getR();
			if(isUnion(a,b)) continue;
			if(exit[b]<temp.getW()) continue;
			merge(a,b);
			count++;
			time += temp.getW();
			
			visited[a] = true; visited[b] = true;
			if(minexit == 0 || minexit>Math.min(exit[a], exit[b])) minexit = Math.min(exit[a], exit[b]);
			
			if(count == N-1) break;
		}
		
//		System.out.println(Arrays.toString(uf));
//		System.out.println(count);
//		System.out.println(time + minexit);
		
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]) continue;
			/*if(i == list.get(0).getC() || i == list.get(0).getR()) {
				visited[i] = true;
				continue;
			}*/
//			System.out.println("unvisited" + i);
			visited[i] = true;
			time += exit[i];
		}
		
		System.out.println(time + minexit);
	}

}
*/
