package org.sergei.impl;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LoopTest {
    private List<String> testCases = Arrays.asList("Adam", "BJ", "Dave", "K", "Boot", "L");

    @Test
    public void loopTest() {
        for (String testCase : testCases) {
            Assert.assertTrue("Failed case: " + testCase, testCase.length() > 2);
        }
    }

}
