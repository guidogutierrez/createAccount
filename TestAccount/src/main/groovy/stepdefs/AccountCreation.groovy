package stepdefs

import pageobjects.AccountPO

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
    accountPO.clickCreateAccount();
}


Given(~"I enter an empty email and a valid password"){ ->

    accountPO.setEmail(" ");
    accountPO.setPassword("123456");

}


Given(~"I enter a wrong email and a valid password"){ ->

    accountPO.setEmail("qaaa ");
    accountPO.setPassword("123456");

}



Given(~"I enter an valid email but with an empty password"){ ->

    accountPO.setEmail("qa@qa.com");
    accountPO.setPassword(" ");

}


Given(~"I enter an valid email but with a shorter password"){ ->

    accountPO.setEmail("qa@qa.com");
    accountPO.setPassword("12345");

}


Given(~"I enter an valid email and password but with wrong captcha"){ ->

    accountPO.setEmail("qa@qa.com");
    accountPO.setPassword("123456");
    accountPO.setCaptcha("koadasas");

}


When (~"I submit the user"){ ->

    accountPO.submitUser();

}


Then(~"I get an error message saying (.*)"){ errorString->
    assert accountPO.getErrorMessage() == errorString;
}

