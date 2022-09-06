import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7465_김준우 {
	static int N, M, v, result;
	static boolean[][] arr;
	static boolean[] visited;
	
	public static void dfs(int start) {
		visited[start] = true;
		v++;
		//System.out.println(start);
		for(int i = 1; i<=N;i++) {
			if(!visited[i] && arr[start][i]) {
				dfs(i);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T;t++) {
			//==========input N,M=============
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new boolean[N+1][N+1];
			visited = new boolean[N+1];
			v= 0; result = 0;
			
			//=========input rest=============
			for(int i = 0; i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				if(st.hasMoreTokens()) {
					int b = Integer.parseInt(st.nextToken());
					arr[a][b] = true;
					arr[b][a] = true;
				}
			}
			
			//======solution=============
			for(int i = 1; i<=N;i++) {
				if(v >= N) {
					break;
				}
				if(visited[i])continue;
				dfs(i);
				result ++;
			}
			System.out.println("#"+t+" "+result);
			
		}
		
	}

}
