package edu.kau.fcit.cpit252;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import edu.kau.fcit.cpit252.observers.*;
import edu.kau.fcit.cpit252.subjects.*;

import java.util.List;

public class App {
    private static String searchForProduct(String keyword){
        try (Playwright playwright = Playwright.create()) {
            // Launch Chromium in headless mode
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            // Navigate and scrape product titles and prices
            page.navigate("https://cpit252.gitlab.io/html/lab-9/");
            List<String>  products = page.locator("h2.title").allInnerTexts();
            List<String>  prices = page.locator("p.price").allInnerTexts();
            for (int i=0; i< products.size(); i++) {
                if(products.get(i).indexOf(keyword) > -1) {
                    return products.get(i) + " " + prices.get(i);
                }
            }
            return null;
        }
    }
    public static void main(String[] args) {
        Observer fbObserver = new FacebookObserver("CPIT_252_price_watcher");
        Observer emailObserver = new EmailObserver("email@example.com");
        Observer waObserver = new WhatsappObserver("9660000000000");

        Subject s = new MessageSubject();

        s.subscribe(fbObserver);
        s.subscribe(emailObserver);
        // Get the price of a product (e.g., MacBook)
        String message = searchForProduct("MacBook");
        s.notifyUpdate(message);

        System.out.println("\nChange observers: unsubscribed email and subscribed Whatsapp\n");
        s.unsubscribe(emailObserver);
        s.subscribe(waObserver);

        s.notifyUpdate(message);
    }
}
