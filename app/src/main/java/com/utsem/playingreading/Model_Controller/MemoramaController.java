package com.utsem.playingreading.Model_Controller;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.os.SystemClock;

import com.utsem.playingreading.R;
import com.utsem.playingreading.Services.BluetoothService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoramaController {

    private BluetoothService bluetoothService;
    private boolean isBound = false;

    private long tiempoInicio = 0;
    private boolean cronometroActivo = false;
    private TextView cronometroTextView;
    private Handler cronometroHandler = new Handler();
    private Runnable actualizarCronometro;

    List<ImageButton> imagenes_botones = new ArrayList<>();
    Map<ImageButton, Integer> imagenesAsignadas = new HashMap<>();
    int colorOculto = Color.GRAY;
    List<ImageButton> botonesSeleccionados = new ArrayList<>();
    Handler handler = new Handler();
    int[] imagenes;

    private Context context;

    public void cargarMemorama(View v, int[] botones, int[] imaInts, Context context) {
        this.context = context;
        imagenes = imaInts;
        cronometroTextView = v.findViewById(R.id.txtCronometro); // se obtiene el textView del cronometro
        TextView txtTop3 = ((Activity) context).findViewById(R.id.txtTop3);
        SharedPreferences prefs = context.getSharedPreferences("MemoramaRangos", Context.MODE_PRIVATE);
        int mejor1 = prefs.getInt("Mejor1", Integer.MAX_VALUE);
        int mejor2 = prefs.getInt("Mejor2", Integer.MAX_VALUE);
        int mejor3 = prefs.getInt("Mejor3", Integer.MAX_VALUE);

        txtTop3.setText("Top 3 Mejores tiempos:\n1. " + (mejor1 == Integer.MAX_VALUE ? "--" : mejor1 + "s") +
                "\n2. " + (mejor2 == Integer.MAX_VALUE ? "--" : mejor2 + "s") +
                "\n3. " + (mejor3 == Integer.MAX_VALUE ? "--" : mejor3 + "s"));

        for (int id : botones) {
            ImageButton imgButton = v.findViewById(id);
            imagenes_botones.add(imgButton);
            imgButton.setBackgroundColor(colorOculto);
            imgButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgButton.setOnClickListener(this::onImageButtonClick);
        }

        iniciarMemorana();
    }

    public void iniciarMemorana() {
        List<Integer> imagenesDisponibles = new ArrayList<>();
        for (int imagen : imagenes) {
            imagenesDisponibles.add(imagen);
        }
        Collections.shuffle(imagenesDisponibles);
        if (imagenesDisponibles.size() < imagenes_botones.size()) {
            throw new IllegalArgumentException("Not enough images for the number of buttons.");
        }
        for (int i = 0; i < imagenes_botones.size(); i++) {
            ImageButton boton = imagenes_botones.get(i);
            int imagenAsignada = imagenesDisponibles.get(i);
            imagenesAsignadas.put(boton, imagenAsignada);
        }
    }

    public void onImageButtonClick(View v) {
        if (!cronometroActivo) {
            iniciarCronometro();
        }

        ImageButton boton = (ImageButton) v;
        Integer imagenOriginal = imagenesAsignadas.get(boton);
        if (imagenOriginal != null && botonesSeleccionados.size() < 2 && boton.isEnabled()) {
            boton.setImageResource(imagenOriginal);
            boton.setBackgroundColor(Color.TRANSPARENT);
            boton.setEnabled(false);
            botonesSeleccionados.add(boton);
            if (botonesSeleccionados.size() == 2) {
                handler.postDelayed(this::comprobarMemorama, 300);
            }
        }
    }

    private void comprobarMemorama() {
        if (botonesSeleccionados.size() != 2) {
            return;
        }

        ImageButton boton1 = botonesSeleccionados.get(0);
        ImageButton boton2 = botonesSeleccionados.get(1);
        int imagen1 = imagenesAsignadas.get(boton1);
        int imagen2 = imagenesAsignadas.get(boton2);

        if (imagen1 == imagen2) {
            boton1.setEnabled(false);
            boton2.setEnabled(false);
            botonesSeleccionados.clear();

            if (verificarJuegoTerminado()) {
                detenerCronometro();
                guardarTiempo();
                mandarA();
            }
        } else {
            boton1.setBackgroundColor(colorOculto);
            boton2.setBackgroundColor(colorOculto);
            boton1.setImageResource(0);
            boton2.setImageResource(0);
            boton1.setEnabled(true);
            boton2.setEnabled(true);
        }

        botonesSeleccionados.clear();
    }

    private boolean verificarJuegoTerminado() {
        for (ImageButton boton : imagenes_botones) {
            if (boton.isEnabled()) {
                return false;
            }
        }
        return true;
    }

    private void iniciarCronometro() {
        tiempoInicio = SystemClock.elapsedRealtime();
        cronometroActivo = true;

        actualizarCronometro = new Runnable() {
            @Override
            public void run() {
                long tiempoActual = SystemClock.elapsedRealtime() - tiempoInicio;
                int segundos = (int) (tiempoActual / 1000);
                cronometroTextView.setText("Tiempo: " + segundos + "s");
               // cronometroHandler.postDelayed(this, 500);
            }
        };
        cronometroHandler.post(actualizarCronometro);
    }

    private void detenerCronometro() {
        cronometroActivo = false;
        cronometroHandler.removeCallbacks(actualizarCronometro);
    }

    private void guardarTiempo() {
        SharedPreferences prefs = context.getSharedPreferences("MemoramaScores", Context.MODE_PRIVATE);
        int mejor1 = prefs.getInt("Mejor1", Integer.MAX_VALUE);
        int mejor2 = prefs.getInt("Mejor2", Integer.MAX_VALUE);
        int mejor3 = prefs.getInt("Mejor3", Integer.MAX_VALUE);

        long tiempoFinal = SystemClock.elapsedRealtime() - tiempoInicio;
        int tiempoSegundos = (int) (tiempoFinal / 1000);

        if (tiempoSegundos < mejor1) {
            mejor3 = mejor2;
            mejor2 = mejor1;
            mejor1 = tiempoSegundos;
        } else if (tiempoSegundos < mejor2) {
            mejor3 = mejor2;
            mejor2 = tiempoSegundos;
        } else if (tiempoSegundos < mejor3) {
            mejor3 = tiempoSegundos;
        }

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Mejor1", mejor1);
        editor.putInt("Mejor2", mejor2);
        editor.putInt("Mejor3", mejor3);
        editor.apply();
        TextView txtTop3 = ((Activity) context).findViewById(R.id.txtTop3);
        txtTop3.setText("Top 3 Mejores Tiempos:\n1. " + (mejor1 == Integer.MAX_VALUE ? "--" : mejor1 + "s") +
                "\n2. " + (mejor2 == Integer.MAX_VALUE ? "--" : mejor2 + "s") +
                "\n3. " + (mejor3 == Integer.MAX_VALUE ? "--" : mejor3 + "s"));


        Toast.makeText(context, "Mejores tiempos: " + mejor1 + "s, " + mejor2 + "s, " + mejor3 + "s", Toast.LENGTH_LONG).show();
    }

    public void mandarA() {
        if (bluetoothService != null) {
            bluetoothService.sendData("A");
        }
    }
}
