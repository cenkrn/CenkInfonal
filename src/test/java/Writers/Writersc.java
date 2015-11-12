package Writers;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

/* 
   - REQUIREMENTS : 3-4-6 are made. 
   - SCOPE: 1 - This tests provide pagination control. It control that is last name  
of page, lists top of second page of writers again?
            2 - Testing of Book/Writers page.
            3 - Already Logged Facebook users can enter automatically.
   
   - RESULTS: There is no defect. 
   - NOTE : Nihat Genç listed two times in both pages ;
            He has two different entry in database with different links. 
            It is a database defect not a pagination.
            
   - PRECONDITIONS: The user can be logged in Facebook.
   - I,Ç,İ,O,Ö,Q,V,W,X,Y and Z letters have one page. 
                                                                                                         */          

public class Writersc {
	private Selenium selenium;



@Before
public void setUp() throws Exception {
	selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.n11.com/");
	selenium.start();
}

// If user already logged in Facebook, the n11.com system automatically log user in. 
@Test
public void test() throws Exception {
	
// PRE-CONDITION //
	selenium.open("http://www.facebook.com/");
	selenium.type("id=email", "cenkinfonal@gmail.com");
	selenium.type("id=pass", "cenkinfonal");
	selenium.click("id=u_0_v");
	selenium.waitForPageToLoad("30000");
// PRE-CONDITION //	 
	
	selenium.open("http://www.n11.com/");
	selenium.waitForPageToLoad("30000");
	assertEquals("n11.com - Alışverişin Uğurlu Adresi", selenium.getTitle());
	selenium.click("link=Giriş Yap");
	selenium.waitForPageToLoad("30000");
	selenium.click("//form[@id='loginForm']/div[4]");
	selenium.waitForPageToLoad("30000");
	

	assertEquals("n11.com - Alışverişin Uğurlu Adresi", selenium.getTitle());
	assertTrue(selenium.isTextPresent("Kitap, Müzik, Film, Oyun"));
	selenium.mouseOver("link=Kitap, Müzik, Film, Oyun");
	selenium.click("link=Kitap, Müzik, Film, Oyun");
	selenium.open("http://www.n11.com/kitap-muzik-film-oyun");
	selenium.click("link=Kitap");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=Yazarlar");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	assertEquals("Yazarlar - Türk ve Yabancı Yazarlar - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("link=Ahmet İnam (1)"));

	selenium.click("//div[@id='brandsPaging']/div/span[3]");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	assertEquals("B ile Başlayan Yazarlar 2 - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("Bilal Civelek (1)"));
	
	selenium.click("//div[@id='brandsPaging']/div/span[4]");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	assertEquals("C ile Başlayan Yazarlar 2 - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("Cemil Kavukçu (1)"));
	
	selenium.click("//div[@id='brandsPaging']/div/span[6]");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	assertEquals("D ile Başlayan Yazarlar 2 - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("DİLA ELİF (1)"));
	
	selenium.click("//div[@id='brandsPaging']/div/span[7]");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	assertEquals("E ile Başlayan Yazarlar 2 - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("EMİLE ZOLA (1)"));
	selenium.click("//div[@id='brandsPaging']/div/span[8]");
	
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	assertEquals("F ile Başlayan Yazarlar 2 - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("FİKRİ AKYÜZ (2)"));
	
	selenium.click("//div[@id='brandsPaging']/div/span[9]");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	assertEquals("G ile Başlayan Yazarlar 2 - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("Graham Burton (1)"));
	
	selenium.click("//div[@id='brandsPaging']/div/span[10]");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	assertEquals("H ile Başlayan Yazarlar 2 - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("Hasan Kösebalaban (1)"));
	
	selenium.click("//div[@id='brandsPaging']/div/span[14]");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	assertEquals("K ile Başlayan Yazarlar 2 - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("Kevin J. Anderson (3)"));
	
	selenium.click("//div[@id='brandsPaging']/div/span[15]");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	assertEquals("L ile Başlayan Yazarlar 2 - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("Liz BEHMOARAS (1)"));
	
	selenium.click("//div[@id='brandsPaging']/div/span[16]");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	assertEquals("M ile Başlayan Yazarlar 2 - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("Marie-Sabine Roger (1)"));
	
	selenium.click("//div[@id='brandsPaging']/div/span[17]");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	assertEquals("N ile Başlayan Yazarlar 2 - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("Nihat Genç (5)"));
	
	selenium.click("//div[@id='brandsPaging']/div/span[20]");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	assertEquals("P ile Başlayan Yazarlar 2 - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("Primo Levi (1)"));
	
	selenium.click("//div[@id='brandsPaging']/div/span[22]");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	assertEquals("R ile Başlayan Yazarlar 2 - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("Roberto Tartaglione (1)"));
	
	selenium.click("//div[@id='brandsPaging']/div/span[23]");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	assertEquals("S ile Başlayan Yazarlar 2 - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("Sebastian Fitzek (1)"));
	
	selenium.click("//div[@id='brandsPaging']/div/span[25]");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=2");
	selenium.waitForPageToLoad("30000");
	selenium.selectWindow("null");
	assertEquals("T ile Başlayan Yazarlar 2 - n11.com", selenium.getTitle());
	verifyFalse(selenium.isElementPresent("Tom Egeland (1)"));
}

private void verifyFalse(boolean textPresent) {
	
	
}

@After
public void tearDown() throws Exception {
	selenium.stop();
}
}
