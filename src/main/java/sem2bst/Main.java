package sem2bst;

/**
 * The purpose of Main is to...
 * @author kasper
 */
public class Main {
    public static void main( String[] args ) {
        Sem2BST dict = new Sem2BST();
        dict.put("Hans", new Address("Pilealle 12"));
        dict.put("Asker", new Address("Lyngtoften 24"));
        dict.put("Johanne", new Address("Lars Bjørnsstræde 7a"));
        dict.put("Niels", new Address("Pilealle 12"));
    }
}
