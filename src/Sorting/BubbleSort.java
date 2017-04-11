package Sorting;

/**
 * Created by annakertesz on 4/6/17.
 */
public class BubbleSort {

    int[] list;

    public BubbleSort(int[] list) {
        this.list = list;
    }

    public int[] sort(){
        int i = 0;
        while (i<list.length-1) {
            int a = 0;
            while (a<list.length-i-1) {
                compare(a);
                a++;
            }
            i++;
        }
        return list;
    }

    private void compare(int a){
        if (list[a]>list[a+1]) {
            int tmp = list[a];
            list[a] = list[a+1];
            list[a+1] = tmp;
        }
    }

}
