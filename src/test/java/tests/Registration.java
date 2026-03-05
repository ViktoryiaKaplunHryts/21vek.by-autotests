package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Registration extends BaseTest  {

    // TC-01: Успешная отправка SMS с кодом подтверждения на номер телефона
    @Test
    public void testSuccessfulRegistration() {
        String actualConfirmationTitle =  registerModal
                .clickRegisterLink()
                .enterPhoneNumber()
                .enterEmail()
                .clickButtonContinue()
                .getPhoneConfirmationTitle();

        Assert.assertEquals(actualConfirmationTitle, "Подтверждение телефона");

    }

    // TC-02: Отправка формы регистрации без заполнения обязательных полей
    @Test
    public void testRegistrationWithEmptyFields() {
        String actualClass = registerModal
                .clickRegisterLink()
                .getContinueButtonClass();

        Assert.assertEquals(actualClass,
                "Button-module__button RegistrationForm_submit__xXtrK Button-module__blue-primary Button-module__disabled");
    }
}
