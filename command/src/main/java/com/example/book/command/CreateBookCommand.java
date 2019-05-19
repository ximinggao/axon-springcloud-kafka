package com.example.book.command;

import lombok.Data;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateBookCommand {
    @TargetAggregateIdentifier
    private String id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String author;
}
