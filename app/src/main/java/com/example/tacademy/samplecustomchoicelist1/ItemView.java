package com.example.tacademy.samplecustomchoicelist1;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tacademy on 2016-01-14.
 */
public class ItemView extends FrameLayout implements Checkable{

    public ItemView(Context context) {
        super(context);
        init();
    }

    TextView titleView;
    ImageView checkView ,image_selector;

    private void init(){
        inflate(getContext(), R.layout.view_item, this);
        titleView = (TextView)findViewById(R.id.text_title);
        checkView = (ImageView)findViewById(R.id.image_check);
        image_selector = (ImageView)findViewById(R.id.image_selector);
    }

    public void setText(String text){
        titleView.setText(text);
    }

    boolean isChecked;

    private void drawCheck(){
        if(isChecked){
            checkView.setImageResource(android.R.drawable.checkbox_on_background);
//            setBackgroundColor(Color.RED);
            image_selector.setVisibility(View.VISIBLE);
        }else {
            checkView.setImageResource(android.R.drawable.checkbox_off_background);
//            setBackgroundColor(Color.TRANSPARENT);
            image_selector.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void setChecked(boolean checked) {
        if(isChecked != checked){
            isChecked = checked;
            drawCheck();
        }
    }
    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked);
    }
}
