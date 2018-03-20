package com.netease.mapper;

import com.netease.model.Booking;
import com.netease.model.BookingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookingMapper {
    int countByExample(BookingExample example);

    int deleteByExample(BookingExample example);

    int deleteByPrimaryKey(Long bookingId);

    int insert(Booking record);

    int insertSelective(Booking record);

    List<Booking> selectByExample(BookingExample example);

    Booking selectByPrimaryKey(Long bookingId);

    int updateByExampleSelective(@Param("record") Booking record, @Param("example") BookingExample example);

    int updateByExample(@Param("record") Booking record, @Param("example") BookingExample example);

    int updateByPrimaryKeySelective(Booking record);

    int updateByPrimaryKey(Booking record);
}