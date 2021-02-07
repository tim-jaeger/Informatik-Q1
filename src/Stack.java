public class Stack<E> {

    private Element<E> firstElement;

    public E pop() {

        if (firstElement == null) {

            throw new IllegalArgumentException("Der Stack ist leer!");
        }
        else if (firstElement.nextElement == null) {

            Element<E> e = firstElement;
            firstElement = null;
            return e.value;
        }

        Element<E> penultimateElement = getPenultimateElement(firstElement);
        Element<E> e = penultimateElement.nextElement;
        penultimateElement.nextElement = null;

        return e.value;
    }

    public void push(E element) {

        Element<E> e = new Element<E>(element);

        if (firstElement == null) {

            firstElement = e;
            return;
        }

        getLastElement(firstElement).nextElement = e;
    }

    private Element<E> getPenultimateElement(Element<E> start) {

        if (start.nextElement.nextElement == null) {

            return start;
        }
        return getPenultimateElement(start.nextElement);
    }

    private Element<E> getLastElement(Element<E> start) {

        if (start.nextElement == null) {

            return start;
        } else {

            return getLastElement(start.nextElement);
        }
    }
}
