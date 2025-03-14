package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class GoogleSearchTest {

	public static void main(String[] args) {

		Browser bw = Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page pg = bw.newPage();
		pg.navigate("https://www.google.com/");
		Locator input = pg.locator(".gLFyf");
		input.fill("Playwright Java");
		input.press("Enter");
		pg.close();

	}

}
