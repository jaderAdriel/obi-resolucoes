package Senior_2023.fase1;

import java.util.ArrayList;
import java.util.Scanner;

public class toupeira {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> saloes = new ArrayList<>();

        int qtdSaloes = sc.nextInt();
        int qtdTuneis = sc.nextInt();

        for (int i = 0; i < qtdSaloes; i++) {
            ArrayList<Integer> tuneis = new ArrayList<>();
            saloes.add(i, tuneis);
        }

        for (int i = 0; i < qtdTuneis; i++) {
            int salaoA = sc.nextInt();
            int salaoB = sc.nextInt();

            saloes.get(salaoA - 1).add(salaoB - 1);
            saloes.get(salaoB - 1).add(salaoA - 1);
        }

        int qtdSugestaoPasseio = sc.nextInt();
        int qtdSugestaoPasseioValidas = qtdSugestaoPasseio;
        for (int i = 0; i < qtdSugestaoPasseio; i++) {
            int qtdParadasRota = sc.nextInt();
            
            ArrayList<Integer> sugestaoPasseio = new ArrayList<>();
            
            for (int j = 0; j < qtdParadasRota; j++) {
                sugestaoPasseio.add(sc.nextInt());
            }

            ArrayList<Integer> tuneis = saloes.get(sugestaoPasseio.get(0) - 1);
            for (int j = 1; j < qtdParadasRota; j++) {
                if (!tuneis.contains(sugestaoPasseio.get(j) - 1)) {
                    qtdSugestaoPasseioValidas--;
                    break;
                };
                tuneis = saloes.get(sugestaoPasseio.get(j) - 1);
            }
            
        }

        System.out.println(qtdSugestaoPasseioValidas);
    }
}
