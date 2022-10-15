package _0513_Class4_김준우;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12865_김준우 {
	static int N, K;
	static int[] w, v, dp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		w = new int[101];
		v = new int[101];
		dp = new int[101][1000001];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			
			for (int j = 1; j <= K; j++) {
				if(j-w[i] >= 0)
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		//출력
		System.out.println(dp[N][K]);
	}

}
