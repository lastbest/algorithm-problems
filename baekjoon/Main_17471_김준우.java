import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17471_김준우 {
	static int N, sum, min = -1;
	static int[][] arr;
	static int[] population;
	
	public static void dfs(int n, int[] sel) {
		sel[n] ++;
		for(int i = 1; i<=N; i++) {
			if(sel[i] == 2) continue;
			if(arr[n][i] > 0 && sel[i]>0) {
				//System.out.print("<"+n+", "+i+">");
				dfs(i, sel);
			}
		}
	}
	
	public static boolean isValid(boolean[] sel) {
		int start = 0;	int n = 0;
		int[] c_sel = new int[N+1];
		for(int i = 1;i<=N;i++) {
			if(!sel[i]) {
				if(start == 0) start = i;
				n++;
				c_sel[i]++;
			}
		}
		if(n == 1) return true;
		
		dfs(start, c_sel);
		for(int i = 1;i<=N;i++) {
			//System.out.print(", " + c_sel[i]);
			if(c_sel[i]==1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void test(int n, boolean[] sel) {
		boolean[] c_sel = Arrays.copyOf(sel, N+1);
		
		c_sel[n] = true;

		for(int i = 1; i<=N; i++) {
			if(c_sel[i]) System.out.print(i);
		}
		System.out.println();
		//가능한가요
		//if(!isValid(c_sel)) return;/////////////////////////////////////
		
		//현재까지 연결된거 출력 , 인구계싼
		int pop1 = 0;
		for(int i = 1; i<=N; i++) {
			if(c_sel[i]) pop1 += population[i];
		}
		if(pop1 > 0 && pop1 < sum) {
			int gap = Math.abs(pop1*2 - sum);
			if(min < 0 || min>gap) min = gap; 
		} else return;
		//System.out.println();
		
		
		//인접한 구역도 연결
		for(int i = 1; i<=N; i++) {
			if(arr[n][i] == 0) continue;
			if(c_sel[i]) continue;
			
			test(i, c_sel);
			//System.out.println(i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//input 1st line
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		population = new int[N+1];
		sum = 0;
		
		//input rest of lines
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i<= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			sum += population[i];
		}
		for(int i = 1 ; i<= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j = 1; j<=n; j++) {
				int near = Integer.parseInt(st.nextToken());
				arr[i][near] ++;
				arr[near][i] ++;
			}
		}
		
		test(1,new boolean[N+1]);
		
		System.out.println(min);
		
	}

}
