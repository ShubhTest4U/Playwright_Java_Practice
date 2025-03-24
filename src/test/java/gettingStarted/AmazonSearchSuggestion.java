package gettingStarted;

import java.nio.file.Path;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.ConnectOptions;
import com.microsoft.playwright.BrowserType.ConnectOverCDPOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.BrowserType.LaunchPersistentContextOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AmazonSearchSuggestion {

	public static void main(String[] args) {

		Browser bw = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(300));
		Page pg = bw.newPage();
		pg.navigate("https://www.amazon.in/");
		Locator inputbox = pg.locator("#twotabsearchtextbox");
		inputbox.fill("iphone ");
		// inputbox.press("Enter");
//		pg.locator("xpath=//input[@id='nav-search-submit-button']").click();

		Locator list = pg.locator(".s-suggestion-container");
		System.out.println("Count of suggestion list = " + list.count());

		for (int i = 0; i < list.count(); i++) {
			String text = list.nth(i).innerText();
//	 		System.out.println(text);
			if (text.contains("iphone 15")) {
				list.nth(i).click();
				break;
			}
		}
		System.out.println(pg.title());

		pg.close();
		bw.close();

	}

}
