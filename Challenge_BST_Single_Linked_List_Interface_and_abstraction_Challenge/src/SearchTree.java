public class SearchTree implements NodeList{

    ListItem root = null;

    public SearchTree(ListItem root){
        this.root = root;
    }



    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem node) {

        //1. First i want to check to see if the root is null which it definately shouldn't be but the constructor isn't checking to see if it is so we need to be sure.
        if (root == null){
            root = node;
            return true;
        }

        // 2. We also need to make sure that the new node isn't null.
        if(node == null){
            return false;
        }

        //3. I now need to create a current node. That we can move through.
        ListItem current = root;

        //4. We now need to compare the current root to the new node.
        //if the new node is bigger than the current node we will go right on the binary tree.
        //We will look to see if the current objects rightLink is empty if it is we will add
        //The new node to the right link and link it back to the current node.
        //if the new node is less then it will goto the left.

        if(current.compareTo(node) > 1){
            if (current.next() == null){

            }
        }


        return false;
    }

    @Override
    public boolean removeItem(ListItem node) {
        return false;
    }

    @Override
    public void traverse() {

    }
}
