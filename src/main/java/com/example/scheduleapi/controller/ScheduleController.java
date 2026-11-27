package com.example.scheduleapi.controller;

import com.example.scheduleapi.dto.Schedule;
import com.example.scheduleapi.service.ScheduleService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> findAllSchedules(){
        List<Schedule> schedules = scheduleService.findAll();

//        return new ResponseEntity<>(schedules, HttpStatus.OK);
        return ResponseEntity.ok(schedules);
    }

    @PostMapping
    public ResponseEntity<Schedule> saveSchedule(@RequestBody Schedule schedule,
                                                 UriComponentsBuilder uriBuider){
        Schedule createdSchedule = scheduleService.saveSchedule(schedule);

        URI location = uriBuider.path("/api/schedules/{id}")
                .buildAndExpand(createdSchedule.getId()).toUri();

//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(location);

//        return new ResponseEntity<>(createdSchedule, headers, HttpStatus.CREATED);

        return ResponseEntity.created(location).body(createdSchedule);
    }

    @GetMapping("/id")
    public ResponseEntity<Schedule> findById(@PathVariable long id){
        Schedule schedule = scheduleService.findById(id);
        return ResponseEntity.ok(schedule);
    }
}
