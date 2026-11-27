package com.example.scheduleapi.mapper;

import com.example.scheduleapi.dto.Schedule;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    @Select("SELECT id, content, description, date, start_time, end_time, created_at FROM schedules ORDER BY created_at DESC")
    List<Schedule> findAll();

    @Insert("INSERT INTO schedules(content, description, date, start_time, end_time) VALUES (#{content}, #{description}, #{date}, #{startTime}, #{endTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id,createdAt", keyColumn = "id,created_at")
    int insert(Schedule schedule);

    @Select("SELECT id, content, description, date, start_time, end_time, created_at FROM schedules WHERE id = #{id}")
    Schedule findById(long id);
}
