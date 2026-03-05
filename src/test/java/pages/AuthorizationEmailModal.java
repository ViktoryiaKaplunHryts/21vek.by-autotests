package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AuthorizationEmailModal {
    private final WebDriver driver;
    private final Properties properties;

    // Конструктор класса pages.AuthorizationEmailModal
    public AuthorizationEmailModal(WebDriver driver, Properties properties) {
        this.driver = driver;
        this.properties = properties;
    }

    // Ввод валидного email
    public AuthorizationEmailModal enterValidEmail() {
        driver.findElement(By.cssSelector("#login-email")).sendKeys(properties.getProperty("valid_email"));
        return this;
    }

    // Ввод валидного пароля
    public AuthorizationEmailModal enterValidPassword() {
        driver.findElement(By.cssSelector("#login-password")).sendKeys(properties.getProperty("valid_password"));
        return this;
    }

    // Клик по кнопке "Продолжить"
    public AuthorizationEmailModal clickButtonContinue() {
        driver.findElement(By.cssSelector("div[class*=EmailLoginForm] button[class*=blue-primary]")).click();
        return this;
    }

    // Получить заголовок личного кабинета
    public String getDashboardTitle() {
        driver.findElement(By.cssSelector(".styles_userToolsToggler__c2aHe")).click();// Открыть меню аккаунта пользователя
        return driver.findElement(By.cssSelector(".userToolsTitle")).getText();
    }

    // Ввод неправильного пароля
    public AuthorizationEmailModal enterIncorrectPassword() {
        driver.findElement(By.cssSelector("#login-password")).sendKeys(properties.getProperty("incorrect_password"));
        return this;
    }

    // Получить сообщение об ошибке для поля пароля (ввод неправильного пароля)
    public String getIncorrectPasswordError() {
        return driver.findElement(By.cssSelector(".ErrorMessageLink_container__7D0yM")).getText();
    }

    // Ввод незарегистрированного email
    public AuthorizationEmailModal enterUnregisteredEmail() {
        driver.findElement(By.cssSelector("#login-email")).sendKeys(properties.getProperty("unregistered_email"));
        return this;
    }

    // Получить сообщение об ошибке для поля email (ввод незарегистрированного email)
    public String getIncorrectEmailError() {
        return driver.findElement(By.cssSelector(".ErrorMessage-module__message")).getText();
    }

    // Получить ошибку валидации поля email
    public String getEmptyEmailError() {
        return driver.findElement(By.cssSelector(".FieldWrapper-module__wrapper:nth-child(1) .ErrorMessage-module__error"))
                .getText();
    }

    // Получить ошибку валидации поля password
    public String getEmptyPasswordError() {
        return driver.findElement(By.cssSelector(".FieldWrapper-module__wrapper:nth-child(2) .ErrorMessage-module__error"))
                .getText();
    }

    // Клик по ссылке "Забыли пароль?"
    public AuthorizationEmailModal clickForgotPasswordLink() {
        driver.findElement(By.cssSelector(".LinkButton-module__small")).click();
        return this;
    }

    // Ввод зарегистрированного email в форму восстановления пароля
    public AuthorizationEmailModal enterEmailPasswordRecovery() {
        driver.findElement(By.cssSelector("#reset-password-email")).sendKeys(properties.getProperty("valid_email"));
        return this;
    }

    // Клик по кнопке "Отправить"
    public AuthorizationEmailModal clickButtonSend() {
        driver.findElement(By.cssSelector("div[class*=Form-module] div[class*=Button-module]")).click();
        return this;
    }

    // Получить заголовок модального окна при восстановлении пароля
    public String getModalWindowTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='SuccessScreen_successTitle']")));
        return driver.findElement(By.cssSelector("[class*='SuccessScreen_successTitle']")).getText();
    }

    // Переключение видимости пароля
    public AuthorizationEmailModal clickPasswordVisibilityIcon() {
        driver.findElement(By.cssSelector("div.BaseInput-module__icon span.SvgIcon-module__base")).click();
        return this;
    }

    // Получить значение атрибута type поля ввода пароля
    public String getPasswordFieldType() {
        return driver.findElement(By.cssSelector("#login-password")).getAttribute("type");
    }

    // Ввод email в неверном формате
    public AuthorizationEmailModal enterEmailWithInvalidFormat() {
        driver.findElement(By.cssSelector("#login-email")).sendKeys(properties.getProperty("invalid_email"));
        return this;
    }

    // Получить сообщение об ошибке для поля Email (неверный формат)
    public String getErrorMessageForInvalidEmail() {
        return driver.findElement(By.cssSelector(".ErrorMessage-module__message")).getText();
    }
}
