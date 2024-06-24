//package Senior_2021.fase1;

import java.util.HashMap;
import java.util.Scanner;

public class zero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        int lastNum = 0;
        HashMap<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];

            if (nums[i] != 0) {
                lastNum++;
                indices.put(lastNum, i);
                continue;
            }

            sum -= nums[indices.get(lastNum)];
            lastNum--;
        }

        System.out.println(sum);
    }
}
