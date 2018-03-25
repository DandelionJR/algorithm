/**
 * @author lyj
 * 基于原地归并的自顶向下归并排序
 * 递归归并，分治思想
 * 对于长度为N的任意数组，自顶向下的归并排序需要1/2*N*lgN至NlgN次比较
 * 最多需要访问数组6*N*lgN
 */
public class Merge {
    private static Comparable[] aux; //归并所需的辅助数组
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length]; //一次性分配空间
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        //将数组a[lo..hi]排序
        if (hi <= lo){
            return;
        }
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid); //将左半边排序
        sort(a, mid + 1, hi); //将右半边排序
        merge(a, lo, mid, hi); //归并结果;
    }

    /**
     * 原地归并的抽象方法
     * @param a 需要排序的数组
     * @param lo 数组起始值
     * @param mid 数组中间值
     * @param hi 数组结束值
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        //将a[lo..mid]和a[mid+1..hi]归并
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++){
            //将a[lo..hi]复制到aux[lo,,hi]
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++){
            //归并回到a[lo..hi]
            if (i > mid){
                a[k] = aux[j++];
            } else if (j > hi){
                a[k] = aux[i++];
            } else if (Example.less(aux[j], aux[i])){
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        String[] a = {"2","5","1","12","6","8","7","11"};
        sort(a);
        Example.show(a);
    }
}
