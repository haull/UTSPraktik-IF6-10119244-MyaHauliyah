package com.example.utspraktik_if6_10119244_myahauliyah;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


//10119244 - MYA HAULIYAH - 3 Juni 2022

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_NAMA = "nama";
    public static final String EXTRA_NIK = "nik";
    public static final String EXTRA_TGL = "tgl";
    public static final String EXTRA_KELAMIN = "kelamin";
    public static final String EXTRA_HUBUNGAN = "hubungan";
    public static final String EXTRA_STATUS = "status";
    public static final String EXTRA_TES = "tes";
    public static final String EXTRA_TGLKON = "tglkon";


    private Dialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        Intent intent = getIntent();
        Intent intent2 = new Intent(this,MainActivity.class);

        String tes = intent.getStringExtra(MainActivity.EXTRA_TES);
        String tglkon = intent.getStringExtra(MainActivity.EXTRA_TGLKON);
        String nik = intent.getStringExtra(MainActivity.EXTRA_NIK);
        String nama = intent.getStringExtra(MainActivity.EXTRA_NAMA);
        String jk = intent.getStringExtra(MainActivity.EXTRA_KELAMIN);
        String tgl = intent.getStringExtra(MainActivity.EXTRA_TGL);
        String hub = intent.getStringExtra(MainActivity.EXTRA_HUBUNGAN);

        TextView tvTes = findViewById(R.id.j_tes);
        TextView tvTglKon = findViewById(R.id.j_tglkon);
        TextView tvNik = findViewById(R.id.j_nik);
        TextView tvNama = findViewById(R.id.j_nama);
        TextView tvTgl = findViewById(R.id.j_tgl);
        TextView tvHub = findViewById(R.id.j_hub);
        TextView tvJk = findViewById(R.id.j_jk);
        Button btn_simpan= findViewById(R.id.btn_simpan);
        Button btn_ubah= findViewById(R.id.btn_ubah);



        tvTes.setText(tes);
        tvTglKon.setText(tglkon);
        tvNik.setText(nik);
        tvNama.setText(nama);
        tvTgl.setText(tgl);
        tvJk.setText(jk);
        tvHub.setText(hub);
        initCustomDialog();

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.show();
            }
        });

        btn_ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2.putExtra(EXTRA_TES,tes);
                intent2.putExtra(EXTRA_TGLKON,tglkon);
                intent2.putExtra(EXTRA_STATUS,"ubah");
                intent2.putExtra(EXTRA_NIK,nik);
                intent2.putExtra(EXTRA_NAMA,nama);
                intent2.putExtra(EXTRA_TGL,tgl);
                intent2.putExtra(EXTRA_KELAMIN,jk);
                intent2.putExtra(EXTRA_HUBUNGAN,hub);


                startActivity(intent2);
            }
        });
    }

    private void initCustomDialog(){

        customDialog = new Dialog(MainActivity2.this);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setContentView(R.layout.activity_success);
        customDialog.setCancelable(true);


        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);
            }
        });

        Button btnok = customDialog.findViewById(R.id.btn_ok);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customDialog.dismiss();
            }
        });
    }
}
