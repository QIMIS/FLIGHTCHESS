package com.chm.flightchess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class GAMETABLE extends Activity implements View.OnClickListener {

    private chessman[] green = new chessman[4];
    private chessman[] yellow = new chessman[4];
    private chessman[] blue = new chessman[4];
    private chessman[] red = new chessman[4];
    private TextView DIS;
    private ImageButton roller;
    private int roll_num, whoseTurn;
    private int chess;
    private static int myplayerid;
    private int move_faction, move_num, move_steps;
    private int FLAG_ROLLER;
    private String text;
    private String[] msg;
    private Handler myHandler;
    Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gametable);
        DIS = (TextView) findViewById(R.id.display);
        ImageView RI_1 = (ImageView) findViewById(R.id.RC_1);
        ImageView RI_2 = (ImageView) findViewById(R.id.RC_2);
        ImageView RI_3 = (ImageView) findViewById(R.id.RC_3);
        ImageView RI_4 = (ImageView) findViewById(R.id.RC_4);
        ImageView YI_1 = (ImageView) findViewById(R.id.YC_1);
        ImageView YI_2 = (ImageView) findViewById(R.id.YC_2);
        ImageView YI_3 = (ImageView) findViewById(R.id.YC_3);
        ImageView YI_4 = (ImageView) findViewById(R.id.YC_4);
        ImageView BI_1 = (ImageView) findViewById(R.id.BC_1);
        ImageView BI_2 = (ImageView) findViewById(R.id.BC_2);
        ImageView BI_3 = (ImageView) findViewById(R.id.BC_3);
        ImageView BI_4 = (ImageView) findViewById(R.id.BC_4);
        ImageView GI_1 = (ImageView) findViewById(R.id.GC_1);
        ImageView GI_2 = (ImageView) findViewById(R.id.GC_2);
        ImageView GI_3 = (ImageView) findViewById(R.id.GC_3);
        ImageView GI_4 = (ImageView) findViewById(R.id.GC_4);
        BI_1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 1) && roll_num != 0 && blue[0].ifcompleted() == false && (blue[0].ifflying() || roll_num == 6)) {
                    go(blue[0]);
                }
                return false;
            }
        });
        BI_2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 1) && roll_num != 0 && blue[1].ifcompleted() == false && (blue[1].ifflying() || roll_num == 6)) {
                    go(blue[1]);
                }
                return false;
            }
        });
        BI_3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 1) && roll_num != 0 && blue[2].ifcompleted() == false && (blue[2].ifflying() || roll_num == 6)) {
                    go(blue[2]);
                }
                return false;
            }
        });
        BI_4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 1) && roll_num != 0 && blue[3].ifcompleted() == false && (blue[3].ifflying() || roll_num == 6)) {
                    go(blue[3]);
                }
                return false;
            }
        });
        RI_1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 0) && roll_num != 0 && red[0].ifcompleted() == false && (red[0].ifflying() || roll_num == 6)) {
                    go(red[0]);
                }
                return false;
            }
        });
        RI_2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 0) && roll_num != 0 && red[1].ifcompleted() == false && (red[1].ifflying() || roll_num == 6)) {
                    go(red[1]);
                }
                return false;
            }
        });
        RI_3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 0) && roll_num != 0 && red[2].ifcompleted() == false && (red[2].ifflying() || roll_num == 6)) {
                    go(red[2]);
                }
                return false;
            }
        });
        RI_4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 0) && roll_num != 0 && red[3].ifcompleted() == false && (red[3].ifflying() || roll_num == 6)) {
                    go(red[3]);
                }
                return false;
            }
        });
        YI_1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 3) && roll_num != 0 && yellow[0].ifcompleted() == false && (yellow[0].ifflying() || roll_num == 6)) {
                    go(yellow[0]);
                }
                return false;
            }
        });
        YI_2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 3) && roll_num != 0 && yellow[1].ifcompleted() == false && (yellow[1].ifflying() || roll_num == 6)) {
                    go(yellow[1]);
                }
                return false;
            }
        });
        YI_3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 3) && roll_num != 0 && yellow[2].ifcompleted() == false && (yellow[2].ifflying() || roll_num == 6)) {
                    go(yellow[2]);
                }
                return false;
            }
        });
        YI_4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 3) && roll_num != 0 && yellow[3].ifcompleted() == false && (yellow[3].ifflying() || roll_num == 6)) {
                    go(yellow[3]);
                }
                return false;
            }
        });
        GI_1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 2) && roll_num != 0 && green[0].ifcompleted() == false && (green[0].ifflying() || roll_num == 6)) {
                    go(green[0]);
                }
                return false;
            }
        });
        GI_2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 2) && roll_num != 0 && green[1].ifcompleted() == false && (green[1].ifflying() || roll_num == 6)) {
                    go(green[1]);
                }
                return false;
            }
        });
        GI_3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 2) && roll_num != 0 && green[2].ifcompleted() == false && (green[2].ifflying() || roll_num == 6)) {
                    go(green[2]);
                }
                return false;
            }
        });
        GI_4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (ifbeing(myplayerid, 2) && roll_num != 0 && green[3].ifcompleted() == false && (green[3].ifflying() || roll_num == 6)) {
                    go(green[3]);
                }
                return false;
            }
        });
        red[0] = new chessman(0, 1, RI_1);
        red[1] = new chessman(0, 2, RI_2);
        red[2] = new chessman(0, 3, RI_3);
        red[3] = new chessman(0, 4, RI_4);
        yellow[0] = new chessman(3, 1, YI_1);
        yellow[1] = new chessman(3, 2, YI_2);
        yellow[2] = new chessman(3, 3, YI_3);
        yellow[3] = new chessman(3, 4, YI_4);
        blue[0] = new chessman(1, 1, BI_1);
        blue[1] = new chessman(1, 2, BI_2);
        blue[2] = new chessman(1, 3, BI_3);
        blue[3] = new chessman(1, 4, BI_4);
        green[0] = new chessman(2, 1, GI_1);
        green[1] = new chessman(2, 2, GI_2);
        green[2] = new chessman(2, 3, GI_3);
        green[3] = new chessman(2, 4, GI_4);
        roller = (ImageButton) findViewById(R.id.roller);
        roller.setOnClickListener(this);
        init_game();
        myHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String) msg.obj;
                Log.e("tag", text);
                String[] msgsz = text.split("v");
                if (msgsz.length == 2) {
                    myplayerid = Integer.valueOf(msgsz[0]).intValue();
                    whoseTurn = Integer.valueOf(msgsz[1]).intValue();
                    if (myplayerid == whoseTurn) turn_in();
                } else if (msgsz.length == 4) {
                    move_faction = Integer.valueOf(msgsz[0]).intValue();
                    move_num = Integer.valueOf(msgsz[1]).intValue();
                    move_steps = Integer.valueOf(msgsz[2]).intValue();
                    whoseTurn = Integer.valueOf(msgsz[3]).intValue();
                    if (myplayerid == whoseTurn) {
                        if (whoseTurn != move_faction) {
                            switch (move_faction) {
                                case Value.red_team:
                                    go(red[move_num-1], move_steps);
                                    Log.e("tag", "已改");
                                    break;
                                case Value.blue_team:
                                    go(blue[move_num-1], move_steps);
                                    Log.e("tag", "已改");
                                    break;
                                case Value.yellow_team:
                                    go(yellow[move_num-1], move_steps);
                                    Log.e("tag", "已改");
                                    break;
                                case Value.green_team:
                                    go(green[move_num-1], move_steps);
                                    Log.e("tag", "已改");
                                    break;
                                default:
                                    break;
                            }
                        }
                        turn_in();
                    }
                    else {
                        switch (move_faction) {
                            case Value.red_team:
                                go(red[move_num-1], move_steps);
                                Log.e("tag", "已改");
                                break;
                            case Value.blue_team:
                                go(blue[move_num-1], move_steps);
                                Log.e("tag", "已改");
                                break;
                            case Value.yellow_team:
                                go(yellow[move_num-1], move_steps);
                                Log.e("tag", "已改");
                                break;
                            case Value.green_team:
                                go(green[move_num-1], move_steps);
                                Log.e("tag", "已改");
                                break;
                            default:
                                break;
                        }
                    }
                }
                Log.e("tag", "handle end!");
            }
        };

        receivemsg.start();


    }

    Thread receivemsg = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                DatagramSocket rece = new DatagramSocket(10001);
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                while (true) {
                    Log.e("tag", "1111111");
                    rece.receive(dp);
                    Log.e("tag", "222222");
                    String text = new String(dp.getData(), 0, dp.getLength());
                    message = myHandler.obtainMessage();
                    message.obj = text;
                    myHandler.sendMessage(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.roller:
                roll();
                Log.e("onClick: ", "已按骰子");
                break;
        }
    }

    private void init_game() {
        Thread sendmsg = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DatagramSocket ds = new DatagramSocket();
                    String msg = "hello";
                    byte[] buf = msg.getBytes();
                    DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.43.237"), 10001);
                    ds.send(dp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        sendmsg.start();
        //game_begin();
    }

    private void turn_in() {
        //roller.setClickable(true);
        Log.e("turn_in: ", myplayerid + ":  it is my turn");
        Toast.makeText(GAMETABLE.this, "现在是你的回合！,请投掷骰子", Toast.LENGTH_LONG).show();

    }

    private void roll() {
        roll_num = (int) (Math.random() * 6) + 1;
        switch (roll_num){
            case 1:
                roller.setImageResource(R.drawable.touzi1);
                roller.setScaleType(ImageView.ScaleType.FIT_XY);
                roller.setAdjustViewBounds(true);
                DIS.setText("您扔出了"+roll_num);
                break;
            case 2:
                roller.setImageResource(R.drawable.touzi2);
                roller.setScaleType(ImageView.ScaleType.FIT_XY);
                roller.setAdjustViewBounds(true);
                DIS.setText("您扔出了"+roll_num);
                break;
            case 3:
                roller.setImageResource(R.drawable.touzi3);
                roller.setScaleType(ImageView.ScaleType.FIT_XY);
                roller.setAdjustViewBounds(true);
                DIS.setText("您扔出了"+roll_num);
                break;
            case 4:
                roller.setImageResource(R.drawable.touzi4);
                roller.setScaleType(ImageView.ScaleType.FIT_XY);
                roller.setAdjustViewBounds(true);
                DIS.setText("您扔出了"+roll_num);
                break;
            case 5:
                roller.setImageResource(R.drawable.touzi5);
                roller.setScaleType(ImageView.ScaleType.FIT_XY);
                roller.setAdjustViewBounds(true);
                DIS.setText("您扔出了"+roll_num);
                break;
            case 6:
                roller.setImageResource(R.drawable.touzi6);
                roller.setScaleType(ImageView.ScaleType.FIT_XY);
                roller.setAdjustViewBounds(true);
                DIS.setText("您扔出了"+roll_num);
                break;
            default:
                break;
        }
        FLAG_ROLLER = roll_num;
        if (!canMove()) {
            roll_num = 0;
            chess = 1;
            turn_end();
        } else {
            Toast.makeText(GAMETABLE.this, "请选择要移动的棋子！", Toast.LENGTH_SHORT).show();
        }
    }

    private void go(chessman c) {
        if (roll_num != 0) {
            if (roll_num == 6) {
                if (!c.ifflying() && !c.ifcompleted()) {
                    c.goflying();
                    Toast.makeText(GAMETABLE.this, "注意：起飞成功", Toast.LENGTH_SHORT).show();
                } else {
                    for (int i = 0; i < roll_num; i++) {
                        c.move(1);
                    }
                    judge(c);
                }
            }
            else {
                for (int i = 0; i < roll_num; i++) {
                    c.move(1);
                }
                judge(c);
            }
        } else {
            Toast.makeText(GAMETABLE.this, "注意：请先滚动骰子", Toast.LENGTH_LONG).show();
            return;
        }
        chess = c.getnum();
        turn_end();
    }

    private void go(chessman c, int steps) {
        if (steps == 6) {
            if (!c.ifflying() && !c.ifcompleted()) {
                c.goflying();
                //Toast.makeText(GAMETABLE.this," "+Value.PlayerName[c.getfaction()]+"玩家的飞机成功起飞！",Toast.LENGTH_SHORT).show();
                DIS.setText(Value.PlayerName[c.getfaction()]+"玩家的飞机成功起飞！");
            } else {
                for (int i = 0; i < steps; i++) {
                    c.move(1);
                    //Toast.makeText(GAMETABLE.this," "+Value.PlayerName[c.getfaction()]+"玩家扔出了"+c.getnum()+"步！",Toast.LENGTH_SHORT).show();
                    DIS.setText(Value.PlayerName[c.getfaction()]+"玩家扔出了"+steps);
                }
                judge(c);
            }
        } else {
            for (int i = 0; i < steps; i++) {
                c.move(1);
                //Toast.makeText(GAMETABLE.this," "+Value.PlayerName[c.getfaction()]+"玩家扔出了"+c.getnum()+"步！",Toast.LENGTH_SHORT).show();
                DIS.setText(Value.PlayerName[c.getfaction()]+"玩家扔出了"+steps);
            }
            judge(c);
        }
    }

    private void judge(chessman c) {
        kill_judge(c);//起跳前检测击毁飞机
        if (c.getalready_passed() == 2 || c.getalready_passed() == 6 || c.getalready_passed() == 10 || c.getalready_passed() == 14 || c.getalready_passed() == 22 || c.getalready_passed() == 26 || c.getalready_passed() == 30 || c.getalready_passed() == 34 || c.getalready_passed() == 38 || c.getalready_passed() == 42 || c.getalready_passed() == 46) {
            for (int i = 0; i < 4; i++) {
                c.move(1);
            }
        } else if (c.getalready_passed() == 18) {
            for (int i = 0; i < 12; i++) {
                c.move(1);
            }
        } else if (c.getalready_passed() > 56) {
            c.changealready_go(c.getalready_passed() - 56);
            c.move(56 - c.getalready_passed());
        } else if (c.getalready_passed() == 56) {
            switch (c.getfaction()) {
                case 0:
                    c.reset(Value.redoriginx[c.getnum() - 1], Value.redoriginy[c.getnum() - 1]);
                    break;
                case 1:
                    c.reset(Value.blueoriginx[c.getnum() - 1], Value.blueoriginy[c.getnum() - 1]);
                    break;
                case 2:
                    c.reset(Value.greenoriginx[c.getnum() - 1], Value.greenoriginy[c.getnum() - 1]);
                    break;
                case 3:
                    c.reset(Value.yelloworiginx[c.getnum() - 1], Value.yelloworiginy[c.getnum() - 1]);
                    break;
                default:
                    break;
            }
            c.gohome();
            game_judge();
        }
        kill_judge(c);//起跳后检测击毁飞机
    }

    public void kill_judge(chessman c) {
        float x = c.getX(), y = c.getY();
        for (int i = 0; i < 4; i++) {
            if (x == red[i].getX() && y == red[i].getY() && c.getfaction() != Value.red_team) {
                red[i].crashed();
                Toast.makeText(GAMETABLE.this, "击毁红方飞机", Toast.LENGTH_SHORT).show();
            }
            if (x == blue[i].getX() && y == blue[i].getY() && c.getfaction() != Value.blue_team) {
                blue[i].crashed();
                Toast.makeText(GAMETABLE.this, "击毁蓝方飞机", Toast.LENGTH_SHORT).show();
            }
            if (x == green[i].getX() && y == green[i].getY() && c.getfaction() != Value.green_team) {
                green[i].crashed();
                Toast.makeText(GAMETABLE.this, "击毁绿方飞机", Toast.LENGTH_SHORT).show();
            }
            if (x == yellow[i].getX() && y == yellow[i].getY() && c.getfaction() != Value.yellow_team) {
                yellow[i].crashed();
                Toast.makeText(GAMETABLE.this, "击毁黄方飞机", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void game_judge() {
        int flag = 0;
        for (int i = 0; i < 4; i++) {
            switch (whoseTurn) {
                case Value.red_team:
                    if (red[i].getcompleted() == true) {
                        flag++;
                    }
                    break;
                case Value.blue_team:
                    if (blue[i].getcompleted() == true) {
                        flag++;
                    }
                    break;
                case Value.yellow_team:
                    if (yellow[i].getcompleted() == true) {
                        flag++;
                    }
                    break;
                case Value.green_team:
                    if (green[i].getcompleted() == true) {
                        flag++;
                    }
                    break;
                default:
                    break;
            }
        }
        if (flag == 4) {
            Toast.makeText(GAMETABLE.this, Value.PlayerName[whoseTurn] + "玩家已经获得游戏胜利！", Toast.LENGTH_SHORT).show();
            Intent win = new Intent(GAMETABLE.this, MainActivity.class);
            startActivity(win);
        }
    }

    private void turn_end() {
        Thread sendmsg = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DatagramSocket ds = new DatagramSocket();
                    String msg = String.valueOf(myplayerid) + "v" + String.valueOf(chess) + "v" + String.valueOf(FLAG_ROLLER);
                    byte[] buf = msg.getBytes();
                    DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.43.237"), 10001);
                    ds.send(dp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        sendmsg.start();
    }

    private boolean ifbeing(int whichturn, int team) {
        if (team == whichturn) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canMove() {
        if (roll_num == 6) {
            return true;
        }
        boolean flag = false;
        switch (whoseTurn) {
            case Value.red_team:
                for (int i = 0; i < 4; i++) {
                    if (!red[i].ifflying()) ;
                    else {
                        flag = true;
                        break;
                    }
                }
                break;
            case Value.yellow_team:
                for (int i = 0; i < 4; i++) {
                    if (!yellow[i].ifflying()) ;
                    else {
                        flag = true;
                        break;
                    }
                }
                break;
            case Value.blue_team:
                for (int i = 0; i < 4; i++) {
                    if (!blue[i].ifflying()) ;
                    else {
                        flag = true;
                        break;
                    }
                }
                break;
            case Value.green_team:
                for (int i = 0; i < 4; i++) {
                    if (!green[i].ifflying()) ;
                    else {
                        flag = true;
                        break;
                    }
                }
                break;
        }
        if (!flag) {
            return false;
        }
        return true;
    }
}
