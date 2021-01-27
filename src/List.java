public class List<E> {

    private Element<E> firstElement;

    public void add(E element) {

        Element<E> listElement = new Element<E>(element);

        if (firstElement == null) {

            firstElement = listElement;
        }
        else {

            Element<E> lastElement = getLastElement(firstElement);
            lastElement.nextElement = listElement;
        }
    }

    public E get(int index) {

        Element<E> element = firstElement;

        for (int i = 0; i < index; i++) {

            element = element.nextElement;
        }

        return element.value;
    }

    public boolean remove(E element) {

        Element<E> previousElement = searchPreviousElementOf(element, firstElement);

        if (previousElement == null) {

            return false;
        }

        try {

            Element<E> nextElement = previousElement.nextElement.nextElement;
            previousElement.nextElement = nextElement;
        }
        catch (NullPointerException e) {

            previousElement.nextElement = null;
        }

        return true;
    }

    private Element<E> searchPreviousElementOf(E value, Element<E> start) {

        if (start.nextElement == null) {

            return null;
        }
        else if (start.nextElement.value.equals(value)) {

            return start;
        }
        else {

            return searchPreviousElementOf(value, start.nextElement);
        }
    }

    private Element<E> getLastElement(Element<E> start) {

        if (start.nextElement == null) {

            return start;
        }
        else {

            return getLastElement(start.nextElement);
        }
    }
}
