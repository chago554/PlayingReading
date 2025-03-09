package com.utsem.playingreading.Model_Controller.MisterioyDetectives;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.utsem.playingreading.R;

public class MisterioyDetectivesMenu extends AppCompatActivity {
    private int valorCuentoSelecto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_misterioy_detectives_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.btnCuento001).setOnClickListener(v -> cuento01());
        findViewById(R.id.btnCuento002).setOnClickListener(v -> cuento02());
        findViewById(R.id.btnCuento003).setOnClickListener(v -> cuento03());
        findViewById(R.id.btnCuento004).setOnClickListener(v -> cuento04());
        findViewById(R.id.btnCuento005).setOnClickListener(v -> cuento05());
        findViewById(R.id.btnGoBack).setOnClickListener(v -> goBack());
    }
    private void goBack(){
        this.finish();
    }

    private void cuento01() {
        Intent intent = new Intent(this, CuentosMisterioyDetectives.class);
        intent.putExtra("VALOR_CUENTO_SELECTO", 1);
        startActivity(intent);
    }
    private void cuento02() {
        Intent intent = new Intent(this, CuentosMisterioyDetectives.class);
        intent.putExtra("VALOR_CUENTO_SELECTO", 2);
        startActivity(intent);
    }
    public void cuento03() {
        Intent intent = new Intent(this, CuentosMisterioyDetectives.class);
        intent.putExtra("VALOR_CUENTO_SELECTO", 3);
        startActivity(intent);
    }
    public void cuento04() {
        Intent intent = new Intent(this, CuentosMisterioyDetectives.class);
        intent.putExtra("VALOR_CUENTO_SELECTO", 4);
        startActivity(intent);
    }
    public void cuento05() {
        Intent intent = new Intent(this, CuentosMisterioyDetectives.class);
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