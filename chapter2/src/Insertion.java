/**
 * @author lyj
 * 插入排序
 * 插入排序所需的时间取决于输入中元素的初始顺序
 * 主键不重复的条件下
 * 最坏情况 N*N/2次比较和N*N/2次交换
 * 平均情况 N*N/4次比较和N*N/4次交换
 * 最好情况 N-1次比较和0次交换
 */
public class Insertion {
    public static void sort(Comparable[] a){
        //将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++){
            //将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
            for (int j = i; j > 0 && Example.less(a[j], a[j-1]); j--){
                Example.exch(a, j, j-1);
            }
        }
    }

    public static void sort(Comparable[] a, int lo, int hi){
        int N = hi - lo + 1;
        for (int i = lo; i < N; i++){
            //将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
            for (int j = i; j > 0 && Example.less(a[j], a[j-1]); j--){
                Example.exch(a, j, j-1);
            }
        }
    }

    public static void main(String[] args){
        String[] a = {"2","5","1","12","6","8","7","11"};
        sort(a);
        Example.show(a);
    }
}
