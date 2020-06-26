package 链表;

public class ListNode<E> {
    private E value;
    private ListNode<E> next;

    public ListNode(E value) {
        this.value = value;
    }

    /**
     * @param value
     * @param next
     */
    public ListNode(E value, ListNode<E> next) {
        this.value = value;
        this.next = next;
    }

    /**
     * @return the value
     */
    public E getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(E value) {
        this.value = value;
    }

    /**
     * @return the next
     */
    public ListNode<E> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(ListNode<E> next) {
        this.next = next;
    }
}