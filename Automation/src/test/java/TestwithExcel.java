import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestwithExcel {
    public static void main(String[] args) throws IOException, InterruptedException {
        /// determine the path of Excel file
        File f = new File("C:\\Users\\user\\Desktop\\test1.xlsx");
        /// / open the file located in the previous path
        FileInputStream fis = new FileInputStream(f);
        /// open the workbook in the file
        XSSFWorkbook wb = new XSSFWorkbook(fis);;
        /// select a specific sheet to work on it
        XSSFSheet sheet = wb.getSheet("Sheet1");
        ///  find the number of rows that actually have data
        int count = sheet.getPhysicalNumberOfRows();
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        for (int i = 0; i < count; i++) {
            String url = "https://www.facebook.com/?locale=ar_AR";
            driver.get(url);
            String UserName=sheet.getRow(i).getCell(0).getStringCellValue();
            String Password=sheet.getRow(i).getCell(1).getStringCellValue();
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div[1]/input")).clear();
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div[1]/input")).sendKeys(UserName);
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div[2]/div/input")).clear();
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div[2]/div/input")).sendKeys(Password);
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
            Thread.sleep(1000);
        }
            driver.close();
    }
}
