import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961_김준우 {
	static int N, d, k, c;
	static int[] belt;
	static int max = 0;
	
	public static void solution() {
		int[] visit = new int[d+1];	//먹은 초밥종류 체크
		int cnt = 0;	//현재까지 먹은양
		
		visit[c]++;
		cnt++;
		
		for (int i = 0; i < k; i++) {
			if(visit[belt[i%N]] == 0) cnt++;
			visit[belt[i%N]]++;
		}
		
		for (int i = 0; i < N; i++) {
			
			visit[belt[i%N]]--;
			if(visit[belt[i%N]] == 0) cnt--;
			
			if(visit[belt[(i+k)%N]] == 0) cnt++;
			visit[belt[(i+k)%N]]++;
			

			if(cnt>max) max = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input 1st line
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		//input rest of lines
		belt = new int[N];
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		solution();
		
		System.out.println(max);
	}

}


/*
public class Main_15961_김준우 {
	static int N, d, k, c;
	static int[] belt;
	static int max = 0;
	
	public static void startEating(int start) {
		int n = start;
		boolean[] had = new boolean[d+1];	//먹은 초밥종류 체크
		int cnt = 0;	//현재까지 먹은양
		
		for (int i = 0; i < k; i++) {
			if(!had[belt[n%8]]) {
				cnt++;
				had[belt[n%8]] = true;
				System.out.println(belt[n%8]);
			}
			//else break;
			n++;
			
			if(i == 3 && !had[c]) {
				cnt++;
				had[c] = true;
			}
		}
		
		
		System.out.println(start + " : " + cnt);
		//System.out.println(Arrays.toString(had));
		for(int i = 0 ; i<d+1; i++)	if(had[i]) System.out.print(i  + " ");
		System.out.println();
		System.out.println();
		
		/*
		while(true) {
			//if(had[n]) break;
			if(!had[belt[n%8]]) {
				cnt++;
				had[belt[n%8]] = true;
				//System.out.println(belt[n%8]);
			}
			n++;
		}*//*
		
		if(cnt>max) max = cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input 1st line
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		//input rest of lines
		belt = new int[N];
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < N; i++) {
			startEating(i);
		}
		
		System.out.println(max);
	}

}

*/