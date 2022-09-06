import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_김준우 {
	static int N, start;	//첫번째줄 입력의 갯수, 시작값
	static int Max = 101;	//숫자의 최대값(100+1)
	static int last;	//마지막 방문한값
	static int[][] arr;		//그래프 row: from column : to
	static int[] visitedtime;
	static boolean[] visited;	//bfs 탐색여부
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;
		int time = 0;
		
		while(!q.isEmpty()) {
			int dq = q.poll();
			for(int i = 0;i<Max;i++) {
				if(arr[dq][i] > 0 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
					visitedtime[i] = visitedtime[dq]+1;
					if(time<visitedtime[i]) time = visitedtime[i];
				}
			}
		}
		for(int i = 0;i<Max;i++) {
			if(visitedtime[i] == time) {
				if(last<i) {
					last = i;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for(int t = 1;t<=T;t++) {
			//=============input===========================
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			arr = new int[Max][Max];
			visited = new boolean[Max];
			visitedtime = new int[Max];
			last = 0;
			
			//===============input 2nd line===============
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0;i<N/2;i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from][to]=1;
			}
			
			bfs(start);
			sb.append("#"+t+" "+last+"\n");
		}
		System.out.println(sb);
		
		
	}

}
