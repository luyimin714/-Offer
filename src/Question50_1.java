public class Question50_1 {
    /******************************************************************
     *              字符流中第一个不重复的字符
     *  请实现一个函数用来找出字符流中第一个只出现一次的字符。
     *  例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     *  当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     ******************************************************************/
    private int[] occurrence = new int[256];
    private int index;

    public Question50_1() {
        for (int i = 0; i < 256; i++) {
            occurrence[i] = -1;
        }
        index = 0;
    }
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (occurrence[ch] == -1)
            occurrence[ch] = index;
        else if (occurrence[ch] >= 0)
            occurrence[ch] = -2;

        index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char ch = '#';
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if (occurrence[i] >= 0 && occurrence[i] < minIndex) {
                ch = (char) i;
                minIndex = occurrence[i];
            }
        }

        return ch;
    }

    public static void main(String[] args) {
        Question50_1 test = new Question50_1();
        test.Insert('g');
        System.out.print(test.FirstAppearingOnce());
        test.Insert('o');
        System.out.print(test.FirstAppearingOnce());
        test.Insert('o');
        System.out.print(test.FirstAppearingOnce());
        test.Insert('g');
        System.out.print(test.FirstAppearingOnce());
        test.Insert('l');
        System.out.print(test.FirstAppearingOnce());
        test.Insert('e');
        System.out.print(test.FirstAppearingOnce());
    }
}
