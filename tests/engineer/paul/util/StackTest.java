package engineer.paul.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack stack;

    @BeforeEach
    void createNewStack() {
        stack = new Stack();
    }

    @AfterEach
    void destroyStack() {
        stack = null;
    }

    @Test
    @DisplayName("Pushing 5 and popping 5 elements on the stack")
    void pushAndPop() {
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        stack.push("five");

        assertEquals(stack.pop(), "five");
        assertEquals(stack.pop(), "four");
        assertEquals(stack.pop(), "three");
        assertEquals(stack.pop(), "two");
        assertEquals(stack.pop(), "one");
    }

    @Test
    @DisplayName("Pushing 11 elements on the stack to force growth")
    void growStack() {
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        stack.push("five");
        stack.push("six");
        stack.push("seven");
        stack.push("eight");
        stack.push("nine");
        stack.push("ten");
        stack.push("eleven");
    }

}