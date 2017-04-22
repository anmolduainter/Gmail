package com.example.joginderpal.gmail;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by joginderpal on 23-04-2017.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private static final int[] ATTRS=new int[]{
      android.R.attr.listDivider
    };

    private static final int HORIZONTAL_LIST= LinearLayoutManager.HORIZONTAL;
    private static final int VERTICAL_LIST=LinearLayoutManager.VERTICAL;
    private Drawable mDivider;
    private int mOrientation;

    public DividerItemDecoration(Context c, int orientation) {

        final TypedArray a=c.obtainStyledAttributes(ATTRS);
        mDivider=a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }
    public void setOrientation(int orientation){
        if (orientation!=HORIZONTAL_LIST && orientation!=VERTICAL_LIST){
            throw new IllegalArgumentException("Exception");
        }
        mOrientation=orientation;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

        if (mOrientation==VERTICAL_LIST){
            drawVertical(c,parent);
        }
        else{
          //  drawHorizontal(c,parent);
        }
    }

    public void drawVertical(Canvas c,RecyclerView parent){

        final int left=parent.getPaddingLeft();
        final int right=parent.getWidth()-parent.getPaddingRight();
        final int childCount=parent.getChildCount();
        for (int i=0;i<childCount;i++){
            final View child=parent.getChildAt(i);
            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) child.getLayoutParams();
            int top=child.getBottom()+params.bottomMargin;
            int bottom=top+mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if (mOrientation==VERTICAL_LIST){
            outRect.set(0,0,0,mDivider.getIntrinsicHeight());
        }
        else{

        }

    }
}
