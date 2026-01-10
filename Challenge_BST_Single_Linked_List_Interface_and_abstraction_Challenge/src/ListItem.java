//This is the abstract class that will create the Nodes.
//In this program we have two different data structures and linked list and then a Binary Search Tree.
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

}
