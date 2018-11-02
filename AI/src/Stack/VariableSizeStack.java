package Stack;

public class VariableSizeStack {
    private String[] content;
    private int top = 0;

    public VariableSizeStack() {
        content = new String[0];
    }

    public void push(String item) {
        String[] contentCopy = content;
        content = new String[++top];
        System.arraycopy(contentCopy, 0, content, 0, contentCopy.length);
        content[top-1] = item;
    }

    public String pop() {
        if(top != 0) {
            String item = content[top-1];
            String[] contentCopy = content;
            content = new String[--top];
            System.arraycopy(contentCopy, 0, content, 0, contentCopy.length-1);
            return item;
        } else {
            return null;
        }
    }
}