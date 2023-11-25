package com.example.study.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Blog {
    @Size(min = 3,max = 3,message = "enter id with 3 letters")
    private String id;
    @NotNull(message = "title cannot be null")
    private String title;
    @Size(min = 30,max = 100,message = "body from 30 to 100")
    private String body;
}
