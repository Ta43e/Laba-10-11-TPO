package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserProfileTest extends AbstractPage {

    private final By clickProfilTab = new By.ByXPath("//span[@class='LeftMenuItem-module__label--GaKMH']/span[text()='Моя страница']");
    private final By playMusic = new By.ByXPath("//span[@class='blind_label _play_blind_label']");
    private final By printLogin = new By.ByXPath("//input[@class='VkIdForm__input']");

    private final By buttonForLogin= new By.ByXPath("//span[@class='FlatButton__content' and text()='Войти']");
    private final By buttonForPass= new By.ByXPath("//span[@class='vkuiButton__in']");

    public UserProfileTest(WebDriver driver) {
        super(driver);
    }

    public UserProfileTest Login(User user){
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

    public UserProfileTest OpenProfileTab(){
        WebElement withdrawlMenuButton = WaitForElementLocatedBy(clickProfilTab);
        withdrawlMenuButton.click();
        try {
            Thread.sleep(2000); // Задержка в 2 секунды (время в миллисекундах)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public UserProfileTest LikeThePost(){
        By likeButtonLocator = By.xpath("//div[@class='PostBottomAction PostBottomAction--withBg PostButtonReactions PostButtonReactions--post PostBottomAction--empty']");
        WebElement likeButton = driver.findElement(likeButtonLocator);
        likeButton.click();
        try {
            Thread.sleep(6000); // Задержка в 2 секунды (время в миллисекундах)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public UserProfileTest UnLikeThePost(){
        By unlikeButtonLocator = By.xpath("//div[contains(@class, 'PostButtonReactions--active')]");
        WebElement unlikeButton = driver.findElement(unlikeButtonLocator);
        unlikeButton.click();
        try {
            Thread.sleep(6000); // Задержка в 2 секунды (время в миллисекундах)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }



}
