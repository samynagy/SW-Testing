import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestWithTestNG {
    WebDriver driver;
    XSSFSheet sheet;
    XSSFWorkbook wb;
    FileInputStream fis;
    int count;
    @BeforeTest
    public void open() throws IOException {
        File f = new File("C:\\Users\\user\\Desktop\\test1.xlsx");
        /// / open the file located in the previous path
         fis = new FileInputStream(f);
        /// open the workbook in the file
         wb = new XSSFWorkbook(fis);;
        /// select a specific sheet to work on it
         sheet = wb.getSheet("Sheet1");
        ///  find the number of rows that actually have data
         count = sheet.getPhysicalNumberOfRows();

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
         driver = new ChromeDriver();
        driver.get("C:\\Users\\user\\Downloads\\responsive-registration-form-in-html-css\\registration-form\\index.html");

    }
    @Test
    public  void test() throws InterruptedException {
        for (int i = 0; i <count; i++) {
            String FirstName_URL = "/html/body/div/div[2]/form/div[1]/div[1]/input";
            String FirstName = sheet.getRow(i).getCell(0).getStringCellValue();
          driver.findElement(By.xpath(FirstName_URL)).clear();

           driver.findElement(By.xpath(FirstName_URL)).sendKeys(FirstName);

            String UserName_URL = "/html/body/div/div[2]/form/div[1]/div[2]/input";
            String UserName = sheet.getRow(i).getCell(1).getStringCellValue();
            driver.findElement(By.xpath(UserName_URL)).clear();

           driver.findElement(By.xpath(UserName_URL)).sendKeys(UserName);

            String Email_URL = "/html/body/div/div[2]/form/div[1]/div[3]/input";
            String Email = sheet.getRow(i).getCell(2).getStringCellValue();
            driver.findElement(By.xpath(Email_URL)).clear();
            ;
            driver.findElement(By.xpath(Email_URL)).sendKeys(Email);

            String PhoneNmuber_URL = "/html/body/div/div[2]/form/div[1]/div[4]/input";
            String PhoneNmuber ="0"+sheet.getRow(i).getCell(3).getStringCellValue().substring(0,10);
            System.out.println(PhoneNmuber);
            driver.findElement(By.xpath(PhoneNmuber_URL)).clear();
            driver.findElement(By.xpath(PhoneNmuber_URL)).sendKeys(PhoneNmuber);

            String Password_URL = "/html/body/div/div[2]/form/div[1]/div[5]/input";
            String Password = sheet.getRow(i).getCell(4).getStringCellValue();;
            driver.findElement(By.xpath(Password_URL)).clear();
            ;
            driver.findElement(By.xpath(Password_URL)).sendKeys(Password);
           String ConfirmPassword_URL = "/html/body/div/div[2]/form/div[1]/div[6]/input";
            driver.findElement(By.xpath(ConfirmPassword_URL)).clear();
            ;
            driver.findElement(By.xpath(ConfirmPassword_URL)).sendKeys(Password);

            /// Gender section
            String type = sheet.getRow(i).getCell(5).getStringCellValue();;
            String male = "/html/body/div/div[2]/form/div[2]/div/label[1]/span[1]";
            String female = "/html/body/div/div[2]/form/div[2]/div/label[2]/span[1]";
            String Gender_URL = ((type.length()>4) ? female : male);
            driver.findElement(By.xpath(Gender_URL)).click();
            ;
            Thread.sleep(2000);
            String Rigester_URL = "/html/body/div/div[2]/form/div[3]/input";
            driver.findElement(By.xpath(Rigester_URL)).click();
            Thread.sleep(2000);
        }


//        /// BirthDate Section
//        /// day
//        String day_URL = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[2]/div[2]/span/span/select[1]";
//        Select day_drop = new Select(driver.findElement(By.xpath(day_URL)));
//        String day_value = "4";
//        day_drop.selectByVisibleText(day_value);
//        ///  month
//        String month_URL = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[2]/div[2]/span/span/select[2]";
//        Select month_drop = new Select(driver.findElement(By.xpath(month_URL)));
//        String month_value = "Mar";
//        month_drop.selectByVisibleText(month_value);
//
//        ///  year
//        String year_URL = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[2]/div[2]/span/span/select[3]";
//        Select year_drop = new Select(driver.findElement(By.xpath(year_URL)));
//        String year_value = "1996";
//        year_drop.selectByVisibleText(year_value);
//
//        /// Gender section
//        String type = "female";
//        String male = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[4]/span/span[2]/label";
//        String female = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[4]/span/span[1]/label";
//        String Gender_URL = ((type.charAt(0) == 'f') ? female : male);
//        driver.findElement(By.xpath(Gender_URL)).click();
//        ;
//
//        /// email section
//        String Email_URL = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[6]/div/div[1]/input";
//        String Email_value = "smith@gmail.com";
//        driver.findElement(By.xpath(Email_URL)).clear();
//        ;
//        driver.findElement(By.xpath(Email_URL)).sendKeys(Email_value);
//        ;
//
//        /// password Section
//        String Password_URL = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[8]/div/div[1]/input";
//        String Password_value = "smith@12578_";
//        driver.findElement(By.xpath(Password_URL)).clear();
//        ;
//        driver.findElement(By.xpath(Password_URL)).sendKeys(Password_value);
//
//        /// sign in Section
//        String signin_URL = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[11]/button";
//        driver.findElement(By.xpath(signin_URL)).click();;
//        Thread.sleep(1000);
    }
    @AfterTest
    public void close() throws IOException, InterruptedException {
        Thread.sleep(5000);
        driver.close();
        wb.close();
        fis.close();


    }
}



