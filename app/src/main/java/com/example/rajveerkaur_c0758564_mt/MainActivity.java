package com.example.rajveerkaur_c0758564_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner car_spinner;
    EditText dailyRent;
    TextView days;
    SeekBar Days_seekbar;
    RadioGroup radio_button;
    CheckBox check_button1;
    CheckBox check_button2;
    CheckBox check_button3;
    TextView amount;
    TextView total_payment;
    Button btn;

    int rate_days;
    double total;
    int Normal_rate = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        car_spinner = findViewById(R.id.spinner);
        dailyRent = findViewById(R.id.dailyrent);
        days = findViewById(R.id.daysTV);
        Days_seekbar = findViewById(R.id.seekbar);
        radio_button = findViewById(R.id.radiogroup);
        check_button1 = findViewById(R.id.checkbox1);
        check_button2 = findViewById(R.id.checkbox2);
        check_button3 = findViewById(R.id.checkbox3);
        btn = findViewById(R.id.btn_viewdetail);
        amount = findViewById(R.id.totalamount);
        total_payment = findViewById(R.id.totalpayment);
        car_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (car_spinner.getSelectedItem().toString()) {
                    case "BMW":
                        dailyRent.setText("$50");
                        break;
                    case "Ferrari":
                        dailyRent.setText("$60");
                        break;
                    case "Honda":
                        dailyRent.setText("$45");
                        break;
                    case "Wolkswagen":
                        dailyRent.setText("$58");
                        break;
                    case "Maruti":
                        dailyRent.setText("$67");
                        break;
                    case "Hummer":
                        dailyRent.setText("$80");
                        break;
                    case "Bentley":
                        dailyRent.setText("$70");
                        break;
                    case "PLease Choose a Car":
                        dailyRent.setText("");
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Days_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rate_days = progress;

//              if (!dailyRent.getText().toString().isEmpty()) {
//                  Normal_rate = Integer.valueOf(dailyRent.getText().toString());
//                  double tax = Double.valueOf(rate_days * Normal_rate * 13) / 100;
//                  Double total = (rate_days * Normal_rate) + tax;
//                  amount.setText(String.valueOf(total));
                  days.setText(String.valueOf(progress));


              }



            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        radio_button.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radiobutton1) {

                    double price = ((rate_days * Normal_rate + 5));
                    total_payment.setText(String.valueOf(total + price));
                } else if (checkedId == R.id.radiobutton3){

                    double price = ((rate_days * Normal_rate - 10));
                    total_payment.setText(String.valueOf(total+price));

                }
            }


        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(total_payment.getText().toString().trim().length()>0 && check_button1.isChecked()){
                    Toast.makeText(MainActivity.this,"you have choosed GPS", Toast.LENGTH_SHORT).show();
                } else if(total_payment.getText().toString().trim().length()>0 && check_button2.isChecked()) {
                    Toast.makeText(MainActivity.this, "you have choosed Child seat", Toast.LENGTH_SHORT).show();
                }else if(total_payment.getText().toString().trim().length()>0 && check_button3.isChecked()) {
                    Toast.makeText(MainActivity.this, "you have choosed unlimited millage", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}