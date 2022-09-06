import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1753_김준우 {
	static int V, E;
	static int[][] graph;
	
	public static void solution() {
		
	}
	
	public static void sss(int start, int cnt, int ) {
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E= Integer.parseInt(st.nextToken());
		
		graph  = new int[V+1][V+1];
		for(int i = 1;i<=V;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1;j<=V;j++) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				graph[u][v] = w;
				graph[v][u] = w;
			}
		}
		
		
		
		
	}

}
