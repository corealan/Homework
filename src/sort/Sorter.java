package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorter {
    public static void quickSort(int[] arr, int left, int right) {
        if (arr.length == 0) {
            return;
        }
        if (left >= right) {
            return;
        }
        int supporting = arr[(left + right) / 2];
        int l = left;
        int r = right;

        while (l <= r) {
            while (arr[l] < supporting) {
                l++;
            }
            while (arr[r] > supporting) {
                r--;
            }
            if (l <= r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;

            }
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    public static void countingSort(int[] arr){
        int min = arr[0], max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max)
                max = arr[i];
            if(arr[i] < min)
                min = arr[i];
        }

        int[] countingArr = new int[max-min + 1];
        Arrays.fill(countingArr, 0);
        for(int i = 0; i < arr.length; i++){
            countingArr[arr[i]-min]++;
        }
        for(int i = 0, j = 0; i < countingArr.length; i++){
            while (countingArr[i] != 0){
                arr[j] = i+min;
                j++;
                countingArr[i]--;
            }
        }
    }
    public static void radixSort(int[] input) {

        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        boolean flag = false;
        int tmp, divisor = 1;
        while (!flag) {
            flag = true;
            for (Integer i : input) {
                tmp = i / divisor;
                buckets[tmp % 10].add(i);
                if (flag && tmp > 0) {
                    flag = false;
                }
            }
            int a = 0;
            for (int b = 0; b < 10; b++) {
                for (Integer i : buckets[b]) {
                    input[a++] = i;
                }
                buckets[b].clear();
            }
            divisor *= 10;
        }
    }
    public static void timSort(int[] arr) {
        if(arr.length < 10){
            insertionSort(arr);
            System.out.println(Arrays.toString(arr));
            return;
        }
        int[] subArr1 = new int[arr.length/2];
        int[] subArr2 = arr.length%2 != 0? new int[arr.length/2 + 1] : new int[arr.length/2];

        fillSubArrs(subArr1, subArr2, arr);
        timSort(subArr1);
        System.out.println("SubArr1: " + Arrays.toString(subArr1));
        timSort(subArr2);
        System.out.println("SubArr2: " + Arrays.toString(subArr2));
        int[] tmp = mergeAscendingOrdered(subArr1, subArr2);
        System.arraycopy(tmp, 0, arr, 0, tmp.length);
        System.out.println("MERGED: " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr){
        int j;
        for( int gap = arr.length / 2; gap > 0; gap /= 2 ) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void fillSubArrs(int[] subArr1, int[] subArr2, int[] arr){
        for(int i = 0, j = arr.length/2; i < subArr1.length; i++){
            subArr1[i] = arr[i];
            subArr2[i] = arr[j];
            j++;
        }
        if(arr.length%2 != 0){
            subArr2[subArr2.length-1] = arr[arr.length-1];
        }
    }

    public static int[] mergeAscendingOrdered(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int k = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] >= arr2[j]) {
                result[k] = arr2[j];
                j++;
            } else if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
            }
            k++;
        }
        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {23, 8, 19, 10, 1, 17};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {110, 104, 100, 109, 112, 117};
        countingSort(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {70, 45, 175, 930, 22, 2, 245, 66,23,11,3,121,64};
        radixSort(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println("-----------------------------------------------------------------------");
        int[] arr3 = {70, 45, 175, 930, 22, 2, 245, 66,23,11,3,121,64,432, 5, 11,32,543, 57, 0, 221, 2,54};
        timSort(arr3);
    }

//    public static void timSort(int[] arr) {
//        if(arr.length < 6){
//            insertionSort(arr);
//            System.out.println(Arrays.toString(arr));
//            return;
//        }
//        int subArr1[] = new int[arr.length/2];
//        int subArr2[];
//        if(arr.length %2 != 0){
//            subArr2 = new int[arr.length/2 + 1];
//        } else subArr2 = new int[arr.length/2];
//        fillSubArrs(subArr1, subArr2, arr);
//        timSort(subArr1);
//        timSort(subArr2);
//        arr = mergeAscendingOrdered(subArr1, subArr2);
//        System.out.println(Arrays.toString(arr));
//    }

}
