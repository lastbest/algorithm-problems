package _0715;

import java.io.BufferedReader;
import java.util.Arrays;

public class Solution_양과늑대_김준우 {
//	static int[] input1 = {0,0,1,1,1,0,1,0,1,0,1,1};
//	static int[][] input2 = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
	static int[] input1 = {0,1,0,1,1,0,1,0,0,1,0};
	static int[][] input2 = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};
	//==============================================================================/
	
	static int N, max;
	static int[] info_copy;
	static boolean[][] graph;	
	static boolean[][] visited;	//노드번호, 방문
	
	
	static void dfs(int n, int sheep, int wolf, int bm) {
		System.out.println(n + "방문");
		
		//노드방문처리
		for (int i = 0; i < N; i++) {
			if(visited2_og)
		}
		visited[n][sheep][wolf] = true;
		
		//여태까지 방문했는지 배열 복사
		boolean[] visited2 = Arrays.copyOf(visited2_og, N);
		
		//처음 방문하면 노드에 있는 동물에 따라 함께 있는 동물 수 최신화
		if(!visited2[n]) {
			if(info_copy[n] == 0) sheep++;
			else wolf++;
			visited2[n] = true;
		}
		System.out.println("양" + sheep + "늑대" + wolf);
		
		//늑대가 많거나 같으면 리턴
		if(wolf>=sheep) return;
		
		//최대값 최신화
		if(sheep>max) max = sheep;
		
		for (int i = 0; i < N; i++) {
			if(!graph[n][i]) continue; //연결 안 되어있으면 컨티뉴
			if(visited[i][sheep][wolf]) continue;	//이미 방문한경우 컨티뉴
			dfs(i,sheep,wolf,visited2);
		}
	}
	
	public static int solution(int[] info, int[][] edges) {
		N = info.length;
		max = 0;
		graph = new boolean[N][N];
		visited = new boolean[N][N*2];
		info_copy = Arrays.copyOf(info, info.length);
		
        for (int i = 0; i < edges.length; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			graph[a][b] = true;
			graph[b][a] = true;
		}
        
        dfs(0,0,0, new boolean[N]);
        
        
        return max;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(input1, input2));
	}

}

/*
package _0715;

import java.io.BufferedReader;
import java.util.Arrays;

public class Solution_양과늑대_김준우 {
//	static int[] input1 = {0,0,1,1,1,0,1,0,1,0,1,1};
//	static int[][] input2 = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
	static int[] input1 = {0,1,0,1,1,0,1,0,0,1,0};
	static int[][] input2 = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};
	//==============================================================================/
	
	static int N, max;
	static int[] info_copy;
	static boolean[][] graph;	
	static boolean[][][] visited;	//노드번호, 양개수, 늑대개수
	
	
	static void dfs(int n, int sheep, int wolf, boolean[] visited2_og) {
		System.out.println(n + "방문");
		
		//노드방문처리
		visited[n][sheep][wolf] = true;
		
		//여태까지 방문했는지 배열 복사
		boolean[] visited2 = Arrays.copyOf(visited2_og, N);
		
		//처음 방문하면 노드에 있는 동물에 따라 함께 있는 동물 수 최신화
		if(!visited2[n]) {
			if(info_copy[n] == 0) sheep++;
			else wolf++;
			visited2[n] = true;
		}
		System.out.println("양" + sheep + "늑대" + wolf);
		
		//늑대가 많거나 같으면 리턴
		if(wolf>=sheep) return;
		
		//최대값 최신화
		if(sheep>max) max = sheep;
		
		for (int i = 0; i < N; i++) {
			if(!graph[n][i]) continue; //연결 안 되어있으면 컨티뉴
			if(visited[i][sheep][wolf]) continue;	//이미 방문한경우 컨티뉴
			dfs(i,sheep,wolf,visited2);
		}
	}
	
	public static int solution(int[] info, int[][] edges) {
		N = info.length;
		max = 0;
		graph = new boolean[N][N];
		visited = new boolean[N][N+1][N+1];
		info_copy = Arrays.copyOf(info, info.length);
		
        for (int i = 0; i < edges.length; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			graph[a][b] = true;
			graph[b][a] = true;
		}
        
        dfs(0,0,0, new boolean[N]);
        
        
        return max;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(input1, input2));
	}

}
*/