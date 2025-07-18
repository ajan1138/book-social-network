package com.ajan.book.history;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookTransactionsHistoryRepository
        extends JpaRepository<BookTransactionHistory, Integer> {
    @Query("""
            SELECT history
            FROM BookTransactionHistory history
            WHERE history.user.id == :userId
            """)
    Page<BookTransactionHistory> findAllBorrowedBooks(PageRequest pageable,Integer userId);
}
