//package fase1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class concurso {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int qtd_alunos = sc.nextInt();
		int qtd_aprovados = sc.nextInt();
		
		ArrayList<Integer> alunos = new ArrayList<>();
		
		for (int i = 0; i < qtd_alunos; i++) {
			alunos.add(sc.nextInt());
		}
		
		Collections.sort(alunos);
		
		System.out.print(alunos.get(qtd_alunos - qtd_aprovados));
		sc.close();
	}
}
