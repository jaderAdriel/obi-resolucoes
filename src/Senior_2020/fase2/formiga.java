package Senior_2020.fase2;

// descrição da questão: https://olimpiada.ic.unicamp.br/pratique/ps/2020/f2/formiga/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class formiga {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int qtdSaloes = sc.nextInt(), qtdTuneis = sc.nextInt(), salaoPartida = sc.nextInt();
        int[] alturas = new int[qtdSaloes];

        HashMap<Integer, ArrayList<Integer>> tuneis = new HashMap<>();

        for (int i = 0; i < qtdSaloes; i++) {
            alturas[i] = sc.nextInt();
        }

        for (int x = 0; x < qtdTuneis; x++) {
            int i = sc.nextInt(), j = sc.nextInt();

            if (!tuneis.containsKey(i)) {
                tuneis.put(i, new ArrayList<>());
            }
            if (!tuneis.containsKey(j)) {
                tuneis.put(j, new ArrayList<>());
            }
            
            tuneis.get(i).add(j);
            tuneis.get(j).add(i);
        }


        int maiorPercurso = 0;
        for (Integer tunel : tuneis.get(salaoPartida)) {
            int tamanhoPercurso = maiorPercurso(alturas, 0, Integer.MIN_VALUE, salaoPartida, tunel, tuneis);
            maiorPercurso = Math.max(tamanhoPercurso, maiorPercurso);
        }

        System.out.println(maiorPercurso);

    }


    public static int maiorPercurso(int[] alturas, int tamanhoPercursoAtual, int tamanhoMaiorPercurso, int i, int j, HashMap<Integer, ArrayList<Integer>> tuneis) {

        if (alturas[i-1] < alturas[j-1]) return tamanhoPercursoAtual;

        tamanhoPercursoAtual++;

        for (Integer tunel : tuneis.get(j)) {
            if (i == tunel) continue;
            int tamanhoPercurso = maiorPercurso(alturas, tamanhoPercursoAtual, tamanhoMaiorPercurso, j, tunel, tuneis);
            tamanhoMaiorPercurso = Math.max(tamanhoPercurso, tamanhoMaiorPercurso);
        }

        return tamanhoMaiorPercurso;
    }
}
