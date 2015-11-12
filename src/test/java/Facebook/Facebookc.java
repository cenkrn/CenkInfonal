package Facebook;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;


/*  REQUIREMENTS : 1-2. 
    SCOPE : Testing of enterance of users with their facebook accounts to site.   
                       */
public class Facebookc {

	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.n11.com/");
		selenium.start();
}

	@Test
	public void Facebook() throws Exception {
		selenium.open("http://www.n11.com/");
		selenium.click("link=Giriş Yap");
		selenium.waitForPageToLoad("30000");
		assertEquals("Giriş Yap - n11.com", selenium.getTitle());
		selenium.open("https://www.facebook.com/login.php?skip_api_login=1&api_key=1374274239476709&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fv2.2%2Fdialog%2Foauth%3Fredirect_uri%3Dhttps%253A%252F%252Fwww.n11.com%252Fsocial%252FWEB_REGULAR_FB%252FfacebookConnectCallback%26display%3Dpopup%26scope%3Demail%252Cpublic_profile%252Cuser_birthday%252Cuser_friends%252Cuser_location%252Cuser_relationship_details%252Cuser_relationships%252Cuser_work_history%26client_id%3D1374274239476709%26ret%3Dlogin&cancel_url=https%3A%2F%2Fwww.n11.com%2Fsocial%2FWEB_REGULAR_FB%2FfacebookConnectCallback%3Ferror%3Daccess_denied%26error_code%3D200%26error_description%3DPermissions%2Berror%26error_reason%3Duser_denied%23_%3D_&display=popup");
		selenium.selectWindow("null");
		selenium.type("id=email", "cenkinfonal@gmail.com");
		selenium.type("id=pass", "cenkinfonal");
		selenium.click("id=u_0_2");
		selenium.waitForPageToLoad("30000");
		selenium.open("http://www.n11.com/");
		assertEquals("n11.com - Alışverişin Uğurlu Adresi", selenium.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}