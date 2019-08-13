import java.util.List;

public interface TodoService {
    List<String> retrieveTodos(String user);

     void deleteTodos(String todo);
}
