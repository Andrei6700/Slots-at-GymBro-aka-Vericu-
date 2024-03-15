package com.example.pacanele.ImageScrolling;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.pacanele.R;

public class ImageScrolling extends FrameLayout {
    private static int ANIMATION_DUR = 150;
    ImageView current_image, next_image;
    int last_result = 0, old_value = 0;
    IEventEnd eventEnd;

    public void setEventEnd(IEventEnd eventEnd) {
        this.eventEnd = eventEnd;
    }

    public ImageScrolling(Context context) {
        super(context);
        init(context);
    }

    public ImageScrolling(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_scrolling_display, this);
        current_image = (ImageView) getRootView().findViewById(R.id.current_image);
        next_image = (ImageView) getRootView().findViewById(R.id.next_image);

        next_image.setTranslationY(getHeight());
    }

    public void setValueRandom(int image, int rotate_count) {
        current_image.animate().translationY(-getHeight()).setDuration(ANIMATION_DUR).start();
        next_image.setTranslationY(next_image.getHeight());
        next_image.animate().translationY(0)
                .setDuration(ANIMATION_DUR)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        setImage(current_image, old_value % 6); // because we have 6 image, so we will mod for 6
                        current_image.setTranslationY(0);
                        if (old_value != rotate_count) {
                            //if old_value still not equal roatate count, we will still roll
                            setValueRandom(image, rotate_count);
                            old_value++;
                        } else  // if roatate is reached
                        {
                            last_result = 0;
                            old_value = 0;
                            setImage(next_image, image);
                            eventEnd.eventEnd(image % 6, rotate_count);
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
    }

    private void setImage(ImageView image_view, int value) {
        if (value == SlotMachineSymbols.samsulek)
            image_view.setImageResource(R.drawable.samsulek);
        else if (value == SlotMachineSymbols.Gigachadface)
            image_view.setImageResource(R.drawable.gigachadface);
        else if (value == SlotMachineSymbols.bench)
            image_view.setImageResource(R.drawable.bench);
        else if (value == SlotMachineSymbols.creatine)
            image_view.setImageResource(R.drawable.creatine);
        else if (value == SlotMachineSymbols.deadlift)
            image_view.setImageResource(R.drawable.deadlift);
        else if (value == SlotMachineSymbols.trenbolone)
            image_view.setImageResource(R.drawable.trenbolone);
        else if (value == SlotMachineSymbols.whey)
            image_view.setImageResource(R.drawable.whey);
        else
            image_view.setImageResource(R.drawable.powder);

        // Set tag for image for use to compare result
        image_view.setTag(value);
        last_result = value;
    }

    public int getValue() {
        if (next_image != null && next_image.getTag() != null) {
            return Integer.parseInt(next_image.getTag().toString());
        } else {
            // Handle in cas if  next_image it s null
            return -1; // or any other appropriate default value
        }
    }
}