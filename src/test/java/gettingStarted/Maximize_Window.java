package gettingStarted;

import com.microsoft.playwright.*;

public class Maximize_Window {

	public static void main(String[] args) {
     
            Browser browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(java.util.Arrays.asList("--start-maximized")));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://www.example.com");
            
        }
    }
