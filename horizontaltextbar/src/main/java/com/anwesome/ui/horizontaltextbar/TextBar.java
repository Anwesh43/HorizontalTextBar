package com.anwesome.ui.horizontaltextbar;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/**
 * Created by anweshmishra on 23/04/17.
 */
public class TextBar {
    private String title;
    private float x,y,w,h,dir = 0,scale = 0,deg = 0;
    private int barColor = Color.parseColor("#BDBDBD");
    private TextBarButton textBarButton;
    private TextBarTitle textBarTitle;
    public TextBar(String title) {
        this.title = title;
    }
    public void setDimension(float x,float y,float w,float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        textBarButton = new TextBarButton(w);
        textBarTitle = new TextBarTitle();
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(x,y);
        textBarButton.draw(canvas,paint);
        textBarTitle.draw(canvas,paint);
        canvas.restore();
    }
    public boolean handleTap(float x,float y) {
        boolean condition =  textBarButton.handleTap(x,y);
        if(condition) {
            dir = deg == 0?1:-1;
        }
        return condition;
    }
    public boolean stopped() {
        return dir == 0;
    }
    public void update() {
        deg+=9*dir;
        scale+=0.2f*dir;
        if(deg>=45 || deg<=0) {
            dir = 0;
        }
    }
    private class TextBarButton {
        public float size;
        public TextBarButton(float size) {
            this.size = size;
        }
        public void draw(Canvas canvas,Paint paint) {
            canvas.save();
            canvas.translate(size/2,size/2);
            paint.setColor(barColor);
            canvas.drawRect(new RectF(-size/2,-size/2,size/2,size/2),paint);
            canvas.save();
            canvas.rotate(deg);
            paint.setStrokeWidth(size/10);
            paint.setColor(Color.WHITE);
            for(int i=0;i<2;i++) {
                canvas.save();
                canvas.rotate(i*90);
                canvas.drawLine(-size/3,0,size/3,0,paint);
                canvas.restore();
            }
            canvas.restore();
            canvas.restore();
        }
        public boolean handleTap(float tapX,float tapY) {
            boolean condition =  tapX>=x && tapX<=x+size && tapY>=y && tapY<=y+size;
            return condition;
        }
    }
    private class TextBarTitle {
        public void draw(Canvas canvas,Paint paint) {
            paint.setColor(barColor);
            canvas.save();
            canvas.translate(w/2,w/2);
            canvas.rotate(90);
            Path path = new Path();
            path.addRect(new RectF(w/2,-w/2,w/2+(h-w)*scale,w/2), Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.drawPath(path,paint);
            paint.setTextSize(w/3);
            String adjustedTitle = adjustString(paint);
            paint.setColor(Color.WHITE);
            canvas.drawText(adjustedTitle,(h-w)/2-paint.measureText(adjustedTitle)/2,paint.getTextSize()/4,paint);
            canvas.restore();
        }
        private String adjustString(Paint paint) {
            String msg = "";
            for(int i=0;i<title.length();i++) {
                if(paint.measureText(msg+title.charAt(i)) > 2*(h-w)/3) {
                    msg += "...";
                }
                else {
                    msg += title.charAt(i);
                }
            }
            return msg;
        }
    }
    public int hashCode() {
        return (int)(x+y)+title.hashCode();
    }
}
