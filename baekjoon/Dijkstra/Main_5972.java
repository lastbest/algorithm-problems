package _0308_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_5972 {
	static int N,M;	//헛간의 갯수, 길의 갯수
	static int[][] map;	//연결된 길에 나눠줘야 하는 여물 개수
	//static boolean[] visited;
	
	static class Vertex implements Comparable<Vertex>{
		int no,minDistance; // 정점번호, 출발지에서자신으로의 최소비용

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.minDistance - o.minDistance;
		}
	}
	
	public static void dijicstra(int start) {
		int[] distance = new int[N+1]; // 출발지에서 자신으로 오는 최소비용
		boolean[] visited = new boolean[N+1]; // 최소비용 확정여부
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0; // 시작점 0으로
		pQueue.offer(new Vertex(start,distance[start]));
		
		while(!pQueue.isEmpty()) {
			// 단계1 : 최소비용이 확정되지 않은 정점중 최소비용의 정점 선택
			Vertex current = pQueue.poll();
			
			if(visited[current.no]) continue;
			
			visited[current.no] = true;
//			if(current==end) break; // current가 도착지라면 끝냄
			
			// 단계2 :  선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른정점의 최소비용을 고려
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && map[current.no][j] != -1 && 
						distance[j] > distance[current.no] + map[current.no][j]) {
					distance[j] =  distance[current.no] + map[current.no][j];
					pQueue.offer(new Vertex(j, distance[j]));
				}
			}
		}
		
		int count = 0;
		
		System.out.println(distance[N]); 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());	//
		M = Integer.parseInt(st.nextToken());	//길 갯수
		map = new int[N+1][N+1];
		
		for(int i = 1;i<=N;i++) {
			Arrays.fill(map[i], -1);
		}
		
		//visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = c;
			map[b][a] = c;
		}
		
		dijicstra(1);
		
		
	}

}
