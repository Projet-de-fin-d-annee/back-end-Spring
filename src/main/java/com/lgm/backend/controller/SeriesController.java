package com.lgm.backend.controller;

import com.lgm.backend.dto.SeriePage;
import com.lgm.backend.dto.SeriesDto;
import com.lgm.backend.service.SeriesService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class SeriesController {

    @Autowired
    private ModelMapper modelMapper;

    private final SeriesService seriesService;


    @GetMapping("/{videoGame}")
    @ResponseBody
    List<SeriesDto> getByVideoGame(@PathVariable("videoGame") String videogame){
        return seriesService.getSeriesByVideoGame(videogame).stream().map(serie -> modelMapper.map(serie, SeriesDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/all/{page}")
    @ResponseBody
    SeriePage getAllByVideoGame(@PathVariable("page") Integer page){
        return seriesService.getPageSeriesByVideogame(page);
    }

}
