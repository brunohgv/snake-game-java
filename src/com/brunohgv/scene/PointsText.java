package com.brunohgv.scene;

import com.brunohgv.graphics.Text;
import com.brunohgv.utils.Constants;

public class PointsText extends Text {

    public PointsText(int score) {
        super(String.format(Constants.POINTS_TEXT, score), Constants.POINTS_LOCATION, Constants.POINTS_COLOR);
    }
}
