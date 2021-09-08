package sorting;

import java.util.ArrayList;
import java.util.List;

public class SortService {
    public void selectionSort(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            replace(list, i, minIndex);
        }
    }

    public void bubbleSort(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    replace(list, j, j + 1);
                }
            }
        }
    }


    private void replace(List<Integer> list, int ind1, int ind2) {
        int tmp = list.get(ind1);
        list.set(ind1, list.get(ind2));
        list.set(ind2, tmp);
    }

    public List<Integer> generateListRandomValues(int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add((int) Math.round((Math.random() * 1000)));
        }
        return list;
    }
}
