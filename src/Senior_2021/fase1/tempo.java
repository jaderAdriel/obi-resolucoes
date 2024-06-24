//package Senior_2021.fase1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class tempo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> amigos = new ArrayList<>();

        HashMap<Integer, Integer> tempoResposta = new HashMap<>();

        int qtdRegistros = sc.nextInt();

        int[][] registros = new int[qtdRegistros][2];


        int r = 'R';
        int t = 'T';
        int e = 'E';

        for (int i = 0; i < qtdRegistros; i++) {
            registros[i][0] = sc.next().charAt(0);
            registros[i][1] = sc.nextInt();

            if (registros[i][0] == r) {
                int amigo = registros[i][1];
                if (tempoResposta.containsKey(amigo)) continue;
                tempoResposta.put(amigo, 0);
                amigos.add(amigo);
            }
        }

        for (int i = 0; i < qtdRegistros; i++) {
            if (registros[i][0] == r) {
                int amigo = registros[i][1];
                int tempo = procurarTempoResposta(i, amigo, registros);
                if (tempo != -1) {
                    tempo += tempoResposta.get(amigo);
                }
                tempoResposta.put(amigo, tempo);
            }
        }

        Collections.sort(amigos);

        for (int amigo : amigos) {
            System.out.println(amigo + " " + tempoResposta.get(amigo));
        }

    }

    public static int procurarTempoResposta(int posicao, int amigo, int[][] registros) {
        int r = 'R';
        int t = 'T';
        int e = 'E';
        int tempoResposta = 0;

        for (int i = posicao ; i < registros.length ; i++) {
            int tipoRegistro = registros[i][0];
            int valorRegistro = registros[i][1];

            if (tipoRegistro == t) {
                tempoResposta--;
                tempoResposta += valorRegistro;
            }

            if (tipoRegistro == e && valorRegistro == amigo) return tempoResposta;

            if (tipoRegistro != t) {
                tempoResposta++;
            };

        }
        return -1;
    }
}
