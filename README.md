# Magento and TodoMVC websites UI tests using Serenity with Java

This exercise demonstrates **web browser automation** and has examples of **finding element locators** and interacting with different types of elements. This exercise also provides an example of how it is possible to run a test several times with different arguments using a **Parameterized Test**.

The websites used are https://magento.softwaretestingboard.com/ and https://todomvc.com/ these are demo sites used to verify automation test scripts.  

For this testing I am using Junit5, Selenium , Maven, Serenity BDD, AssertJ, IntelliJ as the IDE with Java. 

# Goal

The goal of this exercise is to demonstrate being able to find and interact with different types of elements locators. 

Also another goal is to demonstrate **paramaterized testing** using Junit5. 

# Techniques Learned

This exercise demonstrates waiting for an element before we check it. During the tests for creating accounts there are methods that wait for text to appear. I have learnt that it is important in UI tests to know if a condition is being waited for and how to convey that condition.    

This exercise also demonstrates how it is possible to **run a test multiple times with different test data**. For this exercise the JUnit5 User Guide was helpful as a reference to complete the related Java code. The paramaterized test required multiple parameters and used a stream of arguments it also used the **@ParameterizedTest and the @MethodSource annotations**. The code can be found under the "todomvc" folder, Test Class WhenFilteringTasks at the following location "src/test/java/com/serenitydojo/todomvc".   
