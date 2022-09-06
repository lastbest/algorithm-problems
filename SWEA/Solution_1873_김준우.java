import java.util.Scanner;

public class Solution_1873_김준우 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] map = new char[H][W];//게임맵 격자판
			int curh = -1; int curw = -1; int dir = -1;//현재 전차의 위치 방향(0상, 1하, 2좌, 3우)
			int[] dirh = {-1,1,0,0}; int[] dirw = {0,0,-1,1}; //포탄 이동 사방탐색
			for(int h = 0; h<H; h++) {
				String linec = sc.next();
				//System.out.println(linec+" " + h);
				for(int w = 0; w<W; w++) {
					//System.out.println(h+" "+w);
					map[h][w] = linec.charAt(w);
					if(map[h][w]== '^') {curh = h; curw = w; dir = 0;}
					else if(map[h][w]== 'v') {curh = h; curw = w; dir = 1;}
					else if(map[h][w]== '<') {curh = h; curw = w; dir = 2;}
					else if(map[h][w]== '>') {curh = h; curw = w; dir = 3;}
				}
			}
			
			int N = sc.nextInt();
			String linec = sc.next(); //행동 입력
	
			for(int n = 0; n<N; n++) {
				char act = linec.charAt(n);
				switch(act) {
				case 'U':
					dir = 0;
					map[curh][curw] = '^';
					if(curh>0 && map[curh-1][curw] != '*' && map[curh-1][curw] != '#' && map[curh-1][curw] != '-') {
						map[curh-1][curw] = '^';
						map[curh][curw] = '.';
						curh--;
					}
					break;
				case 'D':
					dir = 1;
					map[curh][curw] = 'v';
					if(curh<(H-1) && map[curh+1][curw] != '*' && map[curh+1][curw] != '#' && map[curh+1][curw] != '-') {
						map[curh+1][curw] = 'v';
						map[curh][curw] = '.';
						curh++;
					}
					break;
				case 'L':
					dir = 2;
					map[curh][curw] = '<';
					if(curw>0 && map[curh][curw-1] != '*' && map[curh][curw-1] != '#' && map[curh][curw-1] != '-') {
						map[curh][curw-1] = '<';
						map[curh][curw] = '.';
						curw--;
					}
					break;
				case 'R':
					dir = 3;
					map[curh][curw] = '>';
					if(curw<(W-1) && map[curh][curw+1] != '*' && map[curh][curw+1] != '#' && map[curh][curw+1] != '-') {
						map[curh][curw+1] = '>';
						map[curh][curw] = '.';
						curw++;
					}
					break;
				case 'S':
					
					int bullw =curw; int bullh = curh;
					for(int i = 0; i<W;i++) {
						bullw += dirw[dir];
						bullh += dirh[dir];
						if(bullw>=0 && bullw < W && bullh>=0 && bullh < H ) {
							if(map[bullh][bullw] == '*') {
								map[bullh][bullw] = '.';
								break;
							}else if(map[bullh][bullw] == '#') {
								break;
							}
						}else break;
					}
					break;
				default:
					break;
				}
				
			}
			sb.append("#");sb.append(t);sb.append(" ");
			for(int h = 0; h<H; h++) {
				for(int w = 0; w<W; w++) {
					sb.append(map[h][w]);
				}
				sb.append("\n");
			}
		}//Testcase for문 종료
		System.out.println(sb);
		
		
	}

}
