
/**
 * clase nodo recopliado de
 * https://www.baeldung.com/java-binary-tree
 * @author Juan Marroquin
 * @param <E>
 */
public class Node<E> {

    /**
     * paramatros del nodo
     */
    E value;
    Node left;
    Node right;

    /**
     * constructor del Nodo Nodos izquierdo y derecho null
     * @param value
     */
    public Node(E value) {
        this.value = value;
        left = null;
        right = null;
    }
}
