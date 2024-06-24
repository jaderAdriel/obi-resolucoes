//package Senior_2021.fase1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class baralho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cadeia = sc.next();

        HashMap<String,  ArrayList<Integer>> baralho = new HashMap<>();

        baralho.put("C", new ArrayList<>());
        baralho.put("E", new ArrayList<>());
        baralho.put("U", new ArrayList<>());
        baralho.put("P", new ArrayList<>());

        for (int i = 0; i < cadeia.length(); i += 3) {
            String naipe = String.valueOf(cadeia.charAt(i+2));
            int carta = Integer.valueOf(cadeia.substring(i, i+2));
            baralho.get(naipe).add(carta);
        }

        System.out.println(contabilizarBaralho(baralho.get("C")));
        System.out.println(contabilizarBaralho(baralho.get("E")));
        System.out.println(contabilizarBaralho(baralho.get("U")));
        System.out.println(contabilizarBaralho(baralho.get("P")));
    }

    public static String contabilizarBaralho(ArrayList<Integer> cartas) {

        for (int carta : cartas) {
            int qtdCartasX = 0;
            for (int cartaB : cartas) {
                if (carta == cartaB) qtdCartasX++;
                if (qtdCartasX > 1 ) return "erro";
            }
        }

        return String.valueOf(13 - cartas.size()) ;
    }
}
