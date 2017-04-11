package Sorting;

import java.util.Arrays;

/**
 * Created by annakertesz on 4/6/17.
 */
public class MergeSort {

    int[] list;

    public MergeSort() {
    }

    public MergeSort(int[] list) {
        this.list = list;
    }

    public int[] sort(){
        return partialSort(list);
    }

    private int[] partialSort(int[] list){
//        print("\nI sort the list ", list);
        if (list.length<=1) {
//            System.out.println("\nit has only one element");
            return list;
        }
        int[] aList = Arrays.copyOfRange(list, 0, list.length / 2);
        int[] bList = Arrays.copyOfRange(list, list.length / 2, list.length);
//        print("\nI splitted it to ", aList);
//        print("and", bList);
        aList = partialSort(aList);
        bList = partialSort(bList);
//        print("\n\nA-list", aList);
//        print("B-list", bList);
        return mergeLists(aList, bList);
    }


    private int[] mergeLists(int[] aList, int[] bList) {
        int[] mergedList = new int[aList.length + bList.length];
        int aIndex = 0;
        int bIndex = 0;
        int i = 0;
        while (aIndex<aList.length && bIndex<bList.length) {
//            System.out.println("\n\nI compare "+ aList[aIndex] + " and " + bList[bIndex]);
            if (aList[aIndex] > bList[bIndex]) {
                mergedList[i] = bList[bIndex];
                bIndex++;
            } else {
                mergedList[i] = aList[aIndex];
                aIndex++;
            }

            i++;
        }
        while (aIndex<aList.length) { // inkább for
            mergedList[i]=aList[aIndex];
            i++; aIndex++;
        }
        while (bIndex<bList.length) { // inkább for
            mergedList[i]=bList[bIndex];
            i++; bIndex++;
        }
//        print("merged list",mergedList);
        return mergedList;
    }

    private void print(String methodName, int[] list){
        System.out.println(methodName + ": ");
        for (int i : list) System.out.print(i+", ");
    }


}
