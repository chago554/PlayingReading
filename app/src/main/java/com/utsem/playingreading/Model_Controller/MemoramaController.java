package com.utsem.playingreading.Model_Controller;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.Bundle;

import com.utsem.playingreading.Services.BluetoothService;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoramaController {

    private BluetoothService bluetoothService;
    private boolean isBound = false;

    List<ImageButton> imagenes_botones = new ArrayList<>();
    Map<ImageButton, Integer> imagenesAsignadas = new HashMap<>();
    int colorOculto = Color.GRAY;
    List<ImageButton> botonesSeleccionados = new ArrayList<>();
    Handler handler = new Handler();
    int[] imagenes;

    public void cargarMemorama(View v, int[] botones, int[] imaInts) {
        imagenes = imaInts;
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
        ImageButton boton = (ImageButton) v;
        Integer imagenOriginal = imagenesAsignadas.get(boton);
        if (imagenOriginal != null && botonesSeleccionados.size() < 2 && boton.isEnabled()) {
            boton.setImageResource(imagenOriginal);
            boton.setBackgroundColor(Color.TRANSPARENT);
            boton.setEnabled(false);
            botonesSeleccionados.add(boton);
            if (botonesSeleccionados.size() == 2) {
                handler.postDelayed(this::comprobarMemorama, 500);
            }
        }
    }

    private void comprobarMemorama() {
        if (botonesSeleccionados.size() != 2) {
            return; // No hay dos botones seleccionados.
        }
        ImageButton boton1 = botonesSeleccionados.get(0);
        ImageButton boton2 = botonesSeleccionados.get(1);
        int imagen1 = imagenesAsignadas.get(boton1);
        int imagen2 = imagenesAsignadas.get(boton2);
        if (imagen1 == imagen2) {
            boton1.setEnabled(false);
            boton2.setEnabled(false);
            botonesSeleccionados.clear();
            if (imagenes_botones.isEmpty()) {
                Toast.makeText(boton1.getContext(), "¡Finalizado!", Toast.LENGTH_SHORT).show();
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
        bluetoothService.sendData("A");
    }

}