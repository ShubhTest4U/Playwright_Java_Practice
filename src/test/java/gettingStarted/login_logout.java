package gettingStarted;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class login_logout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Browser bw = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page pg = bw.newPage();
		pg.navigate("https://freelance-learn-automation.vercel.app/login");

		PlaywrightAssertions.assertThat(pg).hasTitle("Learn Automation Courses");

		// ID locator
		// pg.locator("#email1").fill("admin@email.com");

		// Xpath locator
		// pg.locator("xpath=//input[@name='email1']").fill("admin@email.com");

		// Css selector locator
		pg.locator("css=input[name='email1']").fill("admin@email.com");

		// Placeholder locator
		pg.getByPlaceholder("Enter Password").fill("admin@123");

		// text locator and index
		// pg.getByText("Sign in").nth(1).click();

		// last index
		pg.getByText("Sign in").last().click();

		// class locator
		Locator cls = pg.locator(".welcomeMessage");
		String actualText = cls.textContent();
		boolean assertionPassed = actualText.contains("Welcome");

		if (assertionPassed) {
		    System.out.println("PASS: Welcome message contains 'Welcome'. Full text: " + actualText);
		} else {
		    System.out.println("FAIL: Welcome message does not contain 'Welcome'. Full text: " + actualText);
		}

		pg.getByAltText("menu").click();
		pg.locator("css=button[class='nav-menu-item']").click();

		PlaywrightAssertions.assertThat(pg).hasURL(Pattern.compile("login"));

		// pg.waitForTimeout(7000);

		pg.close();
		bw.close();
	}
}
