package Senior_2020.fase2;

// link da questão: https://olimpiada.ic.unicamp.br/pratique/ps/2020/f2/caixeiro/

import java.util.*;

public class caixeiro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, HashMap<Integer, Integer>> pontos = new HashMap<>();

        int n = sc.nextInt();

        for (int i = 0; i < n * (n-1) / 2; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int t = sc.nextInt();


            if (!pontos.containsKey(a)) {
                pontos.put(a, new HashMap<>());
                pontos.get(a).put(b, t);
            } else
                pontos.get(a).put(b, t);
            if (!pontos.containsKey(b)) {
                pontos.put(b, new HashMap<>());
                pontos.get(b).put(a, t);
            } else
                pontos.get(b).put(a, t);
        }

        int menorCaminho = Integer.MAX_VALUE;

        for (Integer start : pontos.keySet()) {
            List<Integer> paradas = new ArrayList<>();
            paradas.add(start);
            int menor = pegarMenorCaminho(0, menorCaminho , start, paradas, pontos);
            menorCaminho = Math.min(menor, menorCaminho);
        }

        System.out.println(menorCaminho);
    }
//
    public static int pegarMenorCaminho(int tamanhoCaminho, int menorCaminho, int pontoAtual, List<Integer> paradas, HashMap<Integer, HashMap<Integer, Integer>> caminhos) {
        if (paradas.size() >= caminhos.size()) return tamanhoCaminho;
        // todas cidades menores que K já foram visitadas
        boolean cond1 = true;
        // todas as cidades menores que K serão visitadas após K
        boolean cond2 = true;

        for (int i = 1; i < pontoAtual; i++) {
            if (!paradas.contains(i)) {
                cond1 = false;
            } else {
                cond2 = false;
            }
            if (!cond1 && !cond2) return Integer.MAX_VALUE;
        }

        for (Integer cidade : caminhos.get(pontoAtual).keySet()) {
            if (paradas.contains(cidade)) continue;
            tamanhoCaminho += caminhos.get(pontoAtual).get(cidade);
            List<Integer> newParadas = new ArrayList<>(paradas);
            newParadas.add(cidade);
            int caminho = pegarMenorCaminho(tamanhoCaminho, menorCaminho ,cidade, newParadas, caminhos);
            menorCaminho = Math.min(caminho, menorCaminho);
        }

        return menorCaminho;
    }
}
