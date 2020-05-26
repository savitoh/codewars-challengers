package com.github.savitoh;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class WhoLikesItTest {
    
    @Test
    public void solutionTest() {
        assertEquals("no one likes this", WhoLikesIt.solution());
        assertEquals("Peter likes this", WhoLikesIt.solution("Peter"));
        assertEquals("Jacob and Alex like this", WhoLikesIt.solution("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", WhoLikesIt.solution("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", WhoLikesIt.solution("Alex", "Jacob", "Mark", "Max"));
    }
}
