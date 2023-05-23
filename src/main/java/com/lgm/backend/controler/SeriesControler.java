package com.lgm.backend.controler;

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
public class SeriesControler {

    @Autowired
    private ModelMapper modelMapper;

    private final SeriesService seriesService;


    @GetMapping("/{videogame}")
    @ResponseBody
    List<SeriesDto> getbyName(@PathVariable("videogame") String videogame){
        return seriesService.getSeriesByVideoGame(videogame).stream().map(serie -> modelMapper.map(serie, SeriesDto.class))
                .collect(Collectors.toList());
    }

}
