package com.burak.project2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    SharedPreferences preferences;
    int sayac;
    int veri=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView = findViewById(R.id.Window);  //textView nesnesini buluyor önemli
        preferences =getSharedPreferences("com.burak.project2.MainActivity", Context.MODE_PRIVATE);
        veri=preferences.getInt("key",0);   //burda tahminimce veriyi alıyoruz
        sayac=veri;

        textView.setText(""+sayac);


    }




    public void say(View view) {  //Android XML dosyasında bir butona tıklama olayı tanımladığında, o butonun referansı otomatik olarak ilgili metoda View view parametresiyle gönderilir
       // sayac=veri;
        sayac+=1;
        textView.setText("deger:"+sayac);
        preferences.edit().putInt("key",sayac).apply();  //burda veriyi koyuyoruz

    }
    public void sifirla(View view){
        sayac=0;
      //  veri=0;
        textView.setText(""+sayac);
        preferences.edit().putInt("key",sayac);



    }
}