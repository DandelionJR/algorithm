import java.util.Iterator;

/**
 * @author lyj
 * 下压堆栈的链表实现，先进后出
 * @param <Item>
 */
public class Stack<Item> implements Iterable<Item> {

    private Node first; //栈顶，最近添加的元素
    private int N; //元素数量
    private class Node{
        //定义了结点的嵌套类
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null; //或N == 0
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        //向栈顶添加元素
        Node oldforst = first;
        first = new Node();
        first.item = item;
        first.next = oldforst;
        N++;
    }

    public Item pop(){
        //从栈顶删除元素
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
