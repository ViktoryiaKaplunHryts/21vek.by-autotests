package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AuthorizationEmailModal;
import pages.AuthorizationPhoneModal;
import pages.RegistrationModal;

import java.io.IOException;
import java.time.Duration;
import java.lang.reflect.Method;
import java.util.Properties;


public abstract class BaseTest {
    protected WebDriver driver;
    protected AuthorizationEmailModal emailModal;
    protected AuthorizationPhoneModal phoneModal;
    protected RegistrationModal registerModal;
    protected Properties properties;

    /**
     * Метод, выполняемый перед КАЖДЫМ тестовым методом.
     * Инициализирует браузер, открывает сайт и создает страницы авторизации
     */

    @BeforeMethod
    protected void beforeMethod(Method method) throws IOException {
        properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("test-data.properties"));

        // Автоматическая загрузка и настройка ChromeDriver через WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Создание объекта для дополнительных настроек браузера Chrome
        ChromeOptions options = new ChromeOptions();

        // Запускаем браузер Chrome с настроенными опциями
        driver = new ChromeDriver(options);

        // Настройка неявных ожиданий
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Разворачиваем окно браузера на весь экран
        driver.manage().window().maximize();

        // Открываем главную страницу сайта
        driver.get("https://www.21vek.by");

        // Принимаем cookies
        driver.findElement(By.cssSelector("div[class*=AgreementCookie] button[class*=blue-primary]")).click();

        // Открыть меню аккаунта пользователя
        driver.findElement(By.cssSelector(".styles_userToolsToggler__c2aHe")).click();

        // Открыть форму авторизации
        driver.findElement(By.cssSelector("div[class=userToolsBtnContainer] button[class*=blue-primary]")).click();

        // Инициализируем объекты страниц авторизации и регистрации
        emailModal = new AuthorizationEmailModal(driver, properties);
        phoneModal = new AuthorizationPhoneModal(driver, properties);
        registerModal = new RegistrationModal(driver, properties);
    }

    /**
     * Метод, выполняемый после КАЖДОГО тестового метода.
     * Закрывает браузер и освобождает ресурсы
     */

    @AfterMethod
    protected void afterMethod(Method method) {
        driver.quit();
    }
}