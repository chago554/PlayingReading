package com.utsem.playingreading.Controller;

import android.content.Intent;
import android.os.Bundle;

//bluetooth
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Set;
import com.utsem.playingreading.R;
import com.utsem.playingreading.Services.BluetoothService;

public class MenuPrincipal extends AppCompatActivity {
    private static final String TAG = "MenuPrincipal";
    private BluetoothService bluetoothService;
    private boolean isBound = false;
    LinearLayout contenido, noHayMaquina;
    Button btnNoMaquina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button connectButton = findViewById(R.id.btnIniciar);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

/*
        //ocultar la pagina de botones
        contenido = (LinearLayout) findViewById(R.id.lyContenidoBotones);
        contenido.setVisibility(View.GONE);
        noHayMaquina = (LinearLayout) findViewById(R.id.lyNoHayMaquina);
        noHayMaquina.setVisibility(View.VISIBLE);
        btnNoMaquina = (Button) findViewById(R.id.btnNoHayMaquina);
*/


        // Vincula el servicio Bluetooth
        Intent intent = new Intent(this, BluetoothService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);

        connectButton.setOnClickListener(v -> {

            if (bluetoothAdapter == null) {
                connectButton.setText("IMPOSIBLE CONECTAR");
                Toast.makeText(this, "Bluetooth no está disponible", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!bluetoothAdapter.isEnabled()) {
                connectButton.setText("CONECTAR");
                Toast.makeText(this, "Activa el Bluetooth primero", Toast.LENGTH_SHORT).show();
                return;
            }

            Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

            if (pairedDevices.size() > 0) {
                BluetoothDevice device = pairedDevices.iterator().next(); // Selecciona el primer dispositivo
                boolean success = bluetoothService.connectToDevice(device);
                if (success) {
                    connectButton.setText("CONECTADO");
                    Toast.makeText(this, "Conectado a " + device.getName(), Toast.LENGTH_SHORT).show();
                    if(connectButton.getText().toString().equals("CONECTADO")){
                        bluetoothService.startListening();
                    }

                } else {
                    connectButton.setText("DESCONECTADO");
                    Toast.makeText(this, "Error al conectar", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "No hay dispositivos emparejados", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Maneja la conexión al servicio

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isBound) {
            //     unbindService(serviceConnection);
            isBound = false;
        }
    }

    //no hay maquina
    public void noHayMaquina(View v){
        noHayMaquina.setVisibility(View.GONE);
        contenido.setVisibility(View.VISIBLE);
    }
//Comentario
}