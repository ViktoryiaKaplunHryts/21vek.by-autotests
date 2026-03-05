package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Properties;


public class RegistrationModal {
    private final WebDriver driver;
    private final Properties properties;

    // Конструктор класса pages.RegistrationModal
    public RegistrationModal(WebDriver driver, Properties properties) {
        this.driver = driver;
        this.properties = properties;
    }

    // Клип по кнопке "Регистрация"
    public RegistrationModal clickRegisterLink() {
        driver.findElement(By.xpath("(//button[text()='Регистрация'])[2]")).click();
        return this;
    }

    // Ввод номера телефона
    public RegistrationModal enterPhoneNumber() {
        driver.findElement(By.cssSelector(".BaseNumberField-module__input")).sendKeys(properties.getProperty("phone"));
        return this;
    }

    // Ввод email
    public RegistrationModal enterEmail() {
        driver.findElement(By.cssSelector("input[label='Электронная почта']")).sendKeys(properties.getProperty("email"));
        return this;
    }

    // Клик по кнопке Продолжить
    public RegistrationModal clickButtonContinue() {
        driver.findElement(By.cssSelector(".RegistrationForm_submit__xXtrK")).click();
        return this;
    }

    // Получить заголовок модального окна "Подтверждение телефона"
    public String getPhoneConfirmationTitle() {
        return driver.findElement(By.cssSelector(".ConfirmationPhoneForm_title__hWunD")).getText();
    }

    // Получить значение атрибута class кнопки "Продолжить"
    public String getContinueButtonClass() {
        return driver.findElement(By.cssSelector(".RegistrationForm_actions__hO2yY button[type='submit']"))
                .getAttribute("class");
    }
}
