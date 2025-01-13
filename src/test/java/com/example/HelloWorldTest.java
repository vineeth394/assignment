package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTest {

    @Test
    public void testGreetWorld() {
        HelloWorld helloWorld = new HelloWorld();
        assertEquals("Hello, World!", helloWorld.greet());
    }

    @Test
    public void testGreetWithName() {
        HelloWorld helloWorld = new HelloWorld();
        assertEquals("Hello, John!", helloWorld.greet("John"));
        assertEquals("Hello, Alice!", helloWorld.greet("Alice"));
    }

    @Test
    public void testGreetWithPrefix() {
        HelloWorld helloWorld = new HelloWorld();
        assertEquals("Good Morning, John!", helloWorld.greetWithPrefix("John", "Good Morning"));
        assertEquals("Hi, Alice!", helloWorld.greetWithPrefix("Alice", "Hi"));
        assertEquals("Hello, World!", helloWorld.greetWithPrefix("", "Hi"));  // Edge case for empty name
        assertEquals("Hi, World!", helloWorld.greetWithPrefix("World", "Hi")); // Edge case for prefix
    }

    @Test
    public void testIsGreetingUppercase() {
        HelloWorld helloWorld = new HelloWorld();
        assertTrue(helloWorld.isGreetingUppercase("JOHN"));
        assertFalse(helloWorld.isGreetingUppercase("John"));
    }

    @Test
    public void testGreetWithNullOrEmptyName() {
        HelloWorld helloWorld = new HelloWorld();
        assertEquals("Hello, World!", helloWorld.greet(null));  // Null name
        assertEquals("Hello, World!", helloWorld.greet(""));    // Empty name
    }
}
