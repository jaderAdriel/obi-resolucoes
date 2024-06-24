//package Senior_2021.fase1;

import java.util.Scanner;

public class torneio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] matches = new String[6];
        int wins = 0;

        for (int i = 0; i < matches.length; i++) {
            matches[i] = sc.next();

            if (matches[i].equals("V"))
                wins++;
        }

        if (wins >= 5)
            System.out.println(1);
        else if (wins >= 3)
            System.out.println(2);
        else if (wins > 0)
            System.out.println(3);
        else
            System.out.println(-1);
    }
}
