package com.serenitydojo.todomvc;

import com.serenitydojo.todomvc.actions.TodoListActions;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingTasks {

    @Managed(driver = "chrome")
    WebDriver driver;

    TodoListActions todoList;
    @Test
    public void addingASingleTask(){

        todoList.openApplication();
        todoList.addItem("Do the dishes");
        Assertions.assertThat(todoList.items()).containsExactly("Do the dishes");
    }
    @Test
    public void addingMultipleTasks(){

        todoList.openApplication();
        todoList.addItem("Do the dishes");
        todoList.addItem("Walk the dogs");
        Assertions.assertThat(todoList.items()).containsExactly("Do the dishes","Walk the dogs");

    }
    @Test
    public void addingMoreTasks(){
        todoList.openApplication();
        todoList.addItems("Do the dishes", "Go to Athletics");
        Assertions.assertThat(todoList.items()).containsExactly("Do the dishes","Go to Athletics");


    }

}
