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
    public static void radixsort(int[] input) {

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
    public static void main(String[] args) {
        int[] arr = {23, 8, 19, 10, 1, 17};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {110, 104, 100, 109, 112, 117};
        countingSort(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {70, 45, 175, 930, 22, 2, 245, 66,23,11,3,121,64};
        radixsort(arr2);
        System.out.println(Arrays.toString(arr2));

    }


}
