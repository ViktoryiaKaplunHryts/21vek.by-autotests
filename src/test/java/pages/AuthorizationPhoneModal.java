package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class AuthorizationPhoneModal {
    private final WebDriver driver;
    private final Properties properties;

    // Конструктор класса pages.AuthorizationPhoneModal
    public AuthorizationPhoneModal(WebDriver driver, Properties properties) {

        this.driver = driver;
        this.properties = properties;
    }

    // Выбор радиокнопки "Номер телефона"
    public AuthorizationPhoneModal selectPhoneRadioButton() {
        driver.findElement(By.cssSelector(".BaseRadioButton-module__uncheckedIcon")).click();
        return this;
    }

    // Ввод валидного номера телефона
    public AuthorizationPhoneModal enterValidPhoneNumber() {
        driver.findElement(By.cssSelector(".BaseNumberField-module__input")).sendKeys(properties.getProperty("valid_phone"));
        return this;
    }

    // Клик по кнопке "Продолжить"
    public AuthorizationPhoneModal clickButtonContinue() {
        driver.findElement(By.cssSelector(".PhoneLoginForm_actions__bE_S1 [class*='buttonText']")).click();
        return this;
    }

    // Извлечь заголовок модального окна "Подтверждение телефона"
    public String getPhoneConfirmationTitle() {
        return driver.findElement(By.cssSelector(".ConfirmationPhoneForm_title__hWunD")).getText();
    }

    // Получить значение атрибута class у кнопки "Продолжить"
    public String getContinueButtonClass() {
        return driver.findElement(By.cssSelector(".PhoneLoginForm_actions__bE_S1 button[type='submit']"))
                .getAttribute("class");
    }

    // Ввод номера телефона с недопустимыми символами (буквы, спецсимволы)
    public AuthorizationPhoneModal enterInvalidPhoneNumber() {
        driver.findElement(By.cssSelector(".BaseNumberField-module__input")).sendKeys(properties.getProperty("invalid_phone"));
        return this;
    }

    // Ввод номера с несуществующим кодом оператора
    public AuthorizationPhoneModal enterInvalidOperatorCode() {
        driver.findElement(By.cssSelector(".BaseNumberField-module__input")).sendKeys(properties.getProperty("invalid_operator_code_phone"));
        return this;
    }

    // Получить сообщение об ошибке
    public String getErrorMessagePhone() {
        return driver.findElement(By.cssSelector(".ErrorMessage-module__message")).getText();
    }
}
