import custom.properties.TestData;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.Electronics;
import pages.MarketHomePage;
import pages.YandexHomePage;
import pages.SmartphoneCatalog;

import static com.codeborne.selenide.Selenide.*;


/**
 * Класс содержит тесты по тесткейсу Задание 2.1 Selenide
 */
public class Tests extends BaseTests {

    /**
     * Метод заходит на страницу из base.url
     * выбирает сервис и переходит по нему, вибирает раздел и переходит по нему, выбирает подраздел и переходит по нему,
     * в чекбоксах выбирает производителя и проверяет, что в выборку попали только товары искомого бренда
     *
     * @param menuElement - название сервиса в шапке домашней страницы яндекса
     * @param category    - название категории в шапке яндекса маркета
     * @param subCategory - название категории в боковом меню на странице категории
     * @param brand       - Производитель
     */
    @Feature("Проверка, что в результатах поиска есть товары только искомого бренда")
    @DisplayName("Проверка, что в выборку попали только")
    @ParameterizedTest(name = "{displayName}: {3}")
    @MethodSource({"helpers.DataProvider#checkBrands"})
    public void selenideTest(String menuElement, String category, String subCategory, String brand) {
        open(TestData.propsUrl.baseURLYandex(), YandexHomePage.class)
                .getHeaderLink(menuElement, MarketHomePage.class)
                .findHeaderCategory(category, Electronics.class)
                .findCategory(subCategory, SmartphoneCatalog.class)
                .brandFilter(brand)
                .checkTitles(brand);
    }
}
