/**
 *
 * Repräsentiert den Knoten eines binären Baumes
 *
 * @author Michael Schlittenbauer
 */

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    // Anfang Attribute
    private T value;
    private Node<T> left;
    private Node<T> right;
    // Ende Attribute

    /**
     * Konstruktor der Klasse Node
     *
     * @param value der Wert der in dem Knoten gespeichert werden soll
     */
    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {

        return value.toString();
    }

    // Anfang Methoden

    /**
     * Getter für den Wert des Knotens
     *
     * @return den Wert der im Knoten gespeichert ist
     */
    public T getValue() {
        return value;
    }

    /**
     * Getter für das linke Kind
     *
     * @return den linken Kindsknoten
     */
    public Node<T> getLeftChild() {
        return left;
    }

    /**
     * Getter für das rechte Kind
     *
     * @return den rechten Kindsknoten
     */
    public Node<T> getRightChild() {
        return right;
    }

    /**
     * Setter für das linke Kind
     *
     * @param leftNeu der neue Knoten, der als linkes Kind gesetzt werden soll
     */
    public void setLeftChild(Node<T> leftNeu) {
        left = leftNeu;
    }

    /**
     * Setter für das rechte Kind
     *
     * @param rightNeu der neue Knoten, der als rechtes Kind gesetzt werden soll
     */
    public void setRightChild(Node<T> rightNeu) {
        right = rightNeu;
    }

    /**
     * Setter für den Value des Knotens
     *
     * @param value der neue Value des Knotens
     */
    public void setValue(T value){
        this.value = value;
    }

    @Override
    public int compareTo(Node<T> o) {
        return getValue().compareTo(o.getValue());
    }
    // Ende Methoden
} // end of Node

