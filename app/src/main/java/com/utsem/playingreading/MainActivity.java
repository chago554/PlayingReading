package com.utsem.playingreading;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.utsem.playingreading.Model_Controller.MenuPrincipal;
import com.utsem.playingreading.Services.BluetoothService;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private static final int REQUEST_PERMISSIONS_CODE = 100;
    private static final int REQUEST_ENABLE_BT = 1;
    private static final String[] REQUIRED_PERMISSIONS = new String[]{
            Manifest.permission.BLUETOOTH_SCAN,
            Manifest.permission.BLUETOOTH_CONNECT
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            v.setPadding(insets.getInsets(WindowInsetsCompat.Type.systemBars()).left,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).right,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
            return insets;
        });

        Intent serviceIntent = new Intent(this, BluetoothService.class);
        startService(serviceIntent);
        Button btnIniciar = findViewById(R.id.btnIniciar);

        // Configuración del MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.musicaloopinicio);
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }

        // Solicitar permisos si es necesario
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && !hasPermissions()) {
            requestPermissions(REQUIRED_PERMISSIONS, REQUEST_PERMISSIONS_CODE);
        }

        btnIniciar.setOnClickListener(this::menuPrincipal);
    }

    private boolean hasPermissions() {
        for (String permission : REQUIRED_PERMISSIONS) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSIONS_CODE) {
            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permisos de Bluetooth denegados. La aplicación no funcionará correctamente.", Toast.LENGTH_LONG).show();
                    finish(); // Cierra la actividad si los permisos son rechazados
                    return;
                }
            }
            Log.d("Permisos", "Todos los permisos concedidos.");
        }
    }

    public void menuPrincipal(View v) {
        if (!hasPermissions()) {
            Toast.makeText(this, "Se necesitan permisos de Bluetooth para continuar", Toast.LENGTH_SHORT).show();
            requestPermissions(REQUIRED_PERMISSIONS, REQUEST_PERMISSIONS_CODE);
            return;
        }

        BluetoothManager bluetoothManager = getSystemService(BluetoothManager.class);
        if (bluetoothManager == null) {
            Toast.makeText(this, "Bluetooth no soportado en este dispositivo.", Toast.LENGTH_SHORT).show();
            return;
        }

        BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth no disponible.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        } else {
            iniciarMenuPrincipal();
        }
    }

    private void iniciarMenuPrincipal() {
        Intent menu = new Intent(this, MenuPrincipal.class);
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        startActivity(menu);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        Intent stopIntent = new Intent(this, BluetoothService.class);
        stopService(stopIntent);
    }
}