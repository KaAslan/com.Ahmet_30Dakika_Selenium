package video04_webElements_K;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElements02_K {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.facebook.com adresine gidin
        driver.get("https:www.facebook.com");
        // cookies cikarsa kabul et butonuna basin
        //driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();

        // e-posta kutusuna rastgele bir mail girin
        WebElement epostaKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        epostaKutusu.sendKeys("ydgfkshd");
     // sifre kismina rastgele bir sifre girin
        WebElement sifreKutusu = driver.findElement(By.xpath("//input[@id='pass']"));
        sifreKutusu.sendKeys("Hlkiujhgtrf");

        // giris yap butonuna basin
        driver.findElement(By.xpath("//button[@name='login']")).click();

        // uyari olarak "The email or mobile number you entered isn’t connected to an account. Find your account and log in."
        //  mesajinin ciktigini test edin
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String expectedSonucYazisi = "Girdiğin e-posta veya cep telefonu numarası bir hesaba bağlı değil. Hesabını bul ve giriş yap.";
        String actualSonucYazisi= sonucYazisi.getText();
        if ( expectedSonucYazisi.equals(actualSonucYazisi)){
            System.out.println("girilemedi testi PASSED");
        }else {
            System.out.println("girilemedi testi FAILED");
        }
       // sayfayi kapatin
        driver.close();
    }
}
