import java.util.*;

class Trie {
    private final ArrayList<String> words;
    private final TrieNode root;
    private TrieNode prefixRoot;
    private String curPrefix;

    Trie() {
        root = new TrieNode();
        words = new ArrayList<>();
    }

    void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode crntparent;
        crntparent = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                t.parent = crntparent;
                children.put(c, t);
            }

            children = t.children;
            crntparent = t;

            //set leaf node
            if (i == word.length() - 1)
                t.isLeaf = true;
        }
    }

    public boolean search(String word) {
        TrieNode t = searchNode(word);
        return t != null && t.isLeaf;
    }

    boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }
        prefixRoot = t;
        curPrefix = str;
        words.clear();
        return t;
    }

    void wordsFinderTraversal(TrieNode node, int offset) {
        if (node.isLeaf) {
            TrieNode altair;
            altair = node;
            Stack<String> hstack = new Stack<>();
            while (altair != prefixRoot) {
                hstack.push(Character.toString(altair.c));
                altair = altair.parent;
            }
            StringBuilder wrd = new StringBuilder(curPrefix);
            while (!hstack.empty()) {
                wrd.append(hstack.pop());
            }
            words.add(wrd.toString());
        }
        Set<Character> kset = node.children.keySet();
        Iterator itr = kset.iterator();
        ArrayList<Character> aloc = new ArrayList<>();
        while (itr.hasNext()) {
            Character ch = (Character) itr.next();
            aloc.add(ch);
        }
        for (Character anAloc : aloc) {
            wordsFinderTraversal(node.children.get(anAloc), offset + 2);
        }
    }

    private List sortWordsSuffix() {
        List<String> orderList = new ArrayList<>();
        for (String word : words) {
            StringBuilder s = new StringBuilder(word);
            orderList.add(s.reverse().toString());
        }
        Collections.sort(orderList);
        return orderList;
    }

    private List sortWordsPrefix() {
        List<String> orderList = new ArrayList<>();
        orderList.addAll(words);
        Collections.sort(orderList);
        return orderList;
    }

    void displayFoundWordsPrefix() {
        List<String> alphaOrder = sortWordsPrefix();
        for (String anAlphaOrder : alphaOrder) {
            System.out.println(anAlphaOrder);
        }
    }

    void displayFoundWordsSuffix() {
        List<String> alphaOrder = sortWordsSuffix();
        for (String anAlphaOrder : alphaOrder) {
            System.out.println(anAlphaOrder);
        }
    }
}