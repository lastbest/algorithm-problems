import java.util.Arrays;
import java.util.Scanner;

public class Main_3040_김준우 {
	static int[] troll7;
	static int[] heights;
	static boolean found;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		heights = new int[9];
		troll7 = new int[7];
		for(int i = 0; i<9;i++) {
			heights[i] = sc.nextInt();
		}
		found = false;
		
		findTrolls(0,0);
	}
	
	public static void findTrolls(int cnt, int start) {
		if(found)return;
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0;i<7;i++) {
				sum += troll7[i];
			}
			if(sum == 100) {
				Arrays.sort(troll7);
				for(int i = 0;i<7;i++) {
					System.out.println(troll7[i]);
				}
				found = true;
			}
			
			return;
		}
		for(int i = start; i<9;i++) {
			troll7[cnt] = heights[i];
			findTrolls(cnt+1, i+1);
		}
		
	}
}