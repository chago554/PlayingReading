package com.utsem.playingreading.Model_Controller.Aventuras;

import android.graphics.Color;
import android.widget.Button;
import com.utsem.playingreading.R;

public class AventuraClass {

    CuentosAventura cuentosAventura = new CuentosAventura();

    private Button escuchar;
    private Button parar;
    private String [] titulos= {
            "Los Tres Cerditos ",
            "Caperucita Roja",
            "El Patito Feo",
            "La Liebre y la Tortuga",
            "Hansel y Gretel"
    };
    private String tituloCuentoSelecto;
    private int cuentoSelecto;
    private String parrafo;
    private int imagen;
    private int audio;

    //componentes de la actividad 1
    private  int imgAct01;
    private  String letra01="", letra02="", letra03="", letra04="", letra05="";
    private  Button btnLetra01, btnLetra02, btnLetra03, btnLetra04, btnLetra05, btnEvaluarAct01;

    //componentes de la actividad 2
    private int img01Act02, img02Act02, img03Act02, img04Act02;
    private String palabra01, palabra02, palabra03, palabra04;
    private Button btn01Act02, btn02Act02, btn03Act02, btn04Act02;

    //componentes de la actividad 3
    private String letra_Act3_01= "", letra_Act3_02 = "", letra_Act3_03 ="", letra_Act3_04 = "", letra_Act3_05 ="", letra_Act3_06 ="";
    private String btn01Act03, btn02Act03, btn03Act03, btn04Act03, btn05Act03, btn06Act03;

