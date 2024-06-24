package Senior_2023.fase2;

import java.util.Scanner;

public class prefixo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] wordA = new char[sc.nextInt()];

        String word = sc.next();
        for (int i = 0; i < wordA.length; i++) {
            wordA[i] = word.charAt(i);
        }

        char[] wordB = new char[sc.nextInt()];
        word = sc.next();

        for (int i = 0; i < wordB.length; i++) {
            wordB[i] = word.charAt(i);
        }

        if (wordA.length > wordB.length) System.out.println(prefix(wordA, wordB));
        else System.out.println(prefix(wordB ,wordA));

    }

    public static int prefix(char[] wordA, char[] wordB) {
        int prefixLength = 0;
        for (int i = 0; i < wordA.length; i++) {
            if (i >= wordB.length) return prefixLength;
            if (wordA[i] != wordB[i]) return prefixLength;
            prefixLength++;
        }
        return prefixLength;
    }
}
