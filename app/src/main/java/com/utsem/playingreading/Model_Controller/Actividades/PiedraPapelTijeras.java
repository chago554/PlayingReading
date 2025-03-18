package com.utsem.playingreading.Model_Controller.Actividades;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.utsem.playingreading.R;
import com.utsem.playingreading.Services.BluetoothService;

public class PiedraPapelTijeras extends AppCompatActivity {
    private BluetoothService bluetoothService = new BluetoothService();
    private boolean isBound = false;

    private TextView txtVictoriasJugador;
    private TextView txtVictoriasMaquina;
    private ImageButton imgBtnPiedra;
    private ImageButton imgBtnPapel;
    private ImageButton imgBtnTijeras;
    private Button volver;
    private String seleccionJugador = "";
    private String seleccionMaquina = "";

    private int victoriasMaquina =0;
    private int victoriasJugador =0;

    String [] arrayPoderes = {
            "Piedra",
            "Papel",
            "Tijeras"
    };

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_piedra_papel_tijeras);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cargarComponentes();
        seleccionMaquina = arrayPoderes[(int) (Math.random() * 3)];
        txtVictoriasJugador.setText("" + victoriasJugador);
        txtVictoriasMaquina.setText("" + victoriasMaquina);
    }

    public void cargarComponentes(){
        txtVictoriasJugador = findViewById(R.id.txtVictoriasJugador);
        txtVictoriasMaquina = findViewById(R.id.txtVictoriasMaquina);
        imgBtnPiedra = findViewById(R.id.imgBtnPiedra);
        imgBtnPapel = findViewById(R.id.imgBtnPapel);
        imgBtnTijeras = findViewById(R.id.imgBtnTijeras);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            if (service instanceof BluetoothService.LocalBinder) {
                BluetoothService.LocalBinder binder = (BluetoothService.LocalBinder) service;
                bluetoothService = binder.getService();
                isBound = true;
            } else {
                Log.e("CuentosAventura", "Error: No se pudo castear el IBinder correctamente.");
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bluetoothService = null;
            isBound = false;
        }
    };

    //soltar dulce al final de cuento
    public void soltarDulce(){
        Intent intent = new Intent(this, BluetoothService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        if(bluetoothService != null){
            try {
                bluetoothService.sendData("7kirDM4r7^P@^$9B#^M#M%40#");
            }catch (Exception e){
                Log.e("SoltarDulce", "Falla al soltar el dulce");
            }
        }
    }

    public void botonClickeado(View v) {
        if (v.getId() == R.id.imgBtnPiedra) {
           seleccionJugador = "Piedra";
        } else if (v.getId() == R.id.imgBtnPapel) {
            seleccionJugador = "Papel";
        } else if (v.getId() == R.id.imgBtnTijeras) {
            seleccionJugador = "Tijeras";
        }
        comprobarGanador();
    }

    public void comprobarGanador(){
        if(seleccionMaquina.equals(seleccionJugador)){
            mediaPlayer = MediaPlayer.create(this, R.raw.empate);
            mediaPlayer.start();
            Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show();
        }
        //gana maquina
        if(seleccionMaquina.equals("Piedra") && seleccionJugador.equals("Tijeras")){
            victoriasMaquina = victoriasMaquina + 1;
            txtVictoriasMaquina.setText("" + victoriasMaquina);
            mediaPlayer = MediaPlayer.create(this, R.raw.perder);
            mediaPlayer.start();
            Toast.makeText(this, "Máquina: " + seleccionMaquina, Toast.LENGTH_SHORT).show();
        }else if(seleccionMaquina.equals("Tijeras") && seleccionJugador.equals("Papel")){
            victoriasMaquina = victoriasMaquina + 1;
            txtVictoriasMaquina.setText("" + victoriasMaquina);
            mediaPlayer = MediaPlayer.create(this, R.raw.perder);
            mediaPlayer.start();
            Toast.makeText(this, "Máquina: " + seleccionMaquina, Toast.LENGTH_SHORT).show();
        }else if(seleccionMaquina.equals("Papel") && seleccionJugador.equals("Piedra")){
            victoriasMaquina = victoriasMaquina + 1;
            txtVictoriasMaquina.setText("" + victoriasMaquina);
            mediaPlayer = MediaPlayer.create(this, R.raw.perder);
            mediaPlayer.start();
            Toast.makeText(this, "Máquina: " + seleccionMaquina, Toast.LENGTH_SHORT).show();
        }

        //gana jugador
        if(seleccionJugador.equals("Piedra") && seleccionMaquina.equals("Tijeras")){
            victoriasJugador = victoriasJugador + 1;
            txtVictoriasJugador.setText("" + victoriasJugador);
            mediaPlayer = MediaPlayer.create(this, R.raw.ganar);
            mediaPlayer.start();
            Toast.makeText(this, "Máquina: " + seleccionMaquina, Toast.LENGTH_SHORT).show();
        }else if(seleccionJugador.equals("Tijeras") && seleccionMaquina.equals("Papel")){
            victoriasJugador = victoriasJugador + 1;
            txtVictoriasJugador.setText("" + victoriasJugador);
            mediaPlayer = MediaPlayer.create(this, R.raw.ganar);
            mediaPlayer.start();
            Toast.makeText(this, "Máquina: " + seleccionMaquina, Toast.LENGTH_SHORT).show();
        }else if(seleccionJugador.equals("Papel") && seleccionMaquina.equals("Piedra")){
            victoriasJugador = victoriasJugador + 1;
            txtVictoriasJugador.setText("" + victoriasJugador);
            mediaPlayer = MediaPlayer.create(this, R.raw.ganar);
            mediaPlayer.start();
            Toast.makeText(this, "Máquina: " + seleccionMaquina, Toast.LENGTH_SHORT).show();
        }
        seleccionMaquina = arrayPoderes[(int) (Math.random() * 3)];

        if(victoriasJugador==3) {
            Toast.makeText(this, "¡¡Ganaste!!", Toast.LENGTH_LONG).show();
            soltarDulce();
            mediaPlayer = MediaPlayer.create(this, R.raw.ganaste);
            mediaPlayer.start();
            imgBtnPiedra.setEnabled(false);
            imgBtnPapel.setEnabled(false);
            imgBtnTijeras.setEnabled(false);
        } else if (victoriasMaquina == 3) {
            Toast.makeText(this, "¡Perdiste!", Toast.LENGTH_LONG).show();
            mediaPlayer = MediaPlayer.create(this, R.raw.perdiste);
            mediaPlayer.start();
            imgBtnPiedra.setEnabled(false);
            imgBtnPapel.setEnabled(false);
            imgBtnTijeras.setEnabled(false);
        }
    }

    public void reset (View v){
        victoriasJugador = 0;
        txtVictoriasJugador.setText("" + victoriasJugador);
        victoriasMaquina = 0;
        txtVictoriasMaquina.setText("" + victoriasMaquina);
        imgBtnPiedra.setEnabled(true);
        imgBtnPapel.setEnabled(true);
        imgBtnTijeras.setEnabled(true);
    }

    public void goBack(View v){
        this.finish();
    }

    public BluetoothService getBluetoothService() {
        return bluetoothService;
    }

    public void setBluetoothService(BluetoothService bluetoothService) {
        this.bluetoothService = bluetoothService;
    }

    public ServiceConnection getServiceConnection() {
        return serviceConnection;
    }

    public void setServiceConnection(ServiceConnection serviceConnection) {
        this.serviceConnection = serviceConnection;
    }

    public boolean isBound() {
        return isBound;
    }

    public void setBound(boolean bound) {
        isBound = bound;
    }

    public TextView getTxtVictoriasJugador() {
        return txtVictoriasJugador;
    }

    public void setTxtVictoriasJugador(TextView txtVictoriasJugador) {
        this.txtVictoriasJugador = txtVictoriasJugador;
    }

    public TextView getTxtVictoriasMaquina() {
        return txtVictoriasMaquina;
    }

    public void setTxtVictoriasMaquina(TextView txtVictoriasMaquina) {
        this.txtVictoriasMaquina = txtVictoriasMaquina;
    }

    public ImageButton getImgBtnPiedra() {
        return imgBtnPiedra;
    }

    public void setImgBtnPiedra(ImageButton imgBtnPiedra) {
        this.imgBtnPiedra = imgBtnPiedra;
    }

    public ImageButton getImgBtnPapel() {
        return imgBtnPapel;
    }

    public void setImgBtnPapel(ImageButton imgBtnPapel) {
        this.imgBtnPapel = imgBtnPapel;
    }

    public ImageButton getImgBtnTijeras() {
        return imgBtnTijeras;
    }

    public void setImgBtnTijeras(ImageButton imgBtnTijeras) {
        this.imgBtnTijeras = imgBtnTijeras;
    }

    public Button getVolver() {
        return volver;
    }

    public void setVolver(Button volver) {
        this.volver = volver;
    }

    public String getSeleccionJugador() {
        return seleccionJugador;
    }

    public void setSeleccionJugador(String seleccionJugador) {
        this.seleccionJugador = seleccionJugador;
    }

}