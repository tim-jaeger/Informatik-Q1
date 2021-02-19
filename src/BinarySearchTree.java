/**
 *
 * Hält die Wurzel eines binären Baumes und liefert Methoden zum hinzufügen, löschen und traversieren des Baumes
 *
 * @author Michael Schlittenbauer
 */

public class BinarySearchTree<T extends Comparable<T>> {

    // Anfang Attribute
    private Node<T> root;
    private int size;
    // Ende Attribute

    /**
     * Konstruktor der Klasse. Setzt die Wurzel auf null und die Größe auf 0
     */
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    // Anfang Methoden

    /**
     * Getter für die Wurzel
     *
     * @return null wenn noch keine Wurzel gesetzt wurde. Ansonsten den Knoten der die aktuelle Wurzel ist
     */
    public Node<T> getRoot() {
        return root;
    }

    /**
     * Gibt die Größe des Baumes zurück
     *
     * @return die Anzahl der Knoten im Baum
     */
    public int getSize() {
        return size;
    }

    /**
     * Fügt ein neues item rekursiv in den Baum ein. Dabei wird auf die Ordnung des binären Suchbaumes geachtet.
     * Alle Werte rechts eines Knotens sind kleiner als der Wert im Knoten. Alle Werte links vom Knoten sind größer.
     *
     * @param item das Item das neu in den Baum eingefügt werden soll
     */
    private void insert(T item) {
        Node<T> n = new Node<>(item);
        size++;

        if(root == null){
            root = n;
        }else{
            insert(n, root);
        }
    }

    /**
     * Hilfsmethode zum rekursiven einfügen.
     *
     * @param newNode der neu einzufügende Knoten
     * @param n der aktuell betrachtete Knoten
     */
    private void insert(Node<T> newNode, Node<T> n){
        //Es wird überprüft, ob der einzufügene Node kleiner ist, als der aktuelle Knoten.
        if(newNode.compareTo(n) < 0) {
            //Prüft, ob der linke Kind-Knoten bereits besetzt wurde.
            if(n.getLeftChild() == null) {
                n.setLeftChild(newNode);
                //Fügt den Node ggf. ein (Rekursionsanker). Wenn der Kind-Knoten besetzt ist, wird die gesamte Methode rekursiv für den Kind-Knoten erneut aufgerufen (Rekursionsschritt).
            }else{
                insert(newNode, n.getLeftChild());
            }
            //Prüft, ob der einzufügende Node größer ist, als der aktuelle Knoten.
        }else if(newNode.compareTo(n) > 0){
            //Prüft, ob der rechte Kind-Knoten bereits besetzt wurde.
            if(n.getRightChild() == null){
                n.setRightChild(newNode);
                //Fügt den Node ggf. ein (Rekursionsanker). Wenn der Kind-Knoten besetzt ist, wird die gesamte Methode rekursiv für den Kind-Knoten erneut aufgerufen (Rekursionsschritt).
            }else{
                insert(newNode, n.getRightChild());
            }
        }
    }

    /**
     * Hilfsmethode zum rekursiven entfernen eines Wertes aus dem Baum
     * @param value
     */
    public void delete(T value){
        root = delete(value, root);
    }

    /**
     * Entfernt einen Wert aus dem Baum.
     *
     * @param value der Wert, der aus dem Baum entfernt werden soll
     * @param node der Knoten, ab dem der Wert aus dem Baum entfernt werden soll
     *
     * @return den aktuellen, veränderten Knoten
     */
    private Node<T> delete(T value, Node<T> node) {
        //Was sollte hier hin?
        if(node == null) {
            return node;
            //Rekursionsanker: Wenn das zu löschende Element nicht im Baum vorhanden ist, wird null zurückgegeben. -> Es ändert sich nichts am Baum.
        }else if(value.compareTo(node.getValue()) < 0){
            node.setLeftChild(delete(value, node.getLeftChild()));
            //Rekursionsschritt: Wenn der zu löschende Wert kleiner als der Ausgangsknoten ist, wird das Element ab den linken Kindknoten gesucht und gelöscht.
        }else if(value.compareTo(node.getValue()) > 0){
            node.setRightChild(delete(value, node.getRightChild()));
            //Rekursionsschritt: Wenn der zu löschende Wert größer als der Ausgangsknoten ist, wird das Element ab den rechten Kindknoten gesucht und gelöscht.
        }else{
            //Wenn der zu löschende Wert der Ausgangsknoten ist...
            if(node.getLeftChild() == null){
                return node.getRightChild();
                //Rekursionsanker: Wenn es keinen linken Kindknoten gibt, ersetzt der rechte Kindknoten den Ausgangsknoten.
            }else if(node.getRightChild() == null){
                return node.getLeftChild();
            }else{
                //Wenn es zwei Kindknoten gibt, wird der aktuelle Knoten durch das kleinste Element des linken Kindknotens ersetzt.
                //Rekursionsschritt: Damit es nicht zweimal vorkommt, wird das kleinste Element gelöscht.
                node.setValue(smallest(node.getLeftChild()));
                node.setLeftChild(delete(node.getValue(), node.getLeftChild()));
            }
        }

        return node;
    }

