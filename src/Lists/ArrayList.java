package Lists;

public class ArrayList<Item> {
    int length = 0;
    Item[] items = (Item[]) new Object[length];

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public Item elementAt(int index) {
        return items[length - 1];
    }

    public void prepend(Item e) {
        Item[] itemsCopy = items;
        items = (Item[]) new Object[++length];
        System.arraycopy(itemsCopy, 0, items, 1, itemsCopy.length);
        items[0] = e;
    }

    public void append(Item e) {
        Item[] itemsCopy = items;
        items = (Item[]) new Object[++length];
        System.arraycopy(itemsCopy, 0, items, 0, itemsCopy.length);
        items[length - 1] = e;
    }

    public void insertAt(int index, Item e) {
        Item[] itemsCopy = items;
        items = (Item[]) new Object[++length];
        System.arraycopy(itemsCopy, 0, items, 0, index);
        System.arraycopy(itemsCopy,
                index,
                items,
                index + 1,
                itemsCopy.length - index);
        items[index] = e;
    }

    public void remove(int index) {
        Item[] itemsCopy = items;
        items = (Item[]) new Object[--length];
        System.arraycopy(itemsCopy, 0, items, 0, index);
        System.arraycopy(itemsCopy,
                index + 1,
                items,
                index,
                items.length - index);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Item item: items) {
            builder.append(item);
            builder.append(" ");
        }

        return builder.toString();
    }
}
