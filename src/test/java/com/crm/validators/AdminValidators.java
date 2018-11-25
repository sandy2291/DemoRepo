package com.crm.validators;

import java.io.IOException;

import org.testng.Assert;

import com.crm.data.CrmData;
import com.crm.services.CrmServices;

public class AdminValidators {
	
	public CrmData crmdata = new CrmData();
	
	public void validateCreateAccount(CrmServices crmservice) throws IOException, InterruptedException {
		Assert.assertEquals(crmservice.getCreateAccountNameFromAccountPage(), crmdata.getCrmData().getRow(1).getCell(2).getStringCellValue());
		Assert.assertEquals(crmservice.getCreateAccountEmailFromAccountPage(), crmdata.getCrmData().getRow(1).getCell(3).getStringCellValue());
		Assert.assertEquals(crmservice.getCreateAccountPhoneFromAccountPage(), "8093360402");
		Assert.assertEquals(crmservice.getCreateAccountWebsiteFromAccountPage(), crmdata.getCrmData().getRow(1).getCell(7).getStringCellValue());
		Assert.assertEquals(crmservice.getCreateAccountDetailsTypeFromAccountPage(), crmdata.getCrmData().getRow(1).getCell(14).getStringCellValue());
		Assert.assertEquals(crmservice.getCreateAccountDetailsSiccodeFromAccountPage() , "23431");
		Assert.assertEquals(crmservice.getCreateAccountDetailsIndustryFromAccountPage(), crmdata.getCrmData().getRow(1).getCell(17).getStringCellValue());
		Assert.assertEquals(crmservice.getCreateAccountDetailsDescriptionFromAccountPage(), crmdata.getCrmData().getRow(1).getCell(18).getStringCellValue());
	}
	
	
}

