package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

/**
 * PageObject домашней страницы яндекс маркета
 */
public class MarketHomePage extends BasePage {

    /**
     * Метод переходит по ссылке категории в шапке яндекса маркета,
     * название которой передается в качестве параметра category
     *
     * @param category - название категории в шапке сайта
     * @param nextPage - объект PageObject класса следующей страницы
     * @param <T>      дженерик наследуемвый от BasePage
     * @return объект PageObject класса следующей страницы
     */
    @Step("Проверяем получилось ли перейти в шапке сайта по ссылке категории: «{category}»")
    public <T extends BasePage> T findHeaderCategory(String category, Class<T> nextPage) {
        $x("//div[@data-zone-name='category-link']//span[text()='"+ category +"']/parent::a").pressEnter();
        return nextPage.cast(page(nextPage));
    }
}
