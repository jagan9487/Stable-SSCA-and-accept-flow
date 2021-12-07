package com.everi.stepdefinitions;


import com.everi.pages.Acceptapplication_page;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class Acceptapplicationsteps {

      Acceptapplication_page accept= new Acceptapplication_page();

    @Then("Accept application in CCI client")
    public void Accept_application() throws IOException {
          accept.launch_application();
          accept.login_application();
          accept.click_creditapplication();
          accept.click_searchicon();
          accept.type_applicationId();
          accept.click_submit();
          accept.select_application();
          accept.navigate_applicationtab();
          accept.accept_application();
          accept.click_yes();
          accept.verify_accept_done();
          accept.click_ok();


    }

}
