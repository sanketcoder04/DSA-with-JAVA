class Trie {
    private class Node {
        Node children[] = new Node[26];
        boolean endWord = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    private Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        for(int level=0;level<word.length();level++) {
            char ch = word.charAt(level);
            int index = ch - 'a'; 
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.endWord = true;
    }

    public boolean search(String target) {
        Node curr = root;
        for(int level=0;level<target.length();level++) {
            char ch = target.charAt(level);
            int index = ch - 'a';
            if(curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.endWord == true;
    }
}

public class TrieMain {
    public static void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any", "thee"};
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        System.out.println(trie.search("thee") + "  " + trie.search("thor"));

    }
}
