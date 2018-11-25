package com.crm.services;


import java.io.IOException;

import org.apache.log4j.Logger;

import com.crm.config.BaseConfiguration;
import com.crm.objectrepo.PageObjects;
import com.crm.utils.Common;

public class CrmServices  extends BaseConfiguration {
	 public  PageObjects pageobj;
	 private static Logger Log = Logger.getLogger(BaseConfiguration.class.getName());
	 
	 public CrmServices openCrmHomePage() {
		 pageobj = new PageObjects();
		 invokeBrowser();
		 return this;
	 }
	 
	 //login to crm
	 public CrmServices loginToCrm(String uname, String pword ) throws IOException {
		 Common.insertText("id", pageobj.getPageObjects().getProperty("crmhomepage_username_txtfieldId"), uname, wd);
		 Common.insertText("id", pageobj.getPageObjects().getProperty("crmhomepage_password_txtfieldId"), pword, wd);
		 Common.clickButtton("id", pageobj.getPageObjects().getProperty("crmhomepage_login_buttonId"), wd);
		// Common.validatePage(CrmPageConstants.CRM_LOGIN_PAGE_TITLE.title(), wd);
		 Log.info("user login successfully");
		return this;
	 }
	 
	 public CrmServices navigateToAccounts() throws IOException, InterruptedException {
		 Common.clinkLink("link", pageobj.getPageObjects().getProperty("crm_accounts_dashboardlink"), wd);
		 Common.wait(2);
		// Common.validatePage(CrmPageConstants.CRM_ACCOUNTS_PAGE_TITLE.title(), wd);
		 return this;
	 }
	 
	 //create account
	 public CrmServices createAccount() throws IOException, InterruptedException {
		 Common.clinkLink("link", pageobj.getPageObjects().getProperty("crm_accounts_createaccountlink"), wd);
		 Common.wait(2);
		// Common.validatePage(CrmPageConstants.CRM_CREATEACCOUNT_PAGE_TITLE.title(), wd);
		 return this;
	 }	
	 
	 public CrmServices insertTextOnName(String name) throws IOException {
		 Common.insertText("name", pageobj.getPageObjects().getProperty("crm_accounts_namename"), name, wd);
		 return this;
	 }
	 
	 public CrmServices insertTextOnEmail(String email) throws IOException {
		 Common.insertText("css", pageobj.getPageObjects().getProperty("crm_accounts_emailcss"), email, wd);
		 return this;
	 }
	 
	 public CrmServices selectDropDownPhone(String phone_item, String phone_dropdown) throws IOException {
		 Common.selectDropDownItem("css", pageobj.getPageObjects().getProperty("crm_accounts_phonecss"), phone_item, phone_dropdown, wd);
		 return this;
	 }
	 
	 public CrmServices insertTextOnMobile() throws IOException {
		Common.insertText("css", pageobj.getPageObjects().getProperty("crm_accounts_mobilecss"), "8093360402", wd);
		return this;
	 }
	 
	 public CrmServices insertTextOnWebsite(String website) throws IOException {
		Common.insertText("name", pageobj.getPageObjects().getProperty("crm_accounts_websitename"), website, wd);
		return this;
	 }
	 
	 public CrmServices insertTextOnBillingAddress( String address) throws IOException {
		 Common.insertText("name", pageobj.getPageObjects().getProperty("crm_accounts_billing_streetname"), address, wd);
		 return this;
	 }
	 
	 public CrmServices insertTextOnBillingCity(String city) throws IOException {
		 Common.insertText("name", pageobj.getPageObjects().getProperty("crm_accounts_billing_cityname"), city, wd);
		 return this;
	 }
		 
	 public CrmServices insertTextOnBillingState(String state)throws IOException {
		 Common.insertText("name", pageobj.getPageObjects().getProperty("crm_accounts_billing_statename"), state, wd);
		 return this;
	 }
		 
	 public CrmServices insertTextOnBillingPostalCode() throws IOException {
		 Common.insertText("name", pageobj.getPageObjects().getProperty("crm_accounts_billing_postalcodename"), "12345", wd);
		 return this;
	 }
		 
	 public CrmServices insertTextOnBillingCountry(String country) throws IOException {
		 Common.insertText("name", pageobj.getPageObjects().getProperty("crm_accounts_billing_countryname"), country, wd);
		 return this;
	 }
	 
	 public CrmServices clickCopyBilling() throws IOException {
		 Common.clickButtton("css", pageobj.getPageObjects().getProperty("crm_accounts_shipping_copybillingcss"), wd);
		 return this;
	 }
	 
	 public CrmServices SelectDropDownType(String type_item, String type_dropdown) throws IOException {
		 Common.selectDropDownItem("css", pageobj.getPageObjects().getProperty("crm_accounts_details_typecss"), type_item, type_dropdown, wd);
		 return this;
	 }
		 
