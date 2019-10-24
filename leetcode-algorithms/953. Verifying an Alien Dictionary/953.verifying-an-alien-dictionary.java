/*
 * @lc app=leetcode id=953 lang=java
 *
 * [953] Verifying an Alien Dictionary
 *
 * https://leetcode.com/problems/verifying-an-alien-dictionary/description/
 *
 * algorithms
 * Easy (56.29%)
 * Likes:    170
 * Dislikes: 62
 * Total Accepted:    19.3K
 * Total Submissions: 34.8K
 * Testcase Example:  '["hello","leetcode"]\n"hlabcdefgijkmnopqrstuvwxyz"'
 *
 * In an alien language, surprisingly they also use english lowercase letters,
 * but possibly in a different order. The order of the alphabet is some
 * permutation of lowercase letters.
 * 
 * Given a sequence of words written in the alien language, and the order of
 * the alphabet, return true if and only if the given words are sorted
 * lexicographicaly in this alien language.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is
 * sorted.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] >
 * words[1], hence the sequence is unsorted.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string
 * is shorter (in size.) According to lexicographical rules "apple" > "app",
 * because 'l' > '∅', where '∅' is defined as the blank character which is less
 * than any other character (More info).
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are english lowercase letters.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> ordermap = new HashMap<>();
        int value = 1;
        for (int i = 0; i < order.length(); i++) {
            ordermap.put(order.charAt(i), value++);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(words[i], words[i + 1], ordermap)) {
                return false;
            }
        }
        return true;
    }

    public boolean compare(String a, String b, Map<Character, Integer> ordermap) {
        int i = 0;
        while (i < a.length() && i < b.length()) {
            if (ordermap.get(a.charAt(i)) < ordermap.get(b.charAt(i))) {
                return true;
            } else if (ordermap.get(a.charAt(i)) > ordermap.get(b.charAt(i))) {
                return false;
            } else {
                i++;
            }
        }
        return a.length() == b.length() || a.length() < b.length();
    }
}
