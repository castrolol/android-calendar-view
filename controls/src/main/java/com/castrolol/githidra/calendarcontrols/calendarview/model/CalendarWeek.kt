package com.castrolol.githidra.calendarcontrols.calendarview.model

import org.joda.time.DateTime
import org.joda.time.Weeks

/**
 * Created by Ps-Luan on 02/06/2016.
 */
data class CalendarWeek(val weekNumber: Int, val month: Int, val year: Int){

    val days by lazy {

        val dayList = mutableListOf<CalendarDay>()
        var firstDay = DateTime(year, month, 1, 0, 0, 0)

        var week = firstDay.weekOfWeekyear().addToCopy(weekNumber - 1).dayOfWeek().withMinimumValue()

        for(i in 1..7){
            dayList.add(CalendarDay(week.year, week.monthOfYear, week.dayOfMonth));
            week = week.plusDays(1)
        }

        return@lazy dayList.toList()

    }

}