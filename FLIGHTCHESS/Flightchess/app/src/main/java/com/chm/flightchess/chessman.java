package com.chm.flightchess;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class chessman {
    private boolean flying = false, completed = false;

    private int already_passed;

    private static float width = 10, origin = 0;

    private int faction, num;

    private ImageView img;

    public chessman(int FACTION, int NUM, ImageView IMAGEVIEW) {
        resetstates();
        faction = FACTION;
        num = NUM;
        img = IMAGEVIEW;
    }

    public void move(int pathx, int pathy) {
        img.setX(pathx * width);
        img.setY(origin + pathy * width);
        switch (faction){
            case Value.red_team:
                if((already_passed <= 4 && already_passed>0)||(already_passed > 7 && already_passed <= 13)||(already_passed > 17 && already_passed <=20)||(already_passed>49 && already_passed<=55)){
                    img.setImageResource(R.drawable.planerr);
                }else if((already_passed > 4 && already_passed <= 7) || ( already_passed > 39 && already_passed <= 43 ) || (already_passed > 46 && already_passed <= 49)){
                    img.setImageResource(R.drawable.planeru);
                }else if((already_passed > 26 && already_passed <= 30) || (already_passed >33 &&already_passed <= 39) ||(already_passed > 43 && already_passed<=46) ){
                    img.setImageResource(R.drawable.planerl);
                }else if((already_passed >13 && already_passed <= 17) || (already_passed > 30 && already_passed <=33) || (already_passed>20 && already_passed<=26)) {
                    img.setImageResource(R.drawable.planerd);
                }
                break;
            case Value.blue_team:
                if((already_passed <= 4 && already_passed>0)||(already_passed > 7 && already_passed <= 13)||(already_passed > 17 && already_passed <=20)||(already_passed>49 && already_passed<=55)){
                    img.setImageResource(R.drawable.planebd);
                }else if((already_passed > 4 && already_passed <= 7) || ( already_passed > 39 && already_passed <= 43 ) || (already_passed > 46 && already_passed <= 49)){
                    img.setImageResource(R.drawable.planebr);
                }else if((already_passed > 26 && already_passed <= 30) || (already_passed >33 &&already_passed <= 39) ||(already_passed > 43 && already_passed<=46) ){
                    img.setImageResource(R.drawable.planebu);
                }else if((already_passed >13 && already_passed <= 17) || (already_passed > 30 && already_passed <=33) || (already_passed>20 && already_passed<=26)) {
                    img.setImageResource(R.drawable.planebl);
                }
                break;
            case Value.green_team:
                if((already_passed <= 4 && already_passed>0)||(already_passed > 7 && already_passed <= 13)||(already_passed > 17 && already_passed <=20)||(already_passed>49 && already_passed<=55)){
                    img.setImageResource(R.drawable.planegl);
                }else if((already_passed > 4 && already_passed <= 7) || ( already_passed > 39 && already_passed <= 43 ) || (already_passed > 46 && already_passed <= 49)){
                    img.setImageResource(R.drawable.planegd);
                }else if((already_passed > 26 && already_passed <= 30) || (already_passed >33 &&already_passed <= 39) ||(already_passed > 43 && already_passed<=46) ){
                    img.setImageResource(R.drawable.planegr);
                }else if((already_passed >13 && already_passed <= 17) || (already_passed > 30 && already_passed <=33) || (already_passed>20 && already_passed<=26)) {
                    img.setImageResource(R.drawable.planegu);
                }
                break;
            case Value.yellow_team:
                if((already_passed <= 4 && already_passed>0)||(already_passed > 7 && already_passed <= 13)||(already_passed > 17 && already_passed <=20)||(already_passed>49 && already_passed<=55)){
                    img.setImageResource(R.drawable.planeyu);
                }else if((already_passed > 4 && already_passed <= 7) || ( already_passed > 39 && already_passed <= 43 ) || (already_passed > 46 && already_passed <= 49)){
                    img.setImageResource(R.drawable.planeyl);
                }else if((already_passed > 26 && already_passed <= 30) || (already_passed >33 &&already_passed <= 39) ||(already_passed > 43 && already_passed<=46) ){
                    img.setImageResource(R.drawable.planeyd);
                }else if((already_passed >13 && already_passed <= 17) || (already_passed > 30 && already_passed <=33) || (already_passed>20 && already_passed<=26)) {
                    img.setImageResource(R.drawable.planeyr);
                }
                break;
            default:
                break;
        }
    }

    public void move(int steps) {
        int cheak = already_passed + steps - Value.Terminal;
        if (cheak < 0) cheak = 0;
        if (ifflying()) {
            switch (faction) {
                case Value.red_team:
                    move(Value.redPathx[already_passed + steps - 2 * cheak], Value.redPathy[already_passed + steps - 2 * cheak]);
                    break;
                case Value.yellow_team:
                    move(Value.yellowPathx[already_passed + steps - 2 * cheak], Value.yellowPathy[already_passed + steps - 2 * cheak]);
                    break;
                case Value.blue_team:
                    move(Value.bluePathx[already_passed + steps - 2 * cheak], Value.bluePathy[already_passed + steps - 2 * cheak]);
                    break;
                case Value.green_team:
                    move(Value.greenPathx[already_passed + steps - 2 * cheak], Value.greenPathy[already_passed + steps - 2 * cheak]);
                    break;
            }
        }
        if (cheak == 0) {
            already_passed += steps;
        } else {
            already_passed = already_passed + steps - 2 * cheak;
        }
    }

    public void resetstates() {
        flying = false;
        completed = false;
        already_passed = 0;
    }

    public void goflying() {
        already_passed = 0;
        flying = true;
        switch (faction) {
            case 0:
                move(Value.redPathx[already_passed], Value.redPathy[already_passed]);
                img.setImageResource(R.drawable.planera);
                break;

            case 1:
                move(Value.bluePathx[already_passed], Value.bluePathy[already_passed]);
                img.setImageResource(R.drawable.planeba);
                break;

            case 2:
                move(Value.greenPathx[already_passed], Value.greenPathy[already_passed]);
                img.setImageResource(R.drawable.planega);
                break;


            case 3:
                move(Value.yellowPathx[already_passed], Value.yellowPathy[already_passed]);
                img.setImageResource(R.drawable.planeya);
                break;

            default:
                break;
        }

    }

    public void changealready_go(int steps) {
        already_passed -= steps;
    }

    public void crashed() {
        resetstates();
        switch (faction){
            case 0:
                reset(Value.redoriginx[num-1],Value.redoriginy[num-1]);
                break;
            case 1:
                reset(Value.blueoriginx[num-1],Value.blueoriginy[num-1]);
                break;
            case 2:
                reset(Value.greenoriginx[num-1],Value.greenoriginy[num-1]);
                break;
            case 3:
                reset(Value.yelloworiginx[num-1],Value.yelloworiginy[num-1]);
                break;
            default:
                break;
        }
    }

    public void gohome(){
        flying = false;
        completed = true;
        switch (faction){
            case Value.red_team:
                img.setImageResource(R.drawable.planerda);
                break;
            case Value.blue_team:
                img.setImageResource(R.drawable.planebda);
                break;
            case Value.green_team:
                img.setImageResource(R.drawable.planegda);
                break;
            case Value.yellow_team:
                img.setImageResource(R.drawable.planeyda);
        }

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    public void reset(float x,float y){
        img.setX(x);
        img.setY(y);
    }

    public boolean ifflying() {
        return flying;
    }

    public boolean ifcompleted() {
        return completed;
    }

    public float getX(){
        return img.getX();
    }

    public float getY(){
        return img.getY();
    }

    public int getalready_passed() {
        return already_passed;
    }

    public int getfaction() {
        return faction;
    }

    public int getnum() {
        return num;
    }

    public boolean getcompleted()
    {
        return completed;
    }
}
