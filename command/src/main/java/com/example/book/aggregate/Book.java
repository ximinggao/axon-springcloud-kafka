package com.example.book.aggregate;

import com.example.book.command.CreateBookCommand;
import com.example.book.command.EditBookCommand;
import com.example.book.event.BookCreated;
import com.example.book.event.BookEdited;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.messaging.MetaData;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
@Slf4j
@NoArgsConstructor
public class Book {
    @AggregateIdentifier
    private String id;

    @CommandHandler
    public Book(CreateBookCommand command, MetaData metaData) {
        log.debug("Creating Book by command: {}", command);
        apply(BookCreated.builder()
                        .id(command.getId())
                        .title(command.getTitle())
                        .author(command.getAuthor())
                        .build(),
                metaData);
    }

    @CommandHandler
    public void handle(EditBookCommand command, MetaData metaData) {
        log.debug("Editing Book by command: {}", command);
        apply(BookEdited.builder()
                        .id(this.id)
                        .title(command.getTitle())
                        .author(command.getAuthor())
                        .build(),
                metaData);
    }

    @EventSourcingHandler
    public void on(BookCreated event, MetaData metaData) {
        log.debug("Event sourcing event: {}", event);
        this.id = event.getId();
    }

    @EventSourcingHandler
    public void on(BookEdited event, MetaData metaData) {
        log.debug("Event sourcing event: {}", event);
    }
}
