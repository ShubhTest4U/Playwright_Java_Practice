package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class first_playwright_program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright pw = Playwright.create();
		BrowserType bt = pw.chromium();
		Browser br = bt.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setSlowMo(1000));
		
		Page pg = br.newPage();
		pg.navigate("https://www.kaggle.com/");
		System.out.println("Page title= "+pg.title());
		pg.close();

	}

}
