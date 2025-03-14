package com.utsem.playingreading.Model_Controller.Superheroes;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.utsem.playingreading.R;
import com.utsem.playingreading.Services.BluetoothService;

public class CuentosSuperheroes extends AppCompatActivity {

    private int cuentoSelecto;
    private LinearLayout barraSuperior;
    private LinearLayout barraInferior;
    private TextView titulo;
    SuperheroesClass superheroesClass;
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
    private ImageView imagenCuento;

    private LinearLayout lyvAct01, lyvAct02, lyvAct03, lyvPreguntas;


    private String correcto =  "¡Correcto!";
    private String incorrecto = "Intentalo de nuevo...";

    //Conmponentes de la actiidad 1
    private ImageView imgAct01;
    private TextView txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05;
    private Button btnLetra01, btnLetra02, btnLetra03, btnLetra04, btnLetra05, btnEvaluar01;

    //componnentes de la actividad 2
    private ImageView img01Act02, img02Act02, img03Act02, img04Act02;
    private Button btn01Act02, btn02Act02, btn03Act02, btn04Act02;

    //componentes de la actividad 3
    private TextView txtLetra01Act3, txtLetra02Act3, txtLetra03Act3, txtLetra04Act3, txtLetra05Act3, txtLetra06Act3;
    private Button btnLetra01Act3, btnLetra02Act3, btnLetra03Act3, btnLetra04Act3, btnEvaluar03;

