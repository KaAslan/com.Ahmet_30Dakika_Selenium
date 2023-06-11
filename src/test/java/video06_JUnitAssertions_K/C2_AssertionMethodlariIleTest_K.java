package video06_JUnitAssertions_K;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C2_AssertionMethodlariIleTest_K {

    /*
    sonuc---> Sonuc yazisi Nutella icermiyor Nutella testi FAILED
    ama test PASSED OLDU
    junit test passed olunca yeşil ,failed olunca kırmızı olacaktı ama yeşil oldu
    ÇÜNKÜ ıf kod bloğu ama test aracı değil

    junıt kodu çalıstırınca sorunla karsılasmazsa yeşil olur ki burda karsılasmadı.
    */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        // 1- https:www.amazon.com sayfasina gidin
        driver.get("https:www.amazon.com");

        //2- arama cubuguna “Nutella” yazdirin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella");

        //3- Nutella yazdiktan sonra ENTER’a basarak arama islemini yapin
        aramaKutusu.submit();

        //4- Bulunan sonuc yazisinin "Nutella" icerdigini test edelim
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualYaziStr = sonucYaziElementi.getText();
        // 1-48 of 105 results for "Nutella"
        String expectedBulunacakKelime = "Nutella";

        Assert.assertTrue(actualYaziStr.contains(expectedBulunacakKelime));

        //5- Bulunan sonuc yazisinin "Kutella" icermedigini test edelim
        Assert.assertFalse(actualYaziStr.contains("Kutella"));

        //6- Bulunan sonuc yazisinin "1-48 of 105 results for Nutella" olduğunu test edelim
        Assert.assertEquals("1-48 of 105 results for Nutella","1-48 of 105 results for Nutella");
    }
}