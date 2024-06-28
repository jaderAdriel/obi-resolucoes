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

            for (int j = 0; j < word.length(); j++) {
                letterList.add(Character.toString(word.charAt(j)));
            }
            Collections.sort(letterList);
            words.add(letterList);
        }

        int p = sc.nextInt();

        List<String> replacePossibilities = generateCombinations(words, p);
        String rightWord = replacePossibilities.get(p - 1);

        System.out.println(rightWord);

        List<String> digits = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (passString.charAt(i) == '#') {
                digits.add(String.valueOf(rightWord.charAt(c)));
                c++;
            } else {
                digits.add(String.valueOf(passString.charAt(i)));
            }
        }

        String password = digits.stream().reduce("" , String::concat);
        System.out.println(password);
    }

    public static List<String> generateCombinations(List<List<String>> lists, int limit) {
        List<String> combinations = new ArrayList<>();
        combine(lists, 0, "", combinations, limit);
        Collections.sort(combinations);
        return combinations;
    }

    public static void combine(List<List<String>> lists, int index, String currentCombination, List<String> combinations, int limit) {

        if (combinations.size() == limit) return;

        if (index == lists.size()) {
            combinations.add(currentCombination);
            return;
        }

        List<String> list = lists.get(index);

        for (String letter : list) {
            combine(lists, index+1, currentCombination+letter, combinations, limit);
        }
    }
}
