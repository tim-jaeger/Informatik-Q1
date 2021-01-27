public class Element<E> {

    public E value;
    public Element<E> nextElement;

    public Element(E value) {

        this.value = value;
    }
}
