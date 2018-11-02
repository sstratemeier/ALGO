package Stack;

public class GenericStack<T> {
    private T[] content;
    private int top = 0;

    public GenericStack() {
        content = (T[]) new Object[0];
    }

    public void push(T item) {
        T[] contentCopy = content;
        content = (T[]) new Object[++top];
        System.arraycopy(contentCopy, 0, content, 0, contentCopy.length);
        content[top-1] = item;
    }

    public T pop() {
        if(top != 0) {
            T item = content[top-1];
            T[] contentCopy = content;
            content = (T[]) new Object[--top];
            System.arraycopy(contentCopy, 0, content, 0, contentCopy.length-1);
            return item;
        } else {
            return null;
        }
    }
}
