//package Senior_2021.fase2;

import java.util.Scanner;

public class tenis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] players = new int[4];

        for (int i = 0; i < players.length; i++) {
            players[i] = sc.nextInt();
        }

        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < players.length; j++) {
                if (players[i] > players[j]) {
                    int aux = players[i];
                    players[i] = players[j];
                    players[j] = aux;
                }
            }
        }

        int team1 = players[0] + players[3];
        int team2 = players[1] + players[2];

        int diff = 0;

        if (team1 > team2)
            diff = team1 - team2;
        else
            diff = team2 - team1;

        System.out.println(diff);
    }
}
