//package prova_teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class contas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dindin = sc.nextInt();
        ArrayList<Integer> contas = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            contas.add(sc.nextInt());
        }

        Collections.sort(contas);

        int contasPagas = 0;
        for (int i = 0; i < contas.size(); i++) {
            if ( dindin >= contas.get(i)) {
                dindin -= contas.get(i);
                contasPagas++;
            }
        }

        System.out.println(contasPagas);
    }
}
