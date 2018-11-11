public class Question50 {
    /*
     * 第一个只出现一次的字符
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
     * 中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return -1;

        int tableSize = 256;
        int[] hashTable = new int[tableSize];

        for (int i = 0; i < s.length(); i++) {
            hashTable[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (hashTable[s.charAt(i)] == 1)
                return i;
        }

        return -1;
    }

    public char firstRepeatingChar(String s) {
        if (s == null)
            return '\0';

        int tableSize = 256;
        int[] hashTable = new int[tableSize];

        for (int i = 0; i < s.length(); i++) {
            hashTable[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (hashTable[s.charAt(i)] == 1)
                return s.charAt(i);
        }

        return '\0';
    }

    public static void main(String[] args) {
        System.out.println('\0');
        Question50 test = new Question50();
        System.out.println(test.firstRepeatingChar("abaccdeff"));
    }
}
