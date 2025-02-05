package com.utsem.playingreading;

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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.utsem.playingreading.Controller.MenuPrincipal;

public class MainActivity extends AppCompatActivity {
    //para poner la musica de loop al iniciar
    MediaPlayer mediaPlayer;
    private static final int REQUEST_PERMISSIONS_CODE = 100;
    private static final String[] REQUIRED_PERMISSIONS = new String[] {
            android.Manifest.permission.BLUETOOTH_SCAN,
            android.Manifest.permission.BLUETOOTH_CONNECT
    };
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
        Button btnIniciar = findViewById(R.id.btnIniciar);

        // Inicializar el MediaPlayer con el recurso de audio
        mediaPlayer = MediaPlayer.create(this, R.raw.musicaloopinicio); // 'audio' es el nombre del archivo sin la extensión
        mediaPlayer.setLooping(true); // Activar el loop
        mediaPlayer.start(); // Iniciar la reproducción

        //permisos
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) { // Android 12 y superior
            if (!hasPermissions(REQUIRED_PERMISSIONS)) {
                requestPermissions(REQUIRED_PERMISSIONS, REQUEST_PERMISSIONS_CODE);
            }
        }
    }
    // Método para comprobar si los permisos ya se concedieron
    private boolean hasPermissions(String[] permissions) {
        for (String permission : permissions) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
    // Método para gestionar la respuesta del usuario
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSIONS_CODE) {
            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    Log.e("Permisos", "No se concedieron todos los permisos necesarios.");
                    return;
                }
            }
            Log.d("Permisos", "Todos los permisos concedidos.");
        }
    }
    //ir al menu principal
    public void menuPrincipal(View v){
        Intent menu = new Intent(this, MenuPrincipal.class);
        mediaPlayer.stop();
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
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            Toast.makeText(this, "Holaa?", Toast.LENGTH_SHORT).show();
        }
    }
}

