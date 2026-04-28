public class Todo {
    private String title;
    private boolean isComplete;

    public Todo(String title) {
        this.title = title;
        this.isComplete = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
}