    /**
     * Traversiert den Baum preorder
     *
     * @return die Aneinanderkettung aller Werte im Baum
     */
    public String preorder() {
        return preorder(root);
    }

    /**
     * Hilfsmethode zur Traversierung des Baumes
     *
     * @param node der aktuell betrachtete Knoten im Baum
     *
     * @return der aktuell zusammengesetzte Wertestring
     */
    private String preorder(Node<T> node) {

        String s = node.toString() + "; ";

        if (node.getLeftChild() != null) {

            s += preorder(node.getLeftChild());
        }
        if (node.getRightChild() != null) {

            s += preorder(node.getRightChild());
        }

        return s;
    }

    /**
     * Traversiert den Baum inorder
     *
     * @return die Aneinanderkettung aller Werte im Baum
     */
    public String inorder() {
        return inorder(root);
    }

    /**
     * Hilfsmethode zur Traversierung des Baumes
     *
     * @param node der aktuell betrachtete Knoten im Baum
     *
     * @return der aktuell zusammengesetzte Wertestring
     */
    private String inorder(Node<T> node) {

        String s = "";

        if (node.getLeftChild() != null) {

            s += inorder(node.getLeftChild());
        }

        s += node.toString() + "; ";

        if (node.getRightChild() != null) {

            s += inorder(node.getRightChild());
        }
        return s;
    }

    /**
     * Traversiert den Baum postorder
     *
     * @return die Aneinanderkettung aller Werte im Baum
     */
    public String postorder() {
        return postorder(root);
    }

    /**
     * Hilfsmethode zur Traversierung des Baumes
     *
     * @param node der aktuell betrachtete Knoten im Baum
     *
     * @return der aktuell zusammengesetzte Wertestring
     */
    private String postorder(Node<T> node) {

        String s = "";

        if (node.getLeftChild() != null) {

            s += postorder(node.getLeftChild());
        }
        if (node.getRightChild() != null) {

            s += postorder(node.getRightChild());
        }

        s += node.toString() + "; ";

        return s;
    }

    /**
     * Berechnet die Anzahl der Knoten im Baum ab einer übergebenen Stelle
     *
     * @param node der aktuelle betrachtete Knoten. Für die Gesamtgröße die Wurzel des Baumes.
     *
     * @return die Anzahl der Knoten im Baum
     */
    private int size(Node<T> node){

        if (node.getLeftChild() != null && node.getRightChild() != null) {

            return size(node.getLeftChild()) + size(node.getRightChild()) + 1;
        }
        else if (node.getLeftChild() != null) {

            return size(node.getLeftChild()) + 1;
        }
        else if (node.getRightChild() != null) {

            return size(node.getRightChild()) + 1;
        }
        else {

            return 1;
        }
    }

    /**
     * Liefert das größte Element ab dem übergebenen Knoten
     *
     * @param node Knoten aber der der größte Wert im Baum gesucht werden soll
     *
     * @return den größten Wert im Baum ab dem übergebenen Knoten
     */
    private T biggest(Node<T> node){

        if (node == null) {

            return null;
        }

        while(node.getRightChild() != null) {

            node = node.getRightChild();
        }

        return node.getValue();
    }

    /**
     * Liefert das kleinste Element ab dem übergebenen Knoten
     *
     * @param node Knoten aber der der kleinste Wert im Baum gesucht werden soll
     *
     * @return den kleinsten Wert im Baum ab dem übergebenen Knoten
     */
    private T smallest(Node<T> node){

        if (node == null) {

            return null;
        }

        while(node.getLeftChild() != null) {

            node = node.getLeftChild();
        }

        return node.getValue();
    }

    // Ende Methoden
    public static void main(String[] args){
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        t.insert(17);
        t.insert(23);
        t.insert(42);
        t.insert(19);
        t.insert(10);

        System.out.println(t.preorder());
        System.out.println(t.inorder());
        System.out.println(t.postorder());

        System.out.println(t.size(t.getRoot()));

        System.out.println(t.smallest(t.getRoot()));
        System.out.println(t.biggest(t.getRoot()));

        t.delete(17);
        System.out.println(t.inorder());
    }
} // end of BinarySearchTree

