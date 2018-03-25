/**
 * @author lyj
 * 选择排序
 * 对于长度为N的数组，选择排序需要大约N*N/2次比较和N次交换
 * 运行时间和输入无关，有序的数组和无序的数组的运行时间相同
 * 数据移动是最少的
 */
public class Selection {
    public static void sort(Comparable[] a){
        //将a[]按升序排列
        int N = a.length; //数组长度
        for (int i = 0; i < N; i++){
            //将a[i]和a[i+1..N]中最小的元素交换
            int min = i; //最小元素的索引
            for (int j = i + 1; j < N; j++){
                if (Example.less(a[j], a[min])){
                    min = j;
                }
            }
            Example.exch(a, i, min);
        }
    }
    public static void main(String[] args){
        String[] a = {"2","5","1","12","6","8","7","11"};
        sort(a);
        Example.show(a);
    }
}
