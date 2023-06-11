package video04_webElements_K;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElements01_K {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https:www.amazon.com sayfasina gidin
        driver.get("https:www.amazon.com");

        //2- arama cubuguna “Nutella” yazdirin
        //önce arama cubugunu locate etmeliyim
       WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
       // WebElement aramaKutusu = driver.findElement(By.className("nav-searchbar nav-progressive-attribute")); olmadı
        aramaKutusu.sendKeys("Nutella");

        //3- Nutella yazdiktan sonra ENTER’a basarak arama islemini yapin
        aramaKutusu.submit();

        //4- Bulunan sonuc sayisini yazdirin.
        //yazdirmak için önce locate etmem gerek
        WebElement sonucyazisielementi =driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
       // simdi yazdiralim ama Webelementler obje oldugundan direkt yazdirilamaz
        //.gettext() ile yazdirilir
        System.out.println("sonucyazisielementi = " + sonucyazisielementi.getText());

        driver.close();
    }
}
