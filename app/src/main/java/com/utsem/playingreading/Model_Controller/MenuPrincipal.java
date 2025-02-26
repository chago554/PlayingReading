package com.utsem.playingreading.Model_Controller;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.utsem.playingreading.R;
import com.utsem.playingreading.Services.BluetoothService;

import java.util.ArrayList;
import java.util.Set;

public class MenuPrincipal extends AppCompatActivity {
    private BluetoothService bluetoothService;
    private boolean isBound = false;
    private static final int REQUEST_ENABLE_BT = 1;
    private static final String TAG = "MenuPrincipal";

    private LinearLayout vistaConectar, vistaContenido, vistaBarra;
    private TextView textoOtrasOpciones;
    private HorizontalScrollView srcOtrasOpciones;
    private Button connectButton;

    private BluetoothAdapter bluetoothAdapter;

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

        // Inicialización de vistas
        connectButton = findViewById(R.id.btnConectar);
        vistaConectar = findViewById(R.id.lnyConectar);
        vistaContenido = findViewById(R.id.lnyContenido);
        vistaBarra = findViewById(R.id.lnyBarra);
        textoOtrasOpciones = findViewById(R.id.txtOtrasOpciones);
        srcOtrasOpciones = findViewById(R.id.scrOtrasOpciones);

        //ver solo el boton
        vistaConectar.setVisibility(View.VISIBLE);
        vistaContenido.setVisibility(View.GONE);
        vistaBarra.setVisibility(View.GONE);
        textoOtrasOpciones.setVisibility(View.GONE);
        srcOtrasOpciones.setVisibility(View.GONE);

        // Verifica y solicita permisos si es necesario
        checkPermissions();

        // Inicializa Bluetooth
        BluetoothManager bluetoothManager = getSystemService(BluetoothManager.class);
        bluetoothAdapter = bluetoothManager.getAdapter();

        if (bluetoothAdapter == null) {
            Toast.makeText(this, "Este dispositivo no soporta Bluetooth", Toast.LENGTH_SHORT).show();
            return;
        }

        // Vincula el servicio Bluetooth
        Intent intent = new Intent(this, BluetoothService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);

        connectButton.setOnClickListener(v -> conectarBluetooth());
    }

    //Verifica y solicita permisos necesarios para Bluetooth.

    private void checkPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.BLUETOOTH_CONNECT,
                    Manifest.permission.BLUETOOTH_SCAN
            }, REQUEST_ENABLE_BT);
        }
    }

    // Maneja la respuesta de la solicitud de permisos.

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_ENABLE_BT) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permisos concedidos", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Se necesitan permisos de Bluetooth para continuar", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //Inicia el proceso de conexión Bluetooth.

    private void conectarBluetooth() {

        Log.d(TAG, "isBound: " + isBound);
        Log.d(TAG, "bluetoothService: " + (bluetoothService != null ? "Inicializado" : "NULO"));


        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            return;
        }

        if (!isBound) {
            Intent intent = new Intent(this, BluetoothService.class);
            bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        }

        new android.os.Handler().postDelayed(() -> {
            if (bluetoothService == null) {
                Toast.makeText(this, "El servicio Bluetooth aún no está listo. Intenta de nuevo.", Toast.LENGTH_SHORT).show();
            } else {
                Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

                if (pairedDevices.isEmpty()) {
                    Toast.makeText(this, "No hay dispositivos emparejados", Toast.LENGTH_SHORT).show();
                    return;
                }

                ArrayList<String> deviceNames = new ArrayList<>();
                ArrayList<BluetoothDevice> deviceList = new ArrayList<>();

                for (BluetoothDevice device : pairedDevices) {
                    deviceNames.add(device.getName() + "\n" + device.getAddress());
                    deviceList.add(device);
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
                builder.setTitle("Selecciona un dispositivo")
                        .setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, deviceNames),
                                (dialog, which) -> conectarDispositivo(deviceList.get(which)));

                builder.setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss());
                builder.show();
            }
        }, 500); // Medio segundo de espera




    }

    //Conecta al dispositivo Bluetooth seleccionado.

    private void conectarDispositivo(BluetoothDevice device) {
        if (bluetoothService != null) {
            boolean success = bluetoothService.connectToDevice(device);
            if (success) {
                Toast.makeText(this, "Conectado a " + device.getName(), Toast.LENGTH_SHORT).show();
                bluetoothService.startListening();
                mostrarInterfaz();
            } else {
                Toast.makeText(this, "Error al conectar con " + device.getName(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Muestra la interfaz después de conectar.

    private void mostrarInterfaz() {
        vistaConectar.setVisibility(View.GONE);
        vistaContenido.setVisibility(View.VISIBLE);
        vistaBarra.setVisibility(View.VISIBLE);
        textoOtrasOpciones.setVisibility(View.VISIBLE);
        srcOtrasOpciones.setVisibility(View.VISIBLE);
    }

    //Maneja la habilitación de Bluetooth.

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ENABLE_BT) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Bluetooth habilitado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Bluetooth no habilitado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //Conexión con el servicio Bluetooth.
    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BluetoothService.LocalBinder binder = (BluetoothService.LocalBinder) service;
            bluetoothService = binder.getService();
            isBound = true;
            Log.d(TAG, "Servicio Bluetooth vinculado correctamente");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bluetoothService = null;
            isBound = false;
            Log.d(TAG, "Servicio Bluetooth desvinculado");
        }
    };


    public void goAventuras (View v){
        Intent intent = new Intent(this, AventuraModel.class);
        startActivity(intent);
    }
    public void goCienciaFiccion (View v){
        Intent intent =  new Intent(this, CienciaFiccion.class);
        startActivity(intent);
    }
    public void goSuperheroes (View v){
        Intent intent =  new Intent(this, Superheroes.class);
        startActivity(intent);
    }
    public void goPrincesas(View v){
        Intent intent =  new Intent(this, PrincesasyHadas.class);
        startActivity(intent);
    }
    public void goMisterio(View v){
        Intent intent =  new Intent(this, MisterioyDetectives.class);
        startActivity(intent);
    }
    public void goMemoramas(View v){
        Intent intent =  new Intent(this, Memorama.class);
        startActivity(intent);
    }

    public void salir(View v){this.finish();}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isBound) {
            unbindService(serviceConnection);
            isBound = false;
        }
    }
}