    //componentes de la activida 4
    private TextView txtPregunta01, txtPregunta02, txtPregunta03, txtPregunta04, txtPregunta05, txtTotalAciertos;
    private RadioButton rdbP011, rdbP012, rdbP013, rdbP021, rdbP022, rdbP023, rdbP031, rdbP032, rdbP033, rdbP041, rdbP042, rdbP043, rdbP051, rdbP052, rdbP053;
    private int pre011, pre012, pre013, pre021, pre022, pre023, pre031, pre032, pre033, pre041, pre042, pre043, pre051, pre052, pre053, totalPuntos;
    private  Button btnEva04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentos_estructura);
        scrCuento = findViewById(R.id.scrCuento);
        barraSuperior = findViewById(R.id.lnhBarraSuperior);
        barraInferior = findViewById(R.id.lyvInferior);
        lyvSuperior = findViewById(R.id.lyvSuperior);
        viewFinal = findViewById(R.id.viewFinal);
        imagenCuento = findViewById(R.id.imgCadaCuento);

        scrCuento.setVisibility(View.VISIBLE);
        lyvSuperior.setVisibility(View.VISIBLE);
        barraSuperior.setVisibility(View.VISIBLE);
        barraInferior.setVisibility(View.VISIBLE);
        viewFinal.setVisibility(View.GONE);

        cuentoSelecto = getIntent().getIntExtra("VALOR_CUENTO_SELECTO", 0);
        titulo = findViewById(R.id.tituloCuento);
        superheroesClass = new SuperheroesClass();
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
        lyvAct01 = findViewById(R.id.lyvAct01);
        lyvAct02 = findViewById(R.id.lyvAct02);
        lyvAct03 = findViewById(R.id.lyvAct03);
        lyvPreguntas = findViewById(R.id.lyvPreguntas);

        cargarComponentesAct01();
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
                scrCuento.setBackgroundColor(Color.parseColor("#FF3B30"));
                barraSuperior.setBackgroundColor(Color.parseColor("#9C1006"));
                barraInferior.setBackgroundColor(Color.parseColor("#9C1006"));
                break;
            case 1:
                scrCuento.setBackgroundColor(Color.parseColor("#6462F8"));
                barraSuperior.setBackgroundColor(Color.parseColor("#2F2DCE"));
                barraInferior.setBackgroundColor(Color.parseColor("#2F2DCE"));
                break;
            case 2:
                scrCuento.setBackgroundColor(Color.parseColor("#ffb703"));
                barraSuperior.setBackgroundColor(Color.parseColor("#bb3e03"));
                barraInferior.setBackgroundColor(Color.parseColor("#bb3e03"));
                break;
            case 3:
                scrCuento.setBackgroundColor(Color.parseColor("#bb3e03"));
                barraSuperior.setBackgroundColor(Color.parseColor("#ae2012"));
                barraInferior.setBackgroundColor(Color.parseColor("#ae2012"));
                break;
            case 4:
                scrCuento.setBackgroundColor(Color.parseColor("#386641"));
                barraSuperior.setBackgroundColor(Color.parseColor("#081c15"));
                barraInferior.setBackgroundColor(Color.parseColor("#081c15"));
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
        String[] titulos = superheroesClass.getTitulos();
        lyvAct01.setVisibility(View.GONE);
        atras.setEnabled(false);

        if (cuentoSelecto >= 0 && cuentoSelecto < titulos.length) {
            superheroesClass.setCuentoSelecto(cuentoSelecto);
            superheroesClass.avance20();
            String tituloCuento = superheroesClass.getTituloCuentoSelecto();
            titulo.setText(tituloCuento);
            parrafo.setText(superheroesClass.getParrafo());
            imagenCuento.setImageResource(superheroesClass.getImagen());

        } else {
            titulo.setText("Título no encontrado");
        }
    }

    public void avance40() {
        scrCuento.scrollTo(0, 0);
        cargarComponentesAct02();
        lyvAct01.setVisibility(View.VISIBLE);
        lyvAct02.setVisibility(View.GONE);

        String[] titulos = superheroesClass.getTitulos();
        atras.setEnabled(true);

        if (cuentoSelecto >= 0 && cuentoSelecto < titulos.length) {
            superheroesClass.setCuentoSelecto(cuentoSelecto);
            superheroesClass.avance40();
            parrafo.setText(superheroesClass.getParrafo());
            imagenCuento.setImageResource(superheroesClass.getImagen());

            //actividad 1
            imgAct01.setImageResource(superheroesClass.getImgAct01());
            btnLetra01.setText(superheroesClass.getBtnLetra01());
            btnLetra02.setText(superheroesClass.getBtnLetra02());
            btnLetra03.setText(superheroesClass.getBtnLetra03());
            btnLetra04.setText(superheroesClass.getBtnLetra04());
            btnLetra05.setText(superheroesClass.getBtnLetra05());

        } else {
            titulo.setText("Título no encontrado");
        }
    }

    public void avance60() {
        scrCuento.scrollTo(0, 0);
        cargarComponentesAct03();
        lyvAct01.setVisibility(View.GONE);
        lyvAct02.setVisibility(View.VISIBLE);
        lyvAct03.setVisibility(View.GONE);

        String[] titulos = superheroesClass.getTitulos();

        if (cuentoSelecto >= 0 && cuentoSelecto < titulos.length) {
            superheroesClass.setCuentoSelecto(cuentoSelecto);
            superheroesClass.avance60();
            parrafo.setText(superheroesClass.getParrafo());
            imagenCuento.setImageResource(superheroesClass.getImagen());

            //actividad 2
            img01Act02.setImageResource(superheroesClass.getImg01Act02());
            img02Act02.setImageResource(superheroesClass.getImg02Act02());
            img03Act02.setImageResource(superheroesClass.getImg03Act02());
            img04Act02.setImageResource(superheroesClass.getImg04Act02());
            btn01Act02.setText(superheroesClass.getPalabra01());
            btn02Act02.setText(superheroesClass.getPalabra02());
            btn03Act02.setText(superheroesClass.getPalabra03());
            btn04Act02.setText(superheroesClass.getPalabra04());

        } else {
            titulo.setText("Título no encontrado");
        }
    }

    public void avance80() {
        scrCuento.scrollTo(0, 0);
        String[] titulos = superheroesClass.getTitulos();
        cargarComponentesAct04();
        lyvAct02.setVisibility(View.GONE);
        lyvAct03.setVisibility(View.VISIBLE);
        lyvPreguntas.setVisibility(View.GONE);


        if (cuentoSelecto >= 0 && cuentoSelecto < titulos.length) {
            superheroesClass.setCuentoSelecto(cuentoSelecto);
            superheroesClass.avance80();
            parrafo.setText(superheroesClass.getParrafo());
            imagenCuento.setImageResource(superheroesClass.getImagen());

            //actividad 3: Amigos
            txtLetra01Act3.setText(superheroesClass.getLetra_Act3_01());
            txtLetra02Act3.setText(superheroesClass.getLetra_Act3_02());
            txtLetra03Act3.setText(superheroesClass.getLetra_Act3_03());
            txtLetra04Act3.setText(superheroesClass.getLetra_Act3_04());
            txtLetra05Act3.setText(superheroesClass.getLetra_Act3_05());
            txtLetra06Act3.setText(superheroesClass.getLetra_Act3_06());

            btnLetra01Act3.setText(superheroesClass.getBtn01Act03());
            btnLetra02Act3.setText(superheroesClass.getBtn02Act03());
            btnLetra03Act3.setText(superheroesClass.getBtn03Act03());
            btnLetra04Act3.setText(superheroesClass.getBtn04Act03());


        } else {
            titulo.setText("Título no encontrado");
        }
    }

    public void avance100() {
        scrCuento.scrollTo(0, 0);
        String[] titulos = superheroesClass.getTitulos();
        lyvAct03.setVisibility(View.GONE);
        lyvPreguntas.setVisibility(View.VISIBLE);

        if (cuentoSelecto >= 0 && cuentoSelecto < titulos.length) {
            superheroesClass.setCuentoSelecto(cuentoSelecto);
            superheroesClass.avance100();
            parrafo.setText(superheroesClass.getParrafo());
            imagenCuento.setImageResource(superheroesClass.getImagen());

            //actividad 4
            txtPregunta01.setText(superheroesClass.getTxtPregunta01());
            rdbP011.setText(superheroesClass.getRdbP011());
            rdbP012.setText(superheroesClass.getRdbP012());
            rdbP013.setText(superheroesClass.getRdbP013());

            txtPregunta02.setText(superheroesClass.getTxtPregunta02());
            rdbP021.setText(superheroesClass.getRdbP021());
            rdbP022.setText(superheroesClass.getRdbP022());
            rdbP023.setText(superheroesClass.getRdbP023());

            txtPregunta03.setText(superheroesClass.getTxtPregunta03());
            rdbP031.setText(superheroesClass.getRdbP031());
            rdbP032.setText(superheroesClass.getRdbP032());
            rdbP033.setText(superheroesClass.getRdbP033());

            txtPregunta04.setText(superheroesClass.getTxtPregunta04());
            rdbP041.setText(superheroesClass.getRdbP041());
            rdbP042.setText(superheroesClass.getRdbP042());
            rdbP043.setText(superheroesClass.getRdbP043());

            txtPregunta05.setText(superheroesClass.getTxtPregunta05());
            rdbP051.setText(superheroesClass.getRdbP051());
            rdbP052.setText(superheroesClass.getRdbP052());
            rdbP053.setText(superheroesClass.getRdbP053());

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
                audio = MediaPlayer.create(this, superheroesClass.getAudio());
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

    //boton de siguiente
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

    //boton de atras
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

    //botno de salir
    public void goBack(View v) {
        this.finish();
    }

    //soltar dulce al final de cuento
    public void soltarDulce(){
        Intent intent = new Intent(this, BluetoothService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        if(bluetoothService != null){
            try {
                bluetoothService.sendData("7kirDM4r7^P@^$9B#^M#M%40#");
                scrCuento.setVisibility(View.GONE);
                lyvSuperior.setVisibility(View.GONE);
                barraSuperior.setVisibility(View.GONE);
                barraInferior.setVisibility(View.GONE);
                viewFinal.setVisibility(View.VISIBLE);
            }catch (Exception e){
                Log.e("SoltarDulce", "Falla al soltar el dulce");
            }
        }
    }

    //carga de componentes
    private void cargarComponentesAct01(){
        imgAct01 = findViewById(R.id.imgAct01);
        txtLetra01 = findViewById(R.id.txtLetra01);
        txtLetra02 = findViewById(R.id.txtLetra02);
        txtLetra03 = findViewById(R.id.txtLetra03);
        txtLetra04 = findViewById(R.id.txtLetra04);
        txtLetra05 = findViewById(R.id.txtLetra05);
        btnLetra01 = findViewById(R.id.btnLetra01);
        btnLetra02 = findViewById(R.id.btnLetra02);
        btnLetra03 = findViewById(R.id.btnLetra03);
        btnLetra04 = findViewById(R.id.btnLetra04);
        btnLetra05 = findViewById(R.id.btnLetra05);
        btnEvaluar01 = findViewById(R.id.btnEvaluar01);
    }
    private void cargarComponentesAct02(){
        img01Act02 = findViewById(R.id.img01Act02);
        img02Act02 = findViewById(R.id.img02Act02);
        img03Act02 = findViewById(R.id.img03Act02);
        img04Act02 = findViewById(R.id.img04Act02);
        btn01Act02 = findViewById(R.id.btn01Act02);
        btn02Act02 = findViewById(R.id.btn02Act02);
        btn03Act02 = findViewById(R.id.btn03Act02);
        btn04Act02 = findViewById(R.id.btn04Act02);
    }
    private void cargarComponentesAct03(){
        txtLetra01Act3 =  findViewById(R.id.txtLetra01Act3);
        txtLetra02Act3 =  findViewById(R.id.txtLetra02Act3);
        txtLetra03Act3 =  findViewById(R.id.txtLetra03Act3);
        txtLetra04Act3 =  findViewById(R.id.txtLetra04Act3);
        txtLetra05Act3 =  findViewById(R.id.txtLetra05Act3);
        txtLetra06Act3 =  findViewById(R.id.txtLetra06Act3);

        btnLetra01Act3 = findViewById(R.id.btnLetra01Act3);
        btnLetra02Act3 = findViewById(R.id.btnLetra02Act3);
        btnLetra03Act3 = findViewById(R.id.btnLetra03Act3);
        btnLetra04Act3 = findViewById(R.id.btnLetra04Act3);
        btnEvaluar03 = findViewById(R.id.btnEvaluar03);
    }
    private  void cargarComponentesAct04(){
        txtTotalAciertos = findViewById(R.id.txtTotalAciertos);

        txtPregunta01 = findViewById(R.id.txtPregunta01);
        txtPregunta02 = findViewById(R.id.txtPregunta02);
        txtPregunta03 = findViewById(R.id.txtPregunta03);
        txtPregunta04 = findViewById(R.id.txtPregunta04);
        txtPregunta05 = findViewById(R.id.txtPregunta05);

        rdbP011 = findViewById(R.id.rdbP011);
        rdbP012 = findViewById(R.id.rdbP012);
        rdbP013 = findViewById(R.id.rdbP013);

        rdbP021 = findViewById(R.id.rdbP021);
        rdbP022 = findViewById(R.id.rdbP022);
        rdbP023 = findViewById(R.id.rdbP023);

        rdbP031 = findViewById(R.id.rdbP031);
        rdbP032 = findViewById(R.id.rdbP032);
        rdbP033 = findViewById(R.id.rdbP033);

        rdbP041 = findViewById(R.id.rdbP041);
        rdbP042 = findViewById(R.id.rdbP042);
        rdbP043 = findViewById(R.id.rdbP043);

        rdbP051 = findViewById(R.id.rdbP051);
        rdbP052 = findViewById(R.id.rdbP052);
        rdbP053 = findViewById(R.id.rdbP053);

        btnEva04 = findViewById(R.id.btnEva04);

    }

    //actividad 1
    public void ponerLetra01(View v) {
        TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
        for(TextView letra : letras){
            if(letra.getText().toString().equals("__")){
                letra.setText(superheroesClass.getBtnLetra01());
                btnLetra01.setEnabled(false);
                return;
            }
        }
    }
    public void ponerLetra02(View v) {
        TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
        for(TextView letra : letras){
            if(letra.getText().toString().equals("__")){
                letra.setText(superheroesClass.getBtnLetra02());
                btnLetra02.setEnabled(false);
                return;
            }
        }
    }
    public void ponerLetra03(View v) {
        TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
        for(TextView letra : letras){
            if(letra.getText().toString().equals("__")){
                letra.setText(superheroesClass.getBtnLetra03());
                btnLetra03.setEnabled(false);
                return;
            }
        }
    }
    public void ponerLetra04(View v) {
        TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
        for(TextView letra : letras){
            if(letra.getText().toString().equals("__")){
                letra.setText(superheroesClass.getBtnLetra04());
                btnLetra04.setEnabled(false);
                return;
            }
        }
    }
    public void ponerLetra05(View v) {
        TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
        for(TextView letra : letras){
            if(letra.getText().toString().equals("__")){
                letra.setText(superheroesClass.getBtnLetra05());
                btnLetra05.setEnabled(false);
                return;
            }
        }
    }

    public void comprobarActividad01(View v){
        switch (cuentoSelecto) {
            case 0:
                if (txtLetra01.getText().toString().equals("H") && txtLetra02.getText().toString().equals("E") && txtLetra03.getText().toString().equals("R") && txtLetra04.getText().toString().equals("O") && txtLetra05.getText().toString().equals("E")) {
                    btnEvaluar01.setEnabled(false);
                    Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                    TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
                    Button[] botones = {btnLetra01, btnLetra02, btnLetra03, btnLetra04, btnLetra05, btnEvaluar01};
                    for (TextView letra : letras) {
                        letra.setText("__");
                    }
                    for (Button boton : botones) {
                        boton.setEnabled(true);
                    }
                }
                break;
            case 1:
                if (txtLetra01.getText().toString().equals("C") && txtLetra02.getText().toString().equals("A") && txtLetra03.getText().toString().equals("L") && txtLetra04.getText().toString().equals("O") && txtLetra05.getText().toString().equals("R")) {
                    btnEvaluar01.setEnabled(false);
                    Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                    TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
                    Button[] botones = {btnLetra01, btnLetra02, btnLetra03, btnLetra04, btnLetra05, btnEvaluar01};
                    for (TextView letra : letras) {
                        letra.setText("__");
                    }
                    for (Button boton : botones) {
                        boton.setEnabled(true);
                    }
                }
                break;
            case 2:
                if (txtLetra01.getText().toString().equals("N") && txtLetra02.getText().toString().equals("U") && txtLetra03.getText().toString().equals("B") && txtLetra04.getText().toString().equals("E") && txtLetra05.getText().toString().equals("S")) {
                    btnEvaluar01.setEnabled(false);
                    Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                    TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
                    Button[] botones = {btnLetra01, btnLetra02, btnLetra03, btnLetra04, btnLetra05, btnEvaluar01};
                    for (TextView letra : letras) {
                        letra.setText("__");
                    }
                    for (Button boton : botones) {
                        boton.setEnabled(true);
                    }
                }
                break;
            case 3:
                if (txtLetra01.getText().toString().equals("J") && txtLetra02.getText().toString().equals("U") && txtLetra03.getText().toString().equals("E") && txtLetra04.getText().toString().equals("G") && txtLetra05.getText().toString().equals("O")) {
                    btnEvaluar01.setEnabled(false);
                    Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                    TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
                    Button[] botones = {btnLetra01, btnLetra02, btnLetra03, btnLetra04, btnLetra05, btnEvaluar01};
                    for (TextView letra : letras) {
                        letra.setText("__");
                    }
                    for (Button boton : botones) {
                        boton.setEnabled(true);
                    }
                }
                break;
            case 4:
                if (txtLetra01.getText().toString().equals("V") && txtLetra02.getText().toString().equals("E") && txtLetra03.getText().toString().equals("L") && txtLetra04.getText().toString().equals("O") && txtLetra05.getText().toString().equals("Z")) {
                    btnEvaluar01.setEnabled(false);
                    Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                    TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
                    Button[] botones = {btnLetra01, btnLetra02, btnLetra03, btnLetra04, btnLetra05, btnEvaluar01};
                    for (TextView letra : letras) {
                        letra.setText("__");
                    }
                    for (Button boton : botones) {
                        boton.setEnabled(true);
                    }
                }
                break;
        }
    }

    //actividad 2
    public void comprobarBtn01Act02(View v){
        switch (cuentoSelecto){
            case 0:
                Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
                btn01Act02.setEnabled(false);
                btn02Act02.setEnabled(false);
                btn03Act02.setEnabled(false);
                btn04Act02.setEnabled(false);
                break;
            case 2:
                Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                break;

        }
    }
    public void comprobarBtn02Act02(View v){
        switch (cuentoSelecto){
            case 0:
                Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                break;

        }
    }
    public void comprobarBtn03Act02(View v){
        switch (cuentoSelecto){
            case 0:
                Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
                btn01Act02.setEnabled(false);
                btn02Act02.setEnabled(false);
                btn03Act02.setEnabled(false);
                btn04Act02.setEnabled(false);
                break;
            case 1:
                Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
                btn01Act02.setEnabled(false);
                btn02Act02.setEnabled(false);
                btn03Act02.setEnabled(false);
                btn04Act02.setEnabled(false);
                break;
            case 4:
                Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                break;
        }

    }
    public void comprobarBtn04Act02(View v){
        switch (cuentoSelecto){
            case 0:
                Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
                btn01Act02.setEnabled(false);
                btn02Act02.setEnabled(false);
                btn03Act02.setEnabled(false);
                btn04Act02.setEnabled(false);
                break;
            case 3:
                Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
                btn01Act02.setEnabled(false);
                btn02Act02.setEnabled(false);
                btn03Act02.setEnabled(false);
                btn04Act02.setEnabled(false);
                break;
        }
    }

    //actividad 3
    public void ponerLetra01Act03(View v) {
        TextView[] letras = {txtLetra01Act3, txtLetra02Act3, txtLetra03Act3, txtLetra04Act3, txtLetra05Act3, txtLetra06Act3};
        for(TextView letra : letras){
            if(letra.getText().toString().equals("__")){
                letra.setText(superheroesClass.getBtn01Act03());
                btnLetra01Act3.setEnabled(false);
                return;
            }
        }
    }
    public void ponerLetra02Act03(View v) {
        TextView[] letras = {txtLetra01Act3, txtLetra02Act3, txtLetra03Act3, txtLetra04Act3, txtLetra05Act3, txtLetra06Act3};
        for(TextView letra : letras){
            if(letra.getText().toString().equals("__")){
                letra.setText(superheroesClass.getBtn02Act03());
                btnLetra02Act3.setEnabled(false);
                return;
            }
        }
    }
    public void ponerLetra03Act03(View v) {
        TextView[] letras = {txtLetra01Act3, txtLetra02Act3, txtLetra03Act3, txtLetra04Act3, txtLetra05Act3, txtLetra06Act3};
        for(TextView letra : letras){
            if(letra.getText().toString().equals("__")){
                letra.setText(superheroesClass.getBtn03Act03());
                btnLetra03Act3.setEnabled(false);
                return;
            }
        }
    }
    public void ponerLetra04Act03(View v) {
        TextView[] letras = {txtLetra01Act3, txtLetra02Act3, txtLetra03Act3, txtLetra04Act3, txtLetra05Act3, txtLetra06Act3};
        for(TextView letra : letras){
            if(letra.getText().toString().equals("__")){
                letra.setText(superheroesClass.getBtn04Act03());
                btnLetra04Act3.setEnabled(false);
                return;
            }
        }
    }

    public void comprobarActividad03(View v){
        switch (cuentoSelecto){
            case 0:
                if(txtLetra01Act3.getText().toString().equals("H") && txtLetra02Act3.getText().toString().equals("O") &&  txtLetra03Act3.getText().toString().equals("M") && txtLetra04Act3.getText().toString().equals("B") && txtLetra05Act3.getText().toString().equals("R") && txtLetra06Act3.getText().toString().equals("E")){

                    btnLetra01Act3.setEnabled(false);
                    btnLetra02Act3.setEnabled(false);
                    btnLetra03Act3.setEnabled(false);
                    btnLetra04Act3.setEnabled(false);
                    btnEvaluar03.setEnabled(false);

                    Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                    txtLetra01Act3.setText(superheroesClass.getLetra_Act3_01());
                    txtLetra02Act3.setText(superheroesClass.getLetra_Act3_02());
                    txtLetra03Act3.setText(superheroesClass.getLetra_Act3_03());
                    txtLetra04Act3.setText(superheroesClass.getLetra_Act3_04());
                    txtLetra05Act3.setText(superheroesClass.getLetra_Act3_05());
                    txtLetra06Act3.setText(superheroesClass.getLetra_Act3_06());

                    btnLetra01Act3.setEnabled(true);
                    btnLetra02Act3.setEnabled(true);
                    btnLetra03Act3.setEnabled(true);
                    btnLetra04Act3.setEnabled(true);
                    btnEvaluar03.setEnabled(true);

                }
                break;
            case 1:

                if(txtLetra01Act3.getText().toString().equals("G") && txtLetra02Act3.getText().toString().equals("L") &&  txtLetra03Act3.getText().toString().equals("O") && txtLetra04Act3.getText().toString().equals("B") && txtLetra05Act3.getText().toString().equals("A") && txtLetra06Act3.getText().toString().equals("L")){

                    btnLetra01Act3.setEnabled(false);
                    btnLetra02Act3.setEnabled(false);
                    btnLetra03Act3.setEnabled(false);
                    btnLetra04Act3.setEnabled(false);
                    btnEvaluar03.setEnabled(false);

                    Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                    txtLetra01Act3.setText(superheroesClass.getLetra_Act3_01());
                    txtLetra02Act3.setText(superheroesClass.getLetra_Act3_02());
                    txtLetra03Act3.setText(superheroesClass.getLetra_Act3_03());
                    txtLetra04Act3.setText(superheroesClass.getLetra_Act3_04());
                    txtLetra05Act3.setText(superheroesClass.getLetra_Act3_05());
                    txtLetra06Act3.setText(superheroesClass.getLetra_Act3_06());

                    btnLetra01Act3.setEnabled(true);
                    btnLetra02Act3.setEnabled(true);
                    btnLetra03Act3.setEnabled(true);
                    btnLetra04Act3.setEnabled(true);
                    btnEvaluar03.setEnabled(true);

                }
                break;
            case 2:
                if(txtLetra01Act3.getText().toString().equals("B") && txtLetra02Act3.getText().toString().equals("O") &&  txtLetra03Act3.getText().toString().equals("M") && txtLetra04Act3.getText().toString().equals("B") && txtLetra05Act3.getText().toString().equals("A") && txtLetra06Act3.getText().toString().equals("S")){
                    btnLetra01Act3.setEnabled(false);
                    btnLetra02Act3.setEnabled(false);
                    btnLetra03Act3.setEnabled(false);
                    btnLetra04Act3.setEnabled(false);
                    btnEvaluar03.setEnabled(false);

                    Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                    txtLetra01Act3.setText(superheroesClass.getLetra_Act3_01());
                    txtLetra02Act3.setText(superheroesClass.getLetra_Act3_02());
                    txtLetra03Act3.setText(superheroesClass.getLetra_Act3_03());
                    txtLetra04Act3.setText(superheroesClass.getLetra_Act3_04());
                    txtLetra05Act3.setText(superheroesClass.getLetra_Act3_05());
                    txtLetra06Act3.setText(superheroesClass.getLetra_Act3_06());

                    btnLetra01Act3.setEnabled(true);
                    btnLetra02Act3.setEnabled(true);
                    btnLetra03Act3.setEnabled(true);
                    btnLetra04Act3.setEnabled(true);
                    btnEvaluar03.setEnabled(true);
                }
                break;
            case 3:
                if(txtLetra01Act3.getText().toString().equals("T") && txtLetra02Act3.getText().toString().equals("I") &&  txtLetra03Act3.getText().toString().equals("E") && txtLetra04Act3.getText().toString().equals("M") && txtLetra05Act3.getText().toString().equals("P") && txtLetra06Act3.getText().toString().equals("O")){

                    btnLetra01Act3.setEnabled(false);
                    btnLetra02Act3.setEnabled(false);
                    btnLetra03Act3.setEnabled(false);
                    btnLetra04Act3.setEnabled(false);
                    btnEvaluar03.setEnabled(false);

                    Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                    txtLetra01Act3.setText(superheroesClass.getLetra_Act3_01());
                    txtLetra02Act3.setText(superheroesClass.getLetra_Act3_02());
                    txtLetra03Act3.setText(superheroesClass.getLetra_Act3_03());
                    txtLetra04Act3.setText(superheroesClass.getLetra_Act3_04());
                    txtLetra05Act3.setText(superheroesClass.getLetra_Act3_05());
                    txtLetra06Act3.setText(superheroesClass.getLetra_Act3_06());

                    btnLetra01Act3.setEnabled(true);
                    btnLetra02Act3.setEnabled(true);
                    btnLetra03Act3.setEnabled(true);
                    btnLetra04Act3.setEnabled(true);
                    btnEvaluar03.setEnabled(true);

                }
                break;
            case 4:
                if(txtLetra01Act3.getText().toString().equals("C") && txtLetra02Act3.getText().toString().equals("O") &&  txtLetra03Act3.getText().toString().equals("R") && txtLetra04Act3.getText().toString().equals("R") && txtLetra05Act3.getText().toString().equals("E") && txtLetra06Act3.getText().toString().equals("R")){

                    btnLetra01Act3.setEnabled(false);
                    btnLetra02Act3.setEnabled(false);
                    btnLetra03Act3.setEnabled(false);
                    btnLetra04Act3.setEnabled(false);
                    btnEvaluar03.setEnabled(false);

                    Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
                    txtLetra01Act3.setText(superheroesClass.getLetra_Act3_01());
                    txtLetra02Act3.setText(superheroesClass.getLetra_Act3_02());
                    txtLetra03Act3.setText(superheroesClass.getLetra_Act3_03());
                    txtLetra04Act3.setText(superheroesClass.getLetra_Act3_04());
                    txtLetra05Act3.setText(superheroesClass.getLetra_Act3_05());
                    txtLetra06Act3.setText(superheroesClass.getLetra_Act3_06());

                    btnLetra01Act3.setEnabled(true);
                    btnLetra02Act3.setEnabled(true);
                    btnLetra03Act3.setEnabled(true);
                    btnLetra04Act3.setEnabled(true);
                    btnEvaluar03.setEnabled(true);
                }
        }
    }

    //comprobar las prguntas
    public void comprobarPreguntas(View v){
        int[] respuestas = {superheroesClass.getPre011(), superheroesClass.getPre012(), superheroesClass.getPre013(), superheroesClass.getPre021(), superheroesClass.getPre022(), superheroesClass.getPre023(), superheroesClass.getPre031(), superheroesClass.getPre032(), superheroesClass.getPre033(), superheroesClass.getPre041(), superheroesClass.getPre042(), superheroesClass.getPre043(), superheroesClass.getPre051(), superheroesClass.getPre052(), superheroesClass.getPre053() };
        RadioButton opciones [] = {rdbP011, rdbP012, rdbP013, rdbP021, rdbP022, rdbP023, rdbP031, rdbP032, rdbP033, rdbP041, rdbP042, rdbP043, rdbP051, rdbP052, rdbP053};
        totalPuntos = 0;
        for (int i = 0; i < opciones.length; i++) {
            if (opciones[i].isChecked() && respuestas[i] == 1) {
                totalPuntos++;
            }
        }

        for(RadioButton opcion: opciones){
            opcion.setClickable(false);
        }

        txtTotalAciertos.setText("Aciertos: " + totalPuntos);
        Toast.makeText(this, "Acietos: " + totalPuntos, Toast.LENGTH_SHORT).show();
        btnEva04.setEnabled(false);
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

    public LinearLayout getBarraSuperior() {
        return barraSuperior;
    }

    public void setBarraSuperior(LinearLayout barraSuperior) {
        this.barraSuperior = barraSuperior;
    }

    public LinearLayout getBarraInferior() {
        return barraInferior;
    }

    public void setBarraInferior(LinearLayout barraInferior) {
        this.barraInferior = barraInferior;
    }

    public TextView getTitulo() {
        return titulo;
    }

    public void setTitulo(TextView titulo) {
        this.titulo = titulo;
    }

    public SuperheroesClass getSuperheroesClass() {
        return superheroesClass;
    }

    public void setSuperheroesClass(SuperheroesClass superheroesClass) {
        this.superheroesClass = superheroesClass;
    }

    public TextView getParrafo() {
        return parrafo;
    }

    public void setParrafo(TextView parrafo) {
        this.parrafo = parrafo;
    }

    public ImageButton getBtnAudio() {
        return btnAudio;
    }

    public void setBtnAudio(ImageButton btnAudio) {
        this.btnAudio = btnAudio;
    }

    public MediaPlayer getAudio() {
        return audio;
    }

    public void setAudio(MediaPlayer audio) {
        this.audio = audio;
    }

    public ImageButton getAtras() {
        return atras;
    }

    public void setAtras(ImageButton atras) {
        this.atras = atras;
    }

    public ImageButton getNext() {
        return next;
    }

    public void setNext(ImageButton next) {
        this.next = next;
    }

    public ScrollView getScrCuento() {
        return scrCuento;
    }

    public void setScrCuento(ScrollView scrCuento) {
        this.scrCuento = scrCuento;
    }

    public LinearLayout getLyvSuperior() {
        return lyvSuperior;
    }

    public void setLyvSuperior(LinearLayout lyvSuperior) {
        this.lyvSuperior = lyvSuperior;
    }

    public LinearLayout getViewFinal() {
        return viewFinal;
    }

    public void setViewFinal(LinearLayout viewFinal) {
        this.viewFinal = viewFinal;
    }

    public BluetoothService getBluetoothService() {
        return bluetoothService;
    }

    public void setBluetoothService(BluetoothService bluetoothService) {
        this.bluetoothService = bluetoothService;
    }

    public boolean isBound() {
        return isBound;
    }

    public void setBound(boolean bound) {
        isBound = bound;
    }

    public ImageView getImagenCuento() {
        return imagenCuento;
    }

    public void setImagenCuento(ImageView imagenCuento) {
        this.imagenCuento = imagenCuento;
    }

    public ImageView getImgAct01() {
        return imgAct01;
    }

    public void setImgAct01(ImageView imgAct01) {
        this.imgAct01 = imgAct01;
    }

    public TextView getTxtLetra01() {
        return txtLetra01;
    }

    public void setTxtLetra01(TextView txtLetra01) {
        this.txtLetra01 = txtLetra01;
    }

    public TextView getTxtLetra02() {
        return txtLetra02;
    }

    public void setTxtLetra02(TextView txtLetra02) {
        this.txtLetra02 = txtLetra02;
    }

    public TextView getTxtLetra03() {
        return txtLetra03;
    }

    public void setTxtLetra03(TextView txtLetra03) {
        this.txtLetra03 = txtLetra03;
    }

    public TextView getTxtLetra04() {
        return txtLetra04;
    }

    public void setTxtLetra04(TextView txtLetra04) {
        this.txtLetra04 = txtLetra04;
    }

    public TextView getTxtLetra05() {
        return txtLetra05;
    }

    public void setTxtLetra05(TextView txtLetra05) {
        this.txtLetra05 = txtLetra05;
    }

    public Button getBtnLetra01() {
        return btnLetra01;
    }

    public void setBtnLetra01(Button btnLetra01) {
        this.btnLetra01 = btnLetra01;
    }

    public Button getBtnLetra02() {
        return btnLetra02;
    }

    public void setBtnLetra02(Button btnLetra02) {
        this.btnLetra02 = btnLetra02;
    }

    public Button getBtnLetra03() {
        return btnLetra03;
    }

    public void setBtnLetra03(Button btnLetra03) {
        this.btnLetra03 = btnLetra03;
    }

    public Button getBtnLetra04() {
        return btnLetra04;
    }

    public void setBtnLetra04(Button btnLetra04) {
        this.btnLetra04 = btnLetra04;
    }

    public Button getBtnLetra05() {
        return btnLetra05;
    }

    public void setBtnLetra05(Button btnLetra05) {
        this.btnLetra05 = btnLetra05;
    }

    public Button getBtnEvaluar01() {
        return btnEvaluar01;
    }

    public void setBtnEvaluar01(Button btnEvaluar01) {
        this.btnEvaluar01 = btnEvaluar01;
    }

    public ImageView getImg01Act02() {
        return img01Act02;
    }

    public void setImg01Act02(ImageView img01Act02) {
        this.img01Act02 = img01Act02;
    }

    public ImageView getImg02Act02() {
        return img02Act02;
    }

    public void setImg02Act02(ImageView img02Act02) {
        this.img02Act02 = img02Act02;
    }

    public ImageView getImg03Act02() {
        return img03Act02;
    }

    public void setImg03Act02(ImageView img03Act02) {
        this.img03Act02 = img03Act02;
    }

    public ImageView getImg04Act02() {
        return img04Act02;
    }

    public void setImg04Act02(ImageView img04Act02) {
        this.img04Act02 = img04Act02;
    }

    public Button getBtn01Act02() {
        return btn01Act02;
    }

    public void setBtn01Act02(Button btn01Act02) {
        this.btn01Act02 = btn01Act02;
    }

    public Button getBtn02Act02() {
        return btn02Act02;
    }

    public void setBtn02Act02(Button btn02Act02) {
        this.btn02Act02 = btn02Act02;
    }

    public Button getBtn03Act02() {
        return btn03Act02;
    }

    public void setBtn03Act02(Button btn03Act02) {
        this.btn03Act02 = btn03Act02;
    }

    public Button getBtn04Act02() {
        return btn04Act02;
    }

    public void setBtn04Act02(Button btn04Act02) {
        this.btn04Act02 = btn04Act02;
    }

    public ServiceConnection getServiceConnection() {
        return serviceConnection;
    }

    public void setServiceConnection(ServiceConnection serviceConnection) {
        this.serviceConnection = serviceConnection;
    }

    public LinearLayout getLyvAct01() {
        return lyvAct01;
    }

    public void setLyvAct01(LinearLayout lyvAct01) {
        this.lyvAct01 = lyvAct01;
    }

    public LinearLayout getLyvAct02() {
        return lyvAct02;
    }

    public void setLyvAct02(LinearLayout lyvAct02) {
        this.lyvAct02 = lyvAct02;
    }

    public LinearLayout getLyvAct03() {
        return lyvAct03;
    }

    public void setLyvAct03(LinearLayout lyvAct03) {
        this.lyvAct03 = lyvAct03;
    }

    public LinearLayout getLyvPreguntas() {
        return lyvPreguntas;
    }

    public void setLyvPreguntas(LinearLayout lyvPreguntas) {
        this.lyvPreguntas = lyvPreguntas;
    }

    public String getCorrecto() {
        return correcto;
    }

    public void setCorrecto(String correcto) {
        this.correcto = correcto;
    }

    public String getIncorrecto() {
        return incorrecto;
    }

    public void setIncorrecto(String incorrecto) {
        this.incorrecto = incorrecto;
    }

    public TextView getTxtLetra01Act3() {
        return txtLetra01Act3;
    }

    public void setTxtLetra01Act3(TextView txtLetra01Act3) {
        this.txtLetra01Act3 = txtLetra01Act3;
    }

    public TextView getTxtLetra02Act3() {
        return txtLetra02Act3;
    }

    public void setTxtLetra02Act3(TextView txtLetra02Act3) {
        this.txtLetra02Act3 = txtLetra02Act3;
    }

    public TextView getTxtLetra03Act3() {
        return txtLetra03Act3;
    }

    public void setTxtLetra03Act3(TextView txtLetra03Act3) {
        this.txtLetra03Act3 = txtLetra03Act3;
    }

    public TextView getTxtLetra04Act3() {
        return txtLetra04Act3;
    }

    public void setTxtLetra04Act3(TextView txtLetra04Act3) {
        this.txtLetra04Act3 = txtLetra04Act3;
    }

    public TextView getTxtLetra05Act3() {
        return txtLetra05Act3;
    }

    public void setTxtLetra05Act3(TextView txtLetra05Act3) {
        this.txtLetra05Act3 = txtLetra05Act3;
    }

    public TextView getTxtLetra06Act3() {
        return txtLetra06Act3;
    }

    public void setTxtLetra06Act3(TextView txtLetra06Act3) {
        this.txtLetra06Act3 = txtLetra06Act3;
    }

    public Button getBtnLetra01Act3() {
        return btnLetra01Act3;
    }

    public void setBtnLetra01Act3(Button btnLetra01Act3) {
        this.btnLetra01Act3 = btnLetra01Act3;
    }

    public Button getBtnLetra02Act3() {
        return btnLetra02Act3;
    }

    public void setBtnLetra02Act3(Button btnLetra02Act3) {
        this.btnLetra02Act3 = btnLetra02Act3;
    }

    public Button getBtnLetra03Act3() {
        return btnLetra03Act3;
    }

    public void setBtnLetra03Act3(Button btnLetra03Act3) {
        this.btnLetra03Act3 = btnLetra03Act3;
    }

    public Button getBtnLetra04Act3() {
        return btnLetra04Act3;
    }

    public void setBtnLetra04Act3(Button btnLetra04Act3) {
        this.btnLetra04Act3 = btnLetra04Act3;
    }

    public Button getBtnEvaluar03() {
        return btnEvaluar03;
    }

    public void setBtnEvaluar03(Button btnEvaluar03) {
        this.btnEvaluar03 = btnEvaluar03;
    }

    public TextView getTxtPregunta01() {
        return txtPregunta01;
    }

    public void setTxtPregunta01(TextView txtPregunta01) {
        this.txtPregunta01 = txtPregunta01;
    }

    public TextView getTxtPregunta02() {
        return txtPregunta02;
    }

    public void setTxtPregunta02(TextView txtPregunt02) {
        this.txtPregunta02 = txtPregunt02;
    }

    public TextView getTxtPregunta03() {
        return txtPregunta03;
    }

    public void setTxtPregunta03(TextView txtPregunta03) {
        this.txtPregunta03 = txtPregunta03;
    }

    public TextView getTxtPregunta04() {
        return txtPregunta04;
    }

    public void setTxtPregunta04(TextView txtPregunta04) {
        this.txtPregunta04 = txtPregunta04;
    }

    public TextView getTxtPregunta05() {
        return txtPregunta05;
    }

    public void setTxtPregunta05(TextView txtPregunta05) {
        this.txtPregunta05 = txtPregunta05;
    }

    public RadioButton getRdbP011() {
        return rdbP011;
    }

    public void setRdbP011(RadioButton rdbP011) {
        this.rdbP011 = rdbP011;
    }

    public RadioButton getRdbP012() {
        return rdbP012;
    }

    public void setRdbP012(RadioButton rdbP012) {
        this.rdbP012 = rdbP012;
    }

    public RadioButton getRdbP013() {
        return rdbP013;
    }

    public void setRdbP013(RadioButton rdbP013) {
        this.rdbP013 = rdbP013;
    }

    public RadioButton getRdbP021() {
        return rdbP021;
    }

    public void setRdbP021(RadioButton rdbP021) {
        this.rdbP021 = rdbP021;
    }

    public RadioButton getRdbP022() {
        return rdbP022;
    }

    public void setRdbP022(RadioButton rdbP022) {
        this.rdbP022 = rdbP022;
    }

    public RadioButton getRdbP023() {
        return rdbP023;
    }

    public void setRdbP023(RadioButton rdbP023) {
        this.rdbP023 = rdbP023;
    }

    public RadioButton getRdbP031() {
        return rdbP031;
    }

    public void setRdbP031(RadioButton rdbP031) {
        this.rdbP031 = rdbP031;
    }

    public RadioButton getRdbP032() {
        return rdbP032;
    }

    public void setRdbP032(RadioButton rdbP032) {
        this.rdbP032 = rdbP032;
    }

    public RadioButton getRdbP033() {
        return rdbP033;
    }

    public void setRdbP033(RadioButton rdbP033) {
        this.rdbP033 = rdbP033;
    }

    public RadioButton getRdbP041() {
        return rdbP041;
    }

    public void setRdbP041(RadioButton rdbP041) {
        this.rdbP041 = rdbP041;
    }

    public RadioButton getRdbP042() {
        return rdbP042;
    }

    public void setRdbP042(RadioButton rdbP042) {
        this.rdbP042 = rdbP042;
    }

    public RadioButton getRdbP043() {
        return rdbP043;
    }

    public void setRdbP043(RadioButton rdbP043) {
        this.rdbP043 = rdbP043;
    }

    public RadioButton getRdbP051() {
        return rdbP051;
    }

    public void setRdbP051(RadioButton rdbP051) {
        this.rdbP051 = rdbP051;
    }

    public RadioButton getRdbP052() {
        return rdbP052;
    }

    public void setRdbP052(RadioButton rdbP052) {
        this.rdbP052 = rdbP052;
    }

    public RadioButton getRdbP053() {
        return rdbP053;
    }

    public void setRdbP053(RadioButton rdbP053) {
        this.rdbP053 = rdbP053;
    }

    public int getTotalPuntos() {
        return totalPuntos;
    }

    public void setTotalPuntos(int totalPuntos) {
        this.totalPuntos = totalPuntos;
    }

    public int getPre011() {
        return pre011;
    }

    public void setPre011(int pre011) {
        this.pre011 = pre011;
    }

    public int getPre012() {
        return pre012;
    }

    public void setPre012(int pre012) {
        this.pre012 = pre012;
    }

    public int getPre013() {
        return pre013;
    }

    public void setPre013(int pre013) {
        this.pre013 = pre013;
    }

    public int getPre021() {
        return pre021;
    }

    public void setPre021(int pre021) {
        this.pre021 = pre021;
    }

    public int getPre022() {
        return pre022;
    }

    public void setPre022(int pre022) {
        this.pre022 = pre022;
    }

    public int getPre023() {
        return pre023;
    }

    public void setPre023(int pre023) {
        this.pre023 = pre023;
    }

    public int getPre031() {
        return pre031;
    }

    public void setPre031(int pre031) {
        this.pre031 = pre031;
    }

    public int getPre032() {
        return pre032;
    }

    public void setPre032(int pre032) {
        this.pre032 = pre032;
    }

    public int getPre033() {
        return pre033;
    }

    public void setPre033(int pre033) {
        this.pre033 = pre033;
    }

    public int getPre041() {
        return pre041;
    }

    public void setPre041(int pre041) {
        this.pre041 = pre041;
    }

    public int getPre042() {
        return pre042;
    }

    public void setPre042(int pre042) {
        this.pre042 = pre042;
    }

    public int getPre043() {
        return pre043;
    }

    public void setPre043(int pre043) {
        this.pre043 = pre043;
    }

    public int getPre051() {
        return pre051;
    }

    public void setPre051(int pre051) {
        this.pre051 = pre051;
    }

    public int getPre052() {
        return pre052;
    }

    public void setPre052(int pre052) {
        this.pre052 = pre052;
    }

    public int getPre053() {
        return pre053;
    }

    public void setPre053(int pre053) {
        this.pre053 = pre053;
    }

    public TextView getTxtTotalAciertos() {
        return txtTotalAciertos;
    }

    public void setTxtTotalAciertos(TextView txtTotalAciertos) {
        this.txtTotalAciertos = txtTotalAciertos;
    }
}