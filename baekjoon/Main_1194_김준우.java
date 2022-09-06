package _0331;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_1194_김준우 {
	static int N, M, n_exits;
	static char[][] maze;
	
	static int[] start = new int[2];	//{행,열}
	static ArrayList<int[]> exit = new ArrayList<int[]>();	//{행,열}
	static int[][] possesion = new int[6][2];	//a~f 열쇠 소지여부
	//static boolean[] door;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		//====input 1st line
		N = sc.nextInt();
		M = sc.nextInt();
		
		//===input rest of lines========
		maze = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				char val = str.charAt(j);
				if(val == '0') {
					start[0]= i;
					start[0]= j;
				}else if(val == '1') {
					int[] e = {i,j};
					exit.add(e);
				}
			}
			
		}
		
		int[] abc = {1,2};
		exit.add(abc);
		System.out.println(exit.remove(0)[1]);
	}

}
