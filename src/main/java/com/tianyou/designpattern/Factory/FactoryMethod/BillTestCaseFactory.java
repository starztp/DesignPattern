package com.tianyou.designpattern.Factory.FactoryMethod;

import com.tianyou.designpattern.Factory.BillTestCase;
import com.tianyou.designpattern.Factory.TestCase;

public class BillTestCaseFactory implements TestCaseFactory{

    public TestCase CreateTestCase() {
        return new BillTestCase();
    }
}
