//package prova_teste;

import java.util.Scanner;

public class premio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int paes = sc.nextInt();
        int doces = sc.nextInt() ;
        int bolos = sc.nextInt();

        int pontos = paes + doces * 2 + bolos * 3;

        if (pontos >= 150) System.out.println("B");
        else if (pontos >= 120) System.out.println("D");
        else if (pontos >= 100) System.out.println("P");
        else System.out.println("N");

    }
}
