package com.castrolol.githidra.calendarcontrols.calendarview.model

import org.joda.time.DateTime
import org.joda.time.Weeks

/**
 * Created by Ps-Luan on 02/06/2016.
 */

data class CalendarMonth(val month: Int, val year: Int){


    val weeks by lazy {


        val list = mutableListOf<CalendarWeek>()
        var monthDay = DateTime(year, month, 1, 0, 0, 0)
        var numberOfWeeks = 1
        list.add(CalendarWeek(1, month, year))

        for(i in 1 .. (monthDay .dayOfMonth().maximumValue)){
            if(i != 1 && monthDay.dayOfWeek == monthDay.dayOfWeek().minimumValue){
                numberOfWeeks++;
                list.add(CalendarWeek(numberOfWeeks, month, year))
            }
            monthDay = monthDay.plusDays(1)
        }

        return@lazy list.toList()

    }

}