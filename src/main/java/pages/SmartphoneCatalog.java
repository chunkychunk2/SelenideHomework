package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import custom.allure.asserts.Assertions;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

/**
 * PageObject раздела Смартфоны яндекс маркета
 */
public class SmartphoneCatalog extends BasePage {

    /**
     * String хранит xpath раздела прозиводителей в фильтрах поиска товаров
     */
    private String brands = "//legend[text()='Производитель']/following-sibling::";

    /**
     * String хранит xpath выпадающего списка максимального показа товаров на странице
     */
    private String nextPage = "//span[text()='Вперёд'] | //a[text()='Вперёд']";

    /**
     * String хранит xpath заголовков товаров в выдаче результатов поиска
     */
    private String productTitles = "//h3[@data-zone-name='title']";

    /**
     * String хранит xpath элмента загрузки выдачи
     */
    private String progressBar = "//div[@data-node-name='SearchSerp']//span[@aria-label='Загрузка...']";

    /**
     * Метод прожимает флажок производителя, название которого передается в качестве параметра
     * Метод учитывает A/B тестирование и может работать с 2 разными версиями страницы
     *
     * @param brand - наименование бренда
     * @return объект класса SmartfonyCatalog
     */
    @Step("Проверяем получилось ли прожать флажок производителя: «{brand}»")
    public SmartphoneCatalog brandFilter(String brand) {
        $x("//span[text()='Показать всё'] | " + brands + "footer/button[text()='Показать всё']").click();
        $x("//label[text()='Найти производителя']/following-sibling::input | " + brands + "div/nav/input[@name='Поле поиска']").setValue(brand);
        $x("//span[text()='" + brand + "']/ancestor::label | " + brands + "ul//input[contains(@name,'" + brand + "')]/parent::label").click();
        $x(progressBar).should(Condition.appear);
        $x(progressBar).shouldBe(Condition.disappear);
        return this;
    }

    /**
     * Метод проверяет все товары в выдаче, относятся они к искомому бренду из параметра или нет
     * метод скролит до конца выдачи, проверяет заголовки на наличие бренда в названии и продолжает поиск
     * на следующей странице, если она есть и на текущей не было товаров чужих брендов
     * если метод нашел в выдачи товар, не относящийся в бренду,
     * вызывается метод Assertions.assertFail и работа метода заканчивается
     *
     * @param brand - наименование бренда товара
     * @return объект класса SmartfonyCatalog
     * @see SmartphoneCatalog#productTitles - заголовки товаров
     */
    @Step("Проверяем все ли товары в выдаче относятся к искомому бренду: «{brand}»")
    public SmartphoneCatalog checkTitles(String brand) {
        for (int i = 0; i < 10; i++) {
            ElementsCollection titles = $$x(productTitles);
            int titlesSize = titles.size();
            for (int j = 0; j < 10; j++) {
                $$x(productTitles).last().scrollTo();
                titles = $$x(productTitles);
                if (titlesSize < titles.size()) {
                    titlesSize = titles.size();
                } else break;
            }
            for (int j = 0; j < titles.size(); j++) {
                titles = $$x(productTitles);
                if (!titles.get(j).getText().toLowerCase().contains(brand.toLowerCase())) {
                    Assertions.assertFail("в выборку попали не только " + brand + ": " + titles.get(j).getText());
                    return this;
                }
            }
            if ($x(nextPage).exists()) {
                $x(nextPage).click();
                $x(progressBar).should(Condition.appear);
                $x(progressBar).shouldBe(Condition.disappear);
            } else {
                break;
            }
        }
        return this;
    }
}
