import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2138_김준우 {
	static int N, min = -1;
	static int[] origin, lights, goal;
	static boolean[] visited;
	
	public static void push(int n) {
		lights[n] = (lights[n] + 1) % 2;
		if(n-1 >= 0)	lights[n-1] = (lights[n-1] + 1) % 2;
		if(n+1 <= N-1)	lights[n+1] = (lights[n+1] + 1) % 2;
	}
	
	public static void dfs(int n, int cnt) {
		push(n);
		if(Arrays.toString(lights).equals(Arrays.toString(goal))) {
			if(cnt < min || min == -1) min = cnt;
			//System.out.println(cnt);
		}
		
		visited[n] = true;
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			if(lights[i] == goal[i]) continue;
			dfs(i, cnt+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		origin = new int[N];
		lights = new int[N];
		goal = new int[N];
		visited= new boolean[N];
		
		String str = br.readLine();
		String str2 = br.readLine();
		for(int i = 0;i<N;i++) {
			origin[i] = str.charAt(i) - '0';
			lights[i] = origin[i];
			goal[i] = str2.charAt(i) - '0';
		}
		
		for (int i = 0; i < N; i++) {
			if(origin[i] == goal[i]) continue;
			visited= new boolean[N];
			dfs(i, 1);
		}
		
		System.out.println(min);
	}
}

/*메모리초과
 * import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2138_김준우 {
	static int N, min = Integer.MAX_VALUE;
	static short[] origin, goal;
	
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		short[] lights = Arrays.copyOf(origin, N);
		
		q.add(n);
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			cnt ++;
			
			int dq = q.poll();
			lights[dq] += 1;	if(lights[dq] == 2) lights[dq] = 0;
			if(dq-1>=0) {	lights[dq-1] += 1;	if(lights[dq-1] == 2) lights[dq-1] = 0;}
			if(dq+1<N)	{	lights[dq+1] += 1;	if(lights[dq+1] == 2) lights[dq+1] = 0;}
			//System.out.println(Arrays.toString(lights));
			if(Arrays.toString(lights).equals(Arrays.toString(goal))) {
				if(cnt<min) min = cnt;
				return;
			}
			
			for (int i = 0; i < N; i++) {
				if(visited[i]) continue;
				if(lights[i] == goal[i]) continue;
				visited[i] = true;
				q.add(i);
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		origin = new short[N];
		goal = new short[N];
		
		String str = br.readLine();
		String str2 = br.readLine();
		for(int i = 0;i<N;i++) {
			origin[i] = (short)(str.charAt(i) - '0');
			goal[i] = (short)(str2.charAt(i) - '0');
		}
		
		for (int i = 0; i < N; i++) {
			if(origin[i] == goal[i]) continue;
			bfs(i);
		}
		
		System.out.println(min);
	}
}*/


/*예전에 시간 초과
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2138_김준우 {
	static int N;
	static int[] origin, lights, goal;
	static boolean found;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		origin = new int[N];
		lights = new int[N];
		goal = new int[N];
		
		String str = br.readLine();
		String str2 = br.readLine();
		for(int i = 0;i<N;i++) {
			origin[i] = str.charAt(i) - '0';
			lights[i] = origin[i];
			goal[i] = str2.charAt(i) - '0';
		}
		
		solution(0);
		System.out.println(Arrays.toString(lights));
		
	}
	
	public static void solution(int cnt) {
		if(finish()) {
			System.out.println(cnt);
			return;
		}
		for(int i = 0;i<N;i++) {
			if(lights[i] != goal[i]) {
				press(i);
				solution(cnt+1);
			}
		}
	}
	
	public static void press(int n) {
		if(n>0) {
			lights[n-1] = change(lights[n-1]);
		}
		if(n<N-1) {
			lights[n+1] = change(lights[n+1]);
		}
		lights[n] = change(lights[n]);
	}
	
	public static int change(int n) {
		if(n == 0) return 1;
		if(n == 1) return 0;
		return -1;
	}
	
	public static boolean finish() {
		boolean f = true;
		for(int i = 0;i<N;i++) {
			if(lights[i] != goal[i]) {
				f = false;
			}
		}
		return f;
	}

}
*/
