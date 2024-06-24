//package fase1;

import java.util.Scanner;

public class placas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String placa = sc.next();
		
		System.out.println(checkPlaca(placa));
		
		
	}
	
	public static int checkPlaca(String placa) {
		
		if (placa.length() == 8) {
			String digits = placa.split("-")[0];
			
			if (digits.length() != 3 || placa.charAt(3) != '-') return 0;
			
			for (int i = 0; i < digits.length(); i++) {
				if (Character.isDigit(digits.charAt(i))) return 0;
			}
			
			for (int i = 0; i < digits.length(); i++) {
				if (Character.isDigit(digits.charAt(i))) return 0;
			}
			
			for (int i = 4; i < 8; i++) {
				if (!Character.isDigit(placa.charAt(i))) return 0;
			}
			
			return 1;
				
		}
		
		if (placa.length() == 7) {
			String digits = placa;
			
			for (int i = 0; i < 3; i++) {
				if (Character.isDigit(digits.charAt(0))) return 0;
				if (!Character.isUpperCase(digits.charAt(0))) return 0;
			}
			
			if (!Character.isDigit(digits.charAt(3))) return 0;
			
			if (Character.isDigit(digits.charAt(4))) return 0;
			if (!Character.isUpperCase(digits.charAt(4))) return 0;
			
			if (!Character.isDigit(digits.charAt(5))) return 0;
			if (!Character.isDigit(digits.charAt(6))) return 0;
			
			return 2;
		}

        return 0;
    }
	
	
	
}
