package _0331;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_12869_김준우 {
	static int N, cnt;
	static Integer[] scv;
	static int[][] atk;
	static int[] rest;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		scv = new Integer[N];
		cnt = 0;
		for(int i =0 ;i<N;i++) {
			scv[i] = sc.nextInt();
		}
		
		big:
		while(scv[0] > 0 || scv[1] > 0 || scv[2]> 0) {
			Arrays.sort(scv, Collections.reverseOrder());
			
			if(scv[0]<=9) {
				if(N>=2 && scv[1]<=3) {
					if(N>=3 && scv[2]<=1) {
						cnt++;
						break big;
					}
				}
			}
			
			int temp = scv[0]/9;
			if(scv[0] < 9) temp++;
			for(int i =0 ;i<N;i++) {
				int minus = 1;
				for (int j = 0; j < 2-i; j++) {
					minus *= 3;
				}
				scv[i] -= minus*temp;
				
				if(scv[i]<0) scv[i] = 0; 
			}
			cnt+=temp;
			System.out.println(cnt);
			
			System.out.println(Arrays.toString(scv));
			
		}
		
		
		System.out.println(cnt);
		
	}x

}


/*
public class Main_12869_김준우 {
	static int N;
	static Integer[] scv;
	static int[][] atk;
	static int[] rest;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		scv = new Integer[N];
		atk = new int[N][3];
		rest = new int[N];
		for(int i =0 ;i<N;i++) {
			scv[i] = sc.nextInt();
		}
		
		Arrays.sort(scv, Collections.reverseOrder());
		
		for(int i =0 ;i<N;i++) {
			atk[i][i] = (int)Math.ceil(	(double)scv[0]/9 );
			rest[i] = scv[i] - atk[i][i];
		}
		
		if(N >=2 ) {
			while(rest[1]/9>0) {
				//rest -= 9;
				atk[1][0] ++;
			}
			//int temp = (int)Math.ceil(	(double)rest[1]/3 );
			//System.out.println(rest+" "+destroy2);
		}
		
		if(N >=3 ) {
			
		}
		
		
		
		
		int destroy1 = (int)Math.ceil(	(double)scv[0]/9 );
		System.out.println(scv[0]+" " +destroy1);
		
		int destroy2 = destroy1;
		if(scv[1] / 3 > destroy2 ) {
			int rest = scv[1] - destroy2 * 3;
			
			int temp = (int)Math.ceil(	(double)rest/3 );
			destroy2 += temp;
			System.out.println(rest+" "+destroy2);
		}
		
		
		int destroy3 = destroy2;
		if(scv[2] > destroy3 ) {
			System.out.println();
		}
		
		
		
	}

}
*/