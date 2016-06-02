package com.castrolol.githidra.calendarcontrols.calendarview

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.castrolol.githidra.calendarcontrols.calendarview.model.CalendarWeek
import org.joda.time.DateTime

/**
 * Created by Ps-Luan on 02/06/2016.
 */

internal open class CalendarWeekView(context: Context, val week: CalendarWeek) : LinearLayout(context) {

    init {
        orientation = HORIZONTAL
        updateView()
    }

    internal fun updateView(){
        removeAllViews()

        week.days.forEach {
            val dayView = CalendarDayView(context, it);
            addView(dayView)
        }
    }

}