package com.castrolol.githidra.calendarcontrols.calendarview

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.castrolol.githidra.calendarcontrols.calendarview.interfaces.OnDayClickListener
import com.castrolol.githidra.calendarcontrols.calendarview.interfaces.OnDayLongClickListener
import com.castrolol.githidra.calendarcontrols.calendarview.model.CalendarDay
import com.castrolol.githidra.calendarcontrols.calendarview.model.CalendarWeek


/**
 * Created by Ps-Luan on 02/06/2016.
 */

internal open class CalendarWeekView(context: Context, val week: CalendarWeek) : LinearLayout(context) {


    private var _dayLongClickEnabled = false;

    var onDayClickListener: OnDayClickListener = OnDayClickListener { view, day -> }
    var onDayLongClickListener: OnDayLongClickListener = OnDayLongClickListener { view, day -> false }


    var isDayLongClickable: Boolean
        get() = _dayLongClickEnabled
        set(value) {
            _dayLongClickEnabled = value
            updateView()
        }

    init {
        orientation = HORIZONTAL
        val lp = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        lp.weight = 0.2f
        layoutParams = lp
        updateView()
    }

    internal fun updateView(){
        removeAllViews()

        week.days.forEach {
            val dayView = CalendarDayView(context, it);
            dayView.setOnClickListener { v -> handleDayClick(v, it) }
            if(_dayLongClickEnabled){
                dayView.setOnLongClickListener { v -> handleDayLongClick(v, it) }
                dayView.isLongClickable = true
            }
            addView(dayView)
        }
    }

    private fun handleDayClick(view: View, day: CalendarDay){
        onDayClickListener.onClick(view, day)
    }

    private fun handleDayLongClick(view: View, day: CalendarDay): Boolean{
        return onDayLongClickListener.onLongClick(view, day)
    }




}