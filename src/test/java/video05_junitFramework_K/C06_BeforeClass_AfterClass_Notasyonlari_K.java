package video05_junitFramework_K;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_BeforeClass_AfterClass_Notasyonlari_K {
     /*
     Olusturdugumuz test class'inin icindeki test method'lari
     hep ayni web sitesi ile ilgili ise her seferinde yeniden driver olusturmaya
     ve her method icin bu driver'i kapatmaya gerek yoktur
     Class'in basinda bir kere setup calisip, en sonda kapansa olur
     dersek @BeforeClass ve @AfterClass kullaniriz

  */

    static WebDriver driver;
    @BeforeClass

    public static void  setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
    }


    @AfterClass
    public static void  tearDown() {
        driver.close();
    }


    @Test
    public void test01(){
        driver.get("https:www.amazon.com");

    }
    @Test @Ignore

    //bu metodu çalıştırmayacak

    public void test02(){
        driver.get("https:www.bestbuy.com");

    }
    @Test
    public void test03(){
        driver.get("https:www.facebook.com");

    }
}
