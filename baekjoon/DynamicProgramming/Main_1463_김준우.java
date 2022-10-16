package class3;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1463_김준우 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		
		int[] min = new int[N+1];
		
		min[1] = 0;
		if(N>=2)min[2] = 1;
		if(N>=3)min[3] = 1;
		for (int i = 4; i <= N; i++) {
			int case3 =-1; 
			int case2 = -1; 
			if(i%3 > 0) case3 = min[i-i%3] + i%3;
			else case3 = min[i/3]+1;
			
			if(i%2 > 0) case2 = min[i-i%2] + i%2;
			else case2 = min[i/2]+1;
			
			min[i] = Math.min(case3, case2);
			
			//System.out.println(case2 + " " + case3);
		}
		
		//System.out.println(Arrays.toString(min));
		System.out.println(min[N]);
	}

}
