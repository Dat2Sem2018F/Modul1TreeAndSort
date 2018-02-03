/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem2bst;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void testEmptyArray() {
        Address[] arr = new Address[ 0 ];
        QuickSort qs = new QuickSort();
        qs.quickSort( arr );
        assertTrue( true ); // This just check to see we do not crash
    }

    @Test
    public void testSortedArray() {
        Address[] input = new Address[ 100 ];
        for ( int i = 0; i < 100; i++ ) {
            input[ i ] = new Address( "R " + i );
        }
        QuickSort qs = new QuickSort();
        qs.quickSort( input );
        boolean res = checkSorted( input );
        assertTrue( res );
    }
    
    @Test
    public void testReverseSortedArray() {
        Address[] input = new Address[ 100 ];
        for ( int i = 0; i < 100; i++ ) {
            input[ i ] = new Address( "R " + (100-i) );
        }
        QuickSort qs = new QuickSort();
        qs.quickSort( input );
        boolean res = checkSorted( input );
        assertTrue( res );
    }
    
    @Test
    public void testRandomArray() {
        Address[] input = new Address[ 100 ];
        Random rnd = new Random();
        for ( int i = 0; i < 100; i++ ) {
            input[ i ] = new Address( "R " + rnd.nextInt( 10000 ) );
        }
        QuickSort qs = new QuickSort();
        qs.quickSort( input );
        boolean res = checkSorted( input );
        assertTrue( res );
    }

    private boolean checkSorted( Address[] input ) {
        for ( int i = 1; i < input.length; i++ ) {
            if ( input[ i - 1 ].compareTo( input[ i ] ) > 0 ) {
                return false;
            }
        }
        return true;
    }

}
