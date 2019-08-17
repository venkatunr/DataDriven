package com.vcenty.tnstc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.vcentry.tnstc.initializer.Initialization;

public class RegPage extends Initialization {
	
	public static void enterUseraname(String username) {
		getElementByName("regpage_type_passsword_name").sendKeys(username);
	}
	
	public static void enterPassword(String password) {
		
		getElementByName("regpage_type_passsword_name").sendKeys(password);
	}
	
	public static void enterConfirmPassword(String confirmPassword) {
		
		getElementByName("regpage_type_confirmpassword_name").sendKeys(confirmPassword);
	}
	
	public static void enterSeceratQuestion(String seceratquestion) {
		WebElement dropdown=getElementByName("regpage_select_securityquestion_name");
		Select s=new Select(dropdown);
		s.selectByVisibleText(seceratquestion);
		
	}

	public static void enterSeceratAnswer(String answer) {
		getElementByName("regpage_type_securityanswer_name").sendKeys(answer);
	}
}
