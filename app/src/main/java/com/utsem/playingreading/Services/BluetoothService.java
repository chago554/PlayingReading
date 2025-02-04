package com.utsem.playingreading.Services;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class BluetoothService extends Service {
    public static final String TAG = "BluetoothService";
    private final IBinder binder = new LocalBinder();
    private BluetoothSocket btSocket;
    private OutputStream mmOutStream;
    private InputStream mmInputStream;
    private BluetoothAdapter bluetoothAdapter;
    private UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    public class LocalBinder extends Binder {
        public BluetoothService getService() {
            return BluetoothService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public boolean connectToDevice(BluetoothDevice device) {
        try {
            btSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
            btSocket.connect();
            mmOutStream = btSocket.getOutputStream();
            mmInputStream = btSocket.getInputStream();
            Log.d(TAG, "Conexión Bluetooth exitosa");
            startListening();  // Inicia la escucha inmediatamente después de la conexión
            return true;
        } catch (IOException e) {
            Log.e(TAG, "Error al conectar: " + e.getMessage());
            closeConnection();
            return false;
        }
    }
    public void sendData(String data) {
        if (mmOutStream != null) {
            try {
                mmOutStream.write(data.getBytes());
                Log.d(TAG, "Datos enviados: " + data);
            } catch (IOException e) {
                Log.e(TAG, "Error al enviar datos: " + e.getMessage());
            }
        } else {
            Log.e(TAG, "El flujo de salida es nulo, no se pueden enviar datos");
        }
    }
    public String recibirData() {
        byte[] buffer = new byte[1024];
        try {
            int bytesRead = mmInputStream.read(buffer);
            if (bytesRead > 0) {
                return new String(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            Log.e(TAG, "Error al recibir datos: " + e.getMessage());
        }
        return null;
    }
    public void startListening() {
        new Thread(() -> {
            while (true) {
                String receivedData = recibirData();
                if (receivedData != null) {
                    Log.d(TAG, "Data received: " + receivedData);
                }
            }
        }).start();
    }
    public void closeConnection() {
        try {
            if (btSocket != null) btSocket.close();
            btSocket = null;
            mmOutStream = null;
            Log.d(TAG, "Conexión Bluetooth cerrada");
        } catch (IOException e) {
            Log.e(TAG, "Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
