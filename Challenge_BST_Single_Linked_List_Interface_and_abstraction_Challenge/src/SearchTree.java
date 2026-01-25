public class SearchTree implements NodeList {

    ListItem root = null;

    public SearchTree(ListItem root) {
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
        //4. If both the node and the root aren't null. We need to compare the root to the node. if the node is bigger it goes to the rightLink less it goes to the LeftLink and equal return false.

        //Step 1.
        if (node == null) {
            return false;
        }

        //Step 2.
        if (root == null) {
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
                    node.setPrevious(current);
                    return true;
                }
            } else if (comparison > 0) {
                // current is larger than node, try to move left/previous
                if (current.previous() != null) {
                    current = current.previous();
                } else {
                    current.setPrevious(node);
                    node.setNext(current);
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
        //1. Check to see if root is null or the new node is null. If either of them are return false.
        //2. Create a viewer/pointer called current to allow us to traverse the items.
        //3. Check if the root node is actually the target to be deleted.
        //4 if it is we need to store the roots prev in prevNode.
        //5 Set the current as root.next (Its right Child).
        //6 Then create a while loop that will always goto the left until we find the bottom left child thats left child is null. current = current.prev
        //7 we will then set the left child as the root nodes previous.
        //8 we will then set the root node to =

        //Step 1
        if (node == null || root == null) {
            return false;
        }
        //Step 2
        ListItem current = root;
        ListItem breakNode = null;
        ListItem parentNode = null;

        // Step 3 deal with the root node first
        if (current.getValue() == node.getValue()) {
            breakNode = current;
            current = breakNode.next();

            while (current.previous() != null) {
                current = current.previous();

                if (current.previous() == null) {
                    current.setPrevious(breakNode.previous());
                    root = breakNode.next();
                    return true;
                }

            }

        }
        // Step 4 If its not the root we will search for where it is keeping track of the item to be deleted breakNode and its parentNode.
        current = root;
        parentNode = root;

        // Having already checked the root node to see if it is the issue we will now find out of we are going to the right or left link.
        int comparison = current.compareTo(node);
        if( comparison < 0){
            current = current.next();
        } else {
            current = current.next();
        }

        boolean lastItemFound = true;
        while (lastItemFound) {
        comparison = current.compareTo(node);

            if(comparison == 0){
                performRemoval(current, parentNode);
            } else {
                if (comparison < 0){

                }
            }


        }


        return false;
    }

    @Override
    public void traverse() {

    }

    private void performRemoval(ListItem nodeToRemove, ListItem parentNode) {

    }
}
