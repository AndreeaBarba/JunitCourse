import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl {
// TodoBusinessImpl is the SUT (system under test)
// TodoService is a dependency
    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<>();
        List<String> todos = todoService.retrieveTodos(user);
        for(String todo:todos){
            if(todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void deleteTodosNotRelatedToSpring(String user) {
        List<String> todos = todoService.retrieveTodos(user);

        for(String todo:todos){
            if(!todo.contains("Spring")){
                todoService.deleteTodos(todo);
            }
        }
    }
}
