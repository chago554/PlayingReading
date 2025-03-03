package com.utsem.playingreading.Model_Controller.Aventuras;

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

public class CuentosAventura extends AppCompatActivity {

    private int cuentoSelecto;
    private LinearLayout barraSuperior;
    private LinearLayout barraInferior;
    private TextView titulo;
    AventuraClass aventuraClass;
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
    private Button btnLetra01Act3, btnLetra02Act3, btnLetra03Act3, btnLetra04Act3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentos_aventura);
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
        aventuraClass = new AventuraClass();
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
                scrCuento.setBackgroundColor(Color.parseColor("#FF9500"));
                barraSuperior.setBackgroundColor(Color.parseColor("#89580F"));
                barraInferior.setBackgroundColor(Color.parseColor("#89580F"));
                break;
            case 1:
                scrCuento.setBackgroundColor(Color.parseColor("#FF3B30"));
                barraSuperior.setBackgroundColor(Color.parseColor("#9C1006"));
                barraInferior.setBackgroundColor(Color.parseColor("#9C1006"));
                break;
            case 2:
                scrCuento.setBackgroundColor(Color.parseColor("#A2845E"));
                barraSuperior.setBackgroundColor(Color.parseColor("#975B0F"));
                barraInferior.setBackgroundColor(Color.parseColor("#975B0F"));
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
        String[] titulos = aventuraClass.getTitulos();
        atras.setEnabled(false);

        if (cuentoSelecto >= 0 && cuentoSelecto < titulos.length) {
            aventuraClass.setCuentoSelecto(cuentoSelecto);
            aventuraClass.avance20();
            String tituloCuento = aventuraClass.getTituloCuentoSelecto();
            titulo.setText(tituloCuento);
            parrafo.setText(aventuraClass.getParrafo());
            imagenCuento.setImageResource(aventuraClass.getImagen());

        } else {
            titulo.setText("Título no encontrado");
        }
    }

    public void avance40() {
        scrCuento.scrollTo(0, 0);
        cargarComponentesAct02();
        String[] titulos = aventuraClass.getTitulos();
        atras.setEnabled(true);

        if (cuentoSelecto >= 0 && cuentoSelecto < titulos.length) {
            aventuraClass.setCuentoSelecto(cuentoSelecto);
            aventuraClass.avance40();
            parrafo.setText(aventuraClass.getParrafo());
            imagenCuento.setImageResource(aventuraClass.getImagen());

            //actividad 1
            imgAct01.setImageResource(aventuraClass.getImgAct01());
            btnLetra01.setText(aventuraClass.getLetra01());
            btnLetra02.setText(aventuraClass.getLetra02());
            btnLetra03.setText(aventuraClass.getLetra03());
            btnLetra04.setText(aventuraClass.getLetra04());
            btnLetra05.setText(aventuraClass.getLetra05());

        } else {
            titulo.setText("Título no encontrado");
        }
    }

    public void avance60() {
        scrCuento.scrollTo(0, 0);
        cargarComponentesAct03();
        String[] titulos = aventuraClass.getTitulos();

        if (cuentoSelecto >= 0 && cuentoSelecto < titulos.length) {
            aventuraClass.setCuentoSelecto(cuentoSelecto);
            aventuraClass.avance60();
            parrafo.setText(aventuraClass.getParrafo());

            //actividad 2
            img01Act02.setImageResource(aventuraClass.getImg01Act02());
            img02Act02.setImageResource(aventuraClass.getImg02Act02());
            img03Act02.setImageResource(aventuraClass.getImg03Act02());
            img04Act02.setImageResource(aventuraClass.getImg04Act02());
            btn01Act02.setText(aventuraClass.getPalabra01());
            btn02Act02.setText(aventuraClass.getPalabra02());
            btn03Act02.setText(aventuraClass.getPalabra03());
            btn04Act02.setText(aventuraClass.getPalabra04());

        } else {
            titulo.setText("Título no encontrado");
        }
    }

    public void avance80() {
        scrCuento.scrollTo(0, 0);
        String[] titulos = aventuraClass.getTitulos();

        if (cuentoSelecto >= 0 && cuentoSelecto < titulos.length) {
            aventuraClass.setCuentoSelecto(cuentoSelecto);
            aventuraClass.avance80();
            parrafo.setText(aventuraClass.getParrafo());
            imagenCuento.setImageResource(aventuraClass.getImagen());

            //actividad 3: Amigos
            txtLetra01Act3.setText(aventuraClass.getLetra_Act3_01());
            txtLetra02Act3.setText(aventuraClass.getLetra_Act3_02());
            txtLetra03Act3.setText(aventuraClass.getLetra_Act3_03());
            txtLetra04Act3.setText(aventuraClass.getLetra_Act3_04());
            txtLetra05Act3.setText(aventuraClass.getLetra_Act3_05());
            txtLetra06Act3.setText(aventuraClass.getLetra_Act3_06());

            btnLetra01Act3.setText(aventuraClass.getBtn02Act03());
            btnLetra02Act3.setText(aventuraClass.getBtn03Act03());
            btnLetra03Act3.setText(aventuraClass.getBtn05Act03());
            btnLetra04Act3.setText(aventuraClass.getBtn06Act03());


        } else {
            titulo.setText("Título no encontrado");
        }
    }

    public void avance100() {
        scrCuento.scrollTo(0, 0);
        String[] titulos = aventuraClass.getTitulos();

        if (cuentoSelecto >= 0 && cuentoSelecto < titulos.length) {
            aventuraClass.setCuentoSelecto(cuentoSelecto);
            aventuraClass.avance100();
            parrafo.setText(aventuraClass.getParrafo());
            imagenCuento.setImageResource(aventuraClass.getImagen());

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
                audio = MediaPlayer.create(this, aventuraClass.getAudio());
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
                bluetoothService.sendData("A");
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

    }



    //actividad 1 cuento 1
    public void ponerLetra01(View v) {
        TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
        for (TextView letra : letras) {
            if (letra.getText().toString().equals("__")) {
                letra.setText("J");
                btnLetra01.setEnabled(false);
                return;
            }
        }
    }

    public void ponerLetra02(View v) {
        TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
        for (TextView letra : letras) {
            if (letra.getText().toString().equals("__")) {
                letra.setText("G");
                btnLetra02.setEnabled(false);
                return;
            }
        }
    }

    public void ponerLetra03(View v) {
        TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
        for (TextView letra : letras) {
            if (letra.getText().toString().equals("__")) {
                letra.setText("R");
                btnLetra03.setEnabled(false);
                return;
            }
        }
    }

    public void ponerLetra04(View v) {
        TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
        for (TextView letra : letras) {
            if (letra.getText().toString().equals("__")) {
                letra.setText("U");
                btnLetra04.setEnabled(false);
                return;
            }
        }
    }

    public void ponerLetra05(View v) {
        TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
        for (TextView letra : letras) {
            if (letra.getText().toString().equals("__")) {
                letra.setText("A");
                btnLetra05.setEnabled(false);
                return;
            }
        }
    }

    public void comprobarActividad01(View v){
        if(txtLetra01.getText().toString().equals("J") && txtLetra02.getText().toString().equals("U") &&  txtLetra03.getText().toString().equals("G") && txtLetra04.getText().toString().equals("A") && txtLetra05.getText().toString().equals("R")){
            btnEvaluar01.setEnabled(false);
            Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
            TextView[] letras = {txtLetra01, txtLetra02, txtLetra03, txtLetra04, txtLetra05};
            Button [] botones = {btnLetra01, btnLetra02, btnLetra03, btnLetra04, btnLetra05, btnEvaluar01};

            for(TextView letra : letras){
                letra.setText("__");
            }

            for(Button boton : botones){
                boton.setEnabled(true);
            }

        }
    }


    //actividad 2 cuento 1
    public void comprobarBtn01Act02(View v){
        Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
    }
    public void comprobarBtn02Act02(View v){
        Toast.makeText(this, correcto, Toast.LENGTH_SHORT).show();
        btn01Act02.setEnabled(false);
        btn02Act02.setEnabled(false);
        btn03Act02.setEnabled(false);
        btn04Act02.setEnabled(false);
    }
    public void comprobarBtn03Act02(View v){
        Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
    }
    public void comprobarBtn04Act02(View v){
        Toast.makeText(this, incorrecto, Toast.LENGTH_SHORT).show();
    }

    //actividad 3 cuento 1


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

    public AventuraClass getAventuraClass() {
        return aventuraClass;
    }

    public void setAventuraClass(AventuraClass aventuraClass) {
        this.aventuraClass = aventuraClass;
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

}