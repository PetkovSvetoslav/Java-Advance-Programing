package Lab.BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book first, Book second) {
        return Comparator.comparing(Book::getTitle)
                .thenComparing(Book::getYear)
                .compare(first, second);

        /*
        int result = first.getTitle().compareTo(second.getTitle());
        return result != 0 ? result : Integer.compare(first.getYear(), second.getYear());

         */
    }
}
