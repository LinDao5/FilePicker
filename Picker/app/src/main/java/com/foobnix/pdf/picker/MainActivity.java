package com.foobnix.pdf.picker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aigestudio.wheelpicker.WheelPicker;

public class MainActivity extends AppCompatActivity implements WheelPicker.OnItemSelectedListener, View.OnClickListener{

    private WheelPicker wheelLeft;
    private WheelPicker wheelCenter;
    private WheelPicker wheelRight;

    private Button gotoBtn, btnDown, btnUp;
    private Integer gotoBtnItemIndex;

    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wheelCenter = (WheelPicker) findViewById(R.id.main_wheel_center);
        wheelCenter.setOnItemSelectedListener(this);

        gotoBtn = (Button) findViewById(R.id.goto_btn);
//        randomlySetGotoBtnIndex();
////        gotoBtn.setOnClickListener(this);
        gotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Toast.makeText(MainActivity.this, wheelCenter.getData().get(wheelCenter.getCurrentItemPosition()).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btnDown = (Button)findViewById(R.id.btnDown);
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                gotoBtnItemIndex = wheelCenter.getCurrentItemPosition();
                wheelCenter.setSelectedItemPosition(gotoBtnItemIndex + 1);
            }
        });

    }

    @Override public void onClick(View view) {

    }

    @Override public void onItemSelected(WheelPicker picker, Object data, int position) {

    }
}
