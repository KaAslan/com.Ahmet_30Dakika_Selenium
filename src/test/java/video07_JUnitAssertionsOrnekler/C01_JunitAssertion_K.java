package video07_JUnitAssertionsOrnekler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.WatchEvent;
import java.time.Duration;

public class C01_JunitAssertion_K {
    @Test
    public void test01(){
        //Test Durumu 5: Kullanıcıyı mevcut e-posta ile kaydedin

        //1. Launch browser --> 1. Tarayıcıyı başlatın
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));

        //2. Navigate to url 'http://automationexercise.com'--> 2. 'http://automationexercise.com' URL'sine gidin
         driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully -->3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement logoelementi =driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoelementi.isDisplayed());

        //4. Click on 'Signup / Login' button -->4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        WebElement signupLinki = driver.findElement(By.xpath("//a[@href='/login']"));
        signupLinki.click();

        //5. Verify 'Login to your account' is visible --> 5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        WebElement loginyaziElementi=driver.findElement(By.xpath("//h2[text()='Login to your account']"));
       // görünür olduğunu doğrulamak için
        Assert.assertTrue(loginyaziElementi.isDisplayed());


        /*

        //6. Enter correct email address and password --> 6. Adı ve kayıtlı e-posta adresini girin
        WebElement emailAdresKutusu = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailAdresKutusu.sendKeys("ahmet@nehaber.com");

        WebElement paswordKutusu = driver.findElement(By.xpath("//input[@type='password']"));
        paswordKutusu.sendKeys("12345");


       //7. Click 'login' button --> 7. 'Kaydol' düğmesini tıklayın
       driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        //8. Verify that 'Logged in as username' is visible --> 8. 'E-posta Adresi zaten mevcut!' hatasını doğrulayın. görünür
       WebElement loggedInYazisi= driver.findElement(By.xpath("//a[text()=' Logged in as '] "));
       Assert.assertTrue(loggedInYazisi.isDisplayed());

       //9. Click 'Logout' button -->
        driver.findElement(By.xpath("//a[text()=' Logout'] ")).click();
       */


        //10. Verify that user is navigated to login page -->
        String expectedUrl="https://automationexercise.com/login";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

         //11. Close driver -->
        driver.close();
    }
}
