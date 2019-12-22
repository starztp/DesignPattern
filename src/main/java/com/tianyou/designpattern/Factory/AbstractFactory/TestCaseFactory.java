package com.tianyou.designpattern.Factory.AbstractFactory;

import com.tianyou.designpattern.Factory.TestCase;
import com.tianyou.designpattern.Factory.TestCaseMode;
import com.tianyou.designpattern.Factory.TestCaseResult;

public interface TestCaseFactory {
    TestCase createTestCase();
    TestCaseMode createTestCaseMode();
    TestCaseResult createTestCaseResult();
}
