package sem2bst;

/**
 * The purpose of Node is to...
 * @author kasper
 */
public class Node {
    String key;
    Address value;
    Node left;
    Node right;

    Node( String key, Address value ) {
        this.key = key;
        this.value = value;
    }
}
