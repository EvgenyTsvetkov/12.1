import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    private Manager manager;

    @BeforeEach
    public void setup() {
        manager = new Manager();
    }

    @Test
    void addMovie() {
        Movie movie = new Movie("Titanic");
        manager.add(movie);
        assertEquals(1, manager.findAll().length);
    }

    @Test
    void findAll() {
        Movie movie1 = new Movie("Titanic");
        Movie movie2 = new Movie("Interstellar");
        manager.add(movie1);
        manager.add(movie2);
        Movie[] actual = manager.findAll();
        Movie[] expected = new Movie[]{movie1, movie2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findLastWithLimitLessThanMovies() {
        for (int i = 0; i < 11; i++) {
            manager.add(new Movie("Movie" + i));
        }
        Movie[] lastMovies = manager.findLast();
        assertEquals(10, lastMovies.length);
        assertEquals("Movie10", lastMovies[0].getTitle());
    }

    @Test
    void findLastWithLimitMoreThanMovies() {
        Manager customManager = new Manager(15);
        for (int i = 0; i < 11; i++) {
            customManager.add(new Movie("Movie" + i));
        }
        Movie[] lastMovies = customManager.findLast();
        assertEquals(11, lastMovies.length);
        assertEquals("Movie10", lastMovies[0].getTitle());
    }

    @Test
    void findLastWithNoMovies() {
        Movie[] lastMovies = manager.findLast();
        assertEquals(0, lastMovies.length);
    }
}
