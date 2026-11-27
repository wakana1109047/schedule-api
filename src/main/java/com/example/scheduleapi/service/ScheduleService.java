package com.example.scheduleapi.service;

import com.example.scheduleapi.dto.Schedule;
import com.example.scheduleapi.exception.ScheduleNotFoundException;
import com.example.scheduleapi.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> findAll(){
        return scheduleRepository.findAll();
    }

    public Schedule saveSchedule(Schedule schedule){
        scheduleRepository.insertSchedule(schedule);
        return schedule;
    }

    public Schedule findById(long id){
        Schedule schedule = scheduleRepository.findById(id);

        if(schedule == null){
            throw new ScheduleNotFoundException(id);
        }
        return schedule;
    }
}
