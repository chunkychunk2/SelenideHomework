package custom.allure.asserts;

import io.qameta.allure.Step;

/**
 * Кастомный Assert
 */
public class Assertions {

    /**
     * Метод проверяет, верно ли условие, что в выборку не попали другие производители по искомому бренду
     */
    @Step("Проверяем что в выборку не попали другие производители по искомому бренду")
    public static void assertFail(String message){
        org.junit.jupiter.api.Assertions.fail(message);
    }
}
