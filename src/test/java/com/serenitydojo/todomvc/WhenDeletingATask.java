package com.serenitydojo.ecommerce.todomvc.actions;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
@ExtendWith(SerenityJUnit5Extension.class)
public class WhenDeletingATask {

    @Managed(driver = "chrome")
    WebDriver driver;

    todoListActions todoList;

    @Test
    public void deletedItemsShouldDissapearFromTheList(){

        todoList.openApplication();
        todoList.addItems("Do the dishes", "Walk the dogs");
        todoList.deleteItem("Do the dishes");

        Assertions.assertThat(todoList.items()).doesNotContain("Do the dishes");
        Assertions.assertThat(todoList.items()).containsExactly("Walk the dogs");


    }
}
