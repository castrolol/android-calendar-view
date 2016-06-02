package com.castrolol.githidra.calendarcontrols.calendarview.model

import org.joda.time.DateTime
import org.joda.time.Weeks

/**
 * Created by Ps-Luan on 02/06/2016.
 */

data class CalendarMonth(val month: Int, val year: Int){


    val weeks by lazy {


        val list = mutableListOf<CalendarWeek>()
        val firstDay = DateTime(year, month, 1, 0, 0, 0)
        val numberOfWeeks = Weeks.weeksBetween(firstDay, firstDay.plusMonths(1).minusDays(1)).weeks;

        for(i in 1..numberOfWeeks){
            list.add(CalendarWeek(i, month, year))
        }

        return@lazy list.toList()

    }

}