package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MusicTest  extends AbstractPage{
    public MusicTest(WebDriver driver) {
        super(driver);
    }

    private final By clickMusicTab = new By.ByXPath("//span[@class='LeftMenuItem-module__label--GaKMH']/span[text()='Музыка']");
    private final By playMusic = new By.ByXPath("//span[@class='blind_label _play_blind_label']");
    private final By printLogin = new By.ByXPath("//input[@class='VkIdForm__input']");

    private final By buttonForLogin= new By.ByXPath("//span[@class='FlatButton__content' and text()='Войти']");
    private final By buttonForPass= new By.ByXPath("//span[@class='vkuiButton__in']");

    public MusicTest Login(User user){
        WebElement withdrawlInput = WaitForElementLocatedBy(printLogin);


        withdrawlInput.sendKeys(user.getUserName());
        WebElement buttonLogin = WaitForElementLocatedBy(buttonForLogin);
        buttonLogin.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
        passwordInput.sendKeys(user.getUserCode());
        WebElement clickPass = WaitForElementLocatedBy(buttonForPass);
        clickPass.click();
        return this;
    }

    public MusicTest OpenMusicTab(){
        WebElement withdrawlMenuButton = WaitForElementLocatedBy(clickMusicTab);
        withdrawlMenuButton.click();
        try {
            Thread.sleep(6000); // Задержка в 2 секунды (время в миллисекундах)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public MusicTest PlayMusic() {

        By audioRowLocator = By.xpath("//div[@class='audio_row__inner']");
        WebElement audioRow = driver.findElement(audioRowLocator);
        audioRow.click();
        try {
            Thread.sleep(6000); // Задержка в 2 секунды (время в миллисекундах)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }



}
