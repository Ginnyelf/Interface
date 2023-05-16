import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {


    AviaSouls manager = new AviaSouls();
    private Ticket first = new Ticket("Пулково", "Кольцево", 2500, 12, 16);
    private Ticket second = new Ticket("Пулково", "Кольцево", 4000, 12, 17);
    private Ticket third = new Ticket("Санкт-Петербург", "Москва", 4000, 12, 17);

    @BeforeEach
    public void setup() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    // Сортировка предложений по цене;
    @Test
    public void shouldCompareTOMethod() {
        Ticket[] expected = new Ticket[]{first, second};
        Ticket[] actual = new Ticket[]{first, second};

        Assertions.assertArrayEquals(actual, expected);

    }

    // Сортировка предложений по цене,метод Search;
    @Test
    public void shouldSearchByMethod() {
        Ticket[] expected = new Ticket[]{first, second};
        Ticket[] actual = manager.search("Пулково", "Кольцево");

        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldSearchByMethodNotFound() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.search("Пулково", "Москва");

        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldSearchByMethodFoundЩOnlyOne() {
        Ticket[] expected = new Ticket[]{third};
        Ticket[] actual = manager.search("Санкт-Петербург", "Москва");

        Assertions.assertArrayEquals(actual, expected);

    }

    // Сортировка предложений по цене,метод searchAndSortBy;
    @Test
    public void shouldSearchAndSortByByMethod() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = new Ticket[]{first, second};
        Ticket[] actual = manager.searchAndBySort("Пулково", "Кольцево", comparator);

        Assertions.assertArrayEquals(actual, expected);

    }
}
