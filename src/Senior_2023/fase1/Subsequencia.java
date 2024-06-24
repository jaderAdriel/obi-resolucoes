package Senior_2023.fase1;

import java.util.Scanner;

public class Subsequencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sa = new int[sc.nextInt()];
        int[] sb = new int[sc.nextInt()];

        for (int i = 0; i < sa.length; i++) {
            sa[i] = sc.nextInt();
        }

        for (int i = 0; i < sb.length; i++) {
            sb[i] = sc.nextInt();
        }

        int ultimoIndex = 0;
        boolean eSub = true;
        for (int i = 0; i < sb.length; i++) {
            boolean tem = false;
            for (int j = ultimoIndex; j < sa.length; j++) {
                if (sb[i] != sa[j]) continue;
                tem = true;
                ultimoIndex = j+1;
                break;
            }

            if (!tem) {
                eSub = false;
                break;
            }
        }

        System.out.println((eSub) ? "S" : "N");
    }
}
