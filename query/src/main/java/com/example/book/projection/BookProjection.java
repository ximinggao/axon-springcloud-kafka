package com.example.book.projection;

import com.example.book.event.BookCreated;
import com.example.book.event.BookEdited;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.MetaData;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ProcessingGroup("Books")
public class BookProjection {
    @EventHandler
    public void on(BookCreated event, MetaData metaData) {
        log.info("Received domain event: {}, metadata: {}", event, metaData);
    }

    @EventHandler
    public void on(BookEdited event, MetaData metaData) {
        log.info("Received domain event: {}, metadata: {}", event, metaData);
    }
}
