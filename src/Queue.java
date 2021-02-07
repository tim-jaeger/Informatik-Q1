public class Queue<E> {

    private Element<E> firstElement;

    public void enqueue(E element) {

        Element<E> e = new Element<E>(element);

        if (firstElement == null) {

            firstElement = e;
            return;
        }

        getLastElement(firstElement).nextElement = e;
    }

    public E dequeue() {

        if (firstElement == null) {

            throw new IllegalArgumentException("Die Queue ist leer!");
        }
        if (firstElement.nextElement == null) {

            Element<E> e = firstElement;
            firstElement = null;
            return e.value;
        }

        Element<E> element = firstElement;
        firstElement = element.nextElement;

        return  element.value;
    }

    private Element<E> getLastElement(Element<E> start) {

        if (start.nextElement == null) {

            return start;
        } else {

            return getLastElement(start.nextElement);
        }
    }
}
