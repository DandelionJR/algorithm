/**
 * @author lyj
 * 希尔排序
 * 基于插入排序的快速排序算法
 */
public class Shell {
    public static void sort(Comparable[] a){
        //将a[]按升序排列
        int N = a.length;
        int h = 1;
        while (h < N/3){
            h = 3 * h + 1; //1, 4, 13, 40, 121, 364, 1093, ...
        }
        while (h >= 1){
            //将数组变为h有序
            for (int i = 1; i < N; i++){
                //将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
                for (int j = i; j >= h && Example.less(a[j], a[j-h]); j -= h){
                    Example.exch(a, j, j-1);
                }
            }
            h = h/3;
        }

    }

    public static void main(String[] args){
        String[] a = {"2","5","1","12","6","8","7","11"};
        sort(a);
        Example.show(a);
    }
}
