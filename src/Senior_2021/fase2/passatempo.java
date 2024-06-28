//package Senior_2021.fase2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class passatempo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> variaveis = new HashMap<>();
        int l = sc.nextInt(), c = sc.nextInt();

        String[][] passatempo = new String[l][c];
        int[] somaLinha = new int[l];
        int[] somaColunas = new int[c];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                passatempo[i][j] = sc.next();
                if (!variaveis.containsKey(passatempo[i][j])) {
                    variaveis.put(passatempo[i][j], 0);
                }
            }
            somaLinha[i] = sc.nextInt();
        }
        for (int i = 0; i < c; i++) somaColunas[i] = sc.nextInt();

        int qtdVariaveis = variaveis.size();
        variaveis.clear();

        while ( variaveis.size() != qtdVariaveis) {
            resolverLinha(l, c, passatempo, somaLinha, variaveis);
            resolverColuna(l, c, passatempo, somaColunas, variaveis);
        }

        variaveis.keySet().stream().sorted().map(item -> item + " " + variaveis.get(item)).forEach(System.out::println);
    }

    static public void acharValorVariavel(int soma, HashMap<String,Integer> frequencia, HashMap<String,Integer> variaveis) {
        int valorVariavelDesconhecida = soma;
        String nomeVariavel = "";
        for (String key : frequencia.keySet()) {
            if (variaveis.containsKey(key)) {
                valorVariavelDesconhecida -= variaveis.get(key) * frequencia.get(key);
            } else {
                nomeVariavel = key;
            }
        }
        variaveis.put(nomeVariavel, valorVariavelDesconhecida / frequencia.get(nomeVariavel));
    }

    static public void resolverLinha(int l, int c, String[][] passatempo, int[] soma, HashMap<String,Integer> variaveis) {
        for (int i = 0; i < l; i++) {
            int variaveisDesconhecidas = 0;
            HashMap<String, Integer> frequencia = new HashMap<>();
            for (int j = 0; j < c; j++) {
                if (!frequencia.containsKey(passatempo[i][j])) {
                    frequencia.put(passatempo[i][j], 1);
                    if (!variaveis.containsKey(passatempo[i][j])) {
                        variaveisDesconhecidas++;
                    }
                } else {
                    frequencia.put(passatempo[i][j], frequencia.get(passatempo[i][j]) + 1);
                }
            }

            if (variaveisDesconhecidas == 1) {
                acharValorVariavel(soma[i], frequencia, variaveis);
            }
        }
    }

    static public void resolverColuna(int l, int c, String[][] passatempo, int[] soma, HashMap<String,Integer> variaveis) {
        for (int j = 0; j < c; j++) {
            int variaveisDesconhecidas = 0;
            HashMap<String, Integer> frequencia = new HashMap<>();
            for (int i = 0; i < l; i++) {
                if (!frequencia.containsKey(passatempo[i][j])) {
                    frequencia.put(passatempo[i][j], 1);
                    if (!variaveis.containsKey(passatempo[i][j])) {
                        variaveisDesconhecidas++;
                    }
                } else {
                    frequencia.put(passatempo[i][j], frequencia.get(passatempo[i][j]) + 1);
                }
            }

            if (variaveisDesconhecidas == 1) {
                acharValorVariavel(soma[j], frequencia, variaveis);
            }
        }
    }
}
