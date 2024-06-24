package Senior_2023.fase2;

import java.util.ArrayList;
import java.util.Scanner;

public class grupos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int qtdAlunos = sc.nextInt();
        int qtdPreferenciaMesmoGrupo = sc.nextInt();
        int qtdNaoPreferenciaMesmoGrupo = sc.nextInt();

        int qtdGrupos = (qtdAlunos - qtdAlunos % 3) / 3 + (qtdAlunos % 3);

        ArrayList<ArrayList<ArrayList<Integer>>> alunos = new ArrayList<>();

        for (int i = 0; i < qtdAlunos; i++) {
            ArrayList<Integer> preferencia = new ArrayList<>();
            ArrayList<Integer> naoPreferencia = new ArrayList<>();
            ArrayList<ArrayList<Integer>> restricoes = new ArrayList<>();
            restricoes.add(preferencia);
            restricoes.add(naoPreferencia);
            alunos.add(restricoes);
        }

        for (int i = 0; i < qtdPreferenciaMesmoGrupo; i++) {
            int alunoA = sc.nextInt() - 1;
            int alunoB = sc.nextInt() - 1;

            alunos.get(alunoA).get(0).add(alunoB);
            alunos.get(alunoB).get(0).add(alunoB);
        }

        for (int i = 0; i < qtdNaoPreferenciaMesmoGrupo; i++) {
            int alunoA = sc.nextInt() - 1;
            int alunoB = sc.nextInt() - 1;

            alunos.get(alunoA).get(1).add(alunoB);
        }

        int condicoesQuebradas = 0;

        for (int i = 0; i < qtdGrupos; i++) {
            ArrayList<Integer> grupo = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                int aluno = sc.nextInt() - 1;
                grupo.add(aluno);
            }

            int naopreferenciaChecados = 0;
            for (int j = 0; j < 3; j++) {
                ArrayList<ArrayList<Integer>> restricoes = alunos.get(grupo.get(j));
                ArrayList<Integer> preferencia = restricoes.get(0);
                ArrayList<Integer> naopreferencia = restricoes.get(1);

                for (int alunoB : preferencia) {
                    if (!grupo.contains(alunoB)) {
                        condicoesQuebradas++;
                    }
                }

                for (int alunoB : naopreferencia) {
                    if (grupo.contains(alunoB)) {
                        condicoesQuebradas++;
                        naopreferenciaChecados++;
                    }
                }
            }


        }

        System.out.println(condicoesQuebradas);
    }
}
