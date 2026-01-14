
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
            //This will move us along until we get to the last item.
            // Because the last item will have a rightLink of Null the while loop will cancel.
            //This means that the above if statement won't check to see if the last item is a duplicate of the item we are trying to add.
            current = current.next();
        }

        // We have to do one last check to make sure that the final item is not a duplicate.
        //If it is we don't add anything and return false.
        if (current.getValue() == node.getValue()) {
            return false;
        }

        // If however there are no duplicates and we are now at the final node with a rightLink of Null.
        // We nee
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
    // The Traverse method should traverse through the linked list and print out the value of all items.
        ListItem current = root;

        if(current == null){
            System.out.println("The list is empty");
            return;
        } else {
            System.out.println(current.getValue());
        }

        while(current.next() != null){
            current = current.next();
            System.out.println(current.getValue());
        }

        return;

    }
}


