package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PhoneAuthorization extends BaseTest {

    // TC-01: Успешная отправка SMS на валидный номер телефона
    @Test
    public void testSuccessfulAuthByPhone() {
        String actualConfirmationTitle = phoneModal
                .selectPhoneRadioButton()
                .enterValidPhoneNumber()
                .clickButtonContinue()
                .getPhoneConfirmationTitle();

        Assert.assertEquals(actualConfirmationTitle, "Подтверждение телефона");
    }

    // TC-02: Авторизация с пустым полем "Номер телефона"
    @Test
    public void testEmptyPhoneField() {
        String continueButtonClass = phoneModal
                .selectPhoneRadioButton()
                .getContinueButtonClass();

        Assert.assertEquals(continueButtonClass,
                "Button-module__button Button-module__blue-primary Button-module__disabled");
    }

    // TC-03: Ввод букв и спецсимволов в поле номера телефона
    @Test
    public void testPhoneInvalidChars() {
        String continueButtonClass = phoneModal
                .selectPhoneRadioButton()
                .enterInvalidPhoneNumber()
                .getContinueButtonClass();

        Assert.assertEquals(continueButtonClass,
                "Button-module__button Button-module__blue-primary Button-module__disabled");
    }

    // TC-04: Ввод номера с несуществующим кодом оператора
    @Test
    public void testInvalidOperatorCode() {
        String actualErrorMessage = phoneModal
                .selectPhoneRadioButton()
                .enterInvalidOperatorCode()
                .clickButtonContinue()
                .getErrorMessagePhone();

        Assert.assertEquals(actualErrorMessage, "Укажите стандартный код оператора");
    }
}

