package ru.netology.Selenide;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    public static String setLocalDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy",
                new Locale("ru")));
    }


    @Test
    void ShouldApplication() {
        String date = setLocalDate(3);
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Москва");
        //$(byText("Выберите дату встречи с представителем банка")).click();
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Волков Лев");
        $("[data-test-id=phone] input").setValue("+79774620011");
        //$x("//*[text()='Я соглашаюсь с условиями обработки и использования моих персональных данных']").click();
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $(byText("Успешно!")).shouldBe(visible, Duration.ofMillis(15000));
        $(".notification__content").shouldHave(text("Встреча успешно забронирована на " + date),
                Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    void ShouldHuphenCity() {
        String date = setLocalDate(3);
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Волков Лев");
        $("[data-test-id=phone] input").setValue("+79774620011");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $(byText("Успешно!")).shouldBe(visible, Duration.ofMillis(15000));
        $(".notification__content").shouldHave(text("Встреча успешно забронирована на " + date),
                Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    void ShouldMoreThreeDays() {
        String date = setLocalDate(4);
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Москва");
        //$(byText("Выберите дату встречи с представителем банка")).click();
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Волков Лев");
        $("[data-test-id=phone] input").setValue("+79774620011");
        //$x("//*[text()='Я соглашаюсь с условиями обработки и использования моих персональных данных']").click();
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $(byText("Успешно!")).shouldBe(visible, Duration.ofMillis(15000));
        $(".notification__content").shouldHave(text("Встреча успешно забронирована на " + date),
                Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    void shouldResultDoubleSurnam() {
        String date = setLocalDate(3);
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Тверь");
        //$(byText("Выберите дату встречи с представителем банка")).click();
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        $("[data-test-id=name] input").setValue("Салтыков-Щедрин Михаил");
        $("[data-test-id=phone] input").setValue("+79770001889");
        //$x("//*[text()='Я соглашаюсь с условиями обработки и использования моих персональных данных']").click();
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $(byText("Успешно!")).shouldBe(visible, Duration.ofMillis(15000));
        $(".notification__content").shouldHave(text("Встреча успешно забронирована на " + date),
                Duration.ofSeconds(15)).shouldBe(visible);
    }
}


