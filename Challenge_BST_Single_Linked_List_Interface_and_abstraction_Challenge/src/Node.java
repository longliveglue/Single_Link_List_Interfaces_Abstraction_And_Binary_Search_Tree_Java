public class Node extends ListItem{

    public Node(Object value) {
        super(value);
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


}
