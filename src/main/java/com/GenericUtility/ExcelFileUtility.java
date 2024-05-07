package com.GenericUtility;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.HashMap;

public class ExcelFileUtility {

    public HashMap<String, String> readDataFromExelFile(String sheetName) throws Throwable {
        FileInputStream fis = new FileInputStream(IPathConstants.excelFilePath);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheetName);
        HashMap<String, String> hm = new HashMap<String, String>();
        for(int i=0; i<sh.getRow(0).getLastCellNum(); i++)
        {
            String key = sh.getRow(0).getCell(i).getStringCellValue();
            String value = sh.getRow(1).getCell(i).getStringCellValue();
            hm.put(key, value);
        }
        return hm;
    }
}
