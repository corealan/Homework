import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cinema {

    public static int calcBestDistance(int[] arr) {
        int firstOneInd = 0;
        while (arr[firstOneInd] != 1){
            firstOneInd++;
        }
        int lastOneInd =  arr.length - 1;
        while (arr[lastOneInd] != 1){
            lastOneInd--;
        }
        int dist = Math.max(arr.length - 1 - lastOneInd, firstOneInd);
        for(int k = firstOneInd  + 1; k <= lastOneInd; k++){
            if(arr[k] == 1){
                dist = Math.max((k - firstOneInd) / 2, dist);
                firstOneInd = k;
            }
        }
        return dist;
    }

    @Test
    public void testCalculations() {
        int[] a = {1, 0};
        assertEquals(1, calcBestDistance(a));

        a = new int[]{1, 0, 1};
        assertEquals(1, calcBestDistance(a));

        // в конце 0
        a = new int[]{1, 0, 1, 0, 0};
        assertEquals(2, calcBestDistance(a));

        // в начале 0
        a = new int[]{0, 0, 1, 0, 1};
        assertEquals(2, calcBestDistance(a));

        // в середине, нечетное
        a = new int[]{1, 0, 1, 0, 0, 0, 1};
        assertEquals(2, calcBestDistance(a));

        // в середине, четное
        a = new int[]{1, 0, 1, 0, 0, 0, 0, 1};
        assertEquals(2, calcBestDistance(a));

//         если внутри
        a = new int[]{1, 0, 0, 0, 0, 0, 1};
        assertEquals(3, calcBestDistance(a));

        // если с 0
        a = new int[]{0, 0, 0, 0, 1};
        assertEquals(4, calcBestDistance(a));

        // если с 1
        a = new int[]{1, 0, 0, 0, 0};
        assertEquals(4, calcBestDistance(a));

        // равнозначные варианты
        a = new int[]{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        assertEquals(5, calcBestDistance(a));
    }
}