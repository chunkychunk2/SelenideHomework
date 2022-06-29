package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Класс, содержащий входные данные для тестов
 */
public class DataProvider {

    /**
     * Метод содержит данные для теста
     * menuElement - название сервиса в шапке домашней страницы яндекса
     * category - название категории в шапке яндекса маркета
     * subCategory - название категории в боковом меню на странице категории
     * brand - Производитель
     *
     * @return String menuElement, String category, String subCategory, List<String> brand , String maxView
     */
    public static Stream<Arguments> checkBrands() {
        String menuElement = "Маркет";
        String category = "Электроника";
        String subCategory = "Смартфоны";
        List<String> brand = new ArrayList<>();
        brand.add("Google");
        brand.add("Apple");
        brand.add("HONOR");
        brand.add("HUAWEI");
        brand.add("Nokia");
        brand.add("OnePlus");
        brand.add("OPPO");
        brand.add("realme");
        brand.add("Samsung");
        brand.add("vivo");
        brand.add("Xiaomi");
        brand.add("ZTE");

        return Stream.of(
                Arguments.of(menuElement, category, subCategory, brand.get(0)),
                Arguments.of(menuElement, category, subCategory, brand.get(1)),
                Arguments.of(menuElement, category, subCategory, brand.get(2)),
                Arguments.of(menuElement, category, subCategory, brand.get(3)),
                Arguments.of(menuElement, category, subCategory, brand.get(4)),
                Arguments.of(menuElement, category, subCategory, brand.get(5)),
                Arguments.of(menuElement, category, subCategory, brand.get(6)),
                Arguments.of(menuElement, category, subCategory, brand.get(7)),
                Arguments.of(menuElement, category, subCategory, brand.get(8)),
                Arguments.of(menuElement, category, subCategory, brand.get(9)),
                Arguments.of(menuElement, category, subCategory, brand.get(10)),
                Arguments.of(menuElement, category, subCategory, brand.get(11))
        );
    }
}
