package Sorting;

/**
 * Created by annakertesz on 4/5/17.
 */
public class QuickSort {

    int[] list;

    public QuickSort(int[] list) {
        this.list = list;
    }

    public int[] sort(){
        partial(0, list.length-1);
        return list;
    }

    public void partial (int lowIndex, int highIndex){ // private
        if (highIndex<0||lowIndex>list.length-1) return;
//        System.out.println("");
//        System.out.println(lowIndex + " " + highIndex);
//        System.out.println("\n\nMy array is from "+ list[lowIndex] + " to " + list[highIndex]);

        if (lowIndex<highIndex) {
            int pivot = lowIndex + (highIndex - lowIndex) / 2;
//            System.out.println("\nI choose " + list[pivot] + " as pivot") ;
            int lower = lowIndex;
            int high = highIndex;
            while (lowIndex < highIndex) {
                while (list[lowIndex] < list[pivot]) lowIndex++;
//                System.out.println(list[lowIndex] + " is greater than pivot");
                while (list[highIndex] > list[pivot]) highIndex--;
//                System.out.println(list[highIndex] + " is smaller than pivot");
                if (list[highIndex] < list[lowIndex]) {
//                    System.out.println("I change " + list[lowIndex] + " to " + list[highIndex]);
                    if (lowIndex == pivot) pivot=highIndex;
                    else if (highIndex == pivot) pivot=lowIndex;
                    int tmp = list[lowIndex];
                    list[lowIndex] = list[highIndex];
                    list[highIndex] = tmp;
                }
//                System.out.println("the pivot now is "+ list[pivot]);
            }
//            System.out.print("now the list is ");
//            print(list);
            partial(lower, pivot-1);
            partial(pivot+1, high);
        }
    }

    private void print(int[] list) {
        System.out.println("");
        for (int i : list) System.out.print(i + ", ");
    }
}
