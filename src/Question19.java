public class Question19 {
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
