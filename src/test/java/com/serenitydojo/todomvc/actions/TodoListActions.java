package com.serenitydojo.todomvc.actions;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class TodoListActions extends UIInteractionSteps {

    @Managed(driver = "chrome")
    WebDriver driver;
    @Step("Adding item '{0}'")
    public void addItem(String item){
        $(".new-todo").typeAndEnter(item);
    }
    public List<String> items(){
        return $$ (".todo-list label").texts();
    }

    @Step("Open the TodoMVC application")
    public void openApplication() {
           openUrl("https://todomvc.com/examples/angular/dist/browser/#/all");
    }


    @Step("Add items {0}")
    public void addItems(List<String> items) {
        items.forEach(this::addItem);

        }

    @Step("Add items {0}")
    public void addItems(String...items) {
          for (String item : items)  {
              addItem(item);
          }
    }

    public void completedTasksShouldNotShowActiveTasks() {
    }

    @Step("Complete item {0}")
    public void completeItem(String item) {
        $("//label[.='{0}']/preceding-sibling::input[@type='checkbox']", item).click();
    }


    public void filterBy(String filterName) {
        $("//ul[@class='filters']//a[.='{0}']",filterName).click();

    }
    @Step("Delete item {0}")
    public void deleteItem(String item) {
        $("//label[.='{0}']",item).click();
        $("//label[.='{0}']//following-sibling::button[@class='destroy']",item).click();
    }
}
