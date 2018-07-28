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

                        int hour = hourOfDay;
                        String str;

                        if (hour >= 2 && hour < 10) {
                            str = "おはよう";
                            Log.d("UI-PARTS", String.valueOf(hour) + "OKOKOKOKOKOKOKOK");
                        }else if (hour >= 10 && hour < 18){
                            str = "こんにちは";
                            Log.d("UI-PARTS", String.valueOf(hour) + "OKOKOKOKOKOKOKOK");
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