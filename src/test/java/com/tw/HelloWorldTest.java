package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {

    private final HelloWorld helloWorld = new HelloWorld();

    @Test
    public void hello_world_test() throws Exception {
        assertEquals("Hello World", helloWorld.hi());
    }
}
