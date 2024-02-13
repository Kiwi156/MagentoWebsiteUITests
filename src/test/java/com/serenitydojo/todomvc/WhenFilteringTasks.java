package com.serenitydojo.todomvc;

import com.serenitydojo.todomvc.actions.TodoListActions;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.assertj.core.api.Assertions;
import java.util.List;
import java.util.stream.Stream;
import static java.util.Arrays.asList;

@ExtendWith(SerenityJUnit5Extension.class)
public class  WhenFilteringTasks {

    @Managed(driver = "chrome")

    @Steps
    TodoListActions todoList;

    @ParameterizedTest(name = "{index} Should be able to search for {0} toDoItems by {2} filterBy Status")
    @MethodSource

    public void shouldDisplayCorrectFilteredItemsTest(List<String> toDoItems, String itemToComplete, String filterBy, List<String> filteredItem) {
        todoList.openApplication();
        todoList.addItems(toDoItems);
        todoList.completeItem(itemToComplete);
        todoList.filterBy(filterBy);

        Assertions.assertThat(todoList.items()).containsExactlyElementsOf(filteredItem);

    }
    private static Stream<Arguments> shouldDisplayCorrectFilteredItemsTest() {
        return Stream.of(Arguments.of(asList("Feed the cat", "Walk the dog"),"Feed the cat","Active", asList("Walk the dog")),
                         Arguments.of(asList("Feed the cat", "Walk the dog"), "Feed the cat", "Completed",asList("Feed the cat")),
                         Arguments.of(asList("Feed the cat", "Walk the dog"),"Walk the dog", "All",asList("Feed the cat", "Walk the dog")));


    }


    @Test
    public void shouldDisplayCorrectActiveFilteredItemsTest() {
        todoList.openApplication();
        todoList.addItems("Feed the cat", "Walk the dog");
        todoList.completeItem("Feed the cat");
        todoList.filterBy("Active");

        Assertions.assertThat(todoList.items()).containsExactly("Walk the dog");

    }
    @Test
    public void shouldDisplayCorrectAllFilteredItemsTest() {
        todoList.openApplication();
        todoList.addItems("Feed the cat", "Walk the dog");
        todoList.completeItem("Feed the cat");
        todoList.filterBy("All");

        Assertions.assertThat(todoList.items()).containsExactly("Feed the cat", "Walk the dog");
    }
}