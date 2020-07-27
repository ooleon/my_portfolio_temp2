package main.events;

import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import main.models.Author;
import main.models.Book;

@RepositoryEventHandler
public class BookEventHandler {
    Logger logger = Logger.getLogger("Class BookEventHandler");

    @HandleBeforeCreate
    public void handleBookBeforeCreate(Book book) {

        logger.info("Inside Book Before Create ....");
        book.getAuthors();
    }

    @HandleBeforeCreate
    public void handleAuthorBeforeCreate(Author author) {
        logger.info("Inside Author Before Create ....");
        author.getBooks();
    }
}
