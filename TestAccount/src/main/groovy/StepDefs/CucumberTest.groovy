package StepDefs

import pageObjects.AccountPO

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

AccountPO accountPO;

Before(){ scenario ->
    accountPO = AccountPO.newInstance();
    accountPO.openBrowser();
}

After(){ scenario ->
    accountPO.closeBrowser();
}

Given(~"I click on create account button"){ ->

    accountPO.btn_Account.click();

}


Given(~"I send an empty email and a valid password"){ ->

    accountPO.txtbx_Email.sendKeys(" ");
    accountPO.txtbx_Password.sendKeys("123456");

}


Given(~"I send a wrong email and a valid password"){ ->

    accountPO.txtbx_Email.sendKeys("qaaa ");
    accountPO.txtbx_Password.sendKeys("123456");

}



Given(~"I send an valid email but with an empty password"){ ->

    accountPO.txtbx_Email.sendKeys("qa@qa.com");
    accountPO.txtbx_Password.sendKeys(" ");

}


Given(~"I send an valid email but with a shorter password"){ ->

    accountPO.txtbx_Email.sendKeys("qa@qa.com");
    accountPO.txtbx_Password.sendKeys("12345");

}


Given(~"I send an valid email and password but with wrong captcha"){ ->

    accountPO.txtbx_Email.sendKeys("qa@qa.com");
    accountPO.txtbx_Password.sendKeys("123456");
    accountPO.txtbx_Captcha.sendKeys("koadasas");

}


When (~"I submit the user"){ ->

    accountPO.btn_CreateAccount.click();

}


Then(~"I get an error message saying (.*)"){ errorString->
    assert accountPO.getErrorMessage() == errorString;
}

