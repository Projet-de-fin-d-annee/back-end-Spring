package com.lgm.backend.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.lgm.backend.model.mainDb.Team;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TournamentDto {

    private Integer id;

    private String name;

    private SeriesDto serie;

    private TeamDto winner;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endAt;

}
