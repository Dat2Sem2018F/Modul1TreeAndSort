package sem2bst;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class Sem2BSTTest {

    @Test
    public void testGetNull() {
        System.out.println( "testGetNull" );
        String key = "jjj";
        Sem2BST instance = new Sem2BST();
        Address expResult = null;
        Address result = instance.get( key );
        assertEquals( expResult, result );
    }

    @Test
    public void testGetActual() {
        System.out.println( "testGetActual" );
        String key = "jjj";
        Sem2BST instance = new Sem2BST();
        instance.put( key, new Address( "Overvandet 7a" ) );
        String expResult = "Overvandet 7a";
        Address result = instance.get( key );
        assertEquals( expResult, result.street );
    }

    @Test
    public void testPut() {
        System.out.println( "put" );
        String key = "Jens";
        Address value = new Address( "Ågade 9" );
        Sem2BST instance = new Sem2BST();
        instance.put( key, value );
        assertTrue( instance.containsKey( key ) );
    }

    @Test
    public void testContainsKey() {
        System.out.println( "containsKey" );
        String key = "Jensen";
        Sem2BST instance = new Sem2BST();
        boolean expResult = false;
        boolean result = instance.containsKey( key );
        assertEquals( expResult, result );
    }

    @Test
    public void testSize0() {
        System.out.println( "testSize0" );
        Sem2BST instance = new Sem2BST();
        int expResult = 0;
        int result = instance.size();
        assertEquals( expResult, result );
    }

    @Test
    public void testSize1() {
        System.out.println( "testSize1" );
        Sem2BST instance = new Sem2BST();
        instance.put( "Joe", new Address( "Nowhere 9" ) );
        int expResult = 1;
        int result = instance.size();
        assertEquals( expResult, result );
    }

    @Test
    public void testValuesEmpty() {
        System.out.println( "testValuesEmpty" );
        Sem2BST instance = new Sem2BST();
        List<Address> expResult = new ArrayList();
        List<Address> result = instance.values();
        assertEquals( expResult, result );
    }

    @Test
    public void testValuesTwoElements() {
        System.out.println( "testValuesTwoElements" );
        Sem2BST instance = new Sem2BST();
        int expResult = 2;
        instance.put( "Hans", new Address( "Øvej 4" ) );
        instance.put( "Iben", new Address( "Øvej 2" ) );
        List<Address> result = instance.values();
        assertEquals( expResult, result.size() );
    }

    @Test
    public void testExtending() {
        System.out.println( "extending" );
        Sem2BST instance = new Sem2BST();
        for ( int i = 0; i < 100; i++ ) {
            String key = "Key" + i;
            Address a = new Address( "Pilegade " + i );
            instance.put( key, a );
        }
        assertEquals( 100, instance.size() );
        assertEquals( "Pilegade 50", instance.get( "Key50" ).street );
    }

    @Test
    public void testRemoving() {
        System.out.println( "removing" );
        Sem2BST instance = new Sem2BST();
        for ( int i = 0; i < 100; i++ ) {
            String key = "Key" + i;
            Address a = new Address( "Pilegade " + i );
            instance.put( key, a );
        }
        instance.remove( "Key45" );
        assertEquals( 99, instance.size() );
        assertFalse( instance.containsKey( "Key45" ) );
    }

    @Test
    public void testReducing() {
        System.out.println( "testReducing" );
        Sem2BST instance = new Sem2BST();
        // add 100 key,value pairs
        for ( int i = 0; i < 100; i++ ) {
            String key = "Key" + i;
            Address a = new Address( "Pilegade " + i );
            instance.put( key, a );
        }
        // remove all but those divisible by 10 (0, 10, 20,...)
        for ( int i = 0; i < 100; i++ ) {
            if ( i % 10 != 0 ) {
                String key = "Key" + i;
                instance.remove( key );
            }
        }
        assertEquals( 10, instance.size() );
        assertTrue( instance.containsKey( "Key30" ) );
        assertFalse( instance.containsKey( "Key59" ) );
    }
}
