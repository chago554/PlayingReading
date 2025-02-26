package com.utsem.playingreading.Model_Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.utsem.playingreading.Model_Controller.Aventuras.CuentosAventura;
import com.utsem.playingreading.R;

public class AventuraModel extends AppCompatActivity {
    private int valorCuentoSelecto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_aventura);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void goBack(View v){this.finish();}

    public void cuento01(View v) {
        Intent intent = new Intent(this, CuentosAventura.class);
        intent.putExtra("VALOR_CUENTO_SELECTO", 1);
        startActivity(intent);
    }
    public void cuento02(View v) {
        Intent intent = new Intent(this, CuentosAventura.class);
        intent.putExtra("VALOR_CUENTO_SELECTO", 2);
        startActivity(intent);
    }
    public void cuento03(View v) {
        Intent intent = new Intent(this, CuentosAventura.class);
        intent.putExtra("VALOR_CUENTO_SELECTO", 3);
        startActivity(intent);
    }
    public void cuento04(View v) {
        Intent intent = new Intent(this, CuentosAventura.class);
        intent.putExtra("VALOR_CUENTO_SELECTO", 4);
        startActivity(intent);
    }
    public void cuento05(View v) {
        Intent intent = new Intent(this, CuentosAventura.class);
        intent.putExtra("VALOR_CUENTO_SELECTO", 5);
        startActivity(intent);
    }

    public void setValorCuentoSelecto(int valorCuentoSelecto){
        this.valorCuentoSelecto = valorCuentoSelecto;
    }
    public int getValorCuentoSelecto(){
        return this.valorCuentoSelecto;
    }
}