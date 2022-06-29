package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

/**
 * PageObject домашней страницы яндекса
 */
public class YandexHomePage extends BasePage {

    /**
     * Метод переходит по ссылке сервиса в шапке сайта, название которого передается в качестве параметра menuElement
     *
     * @param menuElement название сервиса
     * @param nextPage    - объект PageObject класса следующей страницы
     * @param <T>         дженерик наследуемвый от BasePage
     * @return объект PageObject класса следующей страницы
     */
    @Step("Проверяем получилось ли перейти по ссылке сервиса: «{menuElement}»")
    public <T extends BasePage> T getHeaderLink(String menuElement, Class<T> nextPage) {
        $x("//div[@class='services-new__item-title' and text()='" + menuElement + "']/parent::a").pressEnter();
        closeWindow();
        switchTo().window(0);
        return nextPage.cast(page(nextPage));
    }
}
