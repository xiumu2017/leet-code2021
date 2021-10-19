package com.example.code2021.structure.oct;

/**
 * N211DesignAddSearchWordsDataStructure
 *
 * @author Paradise
 * @date 2021/10/19 10:43
 **/
public class N211DesignAddSearchWordsDataStructure {
    public static void main(String[] args) {

        WordDictionary wd = new WordDictionary();
        wd.addWord("hello");
        wd.addWord("world");
        wd.addWord("welcome");

        System.out.println(wd.search("..ll."));
        System.out.println(wd.search("world"));

    }


}

class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Trie node) {
        if (index == word.length()) {
            return node.isEnd();
        }
        final char c = word.charAt(index);
        if (Character.isLetter(c)) {
            int i = c - 'a';
            Trie child = node.getChildren()[i];
            return child != null && dfs(word, index + 1, child);
        } else {
            for (int i = 0; i < 26; i++) {
                Trie child = node.getChildren()[i];
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Trie {
    private final Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public Trie[] getChildren() {
        return children;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public Trie insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
        return node;
    }
}
