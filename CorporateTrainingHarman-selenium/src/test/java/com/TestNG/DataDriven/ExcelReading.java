package com.TestNG.DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;

public class ExcelReading {
  @Test
  public void fileREading() throws IOException 
  {
	  
	  //path of file
	  File f1=new File(System.getProperty("user.dir")+"//TestData//Data.xlsx");
	  
	  //Reading in stream
	  FileInputStream fs=new FileInputStream(f1);
	  
	  //wb-->sheet-->row-->cell-->value
	  XSSFWorkbook wb=new XSSFWorkbook(fs);
	  
	

	// ------------------------multi data from excel --------------------------//	 
	  
	//   below logic will help us to fetch all data from excel i.e all cell value 
	 // here we will shift data from excel into Array and then will use 2D array concept 
	 
	  	  
	  //number of rows
	  int rows=wb.getSheet("userdata").getPhysicalNumberOfRows();
	  System.out.println("Number of rows are: "+rows);
	  
	  //number of columns
	  int cells=wb.getSheet("userdata").getRow(0).getPhysicalNumberOfCells();
	  System.out.println("Number of columns are: "+cells);
	  
	//design array of same size
	 // Object data[][]=new Object[rows][cells]; // use when we wants to include header name
	  Object data[][]=new Object[rows-1][cells]; 
	  	  
	  //iterate array first shift data then read
	  for(int i=1;i<rows;i++)//row
	  {
		  for(int j=0;j<cells;j++)
		  {
			  //to start array from 0th position
			  data[i-1][j]=wb.getSheet("userdata").getRow(i).getCell(j).getStringCellValue();
			  System.out.print(data[i-1][j]+"   ");
			  
		  }
		  System.out.println();
	  }
	  
	  
	 	  
	  
// ------------------------single data from excel --------------------------//	  
	  
	  /* below logic will help us to fetch one data from excel i.e one cell value only

	   System.out.println("--------single steps------- ");  
	  String value=wb.getSheet("userdata").getRow(1).getCell(0).getStringCellValue();
	  
	
	  System.out.println("--------multiple steps------- ");  
	  
	  XSSFSheet sheet1=wb.getSheet("userdata");
	  
	  XSSFRow row=sheet1.getRow(0);
	  
	  XSSFCell cell=row.getCell(0);
	  
	  String value=cell.getStringCellValue();
	  
	 
	  System.out.println(value);
	  
	  */
	  //System.out.println(value);
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
}
