package hooks;

import Page.AbstractPage;
import Util.Singleton;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


import lombok.extern.log4j.Log4j2;
import stepDefinition.AbstractStepDef;

import static Actions.Action.takeScreenshot;

@Log4j2
public class Hooks extends AbstractStepDef {
    @Before("@UI")
    public void beforeUITest(){
        driver = Singleton.getDriver();
        driver.manage().window().maximize();
    }

    @After("@UI")
    public void afterUITest(){
        Singleton.closeDriver();
    }

    @AfterStep("@UI")
    public void takeScreenShot(Scenario scenario) {
        log.info("take a screenshot before steps");
        takeScreenshot(scenario, driver);

    }
//    @Before("@Excel")
//    public void startExcel(){
//        log.info("start connection to Excel file ");
//        new ExcelUtil().connectionToExcelFile();
//        testDataFromExcelFile();
//   }
}
