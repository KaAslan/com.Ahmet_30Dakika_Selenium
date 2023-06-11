package video05_junitFramework_K;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BeforeClass_AfterClass_Notasyonlari_K {

    /*
     Olusturdugumuz test class'inin icindeki test method'lari
     hep ayni web sitesi ile ilgili ise her seferinde yeniden driver olusturmaya
     ve her method icin bu driver'i kapatmaya gerek yoktur
     Class'in basinda bir kere setup calisip, en sonda kapansa olur
     dersek @BeforeClass ve @AfterClass kullaniriz

  */

    static WebDriver driver;
    /*
    WebDriver driver i burda calıstırdık (gökteki ay gibi ) çünkü
      public static void  setUp() içinde çalıssa local variable olacaktı ve sadece bu methodda çalısacaktı.
    ve diğer methodlarda çalısmayacaktı
     */
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
    @Test
    public void test02(){
        driver.get("https:www.bestbuy.com");

    }
    @Test
    public void test03(){
        driver.get("https:www.facebook.com");

    }
}

