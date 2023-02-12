import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class BillboardManagerTest {
    private Billboard poster_one = new Billboard(1, "Крепкий орешек", "боевик", "url1", false);
    private Billboard poster_two = new Billboard(2, "Мистер Бин", "комедия", "url2", false);
    private Billboard poster_three = new Billboard(3, "Муана", "мультфильм", "url3", false);
    private Billboard poster_four = new Billboard(4, "Пила", "ужастик", "url4", false);
    private Billboard poster_five = new Billboard(5, "Шерлок Холмс", "сериал", "url5", false);
    private Billboard poster_six = new Billboard(6, "Крепкий орешек 2", "боевик", "url6", false);
    private Billboard poster_seven = new Billboard(7, "Мистер Бин 2", "комедия", "url7", false);
    private Billboard poster_eght = new Billboard(8, "Муана 2", "мультфильм", "url8", false);
    private Billboard poster_nine = new Billboard(9, "Пила 2", "ужастик", "url9", false);
    private Billboard poster_ten = new Billboard(10, "Шерлок Холмс 2", "сериал", "url10", false);

    public void setUp(BillboardManager manager) {
        manager.addBillboard(poster_one);
        manager.addBillboard(poster_two);
        manager.addBillboard(poster_three);
        manager.addBillboard(poster_four);
        manager.addBillboard(poster_five);
        manager.addBillboard(poster_six);
        manager.addBillboard(poster_seven);
        manager.addBillboard(poster_eght);
        manager.addBillboard(poster_nine);
        manager.addBillboard(poster_ten);
    }

    @Test
    void shouldAddMovie() {
        BillboardManager emptyManager = new BillboardManager();
        emptyManager.addBillboard(poster_one);
        Billboard[] actual = emptyManager.getBillboards();
        Billboard[] expected = new Billboard[]{poster_one};
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    void shouldShowAllMovies() {
        BillboardManager manager = new BillboardManager();
        this.setUp(manager);
        Billboard[] actual = manager.OutputOfAllMovies();
        Billboard[] expected = new Billboard[]{poster_one, poster_two, poster_three, poster_four, poster_five, poster_six, poster_seven, poster_eght, poster_nine, poster_ten};
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    void shouldShowNoMovies() {
        BillboardManager emptyManager = new BillboardManager();
        Billboard[] actual = emptyManager.getBillboards();
        Billboard[] expected = new Billboard[0];
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    void shouldOutputMaximumLimitOfTheLastAddedMovies() {
        BillboardManager manager = new BillboardManager();
        this.setUp(manager);
        Billboard[] actual = manager.OutputMaximumLimitOfTheLastAddedMovies();
        Billboard[] expected = new Billboard[]{poster_ten, poster_nine, poster_eght, poster_seven, poster_six, poster_five, poster_four, poster_three, poster_two, poster_one};
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    void shouldShowLastMoviesEqualsLimit() {
        BillboardManager manager = new BillboardManager(5);
        this.setUp(manager);
        Billboard[] actual = manager.OutputMaximumLimitOfTheLastAddedMovies();
        Billboard[] expected = new Billboard[]{poster_ten, poster_nine, poster_eght, poster_seven, poster_six};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    void shouldShowLastMoviesOverLimit() {
        BillboardManager manager = new BillboardManager(3);
        this.setUp(manager);
        Billboard[] actual = manager.OutputMaximumLimitOfTheLastAddedMovies();
        Billboard[] expected = new Billboard[]{poster_ten, poster_nine, poster_eght};
        Assertions.assertArrayEquals(expected,actual);
    }
}
