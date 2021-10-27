import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {

        // Задача 1. Для 3х чисел выбрал бы вариант getMedian1(), т.к О(n) а с закоченной сортировкой O(n^2)
        float[] arr1 = {1, 3, 2};
        float[] arr2 = {2, 7, 3};
        float[] arr3 = {3, 1.1f, 3};

        System.out.println(getMedian(arr1));
        System.out.println(getMedian(arr2));
        System.out.println(getMedian(arr3));
        //----------------------------------------------------------------------------------------------------

        //Задача 2. revert1() - запись короче :)
        int number = 1234;
        System.out.println("revert1(): " + revert1(number));
        System.out.println("revert(): " + revert(number));
        //----------------------------------------------------------------------------------------------------

        //Задача 3
        float[] arr4 = {100, 12, 1, -5, 26, -40, 72};
        System.out.println(getAvg(arr4));

        //Задача 4. Вариан с moveArr() лучше т.к O(n), а у moveArr1() O(n^2)
        int[] arr5 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(moveArr1(arr5, 1)));
        int[] arr6 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(moveArr(arr6, 1)));

        int[] arr7 = {1, 1, 1, 1, 0, 1, 1 };
        System.out.println("Best place: " + getBestPlace(arr7));
    }

    // ------------------------------------ Задача 1 -------------------------------------------------------------------
    public static float getMedian(float[] arr) {
        bubbleSort(arr);
        return arr[arr.length / 2];
    }

    private static float getMedian1(float[] arr) {
        float temp;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        return arr[0] > arr[1] ? arr[0] : arr[1];
    }

    private static void bubbleSort(float[] arr) {
        float temp;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    // ------------------------------------ Задача 2 -------------------------------------------------------------------

    private static int revert(int digit) {
        char[] digits = String.valueOf(digit).toCharArray();
        char temp;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < digits.length / 2; i++) {
            temp = digits[i];
            digits[i] = digits[digits.length - 1 - i];
            digits[digits.length - 1 - i] = temp;
        }
        for (char c : digits) {
            result.append(c);
        }
        return Integer.parseInt(result.toString());
    }

    private static int revert1(int digit) {
        char[] digits = String.valueOf(digit).toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            result.append(digits[i]);
        }
        return Integer.parseInt(result.toString());
    }

    // ------------------------------------ Задача 3 -------------------------------------------------------------------
    private static float getAvg(float[] arr) {
        float min, max;
        max = min = arr[0];
        // Нашли минимум и максимум
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        // Нашли среднее
        float avg = (max + min) / 2;
        // Нашли ближайшее к среднему
        float result = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(result - avg) > Math.abs(arr[i + 1] - avg)) {
                result = arr[i + 1];
            }
        }
        return result;
    }
    // ------------------------------------ Задача 4 -------------------------------------------------------------------

    private static int[] moveArr(int[] arr, int offset) {
        if (offset > arr.length) {
            offset %= arr.length;
        }
        int[] tmpArr = new int[arr.length];
        Arrays.fill(tmpArr, 0);

        for (int i = offset; i < arr.length; i++) {
            tmpArr[i - offset] = arr[i];
        }
        for (int i = 0; i < offset; i++) {
            tmpArr[tmpArr.length - offset + i] = arr[i];
        }
        return tmpArr;
    }

    private static int[] moveArr1(int[] arr, int offset) {
        checkOffset(offset, arr);
        int i = 0;
        while (offset != 0){
            int tmp = arr[i];
            for (int j = 0; j < arr.length; j++){
                if (j==arr.length-1){
                    arr[j] = tmp;
                    break;
                }
                arr[j] = arr[j+1];
            }
            offset--;
        }
        return arr;
    }

    private static int checkOffset(int offset, int[] arr){
        if (offset > arr.length) {
            offset %= arr.length;
        }
        return offset;
    }

}
