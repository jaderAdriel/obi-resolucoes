package Senior_2021.fase2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class sanduiche {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, Integer> avoid = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            sc.nextInt();

            if (avoid.containsKey(k))
                avoid.put(k, avoid.get(k) + 1);
            else
                avoid.put(k, 1);


        }

        int totalCombinations = 0;

        for (int i = 1; i <= n; i++) {
            totalCombinations += fatorial(n) / (fatorial(i) * fatorial(n - i));
        }

        int j = 1;
        int excludedCombinations = 0;
        for (int i = 2; i < n; i++) {
            for (int key : avoid.keySet()) {
                excludedCombinations += j * avoid.get(key);
                if (avoid.get(key) > 1 && j >= 2) excludedCombinations -= avoid.get(key);
            }
            j++;
        }

        if (!avoid.isEmpty()) {
            excludedCombinations++;
        }

        System.out.println(totalCombinations - excludedCombinations);
    }

    public static int fatorial(int num) {
        int r = 1;
        for (int i = num; i > 0 ; i--) {
            r *= i;
        }
        return r;
    }

}
