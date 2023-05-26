package com.lgm.backend.dto;

import com.lgm.backend.model.mainDb.League;
import lombok.Data;



@Data
public class SeriesDto {

    private Integer id;

    private LeagueDto leagueId;

    private String fullName;


}