import Pages.Custompage;
import Pages.Indexpage;
import org.testng.annotations.Test;

public class Assignment extends BaseTest {
    @Test
    void nicheHySelf()  {
        Indexpage indexpage=new Indexpage(driver);
        Custompage custompage=indexpage.clickOnCustom();
        custompage.tabSwitch();
        custompage.selectPreferdStay();
        custompage.selectCountry();
        custompage.selectContact();
        custompage.contactWindowSwitch();
        custompage.clickOnSubmit();


    }


}
