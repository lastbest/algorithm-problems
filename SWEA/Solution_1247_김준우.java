import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_김준우 {
	static int N, x_com, y_com, x_hom, y_hom;
	static int min;
	static int[] x_cus, y_cus;
	static boolean[] visited;
	
	public static void perm(int cnt, int prev, int dist) {
		if(cnt >= N) {
			int d = getDist(x_hom, y_hom, x_cus[prev], y_cus[prev]);	//마지막 지점에서 집까지의 거리
			if(min == -1 || min>dist+d) {
				min = dist+d;
			}
			return;
		}
		for(int i = 0; i<N; i++) {
			if(visited[i])continue;
			
			int d = 0;
			if(prev==-1) {
				d = getDist(x_com, y_com, x_cus[i], y_cus[i]);	//회사부터 첫 지점까지 거리
			}
			else {
				d = getDist(x_cus[prev], y_cus[prev], x_cus[i], y_cus[i]);	//이전 지점부터 현재 탐색 지점까지 거리
			}
			visited[i] = true;
			perm(cnt+1, i, dist+d);
			visited[i] = false;
		}
	}
	
	public static int getDist(int x1, int y1, int x2, int y2) {
		int dist = Math.abs(x1-x2)+Math.abs(y1-y2);
		return dist;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			
			//======input===================
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			x_com = Integer.parseInt(st.nextToken());
			y_com = Integer.parseInt(st.nextToken());
			x_hom = Integer.parseInt(st.nextToken());
			y_hom = Integer.parseInt(st.nextToken());
			
			x_cus = new int[N];
			y_cus = new int[N];
			visited = new boolean[N];
			min = -1;
			
			for(int n = 0; n<N;n++) {
				x_cus[n] = Integer.parseInt(st.nextToken());
				y_cus[n] = Integer.parseInt(st.nextToken());
			}
			
			perm(0,-1,0);
			
			sb.append('#');sb.append(t);sb.append(' ');
			sb.append(min);sb.append('\n');
		}
		System.out.println(sb);
		
	}
	
}
