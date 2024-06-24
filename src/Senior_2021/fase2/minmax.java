//package Senior_2021.fase2;

import java.util.Scanner;

public class minmax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();

        int min = 0, max = 0;

        for (int i = a, x = b; i < b; i++, x--) {
            if (min > 0 && max > 0) break;

            if (min == 0)
                min = getSumDigits(i) == s ? i : 0;

            if (max == 0)
                max = getSumDigits(x) == s ? x : 0;
        }

        System.out.println(min);
        System.out.println(max);
    }

    public static int getSumDigits(int num) {
        int sum = 0;

        if (num < 10 ) return num;

        int x = num / 10;
        int aux = num;
        while (x > 0) {
            int digit = aux - x * 10;
            aux = x;
            x = x / 10;
            sum +=  digit;
        }
        sum += aux;

        return sum;
    }
}
