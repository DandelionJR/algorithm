import java.util.Iterator;

/**
 * @author lyj
 * 用栈实现队列
 * @param <Item>
 */
public class StackAchieveQueue<Item> implements Iterable<Item> {

    Stack a,b;

    public void enqueue(Item item){
        a.push(item);
    }

    public Item dequeue(){
        if (!b.isEmpty()){
            return (Item) b.pop();
        }
        while (!a.isEmpty()){
            b.push(a.pop());
        }
        return (Item) b.pop();
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
