package com.castrolol.githidra.calendarcontrols.calendarview

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.castrolol.githidra.calendarcontrols.calendarview.model.CalendarMonth
import org.joda.time.DateTime
import java.util.*

/**
 * Created by Ps-Luan on 02/06/2016.
 */

open class CalendarView : LinearLayout {

    private var _month = DateTime.now().monthOfYear
    private var _year = DateTime.now().year;
    private var _model = CalendarMonth(_year, _month)

    constructor(context: Context) : super(context) {
        this.orientation = VERTICAL
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        this.orientation = VERTICAL
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        this.orientation = VERTICAL
    }

    init {
        updateView()
    }

    var month: Int
        get() = _month
        set(value) {
            _month = value
            updateView()
        }

    var year: Int
        get() = _year
        set(value) {
            _year = value
            updateView()
        }

    private fun updateView() {
        _model = CalendarMonth(_year, _month)

        removeAllViews()

        _model.weeks.forEach {
            val weekView = CalendarWeekView(context, it)
            addView(weekView)
        }

    }



}