import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_±èÁØ¿ì {
	static int N, min;
	static int[] sour, bitter, selected_s, selected_b;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		selected_s = new int[N];
		selected_b = new int[N];
		min = -1;
		
		for(int n = 0;n<N;n++) {
			st = new StringTokenizer(br.readLine()," ");
			sour[n] = Integer.parseInt(st.nextToken());
			bitter[n] = Integer.parseInt(st.nextToken());
		}
		
		select(0, 0);
		System.out.println(min);
	}
	
	public static void select(int cnt, int start) {
		if(cnt == N) {
			int s =1; int b = 0; int gap;
			for(int j = 0; j<cnt;j++) {
				s = s*selected_s[j];
				b = b+selected_b[j];
			}
			gap = Math.abs(s-b);
			if(min<0 || min>gap) {
				min = gap;
			}
			return;
		}
		for(int i = start;i<=N;i++) {
			if(i == N) {
				if(cnt == 0) continue;
				int s =1; int b = 0; int gap;
				for(int j = 0; j<cnt;j++) {
					
					s = s*selected_s[j];
					b = b+selected_b[j];
				}
				gap = Math.abs(s-b);
				if(min<0 || min>gap) {
					min = gap;
				}
				return;
			}
			selected_s[cnt] = sour[i];
			selected_b[cnt] = bitter[i];
			select(cnt+1, i+1);
		}
		
	}

}
