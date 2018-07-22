package com.chm.flightchess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button pvc = (Button)findViewById(R.id.bt_pvc);
        pvc.setOnClickListener(this);
        Button pvp = (Button)findViewById(R.id.bt_pvp);
        pvp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_pvc:
                Intent bg_pvc = new Intent(MainActivity.this,GAMETABLE2.class);
                startActivity(bg_pvc);
                break;
            case R.id.bt_pvp:
                Intent bg_pvp = new Intent(MainActivity.this,GAMETABLE.class);
                startActivity(bg_pvp);
                break;
            default:
                break;
        }

    }
}
