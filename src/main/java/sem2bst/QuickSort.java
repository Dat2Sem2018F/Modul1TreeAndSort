package sem2bst;

public class QuickSort {

    public void quickSort( Address arr[] ) {
        if ( arr.length <= 1 ) {
            return;
        }
        quickSort( arr, 0, arr.length - 1 );
    }

    private void quickSort( Address arr[], int left, int right ) {
        int index = partition( arr, left, right );
        if ( left < index - 1 ) {
            quickSort( arr, left, index - 1 );
        }
        if ( index < right ) {
            quickSort( arr, index, right );
        }
    }

    private int partition( Address arr[], int left, int right ) {
        int i = left, j = right;
        Address pivot = arr[ ( left + right ) / 2 ];

        while ( i <= j ) {
            while ( lessThan( arr[ i ], pivot ) ) {
                i++;
            }
            while ( lessThan( pivot, arr[ j ] ) ) {
                j--;
            }
            if ( i <= j ) {
                swap( arr, i, j );
                i++;
                j--;
            }
        };

        return i;
    }


    /* a1 og a2 forventes begge ikke at være null.
    returnerer sand hvis a1.street kommer før a2.street i lexiografisk ordning 
     */
    private boolean lessThan( Address a1, Address a2 ) {
        return a1.street.compareToIgnoreCase( a2.street ) < 0;
    }

    private void swap( Address[] arr, int i, int j ) {
        Address tmp = arr[ i ];
        arr[ i ] = arr[ j ];
        arr[ j ] = tmp;
    }
}
