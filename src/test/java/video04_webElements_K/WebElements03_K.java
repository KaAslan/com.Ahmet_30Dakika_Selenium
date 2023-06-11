package video04_webElements_K;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebElements03_K {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));

        // 1- https://www.bestbuy.com adresine gidin
        driver.get("https://www.bestbuy.com");

        // 2- cookies cikarsa kabul et butonuna basin

        // 3- sayfada kac adet button bulundugunu yazdirin
        List<WebElement> buttonListesi = driver.findElements(By.tagName("button"));
        // kaç tane oldugunu listenin uzunlugundan bulabilirim
        System.out.println(buttonListesi.size()); //3

        // 4- sayfadaki herbir button uzerindeki yazilari yazdirin
        for (WebElement each : buttonListesi) {
            System.out.println(each.getText());
        } //English Français  Español
    }
}