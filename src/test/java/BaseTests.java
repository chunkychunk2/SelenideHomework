import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import custom.allure.selenide.CustomAllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * BaseTest включает в себя основные задачи, которые нужно выполнить до и после выполнения тестов из класса Tests
 *
 * @see Tests
 */
public class BaseTests {
    /**
     * Метод делает скриншот на каждое действие
     */
    @BeforeAll
    public static void customListerSetup() {
        SelenideLogger.addListener("AllureSelenide", new CustomAllureSelenide().screenshots(true).savePageSource(true));
    }

    /**
     * Метод устанавливает таймер явных ожиданий, браузер и открытие в полном окне
     */
    @BeforeEach
    public void option() {
        Configuration.timeout = 20000;
        Configuration.browser = "chrome";
        Configuration.browserSize = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width
                + "x" + java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
        Configuration.browserPosition = "0x0";
    }
}
