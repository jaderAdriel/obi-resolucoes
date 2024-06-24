package Senior_2023.fase1;

import java.util.Locale;
import java.util.Scanner;

public class Estoque {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int tipos = sc.nextInt();
        int tamanhos = sc.nextInt();

        int[][] estoque = new int[tipos][tamanhos];

        for (int i = 0; i < tipos; i++) {
            for (int j = 0; j < tamanhos; j++) {
                estoque[i][j] = sc.nextInt();
            }
        }
        
        int qtdPedidos = sc.nextInt();
        int pedidosEfetivados = 0;
        for (int i = 0; i < qtdPedidos; i++) {
            int tipo = sc.nextInt() - 1;
            int tamanho = sc.nextInt() - 1;

            if (tipo > tipos - 1) continue;
            if (tamanho > tamanhos - 1) continue;

            if (estoque[tipo][tamanho] <= 0) continue;

            estoque[tipo][tamanho]--;
            pedidosEfetivados++;
        }

        System.out.println(pedidosEfetivados);
    }
}
