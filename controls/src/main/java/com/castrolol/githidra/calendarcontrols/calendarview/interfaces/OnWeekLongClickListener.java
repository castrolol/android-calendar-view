package com.castrolol.githidra.calendarcontrols.calendarview.interfaces;

import android.view.View;
import com.castrolol.githidra.calendarcontrols.calendarview.model.CalendarWeek;

/**
 * Created by 'Luan on 03/06/2016.
 */

public interface OnWeekLongClickListener {
    boolean onLongClick(View view, CalendarWeek week);
}
