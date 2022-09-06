import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_김준우 {
	static int R,C,max;
	static char[][] board;
	static int[] dr = {-1,1,0,0,0};
	static int[] dc = {0,0,-1,1,0};
	
	public static void solution() {
		for(int i = 0;i<4;i++) {
			move(0,0,i,4,new char[R*C], 0);
		}
		System.out.println(max);
	}
	
	public static boolean[][] copyBool(boolean[][] bool) {
		boolean[][] copied = new boolean[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				copied[i][j] = bool[i][j];
			}
		}
		return copied;
	}
	
	public static int getOpposite(int n) {
		if(n == 0)return 1;
		else if(n == 1)return 0;
		else if(n == 2)return 3;
		else if(n == 3)return 2;
		else return 4;
	}
	
	public static void move(int r, int c, int d, int pd, char[] alpabet, int cnt) {
		if(r<0 || r>=R || c<0 || c>=C) {
			if(max<cnt)max = cnt;
			return;
		}
		for(int i = 0;i<cnt;i++) {
			if(board[r][c] == alpabet[i]) {
				if(max<cnt)max = cnt;
				return;
			}
		}
		
		alpabet[cnt] = board[r][c];
		
		for(int i = 0;i<4;i++) {
			if(i == getOpposite(d)) continue;
			int nr = r+dr[d];
			int nc = c+dc[d];
			move(nr,nc,i,d,alpabet, cnt+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		max = 0;
		board = new char[R][C];
		for(int r = 0;r<R;r++) {
			String str = br.readLine();
			for(int c = 0;c<C;c++) {
				board[r][c] = str.charAt(c);
			}
		}
		
		solution();
		
	}

}
