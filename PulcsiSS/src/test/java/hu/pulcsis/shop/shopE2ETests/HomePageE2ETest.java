package hu.pulcsis.shop.shopE2ETests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageE2ETest {

    static Playwright playwright;
    static Browser browser;

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(true));
    }

    @AfterAll
    static void teardown() {
        browser.close();
        playwright.close();
    }

    @Test
    void testHomepageLoadsAndShowsTitle() {
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        // FONTOS: legyen elindítva a Spring Boot app pl.: http://localhost:8080
        page.navigate("http://localhost:8080");

        // Példa ellenőrzés: szerepel-e valami a főoldalon
        String pageContent = page.content();
        assertTrue(pageContent.contains("Pulcsi"),
                "A főoldalon nem található a 'Pulcsi' szöveg!");

        // Screenshot a teszt futásáról
        page.screenshot(new Page.ScreenshotOptions().setPath(java.nio.file.Paths.get("homepage.png")));

        context.close();
    }
}
