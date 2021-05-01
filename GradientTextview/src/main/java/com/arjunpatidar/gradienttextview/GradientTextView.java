package com.arjunpatidar.gradienttextview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

@SuppressLint("AppCompatCustomView")
public class GradientTextView extends TextView {

    private static int startColor,endColor;

    public GradientTextView(Context context) {
        super(context);
    }

    public GradientTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GradientTextView(Context context,
                            AttributeSet attrs,
                            int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    private void init(AttributeSet set) {

        if (set ==null)
            return;

        TypedArray ta= getContext().obtainStyledAttributes(set,R.styleable.GradientTextView);
        startColor=ta.getColor(R.styleable.GradientTextView_startColor,Color.RED);
        endColor=ta.getColor(R.styleable.GradientTextView_endColor,Color.YELLOW);

        ta.recycle();


    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onLayout(boolean changed, int left, int top,
                            int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);


        if (changed) {
            getPaint().setShader(new LinearGradient(0,
                    0,
                    getWidth(),
                    getHeight(),
                    ContextCompat.getColor(getContext(),
                            startColor),
                    ContextCompat.getColor(getContext(),
                            endColor),
                    Shader.TileMode.CLAMP));
        }
    }


}