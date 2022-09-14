package class4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_15663_김준우 {
	static int N, M;
	static int arr[];
	static boolean visited[];
	//static PriorityQueue<String> hs = new PriorityQueue<String>();
	//static LinkedHashSet<String> hs = new LinkedHashSet<String>();
	static ArrayList<String> list = new ArrayList<String>();
	
	
	public static void perm(int n, int cnt, String org) {
		visited[n] = true;
		String str = org + arr[n] + " ";
		
		if(cnt == M-1) {
			if(list.contains(str)) return;
			list.add(str);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			perm(i,cnt+1, str);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			perm(i,0,"");
			visited[i] = false;
		}
		
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
