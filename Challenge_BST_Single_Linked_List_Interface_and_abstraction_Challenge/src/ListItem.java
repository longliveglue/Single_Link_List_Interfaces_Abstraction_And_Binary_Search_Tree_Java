//This is the abstract class that will create the Nodes.
//In this program we have two different data structures a linked list and then a Binary Search Tree.
//This ListItem is simply forcing me to demonstrate an abstract class so that i can then extend it into the Node Class.


public abstract class ListItem {
    protected ListItem rightLink;
    protected ListItem leftLink;
    protected Object value;

    // The constructor that sets the value of the Object Value.
    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();

    abstract ListItem setNext(ListItem nextItem);

    abstract ListItem previous();

    abstract ListItem setPrevious(ListItem prevItem);

    abstract int compareTo(ListItem itemToCompare);

    public Object getValue() {
        return value;
    }

    public void setValue(Object setValue) {
        value = setValue;
    }

}
