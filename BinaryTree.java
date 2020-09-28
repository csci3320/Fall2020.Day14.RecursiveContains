
public class BinaryTree<T extends Comparable> implements MyCollection<T>{

    private Node<T> root;

    public BinaryTree(){
        root = null;
    }

    public String getDigraph() {
		if (root == null) {
			return "root->null";
		}
		return "root->" + root.getValue()  + "\n" + digraph(root);
    }
    
    public String digraph(Node<T> node){

    
		if (node == null)
			return "";
		Node<T> left = node.getLeft();
		Node<T> right = node.getRight();

		String nodeValue = node.getValue().toString() ;

		String leftValue = "";
		String rightValue = "";
		String middle = "";

		var showNull = false;
		if (showNull) {
			leftValue = left == null ? "null_l_" + nodeValue : left.getValue().toString();
			rightValue = right == null ? "null_r_" + nodeValue : right.getValue().toString();
			middle = nodeValue + "->" + leftValue + "[label=\"left\"]\n" + nodeValue + "->" + rightValue
					+ "[label=\"right\"]\n";
		} else {
			leftValue = left == null ? "null" : left.getValue().toString() ;
			rightValue = right == null ? "null" : right.getValue().toString() ;
			if (!(leftValue.contentEquals("null"))) {
				middle += nodeValue + "->" + leftValue + "[label=\"left\"]\n";
			}
			if (!(rightValue.contentEquals("null"))) {
				middle += nodeValue + "->" + rightValue + "[label=\"right\"]\n";
			}

		}

		return digraph(left) + middle + digraph(right);
	}

    public void add(T toAdd){
        Node<T> node = new Node<T>(toAdd);
        if(root == null){
            root = node;
        }
        else{
            addNode(root, node);
        }
    }

    public void addNode(Node<T> parentNode, Node<T> toAdd){
        if(toAdd.getValue().compareTo(parentNode.getValue()) <= 0){
            parentNode.addedLeft();

            //Go left
            if(parentNode.getLeft() == null){
                parentNode.setLeft(toAdd);
            }
            else{
                addNode(parentNode.getLeft(), toAdd);
            }
        }
        else{
            parentNode.addedRight();
            //Go right
            if(parentNode.getRight() == null){
                parentNode.setRight(toAdd);
            }
            else{
                addNode(parentNode.getRight(), toAdd);
            }
        }
    }

    public int size(){
        return size(root);
    }

    public int size(Node<T> parent){
        if(parent == null) return 0;
        int leftSize = size(parent.getLeft());
        int rightSize = size(parent.getRight());
        return leftSize + rightSize + 1;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void remove(T toRemove){

    }

    public boolean contains(T element){
       return contains(root, element);
    }

    private boolean contains(Node<T> parent, T element){
        if(parent == null) return false;
        boolean left = contains(parent.getLeft(), element);
        boolean right = contains(parent.getRight(), element);
        if(left  || right )
            return true;
        if(parent.getValue().equals(element)){
            return true;
        }
        return false;
    }

}
