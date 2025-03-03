package com.utsem.playingreading.Model_Controller.CienciaFiccion;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.utsem.playingreading.Model_Controller.Aventuras.AventuraClass;
import com.utsem.playingreading.R;
import com.utsem.playingreading.Services.BluetoothService;

public class CuentosCienciaFiccion extends AppCompatActivity {

    CienciaFiccionClass cienciaFiccionClass;
    private int cuentoSelecto;
    private LinearLayout barraSuperior;
    private LinearLayout barraInferior;
    private TextView titulo;
    private TextView parrafo;
    private int valorAvance = 20;
    private ImageButton btnAudio;
    private MediaPlayer audio;
    private ImageButton atras, next;

    private ScrollView scrCuento;
    private LinearLayout lyvSuperior;
    private LinearLayout viewFinal;
    private BluetoothService bluetoothService = new BluetoothService();
    private boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cuentos_aventura);
        scrCuento = findViewById(R.id.scrCuento);
        barraSuperior = findViewById(R.id.lnhBarraSuperior);
        barraInferior = findViewById(R.id.lyvInferior);
        lyvSuperior = findViewById(R.id.lyvSuperior);
        viewFinal = findViewById(R.id.viewFinal);

        scrCuento.setVisibility(View.VISIBLE);
        lyvSuperior.setVisibility(View.VISIBLE);
        barraSuperior.setVisibility(View.VISIBLE);
        barraInferior.setVisibility(View.VISIBLE);
        viewFinal.setVisibility(View.GONE);

        cuentoSelecto = getIntent().getIntExtra("VALOR_CUENTO_SELECTO", 0);
        titulo = findViewById(R.id.tituloCuento);
        cienciaFiccionClass = new CienciaFiccionClass();
        parrafo = findViewById(R.id.txtParrafo);
        btnAudio = findViewById(R.id.imgBtnEscuchar);
        next = findViewById(R.id.next);
        atras = findViewById(R.id.atras);

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setCuentoSelecto(cuentoSelecto-1);
        colorActivity();
        avance20();
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

    // Método para determinar qué color de layout usar
    public void colorActivity() {
        switch (cuentoSelecto) {
            case 0:
                scrCuento.setBackgroundColor(Color.parseColor("#34C759"));
                barraSuperior.setBackgroundColor(Color.parseColor("#4C9D0D"));
                barraInferior.setBackgroundColor(Color.parseColor("#4C9D0D"));
                break;
            case 1:
                scrCuento.setBackgroundColor(Color.parseColor("#007AFF"));
                barraSuperior.setBackgroundColor(Color.parseColor("#165FAF"));
                barraInferior.setBackgroundColor(Color.parseColor("#165FAF"));
                break;
            case 2:
                scrCuento.setBackgroundColor(Color.parseColor("#80230E"));
                barraSuperior.setBackgroundColor(Color.parseColor("#56180A"));
                barraInferior.setBackgroundColor(Color.parseColor("#56180A"));
                break;
            case 3:
                scrCuento.setBackgroundColor(Color.parseColor("#32ADE6"));
                barraSuperior.setBackgroundColor(Color.parseColor("#0B445F"));
                barraInferior.setBackgroundColor(Color.parseColor("#0B445F"));
                break;
            case 4:
                scrCuento.setBackgroundColor(Color.parseColor("#5856D6"));
                barraSuperior.setBackgroundColor(Color.parseColor("#0A0981"));
                barraInferior.setBackgroundColor(Color.parseColor("#0A0981"));
                break;
            default:
                scrCuento.setBackgroundColor(Color.WHITE);
                barraSuperior.setBackgroundColor(Color.parseColor("#9C1006"));
                barraInferior.setBackgroundColor(Color.parseColor("#9C1006"));
                break;
        }
    }

    public void avance20() {
        scrCuento.scrollTo(0, 0);
        String[] titulos = cienciaFiccionClass.getTitulos();
        atras.setEnabled(false);
        if (titulos == null) {
            titulo.setText("Error: Títulos no disponibles");
            return;
        }
        if (cuentoSelecto >= 0 && cuentoSelecto < titulos.length) {
            cienciaFiccionClass.setCuentoSelecto(cuentoSelecto);
            cienciaFiccionClass.avance20();
            String tituloCuento = cienciaFiccionClass.getTituloCuentoSelecto();
            titulo.setText(tituloCuento);
            parrafo.setText(cienciaFiccionClass.getParrafo());
        } else {
            titulo.setText("Título no encontrado");
        }
    }

    public void avance40() {
        scrCuento.scrollTo(0, 0);
        String[] titulos = cienciaFiccionClass.getTitulos();
        atras.setEnabled(true);
        if (titulos == null) {
            titulo.setText("Error: Títulos no disponibles");
            return;
        }
        if (cuentoSelecto >= 0 && cuentoSelecto < titulos.length) {
            cienciaFiccionClass.setCuentoSelecto(cuentoSelecto);
            cienciaFiccionClass.avance40();
            parrafo.setText(cienciaFiccionClass.getParrafo());
        } else {
            titulo.setText("Título no encontrado");
        }
    }

    public void avance60() {
        scrCuento.scrollTo(0, 0);
        String[] titulos = cienciaFiccionClass.getTitulos();
        if (titulos == null) {
            titulo.setText("Error: Títulos no disponibles");
            return;
        }
        if (cuentoSelecto >= 0 && cuentoSelecto < titulos.length) {
            cienciaFiccionClass.setCuentoSelecto(cuentoSelecto);
            cienciaFiccionClass.avance60();
            parrafo.setText(cienciaFiccionClass.getParrafo());
        } else {
            titulo.setText("Título no encontrado");
        }
    }

    public void avance80() {
        scrCuento.scrollTo(0, 0);
        String[] titulos = cienciaFiccionClass.getTitulos();
        if (titulos == null) {
            titulo.setText("Error: Títulos no disponibles");
            return;
        }
        if (cuentoSelecto >= 0 && cuentoSelecto < titulos.length) {
            cienciaFiccionClass.setCuentoSelecto(cuentoSelecto);
            cienciaFiccionClass.avance80();
            parrafo.setText(cienciaFiccionClass.getParrafo());

        } else {
            titulo.setText("Título no encontrado");
        }
    }

    public void avance100() {
        scrCuento.scrollTo(0, 0);
        String[] titulos = cienciaFiccionClass.getTitulos();
        if (titulos == null) {
            titulo.setText("Error: Títulos no disponibles");
            return;
        }
        if (cuentoSelecto >= 0 && cuentoSelecto < titulos.length) {
            cienciaFiccionClass.setCuentoSelecto(cuentoSelecto);
            cienciaFiccionClass.avance100();
            parrafo.setText(cienciaFiccionClass.getParrafo());
        } else {
            titulo.setText("Título no encontrado");
        }
    }

    // Métodos para audio
    public void escuchar(View v) {
        if (audio != null && audio.isPlaying()) {
            btnAudio.setBackgroundResource(R.drawable.escuchar);
            audio.pause();
        } else {
            // Si el audio está en pausa o no se está reproduciendo, cambiamos la imagen a "parar"
            btnAudio.setBackgroundResource(R.drawable.parar);
            if (audio == null) {
                audio = MediaPlayer.create(this, cienciaFiccionClass.getAudio());
                if (audio != null) {
                    audio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {btnAudio.setBackgroundResource(R.drawable.escuchar);}
                    });
                    audio.start();
                } else {
                    Toast.makeText(this, "Fallo la reproduccion", Toast.LENGTH_SHORT).show();
                }
            } else {
                audio.start();
            }
        }
    }

    public void next(View v) {
        btnAudio.setBackgroundResource(R.drawable.escuchar);
        if (audio != null) {
            audio.stop();
            audio.release();
            audio = null;
        }
        switch (this.valorAvance){
            case 20:
                atras.setEnabled(true);
                setValorAvance(getValorAvance() + 20);
                avance40();
                break;
            case 40:
                setValorAvance(getValorAvance() + 20);
                avance60();
                break;
            case 60:
                setValorAvance(getValorAvance() + 20);
                avance80();
                break;
            case 80:
                setValorAvance(getValorAvance() + 20);
                avance100();
                break;
            case 100:
                soltarDulce();
                break;
            default: this.valorAvance = 100;

        }

    }

    public void atras(View v) {
        btnAudio.setBackgroundResource(R.drawable.escuchar);
        if (audio != null) {
            audio.stop();
            audio.release();
            audio = null;
        }

        switch (this.valorAvance){
            case 20:
                atras.setEnabled(false);
                avance20();
                break;
            case 40:
                atras.setEnabled(true);
                setValorAvance(getValorAvance() - 20);
                avance20();
                break;
            case 60:
                setValorAvance(getValorAvance() - 20);
                avance40();
                break;
            case 80:
                setValorAvance(getValorAvance() - 20);
                avance60();
                break;
            case 100:
                setValorAvance(getValorAvance() - 20);
                avance80();
                break;
            default: this.valorAvance = 100;

        }

    }

    public void goBack(View v) {
        this.finish();
    }

    public void soltarDulce(){
        Intent intent = new Intent(this, BluetoothService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        if(bluetoothService != null){

            try {
                bluetoothService.sendData("A");
                scrCuento.setVisibility(View.GONE);
                lyvSuperior.setVisibility(View.GONE);
                barraSuperior.setVisibility(View.GONE);
                barraInferior.setVisibility(View.GONE);
                viewFinal.setVisibility(View.VISIBLE);
            }catch (Exception e){
                Log.e("SoltarDulce", "Failed to create MediaPlayer");
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (audio != null) {
            audio.stop();
            audio.release();
            audio = null;
        }

    }

    // Getters y setters
    public void setCuentoSelecto(int cuentoSelecto) {
        this.cuentoSelecto = cuentoSelecto;
    }

    public int getCuentoSelecto() {
        return this.cuentoSelecto;
    }

    public int getValorAvance() {
        return valorAvance;
    }

    public void setValorAvance(int valorAvance) {
        this.valorAvance = valorAvance;
    }
}