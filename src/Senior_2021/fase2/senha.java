package Senior_2021.fase2;

import java.util.*;

public class senha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt(), s = sc.nextInt();

        List<List<String>> words = new ArrayList<>();
        String passString = sc.next();

        for (int i = 0; i < m; i++) {
            String word = sc.next();
            List<String> letterList = new ArrayList<>();

            for (int j = 0; j < s; j++) {
                letterList.add(Character.toString(word.charAt(j)));
            }
            Collections.sort(letterList);
            words.add(letterList);
        }

        int p = sc.nextInt();
        p--;

        String[] rightReplace = new String[m];

        for (int i = m - 1; i >= 0; i--) {
            int x = p % s;
            p = p / s;
            rightReplace[i] = words.get(i).get(x);
        }

        int j = 0;
        for (int i = 0; i < n; i++) {
            char letter = passString.charAt(i);
            if (letter == '#') {
                System.out.print(rightReplace[j]);; j++;
            } else {
                System.out.print(letter);
            }
        }
    }
}
