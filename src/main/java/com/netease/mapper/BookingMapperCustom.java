package com.netease.mapper;

import com.netease.model.Booking;
import com.netease.model.BookingExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YukunGeng on 2018/3/25.
 */

public interface BookingMapperCustom extends BookingMapper{
    int insertCodeBatch(List<Booking > record);
}
