package com.utsem.playingreading.Model_Controller;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.utsem.playingreading.R;
import com.utsem.playingreading.Services.BluetoothService;

public class Memorama extends AppCompatActivity {

    private BluetoothService bluetoothService;
    private boolean isBound = false;
    private MemoramaController memorama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_memorama);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button reset = (Button) findViewById(R.id.btnReset);

        memorama = new MemoramaController();
        int[] imagenes = {
                R.drawable.princesasyhadas,
                R.drawable.princesasyhadas,
                R.drawable.superheroes,
                R.drawable.superheroes,
                R.drawable.aventura,
                R.drawable.aventura,
                R.drawable.cienciaficcion,
                R.drawable.cienciaficcion,
                R.drawable.portatil,
                R.drawable.portatil,
                R.drawable.playingreadinlogo,
                R.drawable.playingreadinlogo,
                R.drawable.misterioydetective,
                R.drawable.misterioydetective,
                R.drawable.tilogo,
                R.drawable.tilogo
        };
        int[] botones = {
                R.id.imgBtn01, R.id.imgBtn02, R.id.imgBtn03, R.id.imgBtn04,
                R.id.imgBtn05, R.id.imgBtn06, R.id.imgBtn07, R.id.imgBtn08,
                R.id.imgBtn09, R.id.imgBtn10, R.id.imgBtn11, R.id.imgBtn12,
                R.id.imgBtn13, R.id.imgBtn14, R.id.imgBtn15, R.id.imgBtn16
        };
        memorama.cargarMemorama(findViewById(R.id.main), botones, imagenes, this);

    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BluetoothService.LocalBinder binder = (BluetoothService.LocalBinder) service;
            bluetoothService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bluetoothService = null;
            isBound = false;
        }
    };

    public void mandarA() {
        Intent intent = new Intent(this, BluetoothService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        if (bluetoothService != null) {
            bluetoothService.sendData("A");
            Toast.makeText(this, "Recoge tu premio", Toast.LENGTH_SHORT).show();
        }
    }
    public void goBack(View v){
        this.finish();
    }

    public void reset(View v){
        super.recreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isBound) {
            unbindService(serviceConnection);
            isBound = false;
        }
    }
}