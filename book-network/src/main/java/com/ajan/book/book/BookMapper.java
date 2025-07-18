package com.ajan.book.book;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book toBook(BookRequest request) {
        return Book.builder()
                .id(request.id())
                .title(request.title())
                .authorName(request.authorName())
                .synopsis(request.synopsis())
                .isArchived(false)
                .isShareable(request.isShareable())
                .build();
    }

    public BookResponse toBookResponse(@NotNull Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorName(book.getAuthorName())
                .isbn(book.getIsbn())
                .synopsis(book.getSynopsis())
                .rate(book.getRate())
                .isArchived(book.isArchived())
                .isShareable(book.isShareable())
                .owner(book.getOwner().getFullName())
                // cover
                .build();
    }
}
