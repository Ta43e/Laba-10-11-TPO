package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import service.Checker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicUserActionsInVK  extends AbstractPage {

    private static String messageText;
    private final By clickMessageTab = new By.ByXPath("//span[@class='LeftMenuItem-module__label--GaKMH']/span[text()='Мессенджер']");
    private final By clickGroupTab = new By.ByXPath("//span[@class='LeftMenuItem-module__label--GaKMH']/span[text()='Сообщества']");
    private final By clickGroup = new By.ByXPath("//a[@class='group_row_title' and text()='Пристанище Диктатора']");
    private final By buttonUnsab = new By.ByXPath("//div[@class='redesigned-group-subscribed redesigned-group-subscribed--button']");
    private final By Unsab = new By.ByXPath("//div[@class='ui_actions_menu_item page-group-action' and text()='Отписаться']");

    private final By findFriend= new By.ByXPath("//span[@class='_im_dialog_link' and text()='Ян Ответчиков']");

    private final By printMesageToFriend = new By.ByXPath("/ html / body / div[11] / div / div / div[2] / div[2] / div[3] / div / div / div[1] / div[3] / div[2] / div[4] / div[4] / div[4] / div[1] / div[4]");
    private final By sendMesageToFriend = new By.ByXPath("/html/body/div[11]/div/div/div[2]/div[2]/div[3]/div/div/div[1]/div[3]/div[2]/div[4]/div[4]/div[4]/div[1]/button/span[2]");
    private final By findMessage= new By.ByXPath("//div[@class='im-mess--text wall_module _im_log_body' and text()='Лаба 10 и 11, тестируем']");
    private final By printLogin = new By.ByXPath("//input[@class='VkIdForm__input']");

    private final By buttonForLogin= new By.ByXPath("//span[@class='FlatButton__content' and text()='Войти']");
    private final By buttonForPass= new By.ByXPath("//span[@class='vkuiButton__in']");

    public BasicUserActionsInVK Login(User user){
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

    public BasicUserActionsInVK OpenMessageTab(){
        WebElement withdrawlMenuButton = WaitForElementLocatedBy(clickMessageTab);
        withdrawlMenuButton.click();
        return this;
    }

    public BasicUserActionsInVK FindMyFriend(){
        WebElement withdrawlMenuButton = WaitForElementLocatedBy(findFriend);
        withdrawlMenuButton.click();
        return this;
    }

    public BasicUserActionsInVK PrintMessageToFriend(String amountWithdraw){
        messageText = amountWithdraw;
        WebElement withdrawlInput = WaitForElementLocatedBy(printMesageToFriend);
        withdrawlInput.sendKeys(messageText);
        return this;
    }

    public BasicUserActionsInVK SendMessageToFriend(){
        WebElement withdrawlMenuButton = WaitForElementLocatedBy(sendMesageToFriend);
        withdrawlMenuButton.click();
        return this;
    }

    public void CheckMessage(Checker checker){
        WebElement withdrawlMenuButton = WaitForElementLocatedBy(findMessage);
        withdrawlMenuButton.getText();
        checker.setValue(messageText.equals(withdrawlMenuButton.getText()));
    }
    public BasicUserActionsInVK(WebDriver driver){
        super(driver);
    }
//------------------------------------------------------------//
    public BasicUserActionsInVK OpenCommunitiesTab(){
        WebElement withdrawlMenuButton = WaitForElementLocatedBy(clickGroupTab);
        withdrawlMenuButton.click();
        try {
            Thread.sleep(3000); // Задержка в 2 секунды (время в миллисекундах)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BasicUserActionsInVK FindCommunities(){
        WebElement withdrawlMenuButton = WaitForElementLocatedBy(clickGroup);
        withdrawlMenuButton.click();
        try {
            Thread.sleep(1000); // Задержка в 2 секунды (время в миллисекундах)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BasicUserActionsInVK MenuCommunites(){

        WebElement withdrawlMenuButton = WaitForElementLocatedBy(buttonUnsab);
        withdrawlMenuButton.click();
        try {
            Thread.sleep(2000); // Задержка в 2 секунды (время в миллисекундах)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public BasicUserActionsInVK UnsabFromCommunities(){

        WebElement unsubscribeButton = driver.findElement(By.xpath("//div[contains(@class, 'ui_actions_menu_item') and contains(text(), 'Отписаться')]"));
        unsubscribeButton.click();
        try {
            Thread.sleep(2000); // Задержка в 2 секунды (время в миллисекундах)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public BasicUserActionsInVK CheckUnSub(Checker checker)
    {
        WebElement webElement = WaitForElementLocatedBy(new By.ByXPath("//span[@class='FlatButton__content']"));
        checker.setValue(webElement.getText().equals("Подписаться"));
        return this;
    }

    public BasicUserActionsInVK FindUnCommunities(){
        By elementLocator = By.className("TextClamp-module__multiLine--tG1Ox");
        WebElement element = driver.findElement(elementLocator);
        element.click();
        try {
            Thread.sleep(2000); // Задержка в 2 секунды (время в миллисекундах)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public BasicUserActionsInVK SubOnCommunities(){
        WebElement subscribeButton = WaitForElementLocatedBy(new By.ByXPath("//span[@class='FlatButton__content']"));
        subscribeButton.click();
        try {
            Thread.sleep(2000); // Задержка в 2 секунды (время в миллисекундах)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public BasicUserActionsInVK CheckSub(Checker checker)
    {
        WebElement webElement = WaitForElementLocatedBy(new By.ByXPath("//span[@class='FlatButton__content']"));
        checker.setValue(webElement.getText().equals("Подписаться"));
        return this;
    }



}
