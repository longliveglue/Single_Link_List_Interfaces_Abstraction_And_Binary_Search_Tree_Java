
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
        if(getRoot().rightLink == null){
            getRoot().rightLink = node;
        } else {

        }

        return false;
    }

    @Override
    public boolean removeItem() {
        return false;
    }

    @Override
    public void traverse() {

    }
}
