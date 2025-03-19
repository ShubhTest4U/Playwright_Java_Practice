package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class GoogleSearchAutoSuggestion {

	public static void main(String[] args) {

		Browser bw = Playwright.create().firefox()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page pg = bw.newPage();
		pg.navigate("https://www.google.com/");
		pg.locator("#APjFqb").fill("playwright java ");
		Locator lt = pg.locator("xpath=//div[@class='erkvQe']//li");
		System.out.println("Count of suggestion = " + lt.count());
		for (int i = 0; i < lt.count(); i++) {
			String text = lt.nth(i).innerText();
			// System.out.println("All suggestion of list = " +text);
			if (text.contains("playwright java framework")) {
				lt.nth(i).click();
				break;
			}

		}
		pg.close();

	}

}
