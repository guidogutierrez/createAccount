package StepDefs

import pageObjects.Account_POF

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


Given(~"I navigate to main page"){ ->

    Account_POF.instance.openBrowser();
}


Given(~"I click on create account button"){ ->

    Account_POF.instance.btn_Account.click();

}


Given(~"I send an empty email and a valid password"){ ->

    Account_POF.instance.txtbx_Email.sendKeys(" ");
    Account_POF.instance.txtbx_Password.sendKeys("123456");

}


Given(~"I send a wrong email and a valid password"){ ->

    Account_POF.instance.txtbx_Email.sendKeys("qaaa ");
    Account_POF.instance.txtbx_Password.sendKeys("123456");

}



Given(~"I send an valid email but with an empty password"){ ->

    Account_POF.instance.txtbx_Email.sendKeys("qa@qa.com");
    Account_POF.instance.txtbx_Password.sendKeys(" ");

}


Given(~"I send an valid email but with a shorter password"){ ->

    Account_POF.instance.txtbx_Email.sendKeys("qa@qa.com");
    Account_POF.instance.txtbx_Password.sendKeys("12345");

}


Given(~"I send an valid email and password but with wrong captcha"){ ->

    Account_POF.instance.txtbx_Email.sendKeys("qa@qa.com");
    Account_POF.instance.txtbx_Password.sendKeys("123456");
    Account_POF.instance.txtbx_Captcha.sendKeys("koadasas");

}


When (~"I submit the user"){ ->

    Account_POF.instance.btn_CreateAccount.click();

}


Then(~"I get an error message"){ ->

    Account_POF.instance.checkError();

}

And(~"I close the browser"){ ->

    Account_POF.instance.closeBrowser();

}

