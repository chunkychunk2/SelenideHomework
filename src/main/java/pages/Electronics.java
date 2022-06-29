package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

/**
 * PageObject раздела Электроника яндекс маркета
 */
public class Electronics extends BasePage {

    /**
     * Метод ищет категорию в боковом меню страницы по названию,
     * которое передается в метод в качестве параметра category и переходит по ней
     *
     * @param category - название категории из бокового меню
     * @param nextPage - объект PageObject класса следующей страницы
     * @param <T>      дженерик наследуемвый от BasePage
     * @return объект PageObject класса следующей страницы
     */
    @Step("Проверяем получилось ли перейти по ссылке категории: «{category}»")
    public <T extends BasePage> T findCategory(String category, Class<T> nextPage) {
        $x("//ul[@data-autotest-id='subItems']/../..").$x(".//a[text()='" + category + "']").click();
        return nextPage.cast(page(nextPage));
    }
}
