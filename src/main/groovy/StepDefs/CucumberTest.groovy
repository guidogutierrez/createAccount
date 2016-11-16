package StepDefs

import cucumber.api.PendingException
import cucumber.api.java.en.Given
import groovy.BrowserTools

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

BrowserTools b =  new BrowserTools();

url="http://account-regression-1567302699.us-east-1.elb.amazonaws.com/";
accountButton="Create Account";
submitButton="commit";
email="user_email";
password="user_password";
error="flash_error";
captcha="recaptcha_response_field";

Given(~"I navigate to main page"){ ->

    b.openBrowser(url);
}

Given(~"I click on create account button"){ ->

    b.pressButton(accountButton);


}

Given(~"I send an empty email and a valid password"){ ->

    b.fillEmailField(email, " ");
    b.fillPasswordField(password, "123456");

}

Given(~"I send a wrong email and a valid password"){ ->

    b.fillEmailField(email, "qaa ");
    b.fillPasswordField(password, "123456");

}



Given(~"I send an valid email but with an empty password"){ ->


    b.fillPasswordField(email, "qatest@qa.com");
    b.fillPasswordField(password, "");

}


Given(~"I send an valid email but with a shorter password"){ ->


    b.fillPasswordField(email, "qatest@qa.com");
    b.fillPasswordField(password, "12345");

}


Given(~"I send an valid email and password but with wrong captcha"){ ->

    b.fillPasswordField(email, "qatest@qa.com");
    b.fillPasswordField(password, "123456");
    b.fillPasswordField(captcha, "koadncak");

}



When (~"I submit the user"){ ->

    b.submitButton(submitButton);

}

Then(~"I get an error message"){ ->

      b.errorMessage(error);

}


