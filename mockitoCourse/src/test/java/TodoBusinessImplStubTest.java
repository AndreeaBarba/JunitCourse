//import org.junit.Test;
//
//import java.util.List;
//
//import static java.util.Arrays.asList;
//import static org.junit.Assert.*;
//
//public class TodoBusinessImplStubTest {
//    @Test
//    public void testRetrieveTodosRelatedToSpring_usingAStub_returnsAllSpringTodos() {
//        TodoService todoServiceStub = new TodoServiceStub();
//        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
//
//        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
//
//        assertEquals(2, filteredTodos.size());
//        assertTrue(filteredTodos.containsAll(asList("Learn Spring MVC", "Learn Spring")));
//        assertFalse(filteredTodos.contains(asList("Learn to dance")));
//    }
//}
