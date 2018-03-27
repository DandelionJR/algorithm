package mySort;

import java.util.Arrays;

public class Selection {
    public static void SelectSort(int[] a){
        for (int i = 0; i < a.length; i++){
            for (int j = i; j < a.length; j++){
                if (a[j] < a[i]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args){
        int[] a = {5,8,4,6,1,9,7,2};
        SelectSort(a);
    }
}
