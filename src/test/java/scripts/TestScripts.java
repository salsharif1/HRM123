package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generic.BasePage;
import generic.BaseTest;
import generic.Excel;
import generic.GenericUtils;
import pom.HomePage;

public class TestScripts extends BaseTest {
	@Test(enabled=true)
	public void testCreateEmployee() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage p = new HomePage(driver);
		p.setUserName(Excel.readData("Sheet1", 0, 1));
		p.setPwd(Excel.readData("Sheet1", 1, 1));
		p.clickLogin();
		BasePage.verifyTitle("OrangeHRM");
		p.clickPim();
		p.clickAddEmp();
		p.setFirstName("Adithya");
		p.setLastName("Kadri");
		p.clickSaveBtn();
		//Thread.sleep(2000);
		
	}
	@Test(enabled=true)
	public void testSortListBox() throws EncryptedDocumentException, IOException {
		HomePage p = new HomePage(driver);
		p.setUserName(Excel.readData("Sheet1", 0, 1));
		p.setPwd(Excel.readData("Sheet1", 1, 1));
		p.clickLogin();
		BasePage.verifyTitle("OrangeHRM");
		p.clickPim();
		p.clickEmpList(); 
		GenericUtils.sortListBox(driver.findElement(By.xpath("//select[@id='empsearch_job_title']")));
	}
}
