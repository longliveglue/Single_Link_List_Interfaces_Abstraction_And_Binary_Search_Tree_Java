
public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root){
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem node) {

        //1. Ensure the root isn't set to null if it is then add the item in here.
        if (root == null) {
            root = node;
            return true;
        }

        //2. Create a temporay ListItem and start at the root.
        ListItem current = root;

        //3. We have confirmed that the root item has something in it now we will check through every node to make sure that it
        while (current.next() != null) {
            // Check for duplicate
            if (current.getValue() == node.getValue()) {
                return false;
            }
            current = current.next();
        }

        // CRITICAL: Check the last node for a duplicate too!
        if (current.getValue() == node.getValue()) {
            return false;
        }

        // Link them both ways
        current.setNext(node);
        node.setPrevious(current);

        return true;
    }


    // I need to do more work on the list item. Same as the above i need to do a while loop and make a list variable with a current variable and them move through them.
    // if i find the node that matches the value i want to delete then i need to change the previous nodes right link to the next node and the next nodes left link to the previous node
    @Override
    public boolean removeItem(ListItem node) {

        // 1. Make sure the root isn't null and the node i'm trying to add isn't null.
        if(root == null || node == null){
            return false;
        }

        //2. Create a temporary space called current which starts at the root.
        ListItem current = root;

        // 3. Handle the Root Case make sure that it doesn't contain the value i want to remove.
        if(node.getValue() == current.getValue()){

            if(current.next() != null){
                root = current.next();
                root.setPrevious(null);
                return true;
            } else {
                root = null;
                return true;
            }
        }

        // 2. Handle the rest of the list
        while (current != null){
            if(node.getValue() == current.getValue()){
                ListItem previous = current.previous();
                ListItem next = null;

                if(current.next() != null) {
                    next = current.next();
                    current.next().setPrevious(previous); // Link next back to previous
                }

                // Link previous forward to next (works even if next is null)
                current.previous().setNext(next);

                return true;
            }
            current = current.next();
        }

        return false;
    }

    @Override
    public void traverse() {

    }
}


/*
@Override
public boolean addItem(ListItem node) {

// When adding an item we want to make sure that the root isn't null. If it is null then we will set the root the new node.
if(root == null){
root = node;
return true;
}

// If the root node already has a value then we now need to check through the list to see if we can find a match.
// Now its very unlikely that we are going to find a matching node. What is more likely is that we will find a matching value.
// Therefore we will start with the root node placing it into the new current ListItem variable get its value and compare the value of the current node with the value of the new node.
ListItem current = root;

//While the current node has a right link with a node in it thats not null.
while(current != null){

//the current nodes value is equal to the new nodes value then we shouldn't be adding it.
//We therefore return false.
if(current.getValue() == node.getValue()){
return false;
}
//Having already checked to see if the current Node has a node in the right link.
// Now we shift along the nodes so the current node becomes the rightlink.
current = current.next();
//If after having checked all the nodes and their values and we find that none of them match we can break out of the while loop
}
// Having broken out of the while loop we can now
current.setNext(node);
return true;
}
 */