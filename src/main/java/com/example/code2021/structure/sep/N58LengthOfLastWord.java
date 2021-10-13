package com.example.code2021.structure.sep;

class N58LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(new N58LengthOfLastWord().lengthOfLastWord("Hello World"));

    }

    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/length-of-last-word/solution/zui-hou-yi-ge-dan-ci-de-chang-du-by-leet-51ih/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。