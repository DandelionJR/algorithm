import java.util.Iterator;

/**
 * @author lyj
 * 队列的链表实现，先进先出
 * @param <Item>
 */
public class Queue<Item> implements Iterable<Item> {

    private Node first; //指向最早添加的结点的链接
    private Node last; //指向最近添加的结点的链接
    private int N; //队列中的元素数量

    public Queue(Queue q){
        //复制队列
        for (Object item : q){
            this.enqueue((Item) item);
            q.dequeue();
        }
    }

    public Queue(){}

    public class  Node{
        //定义了结点的嵌套类
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null; //或 N == 0
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        //向表尾添加元素
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()){
            first = last;
        } else{
            oldlast.next = last;
        }
        N++;
    }

    public Item dequeue(){
        //从表头删除元素
        Item item = first.item;
        first = first.next;
        if (isEmpty()){
            last = null;
        }
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

    public static void main(String[] args){
        Queue<String> q = new Queue<String>();
        q.enqueue("haha");
        q.enqueue("xixi");
        System.out.println(q.size());
        q.dequeue();
        for (Iterator<String> it = q.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
        for (String item : q) {
            System.out.println(item);
        }
        System.out.println(q.size());
        Queue<String> r = new Queue<String>(q);
        r.enqueue("hehe");
        for (String item : r) {
            System.out.println(item);
        }
    }
}
