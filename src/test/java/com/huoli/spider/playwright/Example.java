package com.huoli.spider.playwright;

/**
 * @description: example
 * @date: 2022/9/13 14:43
 * @auther: cuixiaowei
 */
import com.microsoft.playwright.*;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class Example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
        }
    }

    @Test
    public void webKitScreenshot() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate("http://whatsmyuseragent.org/");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }
    }
}
