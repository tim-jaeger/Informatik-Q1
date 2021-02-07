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

        if (index < 0) {

            throw new IndexOutOfBoundsException();
        }

        Element<E> element = firstElement;

        try {

            for (int i = 0; i < index; i++) {

                element = element.nextElement;
            }

            return element.value;
        }
        catch (NullPointerException e) {

            throw new IndexOutOfBoundsException();
        }
    }

    public boolean remove(E element) {

        Element<E> previousElement = searchPreviousElementOf(element, firstElement);

        if (previousElement == null) {

            return false;
        }

        Element<E> nextElement = previousElement.nextElement.nextElement;
        previousElement.nextElement = nextElement;

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
        } else {

            return getLastElement(start.nextElement);
        }
    }

    public static void main(String[] args) {

        List<Integer> list = new List<Integer>();

        for(int i = 0; i < 10; i++) {

            list.add(i);
        }

        for(int i = 0; i < 10; i++) {

            System.out.println(list.get(i));
        }

        System.out.println(list.remove(7));
        System.out.println(list.remove(100));

        for(int i = 0; i < 10; i++) {

            System.out.println(list.get(i)); //Soll bewusst den IndexOutOfBoundsException auslösen.
        }
    }
}
