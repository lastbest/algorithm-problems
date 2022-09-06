import java.util.Scanner;

public class Solution_1208_±èÁØ¿ì {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		StringBuilder sb = new StringBuilder();
		for(int t= 0; t<T;t++){
			int dump = sc.nextInt();
			int[] height = new int[100];
			int max = -1; int min = 101; int maxw = 0; int minw = 0;
			for(int i =0;i<100;i++) {
				height[i] = sc.nextInt();
				if(height[i]>max) {
					max = height[i];
					maxw = i;
				}
				if(height[i]<min) {
					min = height[i];
					minw = i;
				}
			}
			while(dump!=0) {
				height[maxw]--;
				height[minw]++;
				max = -0; min = 101;
				for(int i =0;i<100;i++) {
					if(height[i]>max) {
						max = height[i];
						maxw = i;
					}
					if(height[i]<min) {
						min = height[i];
						minw = i;
					}
				}
				dump--;
			}
			
			sb.append("#");
			sb.append(t+1);
			sb.append(" ");
			sb.append(max-min);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
