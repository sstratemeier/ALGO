package Stack;

public class FixedSizeStack {
    private String[] content;
    private int top = 0;

    public FixedSizeStack(int size) {
        content = new String[size];
    }

    public boolean push(String item) {
        if(top < content.length) {
            content[top] = item;
            top++;
            return true;
        } else {
            return false;
        }
    }

    public String pop() {
        if(top != 0) {
            String item = content[top];
            top--;
            return item;
        } else {
            return null;
        }
    }
}
