import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Homework2 {
    public static void main(String[] args) {
//------------------------------------------------ Задача 1 -----------------------------------------------------------
// Есть еще второй вариант, просто создать новый массив, добавить в него все элементы из двух исходных, а потом отсортировать.
// Оно бы и выглядело даже поокорче, наверно :) Но там из за сортрировки будет сложность O(n^2), а тут получается O(n).
// Хотя, сдается мне, можно как то и покрасивей это сделать :)
        int[] arr1 = {3, 6, 14, 19, 20, 25, 26, 30};
        int[] arr2 = {1, 10, 12, 16, 24};

        int[] arr3 = {30, 26, 25 , 20 , 19, 14, 6, 3};
        int[] arr4 = {24, 16, 12, 10, 1};

        int[] arr5 = {24, 16, 12, 10, 1};
        int[] arr6 = {3, 6, 14, 19, 20, 25, 26, 30};
        System.out.println(Arrays.toString(arraysMerge(arr5, arr6)));

//------------------------------------------------ Задача 2 -----------------------------------------------------------
// Не знаю на сколько легально было приделывать в своей реализации метод getSize() :)
        LinkList list = new LinkList();
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.print();
        System.out.println("------------------");
        rebuilt(list);
//------------------------------------------------ Задача 3 -----------------------------------------------------------
        int arr7[] = {1, 2, 3, 5, 1, 2, 3, 5, 12 , 132, 12};
        System.out.println(getLonely(arr7));

    }


    //------------------------------------------------------- Задача 1 -----------------------------------------------------
    public static int[] arraysMerge(int[] arr1, int[] arr2) {
        if (arr1[0] - arr1[arr1.length - 1] < 0 && arr2[0] - arr2[arr2.length - 1] < 0) { // если оба упорядочены по возрастанию
            return mergeAscendingOrdered(arr1, arr2);
        }
        if(arr1[0] - arr1[arr1.length - 1] > 0 && arr2[0] - arr2[arr2.length - 1] > 0){  // если оба упорядочены по убыванию (результирующий тоже сделал по убыванию)
            return mergeDescendingOrdered(arr1, arr2);
        }
        if(arr1[0] - arr1[arr1.length - 1] < 0 && arr2[0] - arr2[arr2.length - 1] > 0){ // если первый по возрастанию, а воторй по убыванию
            return mergeDescendingAscendingOrdered(arr1, arr2);
        }
        else {                                                                          // наоборот
            return mergeDescendingAscendingOrdered(arr2, arr1);
        }
    }

    private static int[] mergeAscendingOrdered(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int k = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
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

    private static int[] mergeDescendingOrdered(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];
        int i = arr1.length - 1;
        int k = arr1.length + arr2.length - 1;
        int j = arr2.length - 1;
        while (i >= 0  && j >= 0) {
            if (arr1[i] > arr2[j]) {
                result[k] = arr2[j];
                j--;
            } else if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i--;
            }
            k--;
        }
        while (i >= 0) {
            result[k] = arr1[i];
            i--;
            k--;
        }
        while (j >= 0) {
            result[k] = arr2[j];
            j--;
            k--;
        }
        return result;
    }

    private static int[] mergeDescendingAscendingOrdered(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int k = 0;
        int j = arr2.length - 1;
        while (i < arr1.length  && j >= 0) {
            if (arr1[i] > arr2[j]) {
                result[k] = arr2[j];
                j--;
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
        while (j >= 0) {
            result[k] = arr2[j];
            j--;
            k++;
        }
        return result;
    }

    //------------------------------------------------------- Задача 2 -----------------------------------------------------
    public static LinkList rebuilt(LinkList linkedList) {
        Node newTail = linkedList.get(linkedList.getSize() / 2 - 1); // Находим новый хвост
        linkedList.getTail().setNext(linkedList.getHead()); // Старую голову приделываем к старому хвосту
        linkedList.setHead(newTail.getNext()); // Новую голову ставим на место :)
        newTail.setNext(null); // Зануляем некст хвоста, иначе какой же он хвост
        linkedList.print();
        return linkedList;
    }

    //------------------------------------------------------- Задача 3 -----------------------------------------------------
    private static int getLonely(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        final int[] lonely = new int[1];
        for (int i = 0; i < arr.length; i++){
            if(set.contains(arr[i])){
                set.remove(arr[i]);
            } else {
                set.add(arr[i]);
            }
        }
        set.forEach(integer -> {
            lonely[0] = integer;
        });
        return lonely[0];
    }
}
