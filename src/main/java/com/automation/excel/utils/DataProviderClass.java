package com.automation.excel.utils;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class DataProviderClass {

    @DataProvider(name = "mydataprovider")
    public synchronized Object[][] testDataProvider(final Method currentTestMethod, final ITestContext executionInfo)
            throws Exception {

        ReadExcelData excelData = new ReadExcelData();

        ArrayList<HashMap<String, String>> rowData = excelData.getDataFromExcel("testdata.xlsx");

        System.out.println("Each row");

        ArrayList<HashMap<String, String>> testRowToRun = new ArrayList<>();

        for (HashMap<String, String> singleRowData : rowData) {
            System.out.println(singleRowData.get("Rerun"));

            if (singleRowData.get("Rerun").equals("yes")) {
                testRowToRun.add(singleRowData);
            }
        }

        final Object[][] returnArray = new Object[testRowToRun.size()][1];

        int i = 0;

        for (final HashMap<String, String> singleSet : testRowToRun) {
            int j = 0;
            returnArray[i][j] = singleSet;
            i++;
        }

        // If test is not tdd driven.
        return returnArray;

    }

    @Test(dataProvider = "mydataprovider")
    public void testDProvider(HashMap<String, String> data1) {

        System.out.println(data1.get("TestName") + "-" + data1.get("Rerun"));

    }
}
