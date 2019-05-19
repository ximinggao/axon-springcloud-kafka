package com.example.book.controller;

import com.example.book.command.CreateBookCommand;
import com.example.book.command.EditBookCommand;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {
    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    public BookController(CommandGateway commandGateway, EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<String> createBook(@RequestBody @Valid CreateBookCommand command) {
        command.setId(UUID.randomUUID().toString());
        log.debug("Sending command from within BookController: {}", command);
        return commandGateway.send(command);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CompletableFuture<Void> editBook(@PathVariable String id,
                                            @RequestBody @Valid EditBookCommand command) {
        command.setId(id);
        log.debug("Sending command from within BookController: {}", command);
        return commandGateway.send(command);
    }
}
