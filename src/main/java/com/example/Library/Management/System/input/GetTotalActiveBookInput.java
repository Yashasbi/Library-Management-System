package com.example.Library.Management.System.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor

public class GetTotalActiveBookInput {
    private UUID rollNumber;
}
