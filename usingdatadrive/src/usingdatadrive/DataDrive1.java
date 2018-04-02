package usingdatadrive;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataDrive1 {
	
	@DataProvider(name="formData")
	public Object[][] enterData()
	{
		System.out.println("enterData executing");
		Object[][] a=new Object[2][5];
		try
		{
			File src=new File("E:\\webdriver\\TestData.xlsx");
			FileInputStream fis= new FileInputStream(src);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet1=wb.getSheetAt(0);
			int rowcount=sheet1.getLastRowNum();
			System.out.println("count : " + rowcount);
			for (int i=1;i<=rowcount;i++)
			{
			    a[i-1][0]=sheet1.getRow(i).getCell(0).getStringCellValue();
			    a[i-1][1]=sheet1.getRow(i).getCell(1).getNumericCellValue();
			    a[i-1][2]=sheet1.getRow(i).getCell(2).getStringCellValue();
			    a[i-1][3]=sheet1.getRow(i).getCell(3).getStringCellValue();
			    a[i-1][4]=sheet1.getRow(i).getCell(4).getStringCellValue();

				System.out.println(a[i-1][0]);
				System.out.println(a[i-1][1]);
				System.out.println(a[i-1][2]);
				System.out.println(a[i-1][3]);
				System.out.println(a[i-1][4]);
			}
		}
		catch(Exception e)
		{
			System.out.println("Enter error message:"+e);
		}
		return a;
	}
}
