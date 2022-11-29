package org.zerock.api01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SampleTodoDTO {

    private Long id;

    private String title;

    private String writer;

    private LocalDate dueDate;

    private boolean complete;

    private LocalDateTime regDate, modDate;
}
