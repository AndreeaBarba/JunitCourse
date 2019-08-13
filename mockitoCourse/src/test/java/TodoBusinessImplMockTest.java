import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock_returnsAllSpringTodos() {
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosReltedToSpring_withEmptyList() {
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList();
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(0, filteredTodos.size());
    }

    @Test
    public void testRetrievedTodosRelatedToSpring_usingBDD() {

        //given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //when
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        //then
        assertThat(filteredTodos.size(), is(2));

    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_UsingBDD() {
        //given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //when
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        // then
        verify(todoServiceMock).deleteTodos("Learn to dance");
        verify(todoServiceMock, never()).deleteTodos("Learn Spring");
        verify(todoServiceMock, never()).deleteTodos("Learn Spring MVC");
        verify(todoServiceMock, times(1)).deleteTodos("Learn to dance");
        then(todoServiceMock).should().deleteTodos("Learn to dance");
        then(todoServiceMock).should(never()).deleteTodos("Learn Spring");
        then(todoServiceMock).should(never()).deleteTodos("Learn Spring MVC");
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingArgumentCapture() {
//      declare an argument captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        //given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //when
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        // then
        // define argument captor on specific method call
        then(todoServiceMock).should().deleteTodos(stringArgumentCaptor.capture());

        // capture the argument
        assertThat(stringArgumentCaptor.getValue(),is ("Learn to dance"));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingArgumentCaptureMultipleTimes() {
//        declare an argument captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        //given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn to Rock anf Roll", "Learn Spring", "Learn to dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //when
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        // then
        // define argument captor on specific method call
        then(todoServiceMock).should(times(2)).deleteTodos(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
    }

}
