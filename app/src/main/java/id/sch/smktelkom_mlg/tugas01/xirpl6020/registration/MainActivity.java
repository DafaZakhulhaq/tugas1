package id.sch.smktelkom_mlg.tugas01.xirpl6020.registration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nama, tahun;
    TextView tvhasil, tvhasil2, tvhasil3, tvhasil4;
    Button sign, resetd;
    RadioGroup rg;
    CheckBox rpl, tkj, multi;
    Spinner kota;
    RadioButton lk, pr;


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
        tvhasil2 = (TextView) findViewById(R.id.hasil2);
        tvhasil3 = (TextView) findViewById(R.id.hasil3);
        tvhasil4 = (TextView) findViewById(R.id.hasil4);
        kota = (Spinner) findViewById(R.id.spinner);
        lk = (RadioButton) findViewById(R.id.radioButton);
        pr = (RadioButton) findViewById(R.id.radioButton2);


        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nama.setText("");
                tahun.setText("");

                lk.setChecked(false);
                pr.setChecked(false);

                rpl.setChecked(false);
                tkj.setChecked(false);
                multi.setChecked(false);

                tvhasil.setText("");
                tvhasil2.setText("");
                tvhasil3.setText("");
                tvhasil4.setText("");

            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doklik();
                doradio();
                docheck();
                dospin();

            }
        });


    }

    private void dospin() {

        tvhasil4.setText("Kota Asal = " + kota.getSelectedItem().toString());

    }

    private void docheck() {

        String hasil = "Jurusan Anda = ";
        int starlen = hasil.length();
        if (rpl.isChecked()) hasil += rpl.getText() + ",";
        if (tkj.isChecked()) hasil += tkj.getText() + ",";
        if (multi.isChecked()) hasil += multi.getText() + ",";

        if (hasil.length() == starlen) hasil += "";

        tvhasil3.setText(hasil);

    }

    private void doradio() {

        String hasil = null;

        if (rg.getCheckedRadioButtonId() != -1) {

            RadioButton rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            hasil = rb.getText().toString();

        } else {


        }

        if (hasil == null) {

            tvhasil2.setText("");

        } else {

            tvhasil2.setText("Kelamin Anda = " + hasil);

        }


    }

    private void doklik() {


        if (isvalid()) {

            String nama1 = nama.getText().toString();
            int lahir = Integer.parseInt(tahun.getText().toString());
            int umur = 400000 * lahir;
            tvhasil.setText("Nama = " + nama1 + "\nTotal Biaya = Rp." + umur);

        }

    }

    private boolean isvalid() {

        boolean valid = true;

        valid = true;

        String namav = nama.getText().toString();
        String tahunv = tahun.getText().toString();

        if (namav.isEmpty()) {

            nama.setError("Nama Belum Diisi");
            valid = false;

        } else if (namav.length() < 3) {

            nama.setError("Minimal 3 Karakter");
            valid = false;
        } else {

            nama.setError(null);

        }

        if (tahunv.isEmpty()) {

            tahun.setError("Belum Diisi");
            valid = false;
        } else {

            tahun.setError(null);
        }


        return valid;
    }


}
