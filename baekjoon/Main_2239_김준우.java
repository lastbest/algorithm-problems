import java.util.Arrays;
import java.util.Scanner;

public class Main_2239_김준우 {
	static int[][] arr;		//입력된 보드값
	static boolean stop = false;

	public static void fill(int r, int c, int[][] p_arr, boolean[] p_filled) { //filled : 3x3 사각형 중복체크배열
		//if(stop) return;
		
		System.out.println(r + " " + c);
		
		//copy array
		int[][] c_arr = new int[9][9];
		boolean[] c_filled = Arrays.copyOf(p_filled, 10);
		for (int i = 0; i < 9; i++) {
			c_arr[i] = Arrays.copyOf(p_arr[i], 9);
		}
		
		
		int val = c_arr[r][c];
		if(val > 0) {
			int nr = r; int nc = c;	//9,9마무리 필요
			
			if(r == 8 && c == 8) {	//마지막인경우
				stop =true;
				System.out.println("sdfdddfine");
				for (int k = 0; k < 9; k++) {
					System.out.println(Arrays.toString(c_arr[k]));
				}
			}
			else if(c%3 == 2 && r%3 == 2) {	//3x3 마지막인 경우
				if(c == 8) {		//맨오른쪽 3X3인경우
					nr = nr+1;
					nc = 0;
				}else {	
					nr = nr-2;
					nc = nc+1;
				}
				
				//filled 다시 만들기
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						int temp = c_arr[nr+k][nr+l];
						if(temp > 0)
							c_filled[temp] = true;
					}
				}
			}
			else if(c%3 == 2) {//다음 행
				nr = nr+1;
				nc = nc-2;
			}
			else {
				nc = nc+1;
			}
			//System.out.println(nr +" " + nc);
			
			
			fill(nr,nc,c_arr,c_filled);
		}
		else {
			//System.out.println(Arrays.toString(c_filled));
			for (int i = 1; i <= 9; i++) {
				if(stop) return;
				if(c_filled[i]) continue;
				//System.out.println("df");
				for (int j = 0; j < 9; j++) {
					if(c != j && c_arr[r][j] == i) continue;
					if(r != j && c_arr[j][c] == i) continue;
				}
				System.out.println("Sdf");
				c_arr[r][c] = i;
				c_filled[i] = true;
				
				int nr = r; int nc = c;	//9,9마무리 필요
				
				
				if(r == 8 && c == 8) {	//마지막인경우
					stop =true;
					System.out.println("sdfdddfine");
					for (int k = 0; k < 9; k++) {
						System.out.println(Arrays.toString(c_arr[k]));
					}
				}
				else if(c%3 == 2 && r%3 == 2) {	//3x3 마지막인 경우
					if(c == 8) {		//맨오른쪽 3X3인경우
						nr = nr+1;
						nc = 0;
					}else {	
						nr = nr-2;
						nc = nc+1;
					}
					
					//filled 다시 만들기
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							int temp = c_arr[nr+k][nr+l];
							if(temp > 0)
								c_filled[temp] = true;
						}
					}
				}
				else if(c%3 == 2) {//다음 행
					nr = nr+1;
					nc = nc-2;
				}
				else {
					nc = nc+1;
				}
				//System.out.println(nr +" " + nc);
				
				
				fill(nr,nc,c_arr,c_filled);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9][9];
		boolean[] filled = new boolean[10];
		
		//input
		for (int i = 0; i < 9; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		//=====첫번째 3x3 입력된 값 넣기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int temp = arr[i][j];
				if(temp > 0)
					filled[temp] = true;
			}
		}
		
		fill(0,0,arr, filled);
		
	}

}
/*
public class Main_2239_김준우 {
	static int[][] arr;

	public static void fill11(int R, int C, boolean[] filled) {
		int val = arr[R][C];
		if(filled[val]) return;
		for (int i = 0; i < 9; i++) {
			if(arr[R][i] == val) return;
		}
	}
	
	public static void fill33(int R, int C) {
		boolean[] filled = new boolean[10];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int temp = arr[R*3+i][C*3+j];
				if(temp > 0)
					filled[temp] = true;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				fill11(R*3+i, C*3+j, filled);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9][9];
		
		//input
		for (int i = 0; i < 9; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				fill33(i, j);
			}
		}
		
		
		
	}

}
*/