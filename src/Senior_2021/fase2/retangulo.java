package Senior_2021.fase2;

// essa questão não está com uma performace boa, passou em 40% do casos pois
// Para um conjunto de casos de testes valendo 20 pontos, N ≤ 100.
// Para um conjunto de casos de testes valendo outros 20 pontos, N ≤ 300.
// Pretendo melhorar depois, com uma solução mais eficaz

import java.util.Scanner;

public class retangulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amountTrees = sc.nextInt();
        int[] archList = new int[amountTrees];
        int circumference = 0;
        boolean appearsRectangle = false;

        for (int i = 0; i < amountTrees; i++) {
            archList[i] = sc.nextInt();
            circumference += archList[i];
        }

        for (int i = 0; i < archList.length; i++) {
            int[] verticesA = new int[]{i,i};

            int x = ( i + 1 >= archList.length) ? 0 : i+1;

            for (int j = x; j < archList.length - 1; j++) {
                verticesA[1] = j - 1;
                int temp = ( j + 1 >= archList.length) ? 0 : j+1;
                appearsRectangle = check(archList,verticesA, temp, circumference);
                if (appearsRectangle) break;
            }

            if (appearsRectangle) break;
        }

        System.out.println((appearsRectangle) ? "S" : "N");
    }

    public static boolean check(int[] archList, int[] verticesA, int x, int circumference) {
        boolean appearsRectangle = false;
        int verticesALength = getVerticesLength(archList,verticesA);
        for (int j = x; j < archList.length; j++) {
            int[] verticesB = new int[]{j,j};
            int verticesBLength = getVerticesLength(archList, verticesB);

            if (verticesBLength == verticesALength) {
                appearsRectangle = hasEqualDistance(archList, verticesA, verticesB, verticesALength, verticesBLength, circumference);
                if (appearsRectangle) return true;
            }

            if (verticesALength < verticesBLength) continue;

            int y = verticesB[1];
            verticesBLength -= archList[verticesB[1]];
            while (y + 1 != verticesA[0] && y + 1 != verticesA[1] && verticesBLength < verticesALength) {
                if (y >= archList.length) {
                    y = 0;
                    continue;
                }
                verticesBLength += archList[y];

                if (verticesBLength == verticesALength ) {
                    verticesB[1] = y;
                    appearsRectangle = hasEqualDistance(archList, verticesA, verticesB, verticesALength, verticesBLength, circumference);
                    if (appearsRectangle) return true;
                }
                y++;
            }
        }
        return appearsRectangle;
    }

    public static int getVerticesLength (int[] archList, int[] vertices) {
        int sum = 0;
        int i = vertices[0];

        boolean goInverse = vertices[0] > vertices[1];
        boolean inverted = false;
        while (true) {
            if (!goInverse && vertices[0] != vertices[1] && i > vertices[1]) break;
            if (inverted && i > vertices[0]) break;

            if (i >= archList.length) {
                i = 0;
                inverted = true;
                continue;
            }
            sum += archList[i];
            i++;

            if (vertices[0] == vertices[1]) break;
        }
        return sum;
    }

    public static boolean hasEqualDistance(int[] archList, int[] verticesA, int[] verticesB, int verticesALength, int verticesBLength,int circumference) {
        int x = verticesA[1] + 1;

        if (Math.abs(verticesA[0] - verticesA[1]) > Math.abs(verticesB[0] - verticesB[1])) {
            x = verticesB[1] + 1;
        }

        if (x >= archList.length) {
            x -= archList.length;
            if (x == verticesA[0] || x == verticesA[0] + 1) return false;
        }

        int j = x;
        int[] distance = {0,0};
        while (j != verticesA[0] && j != verticesA[1] && j != verticesB[0] && j != verticesB[1] ) {
            if (j >= archList.length) {
                j = 0;
                continue;
            }
            distance[1] += archList[j];
            j++;
        }
        distance[0] = circumference - (verticesALength + verticesBLength + distance[1]) ;

        return distance[0] == distance[1] && distance[0] != 0;
    }
}
