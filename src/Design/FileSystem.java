package Design;

public class FileSystem {
}

abstract class systemItem<T> {
    public String name;
    public T content;

    public systemItem(String name, T content) {
        this.name = name;
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
