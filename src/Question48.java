import java.util.HashMap;

public class Question48 {
    /*
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int right = 0, left = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int curLength = 0;
        int maxLength = 0;

        int[] position = new int[26];
        for (int j = 0; j < 26; j++)
            position[j] = -1;

        for (int i = 0; i < s.length(); i++) {
            int prevIndex = position[s.charAt(i) - 'a'];
            if (prevIndex < 0 || i - prevIndex > curLength) //第i个字符没有出现过 || 第i个字符之前出现过第二种情形
                curLength++;
            else { //prevIndex > 0 && i - prevIndex <= curLength 第i个字符之前出现过第一种情形
                if (curLength > maxLength)
                    maxLength = curLength;

                curLength = i - prevIndex;
            }
            position[s.charAt(i) - 'a'] = i;
        }

        return curLength > maxLength ? curLength : maxLength;
    }

    public static void main(String[] args) {
        String s = "arabcacfr";
        Question48 test = new Question48();
        System.out.println(test.lengthOfLongestSubstring(s));
        System.out.println(test.lengthOfLongestSubstring2(s));
    }
}