    public void avance20(){
        setTituloCuentoSelecto(titulos[this.cuentoSelecto]);

        switch (this.cuentoSelecto){
            case 0:
                setParrafo("Había tres cerditos que decidieron construir sus casas. El primero, perezoso, usó paja; el segundo, un poco más trabajador, usó madera; y el tercero, precavido, usó ladrillos. Cada uno confiaba en su elección.");
                setAudio(R.raw.lostrescerditos01);
                setImagen(R.drawable.cerdo);
                break;
            case 1:
                setParrafo("Caperucita Roja siempre usaba una capa roja hecha por su abuela. Un día, su madre le pidió que llevara pan y miel a la casa de la abuela, que estaba al otro lado del bosque. Antes de partir, le advirtió no hablar con extraños.");
                setAudio(R.raw.caperucitaroja01);
                setImagen(R.drawable.caperucitarojafoto);
            break;
            case 2:
                setParrafo("En un apacible estanque, nacieron varios patitos. Todos eran amarillos y esponjosos, salvo uno, que era grande y gris. Los demás se burlaban de él, llamándolo feo.");
                setAudio(R.raw.patitofeo01);
            break;
            case 3:
                setParrafo("La liebre se burlaba de la tortuga por su lentitud. Para demostrar su velocidad, la retó a una carrera. La tortuga aceptó con determinación, pese a las burlas.");
                setAudio(R.raw.liebreytortuga01);
            break;
            case 4:
                setParrafo("Hansel y Gretel vivían en una familia pobre. Sus padres, desesperados, los llevaron al bosque y los abandonaron. Para no perderse, Hansel dejó migas de pan en el camino.");
                setAudio(R.raw.hanselygretel01);
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }

    public void avance40(){
        switch (this.cuentoSelecto){
            case 0:
                setParrafo("Un día, un lobo hambriento llegó al pueblo y vio la casa de paja. Sopló con fuerza y la destruyó en segundos. El cerdito huyó a la casa de su hermano, y el lobo lo siguió.");
                setAudio(R.raw.lostrescerditos02);
                setImagen(R.drawable.lobo);
                setImgAct01(R.drawable.bloquear);
                //actividad 1: jugar
                setLetra01("J");
                setLetra02("G");
                setLetra03("R");
                setLetra04("U");
                setLetra05("A");
                break;
            case 1:
                setParrafo("Mientras caminaba por el bosque, se encontró con un lobo astuto. Él le preguntó adónde iba, y sin sospechar nada, le contó su destino. El lobo ideó un plan para adelantarse.");
                setAudio(R.raw.caperucitaroja02);
                break;
            case 2:
                setParrafo("Sentirse rechazado lo hizo marcharse. El patito vagó solo durante un crudo invierno. A pesar de la soledad, nunca perdió la esperanza.");
                setAudio(R.raw.patitofeo02);
            break;
            case 3:
                setParrafo("Al inicio de la carrera, la liebre salió disparada y dejó a la tortuga muy atrás. Confiada en su triunfo, se detuvo a descansar bajo un árbol. El sueño la venció por completo.");
                setAudio(R.raw.liebreytortuga02);
                break;
            case 4:
                setParrafo("Pero los pájaros se comieron las migas, dejándolos sin ruta de regreso. Perdidos y hambrientos, los niños encontraron una casa hecha de dulces. La tentación era irresistible.");
                setAudio(R.raw.hanselygretel02);
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }

    }

    public void avance60(){
        switch (this.cuentoSelecto){
            case 0:
                setParrafo("Al llegar a la casa de madera, el lobo sopló aún más fuerte y la derribó. Los dos hermanos corrieron asustados hacia la casa de ladrillos del mayor. El peligro se intensificaba.");
                setAudio(R.raw.lostrescerditos03);
                setImagen(R.drawable.casaladrillo);

                setImg01Act02(R.drawable.diccionario);
                setImg02Act02(R.drawable.cursoporinternet);
                setImg03Act02(R.drawable.numeros);
                setImg04Act02(R.drawable.aprenderenlinea);

                setPalabra01("Videos");
                setPalabra02("Aprender");
                setPalabra03("Diversión");
                setPalabra04("Números");
            break;
            case 1:
                setParrafo("El lobo tomó un camino corto y llegó primero a la casa de la anciana. Se disfrazó con su ropa y se metió en la cama. Esperaba engañar a Caperucita al momento de su llegada.");
                setAudio(R.raw.caperucitaroja03);
                break;
            case 2:
                setParrafo("Cuando llegó la primavera, vio un lago habitado por elegantes cisnes. Con temor se acercó, pero fue recibido con amabilidad. Al mirarse en el agua, se sorprendió.");
                setAudio(R.raw.patitofeo03);
                break;
            case 3:
                setParrafo("Mientras la liebre dormía, la tortuga avanzaba paso a paso. Con constancia, se fue acercando a la meta sin detenerse. Su esfuerzo silencioso hablaba por sí mismo.");
                setAudio(R.raw.liebreytortuga03);
                break;
            case 4:
                setParrafo("La dueña de la casa era una bruja malvada que los atrapó. Planeaba engordar a Hansel para comérselo y obligó a Gretel a trabajar. El peligro se cernía sobre ellos.");
                setAudio(R.raw.hanselygretel03);
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }

    public void avance80(){
        switch (this.cuentoSelecto){
            case 0:
                setParrafo("El lobo intentó derribar la casa de ladrillos sin éxito. Furioso, decidió entrar por la chimenea sin prever nada. La situación parecía desesperada para él.");
                setAudio(R.raw.lostrescerditos04);
                setImagen(R.drawable.chimenea);
                //actividad 3
                setLetra_Act3_01("A");
                setLetra_Act3_02("__");
                setLetra_Act3_03("__");
                setLetra_Act3_04("G");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn02Act03("M");
                setBtn03Act03("I");
                setBtn05Act03("O");
                setBtn06Act03("S");







                break;
            case 1:
                setParrafo("Cuando la niña entró, notó que su \"abuela\" tenía grandes orejas, ojos y dientes. Al instante, el lobo saltó de la cama para atraparla. La tensión llenó la habitación en segundos.");
                setAudio(R.raw.caperucitaroja04);
                break;
            case 2:
                setParrafo("Descubrió que había crecido y se había transformado en un hermoso cisne. Ya no era feo, sino especial y digno de admiración. La nueva imagen le devolvió la confianza.");
                setAudio(R.raw.patitofeo04);
                break;
            case 3:
                setParrafo("Cuando la liebre despertó, la tortuga estaba a punto de cruzar la línea de meta. Desesperada, corrió lo más rápido que pudo, pero era tarde.");
                setAudio(R.raw.liebreytortuga04);
                break;
            case 4:
                setParrafo("Con astucia, Gretel empujó a la bruja al horno durante un descuido. Juntos, encontraron un cofre con oro que les permitió escapar. La esperanza resurgía en medio del miedo.");
                setAudio(R.raw.hanselygretel04);
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }

    public void avance100(){
        switch (this.cuentoSelecto){
            case 0:
                setParrafo("El mayor había preparado una olla con agua hirviendo en la chimenea. Al bajar, el lobo cayó en ella, se quemó y huyó para nunca volver. Así, los cerditos aprendieron el valor del esfuerzo y la dedicación.");
                setAudio(R.raw.lostrescerditos05);
                setImagen(R.drawable.olla);
                break;
            case 1:
                setParrafo("Por fortuna, un leñador cercano escuchó los gritos. Entró corriendo, espantó al lobo y rescató a la abuela y a la niña. Desde ese día, Caperucita obedeció las advertencias de su madre.");
                setAudio(R.raw.caperucitaroja05);
                break;
            case 2:
                setParrafo("Ahora, con una familia que lo aceptó, vivió feliz y comprendió que la verdadera belleza viene desde dentro. Nunca volvió a sentirse solo ni rechazado.");
                setAudio(R.raw.patitofeo05);
                break;
            case 3:
                setParrafo("La tortuga ganó la carrera con perseverancia. La liebre aprendió que la constancia y el esfuerzo superan la mera velocidad. Una lección que nunca olvidó.");
                setAudio(R.raw.liebreytortuga05);
                break;
            case 4:
                setParrafo("Al volver a casa, sus padres los recibieron con alegría. Con el oro, la familia nunca volvió a pasar hambre, y la vida de los niños cambió para siempre.");
                setAudio(R.raw.hanselygretel05);
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }





    public int getCuentoSelecto() {
        return cuentoSelecto;
    }

    public void setCuentoSelecto(int cuentoSelecto) {
        this.cuentoSelecto = cuentoSelecto;
    }

    public CuentosAventura getCuentosAventura() {
        return cuentosAventura;
    }

    public void setCuentosAventura(CuentosAventura cuentosAventura) {
        this.cuentosAventura = cuentosAventura;
    }

    public String getTituloCuentoSelecto() {
        return tituloCuentoSelecto;
    }

    public void setTituloCuentoSelecto(String tituloCuentoSelecto) {
        this.tituloCuentoSelecto = tituloCuentoSelecto;
    }

    public String[] getTitulos() {
        return titulos;
    }

    public void setTitulos(String[] titulos) {
        this.titulos = titulos;
    }

    public String getParrafo() {
        return parrafo;
    }

    public void setParrafo(String parrafo) {
        this.parrafo = parrafo;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Button getParar() {
        return parar;
    }

    public void setParar(Button parar) {
        this.parar = parar;
    }

    public Button getEscuchar() {
        return escuchar;
    }

    public void setEscuchar(Button escuchar) {
        this.escuchar = escuchar;
    }

    public int getImgAct01() {
        return imgAct01;
    }

    public void setImgAct01(int imgAct01) {
        this.imgAct01 = imgAct01;
    }

    public String getLetra01() {
        return letra01;
    }

    public void setLetra01(String letra01) {
        this.letra01 = letra01;
    }

    public String getLetra02() {
        return letra02;
    }

    public void setLetra02(String letra02) {
        this.letra02 = letra02;
    }

    public String getLetra03() {
        return letra03;
    }

    public void setLetra03(String letra03) {
        this.letra03 = letra03;
    }

    public String getLetra04() {
        return letra04;
    }

    public void setLetra04(String letra04) {
        this.letra04 = letra04;
    }

    public String getLetra05() {
        return letra05;
    }

    public void setLetra05(String letra05) {
        this.letra05 = letra05;
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

    public Button getBtnEvaluarAct01() {
        return btnEvaluarAct01;
    }

    public void setBtnEvaluarAct01(Button btnEvaluarAct01) {
        this.btnEvaluarAct01 = btnEvaluarAct01;
    }

    public int getImg01Act02() {
        return img01Act02;
    }

    public void setImg01Act02(int img01Act02) {
        this.img01Act02 = img01Act02;
    }

    public int getImg02Act02() {
        return img02Act02;
    }

    public void setImg02Act02(int img02Act02) {
        this.img02Act02 = img02Act02;
    }

    public int getImg03Act02() {
        return img03Act02;
    }

    public void setImg03Act02(int img03Act02) {
        this.img03Act02 = img03Act02;
    }

    public int getImg04Act02() {
        return img04Act02;
    }

    public void setImg04Act02(int img04Act02) {
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

    public String getPalabra01() {
        return palabra01;
    }

    public void setPalabra01(String palabra01) {
        this.palabra01 = palabra01;
    }

    public String getPalabra02() {
        return palabra02;
    }

    public void setPalabra02(String palabra02) {
        this.palabra02 = palabra02;
    }

    public String getPalabra03() {
        return palabra03;
    }

    public void setPalabra03(String palabra03) {
        this.palabra03 = palabra03;
    }

    public String getPalabra04() {
        return palabra04;
    }

    public void setPalabra04(String palabra04) {
        this.palabra04 = palabra04;
    }

    public String getLetra_Act3_01() {
        return letra_Act3_01;
    }

    public void setLetra_Act3_01(String letra_Act3_01) {
        this.letra_Act3_01 = letra_Act3_01;
    }

    public String getLetra_Act3_02() {
        return letra_Act3_02;
    }

    public void setLetra_Act3_02(String letra_Act3_02) {
        this.letra_Act3_02 = letra_Act3_02;
    }

    public String getLetra_Act3_03() {
        return letra_Act3_03;
    }

    public void setLetra_Act3_03(String letra_Act3_03) {
        this.letra_Act3_03 = letra_Act3_03;
    }

    public String getLetra_Act3_04() {
        return letra_Act3_04;
    }

    public void setLetra_Act3_04(String letra_Act3_04) {
        this.letra_Act3_04 = letra_Act3_04;
    }

    public String getLetra_Act3_05() {
        return letra_Act3_05;
    }

    public void setLetra_Act3_05(String letra_Act3_05) {
        this.letra_Act3_05 = letra_Act3_05;
    }

    public String getLetra_Act3_06() {
        return letra_Act3_06;
    }

    public void setLetra_Act3_06(String letra_Act3_06) {
        this.letra_Act3_06 = letra_Act3_06;
    }

    public String getBtn01Act03() {
        return btn01Act03;
    }

    public void setBtn01Act03(String btn01Act03) {
        this.btn01Act03 = btn01Act03;
    }

    public String getBtn02Act03() {
        return btn02Act03;
    }

    public void setBtn02Act03(String btn02Act03) {
        this.btn02Act03 = btn02Act03;
    }

    public String getBtn03Act03() {
        return btn03Act03;
    }

    public void setBtn03Act03(String btn03Act03) {
        this.btn03Act03 = btn03Act03;
    }

    public String getBtn04Act03() {
        return btn04Act03;
    }

    public void setBtn04Act03(String btn04Act03) {
        this.btn04Act03 = btn04Act03;
    }

    public String getBtn05Act03() {
        return btn05Act03;
    }

    public void setBtn05Act03(String btn05Act03) {
        this.btn05Act03 = btn05Act03;
    }

    public String getBtn06Act03() {
        return btn06Act03;
    }

    public void setBtn06Act03(String btn06Act03) {
        this.btn06Act03 = btn06Act03;
    }
}
