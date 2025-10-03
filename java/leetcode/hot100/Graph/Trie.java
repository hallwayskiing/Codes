package hot100.Graph;

class Trie {
    Trie[]children;
    boolean isEnd;

    public Trie(){
        children=new Trie[26];
        isEnd=false;
    }

    public void insert(String word) {
        Trie node=this;
        for (char c:word.toCharArray()){
            int index=c-'a';
            if(node.children[index]==null) node.children[index]=new Trie();
            node=node.children[index];
        }
        node.isEnd=true;
    }

    public boolean search(String word) {
        Trie node=this;
        for (char c:word.toCharArray()){
            int index=c-'a';
            if(node.children[index]==null) return false;
            node=node.children[index];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node=this;
        for (char c:prefix.toCharArray()){
            int index=c-'a';
            if(node.children[index]==null) return false;
            node=node.children[index];
        }
        return true;
    }
}
