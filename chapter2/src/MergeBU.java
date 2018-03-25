import sun.plugin.com.event.COMEventHandler;

/**
 * 自顶向上的归并排序
 * 对于长度为N的任意数组，自底向上的归并排序需要1/2NloN至NlgN次比较，最多访问数组6NlgN次
 * 比较适合用链表组织的数据
 * 分治算法
 */
public class MergeBU {
    private static Comparable[] aux; //归并所需的辅助数组

    public static void sort(Comparable[] a){
        //进行lgN次两两归并
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz*2){ //sz子数组大小
            for (int lo = 0; lo < N - sz; lo += sz*2){ //lo:子数组索引
                merge(a, lo, lo + sz - 1, Math.min(lo+sz+sz-1, N - 1));
            }
        }
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

    public static void main(String[] args){
        String[] a = {"2","5","1","12","6","8","7","11"};
        sort(a);
        Example.show(a);
    }

}

