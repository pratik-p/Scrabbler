import java.util.HashMap;

class TrieNode {
    final HashMap<Character, TrieNode> children = new HashMap<>();
    char c;
    TrieNode parent;
    boolean isLeaf;

    TrieNode() {
    }

    TrieNode(char c) {
        this.c = c;
    }
}
