package com.tianyou.designpattern.Factory.AbstractFactory;

import com.tianyou.designpattern.Factory.*;

public class BillTestCaseFactory implements TestCaseFactory {
    public TestCase createTestCase() {
        return new BillTestCase();
    }

    public TestCaseMode createTestCaseMode() {
        return new BillTestCaseMode();
    }

    public TestCaseResult createTestCaseResult() {
        return new BillTestCaseResult();
    }

}
