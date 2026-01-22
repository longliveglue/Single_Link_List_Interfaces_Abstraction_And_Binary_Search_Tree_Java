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

        //1. Confirm that the node item isn't null. If it is return false.
        //2. Confirm the root isn't null. If it is then set the new node to be the root item and return true as we have added the item. This is useful when adding to left and right Links.
        //3. We need to make a temporary marker to allow us to traverse we will call it current. It will always start at the root.
        //3. If both the node and the root aren't null. We need to compare the root to the node. if the node is bigger it goes to the rightLink less it goes to the LeftLink and equal return false.


        //Step 1.
        if(node == null){
            return false;
        }

        //Step 2.
        if (root == null){
            root = node;
            return true;
        }

        //Step 3.
        ListItem current = root;

        // Step 4.
        while (current != null) {
            int comparison = current.compareTo(node);

            if (comparison < 0) {
                // current is smaller than node, try to move right/next
                if (current.next() != null) {
                    current = current.next();
                } else {
                    current.setNext(node);
                    node.setPrevious(current); // If it's a doubly linked list
                    return true;
                }
            } else if (comparison > 0) {
                // current is larger than node, try to move left/previous
                if (current.previous() != null) {
                    current = current.previous();
                } else {
                    current.setPrevious(node);
                    node.setNext(current); // If it's a doubly linked list
                    return true;
                }
            } else {
                // comparison == 0 (The item already exists)
                return false;
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
