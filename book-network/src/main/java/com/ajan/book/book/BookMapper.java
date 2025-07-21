package com.ajan.book.book;

import com.ajan.book.file.FileUtils;
import com.ajan.book.history.BookTransactionHistory;
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
                .cover(FileUtils.readFileFromLocation(book.getBookCover()))
                .build();
    }

    public BorrowedBookResponse toBorrowedBookResponse(@NotNull BookTransactionHistory bookTransactionHistory) {
        Book book = bookTransactionHistory.getBook();
        return BorrowedBookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorName(book.getAuthorName())
                .isbn(book.getIsbn())
                .rate(book.getRate())
                .returned(bookTransactionHistory.isReturned())
                .returnApproved(bookTransactionHistory.isReturnApproved())
                .build();
    }
}
