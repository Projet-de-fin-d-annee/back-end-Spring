package com.lgm.backend.controler;


import com.lgm.backend.dto.SeriesDto;
import com.lgm.backend.dto.TournamentDto;
import com.lgm.backend.model.mainDb.Tournament;
import com.lgm.backend.service.TournamentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tournaments")
@RequiredArgsConstructor
public class TournamentController {
    @Autowired
    private ModelMapper modelMapper;

    private final TournamentService tournamentService;

    @GetMapping("/{videogame}")
    @ResponseBody
    List<TournamentDto> getbyName(@PathVariable("videogame") String videogame){
        return tournamentService.getTounamentsByVideoGame(videogame).stream().map(tournament -> modelMapper.map(tournament, TournamentDto.class))
                .collect(Collectors.toList());
    }
}