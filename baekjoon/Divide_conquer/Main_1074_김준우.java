import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_김준우 {
	static int N, r, c, size, cnt;
	static boolean stop;
	public static void main(String[] args) throws IOException {
		//======input first line===============
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		size = (int)Math.pow(2, N);
		stop = false;
		
		movez(N,0,0);
		
	}
	
	public static void movez(int size_z, int start_c, int start_r) {
		if(stop) return;
		if(start_c>c && start_r > r) return;
		if(size_z>0) {
			int dist = (int)Math.pow(2, size_z-1);
			if(start_c <= c && start_c+dist > c && start_r <= r && start_r+dist > r) {
				movez(size_z-1,start_c, start_r);
			}
			else {
				cnt += (dist*dist);
			}
			
			if(start_c+dist <= c && start_c+dist+dist > c && start_r <= r && start_r+dist > r) {
				movez(size_z-1,start_c + dist, start_r);
			}
			else {
				cnt += (dist*dist);
			}
			
			if(start_c <= c && start_c+dist > c && start_r+dist <= r && start_r+dist+dist > r) {
				movez(size_z-1,start_c, start_r + dist);
			}
			else {
				cnt += (dist*dist);
			}
			
			if(start_c+dist <= c && start_c+dist+dist > c && start_r+dist <= r && start_r+dist+dist > r) {
				movez(size_z-1,start_c + dist, start_r + dist);
			}
			else {
				cnt += (dist*dist);
			}
			
		}
		else {
			if(start_c == c && start_r == r) {
				System.out.println(cnt);
				stop = true;
			}
			cnt++;
		}
		
		return;
	}

}
