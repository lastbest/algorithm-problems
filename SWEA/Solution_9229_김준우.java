import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229_±èÁØ¿ì {
	static int N, M;
	static int max;
	static int[] input, numbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for(int t = 1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			max = -1;
			input = new int[N];
			numbers = new int[2];
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0;n<N;n++) {
				input[n] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			sb.append("#");sb.append(t);sb.append(" ");
			sb.append(max);sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == 2) {
			//System.out.println(Arrays.toString(numbers));
			int weight = numbers[0] + numbers[1];
			if(weight>max && weight<=M) {
				max = weight;
			}
			return;
		}
		for(int i = start;i<N;i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}

}
