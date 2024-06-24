package Senior_2023.fase1;

import java.util.Collections;
import java.util.Scanner;

public class ContasAPagar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double dinheiroDisponivel = sc.nextDouble();
        double numeroContasPossiveisPagar = 0;
        double[] contas = {sc.nextDouble(), sc.nextDouble(), sc.nextDouble()};

        for (int i = 0; i < contas.length; i++) {
            for (int j = 0; j < contas.length; j++) {
                if (!(contas[i] < contas[j])) continue;
                double aux = contas[j];
                contas[j] = contas[i];
                contas[i] = aux;
            }
        }
        
        double total = 0;
        for (double conta : contas) {
            System.out.println("conta = " + conta);
            if (total + conta <= dinheiroDisponivel) {
                total += conta;
                numeroContasPossiveisPagar++;
            }
        }

        System.out.println(numeroContasPossiveisPagar);
    }
}
