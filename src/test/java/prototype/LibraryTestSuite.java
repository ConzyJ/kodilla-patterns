package prototype;

import com.kodilla.patterns.library.Book;
import com.kodilla.patterns.library.Library;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTestSuite {

    @Test
    void testGetBooks() {
        // Given
        Library library = new Library("Main Library");
        library.getBooks().add(new Book("The Hobbit", "J.R.R. Tolkien", LocalDate.of(1937, 9, 21)));
        library.getBooks().add(new Book("1984", "George Orwell", LocalDate.of(1949, 6, 8)));
        library.getBooks().add(new Book("To Kill a Mockingbird", "Harper Lee", LocalDate.of(1960, 7, 11)));

        // Shallow copy
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Shallow Copy Library");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // Deep copy
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep Copy Library");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // When
        library.getBooks().remove(new Book("1984", "George Orwell", LocalDate.of(1949, 6, 8)));

        // Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);

        assertEquals(2, library.getBooks().size());
        assertEquals(2, clonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());

        assertEquals(library.getBooks(), clonedLibrary.getBooks()); // Płytkie klonowanie - te same książki
        assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks()); // Głębokie klonowanie - inne książki
    }
}
