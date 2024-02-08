package com.serenitydojo.todomvc;

import com.serenitydojo.todomvc.actions.TodoListActions;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.assertj.core.api.Assertions;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;

@ExtendWith(SerenityJUnit5Extension.class)

public class WhenFilteringTasks {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    private List<String> todoItems;
    private String itemToComplete;
    private String filterBy;
    private List<String> filteredItem;

    public WhenFilteringTasks(String filterBy, List<String> todoItems, String itemToComplete,  List<String> filteredItem) {
        this.todoItems = todoItems;
        this.itemToComplete = itemToComplete;
        this.filterBy = filterBy;
        this.filteredItem = filteredItem;
    }

    @TestData(columnNames = "Filter By, Todo Items, Completed Items, Filtered Items")
    public static Collection<Object[]> testData() {
        return asList(
              new Object[][]{
                      {"Active", asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Walk the dog")},
                      {"Completed", asList("Feed the cat","Walk the dog"), "Feed the cat", asList("Feed the cat")},
                      {"All", asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Feed the cat", "Walk the dog")},
              }
        );
    }
    @Test

    public void shouldDisplayCorrectFilteredItems(){
        todoList.openApplication();
        todoList.addItems(todoItems);
        todoList.completeItem(itemToComplete);

        todoList.filterBy(filterBy);

        Assertions.assertThat(todoList.items()).containsExactlyElementsOf(filteredItem);

    }
}
