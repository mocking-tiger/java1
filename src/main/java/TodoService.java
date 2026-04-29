import java.util.ArrayList;
import java.util.List;

public class TodoService {
    private List<Todo> todos = new ArrayList<>();

    // 사이즈 반환
    public int size(){
        return todos.size();
    }

    // 특정 todo 반환
    public Todo getTodo(int index){
        return todos.get(index);
    }

    // 1. 할 일 추가
    public void addTodo(String title){
        Todo todo = new Todo(title);
        todos.add(todo);
    }

    // 2. 할 일 조회
    public List<Todo> getTodos(){
        return todos;
    }

    // 3. 할 일 삭제
    public void deleteTodo(int index){
        todos.remove(index);
    }

    // 4. 할 일 상태변경
    public boolean toggleTodoStatus(int index){
        Todo todo = todos.get(index);
        todo.setIsComplete(!todo.getIsComplete());

        return todo.getIsComplete();
    }

}