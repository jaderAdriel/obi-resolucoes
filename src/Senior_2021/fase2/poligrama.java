package Senior_2021.fase2;

import java.util.HashMap;
import java.util.Scanner;

public class poligrama {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int poligramaLen = sc.nextInt();
        char[] poligrama = sc.next().toCharArray();

        String raiz = "*";

        int metadeTamanho = poligramaLen / 2;
        for (int i = 1; i <= metadeTamanho; i++) {

            if (poligramaLen % i != 0 ) continue;

            HashMap<Character, Integer> pattern = new HashMap<>();
            raiz = "";
            for (int j = 0; j < i; j++) {
                raiz = raiz.concat(String.valueOf(poligrama[j]));
                if (pattern.containsKey(poligrama[j])) {
                    pattern.put(poligrama[j], pattern.get(poligrama[j]) + 1);
                } else {
                    pattern.put(poligrama[j], 1);
                }
            }

            if (isPoligrama(i, poligrama, pattern)) break;
            raiz = "*";
            if (poligramaLen % 2 == 1) break;
        }

        System.out.println(raiz);
    }

    public static boolean isPoligrama(int qtdPalavras, char[] letters, HashMap<Character, Integer> pattern) {

        for (int i = qtdPalavras; i < letters.length; i++) {
            HashMap<Character, Integer> palavra = new HashMap<>();
            for (int j = i; j < i + qtdPalavras; j++) {
                if (!pattern.containsKey(letters[j])) return false;
                if (palavra.containsKey(letters[j])) {
                    palavra.put(letters[j], palavra.get(letters[j]) + 1);
                } else {
                    palavra.put(letters[j], 1);
                }
            }

            for (char key : pattern.keySet()) {
                if (!palavra.containsKey(key)) return false;
                if (palavra.get(key) != pattern.get(key)) return false;
            }

            i += qtdPalavras - 1;
        }
        return true;
    }
}
