import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_16236_김준우 {
	static int N, sr, sc, size_s, sec;	// 공간의 크기, 상어 좌표 행, 상어 좌표 열, 상어 사이즈, 초
	static int[][] map;
	static LinkedList<fish> fishes;
	static int[] dr = {-1,1,0,0}; //up down left right
	static int[] dc = {0,0,-1,1};
	
	
	
	public static void moveto(int r, int c) {
		int dir1, dir2;
		int a = 0; int b = 0;
		if(r>sr) {
			dir1 = 1;
			a = r-sr;
		}
		else if(r<sr) {
			dir1 = 0;
			a = sr-r;
		}
		if(c>sc) {
			dir2 = 3;
			b = c-sc;
		}
		else if(c<sc) {
			dir2 = 2;
			b = sc-c;
		}
		
		for(int i = 0; i<(a+b); i++) {
			
		}
	}
	
	public static void combination(int a, int cnt, int[] arr) {
		
	}
	
	public static void move(int dir, int cr, int cc) {
		int nr = cr + dr[dir];
		int nc = cc + dc[dir];
		if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc]>size_s) {
			return;
		}
		if(map[nr][nc]<size_s) {map[nr][nc] = 0;}
		else {}
		cr = nr;
		cc = nc;
		//sec++;
	}
	
	//==============물고기 정보 클래스==========================
	public static class fish implements Comparable<fish>{	
		int r;	//물고기가 위치한 행
		int c;	//물고기가 위치한 열
		int size;
		
		public fish(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}
		
		@Override
		public int compareTo(fish o) {
			if(this.r-o.r == 0) {	//같은 행이면 열 비교
				return this.c-o.c;
			}
			else {
				return this.r-o.r;	//행 비교
			}
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(r);
			builder.append(", ");
			builder.append(c);
			builder.append(", size: ");
			builder.append(size);
			return builder.toString();
		}
		
	}
	
	
	//=============main=========================================================
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		fishes = new LinkedList<fish>();
		map = new int[N][N];
		size_s = 2;
		sec = 0;
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<N;j++) {
				int temp =  Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp>0 && temp<9) {
					fishes.add(new fish(i,j,temp));
				}
				else if(temp == 9) {
					sr = i;
					sc = j;
					map[i][j] = 0;
				}
			}
		}
		
	
		fishes.sort(null);
		/*
		fishes.sort(new Comparator<fish>() {
			@Override
			public int compare(fish o1, fish o2) {
				return o1.c-o2.c;
			}
		});
		
		fishes.sort(new Comparator<fish>() {
			@Override
			public int compare(fish o1, fish o2) {
				return o1.r-o2.r;
			}
		});*/
		
		
		
		while(!fishes.isEmpty()) {
			System.out.println(fishes.poll());
		}
		
		
		
	}

}
