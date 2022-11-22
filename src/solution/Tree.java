package solution;

/**
 * @author LZN
 * @Title Tree
 * @ProjectName 树和深林
 * @Description 树和深林
 * 树：是n（n>=0)个节点的有限集合,若n等于0，称为空树
 * <p>
 * 深林：是m（m>=0)互不相交的数据的集合。
 * @date 2022-10-01 20:23
 **/
public class Tree {
    static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        Node s = null;
        Node<String> objectNode = new Node<>(null,"df",null);
    }
}
