package com.serenitydojo.ecommerce.todomvc.actions;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenCompletingATask {

    @Managed(driver = "chrome")
    WebDriver driver;

    todoListActions todoList;

    @Test
    public void activeTasksShouldNotShowCompletedTasks() {
        todoList.openApplication();
        todoList.addItems("Do the dishes", "Walk the dogs");
        todoList.completeItem("Do the dishes");
        todoList.filterBy("Active");

        Assertions.assertThat(todoList.items()).containsExactly("Walk the dogs");
    }

    @Test
    public void completedTasksShouldNotShowActiveTasks() {
        todoList.openApplication();
        todoList.addItems("Do the dishes", "Walk the dogs");
        todoList.completeItem("Do the dishes");
        todoList.filterBy("Completed");

        Assertions.assertThat(todoList.items()).doesNotContain("Walk the dogs");
    }
}