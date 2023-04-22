package com.example.transactions.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDtoResponse { // what we will return to a client

    private Long id;

    private String username;
}
