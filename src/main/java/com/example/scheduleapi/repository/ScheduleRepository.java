package com.example.scheduleapi.repository;

import com.example.scheduleapi.dto.Schedule;
import com.example.scheduleapi.mapper.ScheduleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleRepository {
    private final ScheduleMapper scheduleMapper;

    public ScheduleRepository(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    public List<Schedule> findAll(){
        return scheduleMapper.findAll();
    }

    public int insertSchedule(Schedule schedule){
        return scheduleMapper.insert(schedule);
    }

    public Schedule findById(long id){
        return scheduleMapper.findById(id);
    }
}
