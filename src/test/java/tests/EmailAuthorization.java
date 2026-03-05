package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailAuthorization extends BaseTest {

   // TC-01: Успешная авторизация с валидными учетными данными
    @Test
    public void testSuccessfulAuthorization() {
        String actualDashboardTitle = emailModal
                .enterValidEmail()
                .enterValidPassword()
                .clickButtonContinue()
                .getDashboardTitle();

        Assert.assertEquals(actualDashboardTitle, "Личный аккаунт");
    }

    // TC-02: Ввод неверного пароля
    @Test
    public void testInvalidPassword() {
        String actualPasswordErrorMessage = emailModal
                .enterValidEmail()
                .enterIncorrectPassword()
                .clickButtonContinue()
                .getIncorrectPasswordError();

        Assert.assertEquals(actualPasswordErrorMessage, "Неправильный пароль. \nСбросить пароль?");
    }

    // TC-03: Ввод незарегистрированного email
    @Test
    public void testUnregisteredEmail() {
        String actualEmailErrorMessage = emailModal
                .enterUnregisteredEmail()
                .enterValidPassword()
                .clickButtonContinue()
                .getIncorrectEmailError();

        Assert.assertEquals(actualEmailErrorMessage, "Проверьте электронную почту или \nзарегистрируйтесь");
    }

    // TC-04:Проверка валидации обязательных полей
    @Test
    public void testEmptyFormValidation() {
        String actualEmailValidationError = emailModal
                .clickButtonContinue()
                .getEmptyEmailError();

        String actualPasswordValidationError = emailModal.getEmptyPasswordError();

        Assert.assertEquals(actualEmailValidationError, "Электронная почта не указана");
        Assert.assertEquals(actualPasswordValidationError, "Пароль не указан");
    }

    // TC-05: Восстановление пароля
    @Test
    public void testPasswordRecovery() {
        String actualTitleModalWindow = emailModal
                .clickForgotPasswordLink()
                .enterEmailPasswordRecovery()
                .clickButtonSend()
                .getModalWindowTitle();

        Assert.assertEquals(actualTitleModalWindow, "Письмо отправлено");

    }

    // TC-06: Проверка переключения видимости пароля
    @Test
    public void testPasswordVisibilityToggle() {
        String actualFieldType = emailModal
                .enterValidPassword()
                .getPasswordFieldType();
        Assert.assertEquals(actualFieldType, "password");


        String actualFieldTypeAfterFirstClick = emailModal
                .clickPasswordVisibilityIcon()
                .getPasswordFieldType();
        Assert.assertEquals(actualFieldTypeAfterFirstClick, "text");

        String actualFieldTypeAfterSecondClick = emailModal
                .clickPasswordVisibilityIcon()
                .getPasswordFieldType();
        Assert.assertEquals(actualFieldTypeAfterSecondClick, "password");
    }

    // TC-07: Ввод email в неверном формате
    @Test
    public void testLoginWithInvalidEmailFormat() {
        String actualEmailErrorMessage = emailModal
                .enterEmailWithInvalidFormat()
                .enterValidPassword()
                .clickButtonContinue()
                .getErrorMessageForInvalidEmail();

        Assert.assertEquals(actualEmailErrorMessage, "Неправильный формат электронной почты");
    }
}

