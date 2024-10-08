package clase2;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class actividad21 {

    // Método para buscar un valor en el BST
    public TreeNode searchBST(TreeNode root, int x) {
        // Caso base: si el nodo es nulo o si el valor del nodo es el que estamos buscando
        if (root == null || root.value == x) {
            return root;
        }

        // Si el valor a buscar es menor que el valor del nodo actual, buscar en el subárbol izquierdo
        if (x < root.value) {
            return searchBST(root.left, x);
        }

        // Si el valor a buscar es mayor que el valor del nodo actual, buscar en el subárbol derecho
        return searchBST(root.right, x);
    }

    private static int altura(TreeNode root) {
        if(root==null) { 
            return -1;
        } else {
            return 1+ Math.max(altura(root.left),
            altura(root.right));
        }    
    }

    public static void main(String[] args) {
        actividad21 tree = new actividad21();

        // Crear un árbol de ejemplo
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(22);
        root.right.right.right = new TreeNode(30);

        // Buscar el valor 7 en el árbol
        int valueToSearch = 7;
        TreeNode result = tree.searchBST(root, valueToSearch);
        
        if (result != null) {
            System.out.println("Valor " + result.value + " encontrado en el árbol.");
        } else {
            System.out.println("Valor no encontrado en el árbol.");
        }
        System.out.println("Altura del arbole " + altura(root));

    }
}