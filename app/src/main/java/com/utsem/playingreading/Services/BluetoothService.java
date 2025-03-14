package com.utsem.playingreading.Services;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import android.os.Handler;
import android.os.Looper;

import com.utsem.playingreading.R;

public class BluetoothService extends Service {

    private static final String TAG = "BluetoothService";
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    private final IBinder binder = new LocalBinder();
    private BluetoothSocket btSocket;
    private OutputStream mmOutStream;
    private InputStream mmInputStream;
    private boolean isConnected = false;
    private final Handler reconnectHandler = new Handler(Looper.getMainLooper());
    private static final int RECONNECT_DELAY = 5000; // 5 segundos de espera antes de intentar reconectar
    private BluetoothDevice lastDevice; // Guardar el último dispositivo conectado


    public class LocalBinder extends Binder {
        public BluetoothService getService() {
            return BluetoothService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Servicio iniciado");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "BluetoothServiceChannel",
                    "Bluetooth Service",
                    NotificationManager.IMPORTANCE_LOW
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }

            Notification notification = new NotificationCompat.Builder(this, "BluetoothServiceChannel")
                    .setContentTitle("Conexión Bluetooth Activa")
                    .setContentText("Manteniendo la conexión con la máquina de recompensas")
                    .setSmallIcon(R.drawable.bluetooth)
                    .build();

            startForeground(1, notification);
        }
    }



    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "Servicio vinculado");
        return binder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Servicio destruido");
        closeConnection();
    }

    public boolean connectToDevice(BluetoothDevice device) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            Log.e(TAG, "Permiso BLUETOOTH_CONNECT no concedido.");
            return false;
        }

        closeConnection(); // Cierra cualquier conexión anterior
        lastDevice = device; // Guarda el último dispositivo conectado

        new Thread(() -> {
            try {
                btSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
                btSocket.connect();

                mmOutStream = btSocket.getOutputStream();
                mmInputStream = btSocket.getInputStream();
                isConnected = true;

                Log.d(TAG, "Conexión Bluetooth exitosa con " + device.getName());

                startListening();
            } catch (IOException e) {
                Log.e(TAG, "Error al conectar: " + e.getMessage());
                scheduleReconnect(); // Intentar reconectar
            }
        }).start();

        return true;
    }

    private void scheduleReconnect() {
        if (lastDevice != null) {
            Log.d(TAG, "Intentando reconectar en " + RECONNECT_DELAY / 1000 + " segundos...");
            reconnectHandler.postDelayed(() -> connectToDevice(lastDevice), RECONNECT_DELAY);
        }
    }



    public void sendData(String data) {
        try {
            mmOutStream.write(data.getBytes());
            Log.d(TAG, "Datos enviados: " + data);
        } catch (IOException e) {
            Log.e(TAG, "Error al enviar datos: " + e.getMessage());
        }
    }

    public void startListening() {
        if (!isConnected || mmInputStream == null) {
            Log.e(TAG, "No se puede escuchar datos: no hay conexión establecida.");
            return;
        }

        new Thread(() -> {
            byte[] buffer = new byte[1024];
            int bytes;

            while (isConnected) {
                try {
                    bytes = mmInputStream.read(buffer);
                    if (bytes > 0) {
                        String receivedData = new String(buffer, 0, bytes);
                        Log.d(TAG, "Datos recibidos: " + receivedData);
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Error al recibir datos: " + e.getMessage());
                    closeConnection();
                }
            }
        }).start();
    }

    public void closeConnection() {
        try {
            if (btSocket != null) {
                btSocket.close();
                btSocket = null;
            }
            if (mmOutStream != null) {
                mmOutStream.close();
                mmOutStream = null;
            }
            if (mmInputStream != null) {
                mmInputStream.close();
                mmInputStream = null;
            }
            isConnected = false;
            Log.d(TAG, "Conexión Bluetooth cerrada.");
        } catch (IOException e) {
            Log.e(TAG, "Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public boolean isConnected() {
        return isConnected;
    }
}