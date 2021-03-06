/**
 * @author lyj
 * 排序算法类模板
 */
public class Example {
    public static boolean less(Comparable v, Comparable w){
        //判断v是否比w小
        return v.compareTo(w) < 0;
    }
    public static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void show(Comparable[] a){
        //在单行中打印数组
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        //测试数组元素是否有序
        for (int i = 1; i <a.length; i++){
            if (less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }
}
