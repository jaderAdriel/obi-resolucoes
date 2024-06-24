//package prova_teste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class toupeira {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int qtd_saloes = sc.nextInt();
        int qtd_tuneis = sc.nextInt();

        HashMap<Integer, ArrayList<Integer>> saloesMap = new HashMap<>();
        
        for (int i = 1; i <= qtd_saloes; i++) {
            saloesMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < qtd_tuneis; i++) {
            int salaoA = sc.nextInt();
            int salaoB = sc.nextInt();

            saloesMap.get(salaoA).add(salaoB);
            saloesMap.get(salaoB).add(salaoA);
        }

        int qtd_sugestao_passeio = sc.nextInt();

        int sugestoesPossiveis = qtd_sugestao_passeio;

        for (int i = 0; i < qtd_sugestao_passeio; i++) {

            int[] rota_passeio = new int[sc.nextInt()];

            boolean  ignore = false;
            int salaoAnterior = sc.nextInt();

            for (int j = 0; j < rota_passeio.length - 1; j++) {
                rota_passeio[j] = sc.nextInt();
                if (ignore) continue;

                if (saloesMap.get(salaoAnterior).contains(rota_passeio[j])) {
                    salaoAnterior = rota_passeio[j];
                } else {
                    ignore = true;
                    sugestoesPossiveis--;
                }

            }
        }

        System.out.println(sugestoesPossiveis);
    }
}
