package com.everi.pages;

import com.everi.Helper.GlobalVariables;
import com.everi.Test.ProjectGlobalVariables;
import org.junit.Assert;

public class Verification {

    String requesttype;
    String Arrivaldate;
    String referred;
    String applicationtype;
    String tripoccasssion;
    String cardno;
    String Amountreq;
    String Name;
    String Aka;
    String DOb;
    String ssn_eye;
    String ssn;
    String addresstype;
    String yearataddress;
    String Idtype;
    String Number;
    String Issuing_country;
    String Expiry;
    String Primaryphonetype;
    String Email;
    String Pref_contact;
    String mothersmaidenname;
    String gender;
    String maritalstatus;



    public Verification(){

        requesttype=GlobalVariables.testDataMap.get("RequestType");
        Arrivaldate=arrivaldate();
        referred=GlobalVariables.testDataMap.get("ReferredByHost");
        applicationtype=GlobalVariables.testDataMap.get("ApplicationType");
        tripoccasssion=GlobalVariables.testDataMap.get("TripOccassion");
        cardno=GlobalVariables.testDataMap.get("Cardnumber");
        Amountreq=GlobalVariables.testDataMap.get("CreditLimit");
        Name=primaryname();
        Aka=aka();
        DOb=dob();
        ssn_eye="/Window/Custom[2]/Tab/TabItem[2]/Custom/Pane/Group[2]/Button[5]/Image";
        ssn="/Window[3]/Custom[2]/Tab/TabItem[2]/Custom/Pane/Group[2]/Text[25]/Text";
        addresstype=GlobalVariables.testDataMap.get("Addresstype");
        yearataddress=GlobalVariables.testDataMap.get("YearAtAddress");
        Idtype=GlobalVariables.testDataMap.get("TypeOfIdentification");
        Number=GlobalVariables.testDataMap.get("PassportNumber");
        Issuing_country="/Window/Custom[2]/Tab/TabItem[2]/Custom/Pane/Group[2]/Text[39]/Text";
        Expiry=expirydate();
        Primaryphonetype=GlobalVariables.testDataMap.get("PrimaryPhoneType");
        Email=GlobalVariables.testDataMap.get("Email");
        Pref_contact=GlobalVariables.testDataMap.get("PreferredContactMethod");
        mothersmaidenname=GlobalVariables.testDataMap.get("MothersMaiden");
        gender=GlobalVariables.testDataMap.get("Gender");
        maritalstatus=GlobalVariables.testDataMap.get("MaritalStatus");


    }

  public String primaryname(){

      String  s1=GlobalVariables.testDataMap.get("FirstName");
      String  s2=GlobalVariables.testDataMap.get("LastName");

      String str=s1+"  "+s2+" ";

      return str;

  }

    public String aka(){

        String  s1=GlobalVariables.testDataMap.get("AkaFirstName");
        String  s2=GlobalVariables.testDataMap.get("AkaLastName");

        String str=s1+" "+s2;

        return str;

    }

    public String dob(){

        String s=GlobalVariables.testDataMap.get("DOB");

        String s1=s.substring(0, 2);
        String s2=s.substring(2, 4);
        String s3=s.substring(4, 8);

        String str=s1+"-"+s2+"-"+s3;

        return str;
    }

    public String arrivaldate(){

        String s=GlobalVariables.testDataMap.get("ArrivalDate");

        String s1=s.substring(0, 2);
        String s2=s.substring(2, 4);
        String s3=s.substring(4, 8);

        String str=s1+"-"+s2+"-"+s3;

        return str;
    }

    public String expirydate(){

        String s=GlobalVariables.testDataMap.get("IDExpirationDate");

        String s1=s.substring(0, 2);
        String s2=s.substring(2, 4);
        String s3=s.substring(4, 8);

        String str=s1+"/"+s2+"/"+s3;

        return str;
    }


    public void verify_allfields(){

      Assert.assertEquals(GlobalVariables.testDataMap.get("RequestType"),ProjectGlobalVariables.winAppDriver.findElementByName(requesttype).getText());
      Assert.assertEquals(arrivaldate(),ProjectGlobalVariables.winAppDriver.findElementByName(Arrivaldate).getText());
      Assert.assertEquals(GlobalVariables.testDataMap.get("ReferredByHost"),ProjectGlobalVariables.winAppDriver.findElementByName(referred).getText());
      Assert.assertEquals(GlobalVariables.testDataMap.get("ApplicationType"),ProjectGlobalVariables.winAppDriver.findElementByName(applicationtype).getText());
      Assert.assertEquals(GlobalVariables.testDataMap.get("TripOccassion"),ProjectGlobalVariables.winAppDriver.findElementByName(tripoccasssion).getText());
      Assert.assertEquals(GlobalVariables.testDataMap.get("Cardnumber"),ProjectGlobalVariables.winAppDriver.findElementByName(cardno).getText());
      Assert.assertEquals(primaryname(),ProjectGlobalVariables.winAppDriver.findElementByName(Name).getText());
      Assert.assertEquals(aka(),ProjectGlobalVariables.winAppDriver.findElementByName(Aka).getText());
      Assert.assertEquals(dob(),ProjectGlobalVariables.winAppDriver.findElementByName(DOb).getText());
      Assert.assertEquals(GlobalVariables.testDataMap.get("Addresstype"),ProjectGlobalVariables.winAppDriver.findElementByName(addresstype).getText());
      Assert.assertEquals(GlobalVariables.testDataMap.get("YearAtAddress"),ProjectGlobalVariables.winAppDriver.findElementByName(yearataddress).getText());
      Assert.assertEquals(GlobalVariables.testDataMap.get("TypeOfIdentification"),ProjectGlobalVariables.winAppDriver.findElementByName(Idtype).getText());
      Assert.assertEquals(GlobalVariables.testDataMap.get("PassportNumber"),ProjectGlobalVariables.winAppDriver.findElementByName(Number).getText());
      Assert.assertEquals(expirydate(),ProjectGlobalVariables.winAppDriver.findElementByName(Expiry).getText());
      Assert.assertEquals(GlobalVariables.testDataMap.get("PrimaryPhoneType"),ProjectGlobalVariables.winAppDriver.findElementByName(Primaryphonetype).getText());
      Assert.assertEquals(GlobalVariables.testDataMap.get("Email"),ProjectGlobalVariables.winAppDriver.findElementByName(Email).getText());
      Assert.assertEquals(GlobalVariables.testDataMap.get("PreferredContactMethod"),ProjectGlobalVariables.winAppDriver.findElementByName(Pref_contact).getText());
      Assert.assertEquals(GlobalVariables.testDataMap.get("MothersMaiden"),ProjectGlobalVariables.winAppDriver.findElementByName(mothersmaidenname).getText());
      Assert.assertEquals(GlobalVariables.testDataMap.get("Gender"),ProjectGlobalVariables.winAppDriver.findElementByName(gender).getText());
      Assert.assertEquals(GlobalVariables.testDataMap.get("MaritalStatus"),ProjectGlobalVariables.winAppDriver.findElementByName(maritalstatus).getText());


    }

}
