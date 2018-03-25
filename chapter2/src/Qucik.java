import javafx.beans.binding.When;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyj
 * 原地排序
 * 切分的位置取决于数组的内容
 * 递归调用发生在处理整个数组之后
 * 长度为N的无重复数组排序，快速排序平均需要2NlnN次比较，以及1/6的交换
 * 最多需要N*N/2次比较，但随机打乱数组能够预防这种情况
 */
public class Qucik {
    // 使用插入排序时的转换参数
    private static final int M = 5;

    public static void sort(Comparable[] a){
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
//        if (hi <= lo){
//            return;
//        }
        // 使用插入排序处理小数组
        if (hi <= lo + M){
            Insertion.sort(a, lo, hi);
            return;
        }
        int j = partition(a, lo, hi); //切分位置
        sort(a, lo, j-1); //将左半部分a[lo .. j-1]排序;
        sort(a, j+1, hi); //将右半部分a[j+1 .. hi]排序
    }

    /**
     * 快速排序的切分
     * @param a 切分的数组
     * @param lo 起始位置
     * @param hi 结束位置
     * @return 切分位置
     */
    private static int partition(Comparable[] a, int lo, int hi){
        //将数组切分为a[lo..i-1]，a[i]，a[i+1..hi]
        int i = lo;
        int j = hi + 1; //左右扫描指针
        Comparable v = a[lo]; //切分元素
        while (true) {
            //扫描左右，检查扫面是否结束并交换元素
            while (Example.less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (Example.less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            Example.exch(a, i, j);
        }
            Example.exch(a, lo, j); //将v = a[j]放入正确的位置
            return j; //a[lo .. j-1] <= a[j] <= a[j+1 .. hi]达成
    }

    public static void main(String[] args){
        String[] a = {"2","5","1","12","6","8","7","11"};
        sort(a);
        Example.show(a);
    }
}
