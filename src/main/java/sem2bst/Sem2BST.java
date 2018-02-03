package sem2bst;

import java.util.ArrayList;
import java.util.List;

/**
 The purpose of Sem2BST is to...

 @author kasper
 */
public class Sem2BST {

    Node root;

    public boolean containsKey( String key ) {
        return get( key ) != null;
    }

    public Address get( String key ) {
        return get( key, root );
    }

    public void put( String key, Address value ) {
        if ( root == null ) {
            root = new Node( key, value );
        } else {
            insert( key, value, root );
        }
    }

    public int size() {
        return size( root );
    }

    public List<Address> keys() {
        return keys(root);
    }

    private void insert( String key, Address value, Node node ) {
        switch ( Integer.signum( key.compareToIgnoreCase( node.key ) ) ) {
            case -1:
                if ( node.left == null ) {
                    node.left = new Node( key, value );
                } else {
                    insert( key, value, node.left );
                }
                break;
            case 0:
                node.value = value;
                break;
            case 1:
                if ( node.right == null ) {
                    node.right = new Node( key, value );
                } else {
                    insert( key, value, node.right );
                }
                break;
        }
    }

    private int size( Node node ) {
        if ( node == null ) {
            return 0;
        }
        return size( node.left ) + 1 + size( node.right );
    }

    private Address get( String key, Node node ) {
        if ( node == null ) {
            return null;
        }
        int compare = key.compareTo( node.key );
        if ( compare < 0 ) {
            return get( key, node.left );
        } else if ( compare > 0 ) {
            return get( key, node.right );
        } else {
            return node.value;
        }
    }

    List<Address> values() {
        return values( root );
    }

    private List<Address> values( Node node ) {
        List<Address> l = new ArrayList<>();
        if ( node == null ) {
            return l;
        }
        l.addAll( values( node.left ) );
        l.add( node.value );
        l.addAll( values( node.right ) );
        return l;
    }

    void remove( String key ) {
        remove( key, root );
    }

    // return the root of the tree where key has been removed
    // (same as node unless key is in node)
    private Node remove( String key, Node node ) {
        if ( node == null ) { // the key is not there
            return null;
        }
        int compare = key.compareTo( node.key );
        if ( compare < 0 ) {
            node.left = remove( key, node.left );
        } else if ( compare > 0 ) {
            node.right = remove( key, node.right );
        } else { // they are equal
            if ( node.left == null && node.right == null ) {
                return null;
            } else if ( node.left != null && node.right == null ) {
                return node.left;
            } else if ( node.left == null && node.right != null ) {
                return node.right;
            } else { // left and right not null
                Node maxLeft = max( node.left );
                node.key = maxLeft.key;
                node.value = maxLeft.value;
                node.left = remove( maxLeft.key, node.left );
            }
        }
        return node;
    }

    private Node max( Node node ) {
        if ( node.right == null ) {
            return node;
        }
        return max( node.right );
    }

    private List<Address> keys( Node node ) {
        if (node == null) return new ArrayList();
        ArrayList l = new ArrayList();
        l.addAll( keys(node.left));
        l.add( node);
        l.addAll( keys(node.right));
        return l;
    }
}