	 public CrmServices insertTextOnSicCode() throws IOException {
		 Common.insertText("name", pageobj.getPageObjects().getProperty("crm_accounts_details_siccodename"), "23431", wd);
		 return this;
	 }
		 
	 public CrmServices SelectDropDownIndustry(String industry_item,String industry_dropdown) throws IOException {
		 Common.selectDropDownItem("css", pageobj.getPageObjects().getProperty("crm_accounts_details_industrycss"), industry_item, industry_dropdown, wd);
		 return this;
	 }
		 
	 public CrmServices insertTextOnDescription(String description) throws IOException {
		 Common.insertText("css", pageobj.getPageObjects().getProperty("crm_accounts_details_descriptioncss"), description, wd);
		 return this;
	 }
	 
	 public CrmServices clickOnSaveButton() throws IOException {
		 Common.clickButtton("css", pageobj.getPageObjects().getProperty("crm_accounts_savebuttoncss"), wd);
		 return this;
		
	 }
	
	 //validation Process
	 public String getCreateAccountNameFromAccountPage() throws IOException, InterruptedException {
		 Common.wait(2);
		 String name = Common.getText("css",  pageobj.getPageObjects().getProperty("crm_createaccountpage_namecss"), wd);
		 System.out.println(name);
		 return name;
	 }
 
	 public String getCreateAccountEmailFromAccountPage() throws IOException {
		 String email = Common.getText("link",  pageobj.getPageObjects().getProperty("crm_createaccountpage_emaillink"), wd);
		 System.out.println(email);
		 return email;
	 }

	 public String getCreateAccountPhoneFromAccountPage() throws IOException {
		 String phone = Common.getText("link",  pageobj.getPageObjects().getProperty("crm_createaccount_phonelink"), wd);
		 System.out.println(phone);
		 return phone;
	 }	 
		 
		 
	 public String getCreateAccountWebsiteFromAccountPage() throws IOException {
		 String website= Common.getText("link",  pageobj.getPageObjects().getProperty("crm_createaccount_websitelink"), wd);
		 System.out.println(website);
		 return website;
	 }
	 
	 public String getCreateAccountBillingAddressFromAccountPage() throws IOException {
		 String billingaddress = Common.getText("css",  pageobj.getPageObjects().getProperty("crm_createaccount_billingaddresscss"), wd);
		 System.out.println(billingaddress);
		 return billingaddress;
	 }
	 
	 public String getCreateAccountDetailsTypeFromAccountPage() throws IOException {
		 String type = Common.getText("css",  pageobj.getPageObjects().getProperty("crm_createaccount_DetailsTypecss"), wd);
		 System.out.println(type);
		 return type;
	 }
	 
	 public String getCreateAccountDetailsSiccodeFromAccountPage() throws IOException {
		 String siccode = Common.getText("css",  pageobj.getPageObjects().getProperty("crm_createaccount_DetailsSiccodecss"), wd);
		 System.out.println(siccode);
		 return siccode;
	 }
	 
	 public String getCreateAccountDetailsIndustryFromAccountPage() throws IOException {
		 String industry = Common.getText("css",  pageobj.getPageObjects().getProperty("crm_createaccount_DetailsIndustrycss"), wd);
		 System.out.println(industry);
		 return industry;
	 }
	 
	 public String getCreateAccountDetailsDescriptionFromAccountPage() throws IOException {
		 String description = Common.getText("css",  pageobj.getPageObjects().getProperty("crm_createaccount_DetailsDescriptioncss"), wd);
		 System.out.println(description);
		 return description;
	 }
	 
	 //editing the created page
	 public CrmServices clickOnEditButton() throws IOException {
		 Common.clickButtton("css", pageobj.getPageObjects().getProperty("crm_createaccount_editbuttoncss"), wd);
		 return this;
	 }
	 
	 public CrmServices editOnEmail() throws IOException {
		 Common.editText("css", pageobj.getPageObjects().getProperty("crm_createaccount_edit_emailcss"), "sandeep.ideal22@gmail.com", wd);
		return this;
	 }
	 
	 public CrmServices clickOnSaveButtonAfterEdit() throws IOException, InterruptedException {
		 Common.clickButtton("css", pageobj.getPageObjects().getProperty("crm_createaccount_edit_savebuttoncss"), wd);
		 Common.wait(2);
		return this;
	 }
	 
	 //remove the created account
	 public CrmServices clickOnRemoveButton() throws IOException {
		 Common.clickButtton("css", pageobj.getPageObjects().getProperty("crm_remove_createaccount_dropdownbuttoncss"), wd);
		 Common.clinkLink("link", pageobj.getPageObjects().getProperty("crm_removelink"), wd);
		 Common.clickButtton("css", pageobj.getPageObjects().getProperty("crm_remove_confirm_buttoncss"), wd);
		 return this;
	 }
	 
	 
	 
		 
	
			 
			 
 		 
}
