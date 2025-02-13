package com.utsem.playingreading.Model_Controller;
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
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
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
        Button connectButton = findViewById(R.id.btnConectar);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        LinearLayout vistaConectar =findViewById(R.id.lnyConectar);
        LinearLayout vistaContenido =findViewById(R.id.lnyContenido);
        LinearLayout vistaBarra =findViewById(R.id.lnyBarra);
        TextView textoOtrasOpciones = findViewById(R.id.txtOtrasOpciones);
        HorizontalScrollView srcOtrasOpciones = findViewById(R.id.scrOtrasOpciones);

        vistaConectar.setVisibility(View.VISIBLE);
        vistaContenido.setVisibility(View.GONE);
        vistaBarra.setVisibility(View.GONE);
        textoOtrasOpciones.setVisibility(View.GONE);
        srcOtrasOpciones.setVisibility(View.GONE);

        ImageButton aventuras = findViewById(R.id.btnAventura);
        ImageButton cienciaFiccion = findViewById(R.id.btnCienciaFiccion);
        ImageButton superheroes = findViewById(R.id.btnSuperheroes);
        ImageButton princesasyhadas = findViewById(R.id.btnPrincesasYHadas);
        ImageButton misterio = findViewById(R.id.btnMisterio);

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

                //poner para que se muestre solo cuando se conecte a la maquina
                //por lo mientras solo se muestra en pruebas
                vistaConectar.setVisibility(View.GONE);
                vistaContenido.setVisibility(View.VISIBLE);
                vistaBarra.setVisibility(View.VISIBLE);
                textoOtrasOpciones.setVisibility(View.VISIBLE);
                srcOtrasOpciones.setVisibility(View.VISIBLE);
                //aqui termina


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
                Toast.makeText(this, "No hay dispositivos emparejados",   Toast.LENGTH_SHORT).show();

                //poner para que se muestre solo cuando se conecte a la maquina
                //por lo mientras solo se muestra en pruebas
                vistaConectar.setVisibility(View.GONE);
                vistaContenido.setVisibility(View.VISIBLE);
                vistaBarra.setVisibility(View.VISIBLE);
                textoOtrasOpciones.setVisibility(View.VISIBLE);
                srcOtrasOpciones.setVisibility(View.VISIBLE);
                //aqui termina


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
            isBound = false;
        }
    }
}