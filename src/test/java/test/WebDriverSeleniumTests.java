package test;

import page.BasicUserActionsInVK;
import page.MusicTest;
import page.UserProfileTest;
import service.Checker;
import service.UserCreator;
import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import util.TestListener;

@Listeners({TestListener.class})
public class WebDriverSeleniumTests {
    private static WebDriver DRIVER;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        DRIVER = DriverSingleton.getDriver();
        DRIVER.get("https://vk.com/feed");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        DriverSingleton.closeDriver();
    }

    @Test
    public void SendMessageToFriend(){
        Checker checker = new Checker();
        UserCreator userCreator = new UserCreator();
         new BasicUserActionsInVK(DRIVER).
                 Login(userCreator.WithCredentialsFromProperty()).
                 OpenMessageTab().
                 FindMyFriend().
                 PrintMessageToFriend("Лаба 10 и 11, тестируем").
                 SendMessageToFriend().
                 CheckMessage(checker);
        Assert.assertTrue(checker.getValue(), String.valueOf(true));
    }

    @Test
    public void UnSubFromCommuniteis(){
        Checker checker = new Checker();
        UserCreator userCreator = new UserCreator();

        new BasicUserActionsInVK(DRIVER).
                Login(userCreator.WithCredentialsFromProperty()).
                OpenCommunitiesTab().
                FindCommunities().
                MenuCommunites().
                UnsabFromCommunities().
                CheckUnSub(checker);
        Assert.assertTrue(checker.getValue());
    }

    @Test
    public void MusicHear(){
        Checker checker = new Checker();
        UserCreator userCreator = new UserCreator();

        new MusicTest(DRIVER).
                Login(userCreator.WithCredentialsFromProperty()).
                OpenMusicTab().
                PlayMusic();
        Assert.assertTrue(true);
    }

    @Test
    public void UserProfileTestLike(){
        Checker checker = new Checker();
        UserCreator userCreator = new UserCreator();

        new UserProfileTest(DRIVER).
                Login(userCreator.WithCredentialsFromProperty()).
                OpenProfileTab().
                LikeThePost();

        Assert.assertTrue(true);
    }
    @Test
    public void SubFromCommuniteis() {
        Checker checker = new Checker();
        UserCreator userCreator = new UserCreator();

        new BasicUserActionsInVK(DRIVER).
                Login(userCreator.WithCredentialsFromProperty()).
                OpenCommunitiesTab().
                FindUnCommunities().
                SubOnCommunities().
                CheckSub(checker);
        Assert.assertFalse(checker.getValue());
    }
    @Test
    public void UserProfileTestUnLike(){
        Checker checker = new Checker();
        UserCreator userCreator = new UserCreator();

        new UserProfileTest(DRIVER).
                Login(userCreator.WithCredentialsFromProperty()).
                OpenProfileTab().
                UnLikeThePost();

        Assert.assertTrue(true);
    }
    @Test
    public void Repost(){
        Checker checker = new Checker();
        UserCreator userCreator = new UserCreator();
        new BasicUserActionsInVK(DRIVER).
                Login(userCreator.WithCredentialsFromProperty()).
                OpenMessageTab().
                FindMyFriend().
                PrintMessageToFriend("Лаба 10 и 11, тестируем").
                SendMessageToFriend().
                CheckMessage(checker);
        Assert.assertTrue(checker.getValue(), String.valueOf(true));
    }
    @Test
    public void RepostUn() {
        Checker checker = new Checker();
        UserCreator userCreator = new UserCreator();

        new BasicUserActionsInVK(DRIVER).
                Login(userCreator.WithCredentialsFromProperty()).
                OpenCommunitiesTab().
                FindUnCommunities().
                SubOnCommunities().
                CheckSub(checker);
        Assert.assertFalse(checker.getValue());
    }
    @Test
    public void SendMessageToFriendToo(){
        Checker checker = new Checker();
        UserCreator userCreator = new UserCreator();
        new BasicUserActionsInVK(DRIVER).
                Login(userCreator.WithCredentialsFromProperty()).
                OpenMessageTab().
                FindMyFriend().
                PrintMessageToFriend("Лаба 10 и 11, тестируем").
                SendMessageToFriend().
                CheckMessage(checker);
        Assert.assertTrue(checker.getValue(), String.valueOf(true));
    }
 }
