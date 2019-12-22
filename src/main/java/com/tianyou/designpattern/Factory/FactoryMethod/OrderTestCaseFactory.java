package com.tianyou.designpattern.Factory.FactoryMethod;

import com.tianyou.designpattern.Factory.OrderTestCase;
import com.tianyou.designpattern.Factory.TestCase;

public class OrderTestCaseFactory implements TestCaseFactory{

    public TestCase CreateTestCase() {
        return new OrderTestCase();
    }
}
