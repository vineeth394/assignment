package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;

public class HelloWorldServletTest {

    private HelloWorldServlet helloWorldServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PrintWriter writer;

    @BeforeEach
    public void setUp() {
        helloWorldServlet = new HelloWorldServlet();

        // Mock HttpServletRequest and HttpServletResponse
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        
        // Mock the response's PrintWriter to capture output
        try {
            writer = mock(PrintWriter.class);
            when(response.getWriter()).thenReturn(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDoGet() throws Exception {
        // Call the doGet method of the servlet
        helloWorldServlet.doGet(request, response);

        // Verify that the content type is set correctly
        verify(response).setContentType("text/html");

        // Verify that the response writer is used to send the correct output
        verify(writer).write("<h1>Hello, World!</h1>");
    }
}
