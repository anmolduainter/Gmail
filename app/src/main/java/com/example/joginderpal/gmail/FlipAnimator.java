package com.example.joginderpal.gmail;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;

/**
 * Created by joginderpal on 23-04-2017.
 */
public class FlipAnimator {

   static AnimatorSet leftIn,leftOut,rightIn,rightOut;

    public static void flipView(Context ctx, View back,View front,boolean showFront){

        leftIn= (AnimatorSet) AnimatorInflater.loadAnimator(ctx,R.animator.card_flip_left_in);
        leftOut= (AnimatorSet) AnimatorInflater.loadAnimator(ctx,R.animator.card_flip_left_out);
        rightIn= (AnimatorSet) AnimatorInflater.loadAnimator(ctx,R.animator.card_flip_right_in);
        rightOut= (AnimatorSet) AnimatorInflater.loadAnimator(ctx,R.animator.card_flip_right_out);

        AnimatorSet FrontAnim=new AnimatorSet();
        AnimatorSet backAnim=new AnimatorSet();

        leftIn.setTarget(back);
        rightOut.setTarget(front);
        FrontAnim.playTogether(leftIn,rightOut);

        leftOut.setTarget(back);
        rightIn.setTarget(front);
        backAnim.playTogether(leftOut,rightIn);

        if(showFront){

            FrontAnim.start();

        }
        else{
                backAnim.start();
        }

    }


}