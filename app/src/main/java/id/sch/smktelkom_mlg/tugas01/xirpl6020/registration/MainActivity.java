package id.sch.smktelkom_mlg.tugas01.xirpl6020.registration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nama, tahun;
    TextView tvhasil;
    Button sign;
    RadioGroup rg;
    CheckBox rpl, tkj, multi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (EditText) findViewById(R.id.editText);
        tahun = (EditText) findViewById(R.id.editText2);
        tvhasil = (TextView) findViewById(R.id.hasil);
        rg = (RadioGroup) findViewById(R.id.rgr);
        rpl = (CheckBox) findViewById(R.id.checkBox);
        tkj = (CheckBox) findViewById(R.id.checkBox2);
        multi = (CheckBox) findViewById(R.id.checkBox3);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doklik();

            }
        });


    }

    private void doklik() {

        String nama1 = nama.getText().toString();
        int lahir = Integer.parseInt(tahun.getText().toString());
        int umur = 2016 - lahir;
        tvhasil.setText("" + nama1 + "/n" + umur);

    }
}
