package jp.techacademy.hiroko.sakoda.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.TimePickerDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView greetingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        greetingTextView = (TextView) findViewById(R.id.textView);
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        String str;

                        if (hourOfDay >= 2 && hourOfDay < 10) {
                            str = "おはよう";
                        }else if (hourOfDay >= 10 && hourOfDay < 18){
                            str = "こんにちは";
                        }else{
                            str = "こんばんは";
                        }

                        greetingTextView.setText(str);
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }

    @Override
    public void onClick(View v) {
        showTimePickerDialog();
    }
}