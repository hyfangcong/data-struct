package leetcode.leetcodedynamic;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/5/10
 */
public class 连接词 {
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        for(int i = 0 ; i < words.length ; i ++){
            dfs(words[i], words, 0, result);
        }
        return result;
    }

    /**
     * 超时
     */
    private static void dfs(String s, String[] words, int index, List<String> result){
        if(index == s.length())
            result.add(s);
        if(index < s.length()){
            for(String word : words){
                if(!word.equals(s) && s.startsWith(word, index)){
                    dfs(s, words, index + word.length(), result);
                }
            }
        }
    }

    public static void main(String[] args) {
       String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        连接词 tt = new 连接词();
        List<String> result = tt.findAllConcatenatedWordsInADict2(words);
        Iterator<String> iterator = result.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }


    /**
     * 使用字典树：这种处理字符串的问题，可以考虑使用字典树。
     *
     * 字典树的查询效率和单词的中数量没有关系，只与单词的长度有关。
     */

    class Trie{
        class Node{
            boolean isWord;
            Map<Character, Node> next; //使用map可以所处理的字符种类是动态变化的情况。

            public Node(){
                this(false);
            }

            public Node(boolean isWord){
                this.isWord = isWord;
                next = new TreeMap<>();
            }
        }

        private Node root;

        public Trie(){
            root = new Node();
        }

        public void add(String word){
            Node cur = root;
            for(int i = 0 ; i < word.length(); i ++){
                char c = word.charAt(i);
                if(cur.next.get(c) == null){
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }
            cur.isWord = true;
        }
    }

    public List<String> findAllConcatenatedWordsInADict2(String[] words) {
        Trie trie = new Trie();
        for(String word : words){
            trie.add(word);
        }
        List<String> result = new ArrayList<>();
        for(String word : words){
            if(isFind(trie.root, word, 0, 0))
                result.add(word);
        }
        return result;
    }

    private boolean isFind(Trie.Node root, String word, int index, int count){
        if(index == word.length())
            return count > 1;
        Trie.Node cur = root;
        for(int i = index ; i < word.length() ; i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                return false;

            if(cur.next.get(c).isWord && isFind(root, word, i + 1, count + 1))
                return true;
            cur = cur.next.get(c);
        }
        return false;
    }



}
