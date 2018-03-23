package com.netease.criteria;

import com.netease.model.BookingExample;

/**
 * Created by YukunGeng on 2018/3/23.
 */
public class BookingCriteria {
    public static BookingExample.Criteria getCriteria(BookingExample example) {
        return example.createCriteria();
    }
}
