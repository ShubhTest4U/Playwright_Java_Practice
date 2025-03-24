package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FlipkartAutoSuggestionList {

	public static void main(String[] args) {

		Browser bw = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page pg = bw.newPage();
		pg.navigate("https://www.flipkart.com/");
		Locator searchbox = pg.getByPlaceholder("Search for Products, Brands and More");
		searchbox.fill("iphone");
		Locator list = pg.locator("xpath=//ul[@class='_1sFryS _2x2Mmc _3ofZy1']//li");
		//pg.pause();
		System.out.println("Count of suggestion= " + list.count());
		for (int i = 0; i < list.count(); i++) {
			String text = list.nth(i).innerText();
			// System.out.println(text);
			if (text.contains("iphone xr")) {
				list.nth(i).click();
				break;
			}

		}
		System.out.println(pg.title());
		pg.close();
		bw.close();

	}

}
