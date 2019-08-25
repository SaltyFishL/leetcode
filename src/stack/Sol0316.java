package stack;

import java.util.LinkedList;

public class Sol0316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] used = new boolean[26];
        StringBuilder resSb = new StringBuilder();
        LinkedList<Character> resList = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        char letter;
        for (int i = 0; i < s.length(); i++) {
            letter = s.charAt(i);
            count[letter - 'a']--;
            if (used[letter - 'a']) {
                continue;
            }

            while (resList.size() > 0 && letter < resList.getLast() && count[resList.getLast() - 'a'] > 0) {
                used[resList.getLast() - 'a'] = false;
                resList.removeLast();
            }
            resList.addLast(letter);
            used[letter - 'a'] = true;
        }
        for (Character character : resList) {
            resSb.append(character);
        }
        return resSb.toString();
    }

    public static void main(String[] args) {
        String tests[] = {
                "bcabc",
                "cbacdcbc",
                "abacb"
        };

        Sol0316 sol = new Sol0316();
        for (String test : tests) {
            System.out.println(sol.removeDuplicateLetters(test));
        }
    }
}
