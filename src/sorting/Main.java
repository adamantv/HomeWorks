package sorting;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SortService sortService = new SortService();
//        List<Integer> listForStandartSort = sortService.generateListRandomValues(10000);
//        System.out.println("Исходный массив");
//        System.out.println(listForStandartSort);
//        System.out.println("Сортировка средствами Collections");
//        long s1 = System.currentTimeMillis();
//        Collections.sort(listForStandartSort);
//        System.out.println("Время на cортировкy средствами Collections " + (System.currentTimeMillis() - s1));
//        System.out.println(listForStandartSort);

        List<Integer> listForBubbleSort = sortService.generateListRandomValues(10000);
        System.out.println("Исходный массив");
        System.out.println(listForBubbleSort);
        System.out.println("Сортировка пузырьком");
        long s2 = System.currentTimeMillis();
        sortService.bubbleSort(listForBubbleSort);
        System.out.println("Время на cортировкy пузырьком " + (System.currentTimeMillis() - s2));
        System.out.println(listForBubbleSort);

//        List<Integer> listForSelectionSort = sortService.generateListRandomValues(10000);
//        System.out.println("Исходный массив");
//        System.out.println(listForSelectionSort);
//        System.out.println("Сортировка выбором");
//        long s3 = System.currentTimeMillis();
//        sortService.selectionSort(listForSelectionSort);
//        System.out.println("Время на cортировкy выбором " + (System.currentTimeMillis() - s3));
//        System.out.println(listForSelectionSort);

    }

}
