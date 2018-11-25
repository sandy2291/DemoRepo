package com.crm.testscripts;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.data.CrmData;
import com.crm.services.CrmServices;
import com.crm.validators.AdminValidators;

public class AdminTests {
	public CrmServices crmservice;
	public CrmData crmData;
	public AdminValidators adminvalidator ;
	
	@BeforeClass
	public void init() throws IOException {
		crmservice = new CrmServices();
		crmData = new CrmData();
		adminvalidator = new AdminValidators();
		crmservice.openCrmHomePage().loginToCrm(crmData.getCrmData().getRow(1).getCell(0).getStringCellValue(), crmData.getCrmData().getRow(1).getCell(1).getStringCellValue() );
	}
	
	@Test(description = "create account with validate data")
	public void createAccountsWithValidataData() throws IOException, InterruptedException {
		crmservice.navigateToAccounts().createAccount();
		crmservice.insertTextOnName(crmData.getCrmData().getRow(1).getCell(2).getStringCellValue());
		crmservice.insertTextOnEmail(crmData.getCrmData().getRow(1).getCell(3).getStringCellValue());
		crmservice.selectDropDownPhone(crmData.getCrmData().getRow(1).getCell(4).getStringCellValue(),crmData.getCrmData().getRow(1).getCell(5).getStringCellValue());
		crmservice.insertTextOnMobile();
		crmservice.insertTextOnWebsite(crmData.getCrmData().getRow(1).getCell(7).getStringCellValue());
		crmservice.insertTextOnBillingAddress(crmData.getCrmData().getRow(1).getCell(8).getStringCellValue());
		crmservice.insertTextOnBillingCity(crmData.getCrmData().getRow(1).getCell(9).getStringCellValue());
		crmservice.insertTextOnBillingState(crmData.getCrmData().getRow(1).getCell(10).getStringCellValue());
		crmservice.insertTextOnBillingPostalCode();
		crmservice. insertTextOnBillingCountry(crmData.getCrmData().getRow(1).getCell(12).getStringCellValue());
		crmservice.clickCopyBilling();
		crmservice.SelectDropDownType(crmData.getCrmData().getRow(1).getCell(13).getStringCellValue(), crmData.getCrmData().getRow(1).getCell(14).getStringCellValue());
		crmservice.insertTextOnSicCode();
		crmservice.SelectDropDownIndustry(crmData.getCrmData().getRow(1).getCell(16).getStringCellValue(),crmData.getCrmData().getRow(1).getCell(17).getStringCellValue());
		crmservice.insertTextOnDescription(crmData.getCrmData().getRow(1).getCell(18).getStringCellValue());
		crmservice.clickOnSaveButton().getCreateAccountNameFromAccountPage();
		crmservice.getCreateAccountEmailFromAccountPage();
		crmservice.getCreateAccountPhoneFromAccountPage();
		crmservice.getCreateAccountWebsiteFromAccountPage();
		//crmservice.getCreateAccountBillingAddressFromAccountPage();
		crmservice.getCreateAccountDetailsTypeFromAccountPage();
		crmservice.getCreateAccountDetailsSiccodeFromAccountPage();
		crmservice.getCreateAccountDetailsIndustryFromAccountPage();
		crmservice.getCreateAccountDetailsDescriptionFromAccountPage();
		adminvalidator.validateCreateAccount(crmservice);
		
	}
	
	@Test(description = "Edit account with valid data")
	public void editAccountWithValidData() throws IOException, InterruptedException {
		crmservice.clickOnEditButton().editOnEmail().clickOnSaveButtonAfterEdit();
	}
	
	@Test(description = "remove the created account")
	public void removeCreateAccount() throws IOException {
		crmservice.clickOnRemoveButton();
	}

} 
