//package Senior_2021.fase2;

import java.util.Scanner;

public class lista {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int operations = 0;
        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        int i = 0, j = n-1;
        int left = list[i], right = list[j];

        while (i < j) {
            if (left == right){
                i++; j--;
                left = list[i];
                right = list[j];
                continue;
            }

            operations++;

            if (left < right) {
                i++;
                left += list[i];
            } else {
                j--;
                right += list[j];
            }

            if (i == j)
                break;
        }

        System.out.println(operations);
    }

}
