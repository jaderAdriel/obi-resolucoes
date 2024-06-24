//package fase1;

import java.util.Scanner;

public class ogro {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int d = sc.nextInt();
		int res = 2 * (d - e);
		
		if (e > d) {
			res = d + e; 
		}
		System.out.println(res);
	}
}
