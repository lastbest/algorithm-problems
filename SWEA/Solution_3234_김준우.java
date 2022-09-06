import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3234_김준우 {
	static int N, V, V2, Sum, score;
	static int[] weights, selected;
	static boolean[] visited, visited2, selected2;
	
	
	public static void newperm(int v) {
		visited = new boolean[N];
		V = v;
		selected = new int[V];
		permutation(0);
	}
	
	public static void permutation(int cnt) {
		if(cnt == V) {
			//System.out.println(Arrays.toString(selected));
			int[] copied = Arrays.copyOf(selected, V);
			
			putorder(copied);
			//System.out.println();
			return;
		}
		for(int i = 0;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selected[cnt] = weights[i]; 
			permutation(cnt+1);
			visited[i] = false;
		}
	}
	
	public static void permutation2(int cnt, int start) {
		if(cnt == V2) {
			//System.out.println(V2+"	"+Arrays.toString(visited2));
			int left = 0; int right = 0;
			for(int i = 0;i<V;i++) {
				if(visited2[i]) {
					right+=selected[i];
				}else {
					left+=selected[i];
				}
				if(right>left) {
					return;
				}
			}
			score++;
			//System.out.println("vvv");
			return;
		}
		for(int i = start;i<V;i++) {
			if(visited2[i]) continue;
			visited2[i] = true;
			permutation2(cnt+1,i);
			visited2[i] = false;
		}
	}
	
	public static void putorder(int[] arr) {
		//int i = 1;
		for(int i = 0;i<=V;i++) {
			visited2 = new boolean[V];
			V2 = i;
			permutation2(0,0);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			weights = new int[N];
			Sum = 0;
			score = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i = 0;i<N;i++) {
				int temp = Integer.parseInt(st.nextToken());
				weights[i] = temp;
				Sum += temp;
			}
			
			newperm(N);
			//System.out.println();
			sb.append("#");sb.append(t);sb.append(" ");
			sb.append(score);sb.append("\n");
		}
		System.out.println(sb);
	}

}
