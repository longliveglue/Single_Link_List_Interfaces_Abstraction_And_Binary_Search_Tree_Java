//This is the abstract class that will create the Nodes.
//In this program we have two different data structures a linked list and then a Binary Search Tree.
//This ListItem is simply forcing me to demonstrate an abstract class so that i can then extend it into the Node Class.


public abstract class ListItem {
    protected ListItem rightLink;
    protected ListItem leftLink;
    protected Object value;

    public ListItem(Object value){
        this.value = value;
    }

    public ListItem next(){
    return rightLink;
    }

    public ListItem setNext(ListItem nextItem){
        rightLink = nextItem;
        return rightLink;
    }

    public ListItem previous(){
        return leftLink;
    }

    public ListItem setPrevious(ListItem prevItem){
        leftLink = prevItem;
        return leftLink;
    }

    public int compareTo(ListItem itemToCompare){
        int currentItem = (int) value;
        int newItem = (int) itemToCompare.getValue();

        if (currentItem == newItem){
            return 0;
        } else if ( currentItem > newItem) {
            return 1;
        }
        return -1;
    }

    public Object getValue(){
        return value;
    }

    public void setValue(Object setValue){
        value = setValue;
    }

}
