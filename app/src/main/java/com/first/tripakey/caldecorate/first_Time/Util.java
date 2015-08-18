package com.first.tripakey.caldecorate.first_Time;

/**
 * Created by gaewgan on 8/12/2015.
 */

import android.content.res.Resources;
import android.util.TypedValue;

public class Util {

    public static int dpToPx(Resources res, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, res.getDisplayMetrics());
    }

}
