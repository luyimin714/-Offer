public class Question19 {
    /**************************************************************************
     *                              正则表达式匹配
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串
     * 的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
     * 但是与"aa.a"和"ab*a"均不匹配
     **************************************************************************/
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        return helper(str, 0, pattern, 0);
    }

    private boolean helper(char[] str, int sId, char[] pattern, int pId) {
        if (sId == str.length && pId == pattern.length)
            return true;
        if (sId != str.length && pId == pattern.length)
            return false;

        if (pId + 1 < pattern.length && pattern[pId + 1] == '*') {
            if ((sId != str.length && pattern[pId] == str[sId]) || (pattern[pId] == '.' && sId != str.length))
                return helper(str, sId + 1, pattern, pId + 2) ||
                       helper(str, sId + 1, pattern, pId) ||
                       helper(str, sId, pattern, pId + 2);
            else
                return helper(str, sId, pattern, pId + 2);
        }
        if ((sId != str.length && pattern[pId] == str[sId]) || (pattern[pId] == '.' && sId != str.length))
            return helper(str, sId + 1, pattern, pId + 1);
        return false;
    }
}
