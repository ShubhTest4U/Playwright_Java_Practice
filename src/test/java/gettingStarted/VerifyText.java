package gettingStarted;


import java.util.regex.Pattern;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class VerifyText {

	public static void main(String[] args) {
		
		Browser bw = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page pg = bw.newPage();
		pg.navigate("https://freelance-learn-automation.vercel.app/login");
		pg.locator(".submit-btn").click();
		
		//Approach1
		String expected_msg = "Email and Password is required";
		String actual_msg = pg.locator(".errorMessage").textContent();
		
		System.out.println("Error msg is = " +actual_msg);
		
		Assert.assertEquals(actual_msg, expected_msg);
		Assert.assertTrue(actual_msg.contains("Password is required"));
		
		PlaywrightAssertions.assertThat(pg.locator(".errorMessage")).containsText(Pattern.compile(expected_msg));
		
//		//Approach2
//		String msg1 = pg.locator(".errorMessage").innerText();
//		System.out.println("Error msg2 is = " +msg1);
//		
//		//Approach3
//		String msg_via_js = (String)pg.evaluate("document.getElementsByClassName('errorMessage')[0].textContent");
//		System.out.println("Error msg via json= " +msg_via_js);
		
		pg.close();
		bw.close();
	}

}
