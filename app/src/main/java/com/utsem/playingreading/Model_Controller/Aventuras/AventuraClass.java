package com.utsem.playingreading.Model_Controller.Aventuras;

import com.utsem.playingreading.R;

public class AventuraClass {

    private final String [] titulos= {
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
    private  String btnLetra01 ="", btnLetra02 ="", btnLetra03 ="", btnLetra04 ="", btnLetra05 ="";

    //componentes de la actividad 2
    private int img01Act02, img02Act02, img03Act02, img04Act02;
    private String palabra01, palabra02, palabra03, palabra04;

    //componentes de la actividad 3
    private String letra_Act3_01= "", letra_Act3_02 = "", letra_Act3_03 ="", letra_Act3_04 = "", letra_Act3_05 ="", letra_Act3_06 ="";
    private String btn01Act03, btn02Act03, btn03Act03, btn04Act03;

    //componentes de la activida 4
    private String txtPregunta01, txtPregunta02, txtPregunta03, txtPregunta04, txtPregunta05;
    private String rdbP011, rdbP012, rdbP013, rdbP021, rdbP022, rdbP023, rdbP031, rdbP032, rdbP033, rdbP041, rdbP042, rdbP043, rdbP051, rdbP052, rdbP053;
    private int pre011, pre012, pre013, pre021, pre022, pre023, pre031, pre032, pre033, pre041, pre042, pre043, pre051, pre052, pre053 ;

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
                setImagen(R.drawable.patito);
            break;
            case 3:
                setParrafo("La liebre se burlaba de la tortuga por su lentitud. Para demostrar su velocidad, la retó a una carrera. La tortuga aceptó con determinación, pese a las burlas.");
                setAudio(R.raw.liebreytortuga01);
                setImagen(R.drawable.liebre);
            break;
            case 4:
                setParrafo("Hansel y Gretel vivían en una familia pobre. Sus padres, desesperados, los llevaron al bosque y los abandonaron. Para no perderse, Hansel dejó migas de pan en el camino.");
                setAudio(R.raw.hanselygretel01);
                setImagen(R.drawable.bosque);
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }

    public void avance40(){
        switch (this.cuentoSelecto) {
            case 0:
                setParrafo("Un día, un lobo hambriento llegó al pueblo y vio la casa de paja. Sopló con fuerza y la destruyó en segundos. El cerdito huyó a la casa de su hermano, y el lobo lo siguió.");
                setAudio(R.raw.lostrescerditos02);
                setImagen(R.drawable.lobo);
                setImgAct01(R.drawable.bloquear);

                //actividad 1: jugar
                setBtnLetra01("J");
                setBtnLetra02("G");
                setBtnLetra03("R");
                setBtnLetra04("U");
                setBtnLetra05("A");
                break;
            case 1:
                setParrafo("Mientras caminaba por el bosque, se encontró con un lobo astuto. Él le preguntó adónde iba, y sin sospechar nada, le contó su destino. El lobo ideó un plan para adelantarse.");
                setAudio(R.raw.caperucitaroja02);
                setImagen(R.drawable.bosque);
                setImgAct01(R.drawable.libro);

                //actividad 1: libro
                setBtnLetra01("L");
                setBtnLetra02("B");
                setBtnLetra03("O");
                setBtnLetra04("I");
                setBtnLetra05("R");
                break;
            case 2:
                setParrafo("Sentirse rechazado lo hizo marcharse. El patito vagó solo durante un crudo invierno. A pesar de la soledad, nunca perdió la esperanza.");
                setAudio(R.raw.patitofeo02);
                setImagen(R.drawable.arboldeinvierno);
                setImgAct01(R.drawable.noble);

                //actividad 1: Noble
                setBtnLetra01("B");
                setBtnLetra02("O");
                setBtnLetra03("E");
                setBtnLetra04("L");
                setBtnLetra05("N");
            break;
            case 3:
                setParrafo("Al inicio de la carrera, la liebre salió disparada y dejó a la tortuga muy atrás. Confiada en su triunfo, se detuvo a descansar bajo un árbol. El sueño la venció por completo.");
                setAudio(R.raw.liebreytortuga02);
                setImagen(R.drawable.tortuga);
                setImgAct01(R.drawable.coche);

                //actividad 1: Coche
                setBtnLetra01("C");
                setBtnLetra02("O");
                setBtnLetra03("H");
                setBtnLetra04("E");
                setBtnLetra05("C");
                break;

            case 4:
                setParrafo("Pero los pájaros se comieron las migas, dejándolos sin ruta de regreso. Perdidos y hambrientos, los niños encontraron una casa hecha de dulces. La tentación era irresistible.");
                setAudio(R.raw.hanselygretel02);
                setImagen(R.drawable.tucan);
                setImgAct01(R.drawable.playa);

                //actividad 1: Playa
                setBtnLetra01("A");
                setBtnLetra02("P");
                setBtnLetra03("Y");
                setBtnLetra04("L");
                setBtnLetra05("A");
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

                setPalabra01("Laptop");
                setPalabra02("Aprender");
                setPalabra03("Enojo");
                setPalabra04("Tablas");
                break;
            case 1:
                setParrafo("El lobo tomó un camino corto y llegó primero a la casa de la anciana. Se disfrazó con su ropa y se metió en la cama. Esperaba engañar a Caperucita al momento de su llegada.");
                setAudio(R.raw.caperucitaroja03);
                setImagen(R.drawable.viejo);

                setImg01Act02(R.drawable.planta);
                setImg02Act02(R.drawable.hoja);
                setImg03Act02(R.drawable.planta1);
                setImg04Act02(R.drawable.planta2);

                setPalabra01("Plantas");
                setPalabra02("Armario");
                setPalabra03("Fauna");
                setPalabra04("Bicicleta");
                break;
            case 2:
                setParrafo("Cuando llegó la primavera, vio un lago habitado por elegantes cisnes. Con temor se acercó, pero fue recibido con amabilidad. Al mirarse en el agua, se sorprendió.");
                setAudio(R.raw.patitofeo03);
                setImagen(R.drawable.primavera);

                setImg01Act02(R.drawable.corazones);
                setImg02Act02(R.drawable.amor);
                setImg03Act02(R.drawable.amabilidad);
                setImg04Act02(R.drawable.unir);

                setPalabra01("Valiente");
                setPalabra02("Auto");
                setPalabra03("Amor");
                setPalabra04("Carencia");
                break;
            case 3:
                setParrafo("Mientras la liebre dormía, la tortuga avanzaba paso a paso. Con constancia, se fue acercando a la meta sin detenerse. Su esfuerzo silencioso hablaba por sí mismo.");
                setAudio(R.raw.liebreytortuga03);
                setImagen(R.drawable.lineademeta);

                setImg01Act02(R.drawable.correr);
                setImg02Act02(R.drawable.corriendo);
                setImg03Act02(R.drawable.corriendo1);
                setImg04Act02(R.drawable.trotar);

                setPalabra01("Perro");
                setPalabra02("Correr");
                setPalabra03("Tarta");
                setPalabra04("Viento");
                break;
            case 4:
                setParrafo("La dueña de la casa era una bruja malvada que los atrapó. Planeaba engordar a Hansel para comérselo y obligó a Gretel a trabajar. El peligro se cernía sobre ellos.");
                setAudio(R.raw.hanselygretel03);
                setImagen(R.drawable.bruja);

                setImg01Act02(R.drawable.paleta);
                setImg02Act02(R.drawable.caramelos);
                setImg03Act02(R.drawable.bastoncaramelo);
                setImg04Act02(R.drawable.chupete);

                setPalabra01("Malo");
                setPalabra02("Miedo");
                setPalabra03("Dulce");
                setPalabra04("Bueno");
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
                setBtn01Act03("M");
                setBtn02Act03("I");
                setBtn03Act03("O");
                setBtn04Act03("S");


                break;
            case 1:
                setParrafo("Cuando la niña entró, notó que su \"abuela\" tenía grandes orejas, ojos y dientes. Al instante, el lobo saltó de la cama para atraparla. La tensión llenó la habitación en segundos.");
                setAudio(R.raw.caperucitaroja04);
                setImagen(R.drawable.hombrelobo);

                //actividad 3: verdad
                setLetra_Act3_01("__");
                setLetra_Act3_02("E");
                setLetra_Act3_03("__");
                setLetra_Act3_04("D");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn01Act03("D");
                setBtn02Act03("A");
                setBtn03Act03("V");
                setBtn04Act03("R");
                break;
            case 2:
                setParrafo("Descubrió que había crecido y se había transformado en un hermoso cisne. Ya no era feo, sino especial y digno de admiración. La nueva imagen le devolvió la confianza.");
                setAudio(R.raw.patitofeo04);
                setImagen(R.drawable.cisne);

                //actividad 3: Bondad
                setLetra_Act3_01("__");
                setLetra_Act3_02("O");
                setLetra_Act3_03("__");
                setLetra_Act3_04("__");
                setLetra_Act3_05("A");
                setLetra_Act3_06("__");

                setBtn01Act03("D");
                setBtn02Act03("N");
                setBtn03Act03("B");
                setBtn04Act03("D");
                break;
            case 3:
                setParrafo("Cuando la liebre despertó, la tortuga estaba a punto de cruzar la línea de meta. Desesperada, corrió lo más rápido que pudo, pero era tarde.");
                setAudio(R.raw.liebreytortuga04);
                setImagen(R.drawable.dormido);

                //actividad 3: Ciudad
                setLetra_Act3_01("C");
                setLetra_Act3_02("__");
                setLetra_Act3_03("U");
                setLetra_Act3_04("__");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn01Act03("D");
                setBtn02Act03("I");
                setBtn03Act03("A");
                setBtn04Act03("D");

                break;
            case 4:
                setParrafo("Con astucia, Gretel empujó a la bruja al horno durante un descuido. Juntos, encontraron un cofre con oro que les permitió escapar. La esperanza resurgía en medio del miedo.");
                setAudio(R.raw.hanselygretel04);
                setImagen(R.drawable.cofre);

                //actividad 3: Música
                setLetra_Act3_01("__");
                setLetra_Act3_02("U");
                setLetra_Act3_03("S");
                setLetra_Act3_04("__");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn01Act03("M");
                setBtn02Act03("C");
                setBtn03Act03("I");
                setBtn04Act03("A");

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

                setTxtPregunta01("¿De qué hizo su casita el cerdito más perezoso?");
                setRdbP011("a) De ladrillos");
                setRdbP012("b) De paja"); //corecta
                setRdbP013("c) De madera");
                setPre012(1);

                setTxtPregunta02("¿Qué animal malo quería comerse a los cerditos?");
                setRdbP021("a) Un león");
                setRdbP022("b) Un oso");
                setRdbP023("c) Un lobo");//correcta
                setPre023(1);


                setTxtPregunta03("¿Qué hizo el lobo para tirar la casa de paja?");
                setRdbP031("a) La pateó");
                setRdbP032("b) La sopló"); //correcta
                setRdbP033("c) La mordió");
                setPre032(1);

                setTxtPregunta04("¿De qué material era la casa más fuerte?");
                setRdbP041("a) De paja");
                setRdbP042("b) De madera");
                setRdbP043("c) De ladrillos");//correcta
                setPre043(1);

                setTxtPregunta05("¿Por dónde intentó entrar el lobo a la casa de ladrillos?");
                setRdbP051("a) Por la puerta");
                setRdbP052("b) Por la ventana");
                setRdbP053("c) Por la chimenea");//correcta
                setPre053(1);

                break;
            case 1:
                setParrafo("Por fortuna, un leñador cercano escuchó los gritos. Entró corriendo, espantó al lobo y rescató a la abuela y a la niña. Desde ese día, Caperucita obedeció las advertencias de su madre.");
                setAudio(R.raw.caperucitaroja05);
                setImagen(R.drawable.madera);

                setTxtPregunta01("¿Qué llevaba Caperucita en su canasta?");
                setRdbP011("a) Frutas y verduras");
                setRdbP012("b) Pan y miel"); //corecta
                setRdbP013("c) Galletas y leche");
                setPre012(1);

                setTxtPregunta02("¿Quién le hizo la capa roja a Caperucita?");
                setRdbP021("a) Su mamá");
                setRdbP022("b) Su abuela");//correcta
                setRdbP023("c) Su tía");
                setPre022(1);


                setTxtPregunta03("¿A quién se encontró Caperucita en el bosque?");
                setRdbP031("a) Un oso");
                setRdbP032("b) Un conejo");
                setRdbP033("c) Un lobo");//correcta
                setPre033(1);

                setTxtPregunta04("¿Qué hizo el lobo para engañar a Caperucita?");
                setRdbP041("a) Se disfrazó de su abuela");//correcta
                setRdbP042("b) Se escondió en un árbol");
                setRdbP043("c) Se hizo amigo de ella");
                setPre041(1);

                setTxtPregunta05("¿Quién salvó a Caperucita y a su abuela?");
                setRdbP051("a) Un príncipe");
                setRdbP052("b) Un leñador");//correcta
                setRdbP053("c) Un cazador");
                setPre052(1);


                break;
            case 2:
                setParrafo("Ahora, con una familia que lo aceptó, vivió feliz y comprendió que la verdadera belleza viene desde dentro. Nunca volvió a sentirse solo ni rechazado.");
                setAudio(R.raw.patitofeo05);
                setImagen(R.drawable.corazones);

                setTxtPregunta01("¿De qué color era el patito diferente al principio?");
                setRdbP011("a) Amarillo");
                setRdbP012("b) Gris"); //corecta
                setRdbP013("c) Blanco");
                setPre012(1);

                setTxtPregunta02("¿Qué le decían los otros patitos al patito diferente?");
                setRdbP021("a) Lindo");
                setRdbP022("b) Amigo");
                setRdbP023("c) Feo");//correcta
                setPre023(1);


                setTxtPregunta03("¿En qué animal se convirtió el patito feo?");
                setRdbP031("a) Un pato grande");
                setRdbP032("b) Un cisne");//correcta
                setRdbP033("c) Un ganso");
                setPre032(1);

                setTxtPregunta04("¿Qué estación del año llegó después del invierno en la historia?");
                setRdbP041("a) El verano");
                setRdbP042("b) La primavera");//correcta
                setRdbP043("c) El otoño");
                setPre042(1);

                setTxtPregunta05("¿Qué aprendió el patito sobre la belleza?");
                setRdbP051("a) Que la verdadera belleza está en el interior");//correcta
                setRdbP052("b) Que debe ser igual a los demás");
                setRdbP053("c) Que solo importa el exterior");
                setPre051(1);
                break;
            case 3:
                setParrafo("La tortuga ganó la carrera con perseverancia. La liebre aprendió que la constancia y el esfuerzo superan la mera velocidad. Una lección que nunca olvidó.");
                setAudio(R.raw.liebreytortuga05);
                setImagen(R.drawable.ganar);

                setTxtPregunta01("¿Qué animal retó a la tortuga a una carrera?");
                setRdbP011("a) Un conejo");
                setRdbP012("b) Una ardilla");
                setRdbP013("c) Una liebre");//corecta
                setPre013(1);

                setTxtPregunta02("¿Qué hizo la liebre durante la carrera?");
                setRdbP021("a) Siguió corriendo");
                setRdbP022("b) Se detuvo a dormir");//correcta
                setRdbP023("c) Se puso a comer");
                setPre022(1);


                setTxtPregunta03("¿Quién ganó la carrera?");
                setRdbP031("a) La tortuga");//correcta
                setRdbP032("b) La liebre");
                setRdbP033("c) Un ganso");
                setPre031(1);

                setTxtPregunta04("¿Qué aprendió la liebre de la carrera?");
                setRdbP041("a) Que debe dormir más");
                setRdbP042("b) Que la velocidad lo es todo");
                setRdbP043("c) Que la constancia supera la velocidad");//correcta
                setPre043(1);

                setTxtPregunta05("¿Cómo avanzaba la tortuga durante la carrera?");
                setRdbP051("a) Saltando");
                setRdbP052("b) Corriendo");
                setRdbP053("c) Paso a paso");//correcta
                setPre053(1);

                break;
            case 4:
                setParrafo("Al volver a casa, sus padres los recibieron con alegría. Con el oro, la familia nunca volvió a pasar hambre, y la vida de los niños cambió para siempre.");
                setAudio(R.raw.hanselygretel05);
                setImagen(R.drawable.casa1);

                setTxtPregunta01("¿De qué material estaba hecha la casa que encontraron Hansel y Gretel?");
                setRdbP011("a) Dulces");//corecta
                setRdbP012("b) Ladrillos");
                setRdbP013("c) Madera");
                setPre011(1);

                setTxtPregunta02("¿Quién vivía en la casa de dulces?");
                setRdbP021("a) Un hada");
                setRdbP022("b) Un gidante");
                setRdbP023("c) Una bruja");//correcta
                setPre023(1);


                setTxtPregunta03("¿Qué dejaron Hansel y Gretel para encontrar el camino de regreso?");
                setRdbP031("a) Piedras");
                setRdbP032("b) Migas de pan");//correcta
                setRdbP033("c) Flores");
                setPre032(1);

                setTxtPregunta04("¿Qué encontraron Hansel y Gretel que les permitió vivir bien?");
                setRdbP041("a) Un castillo");
                setRdbP042("b) Un cofre de oro");//correcta
                setRdbP043("c) Un animal mágico");
                setPre042(1);

                setTxtPregunta05("¿Qué le hizo Gretel a la bruja?");
                setRdbP051("a) La encerró en la casa");
                setRdbP052("b) La convirtió en piedra");
                setRdbP053("c) La empujó al horno");//correcta
                setPre053(1);

                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }


    public void setCuentoSelecto(int cuentoSelecto) {
        this.cuentoSelecto = cuentoSelecto;
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

    public int getImgAct01() {
        return imgAct01;
    }

    public void setImgAct01(int imgAct01) {
        this.imgAct01 = imgAct01;
    }

    public String getBtnLetra01() {
        return btnLetra01;
    }

    public void setBtnLetra01(String btnLetra01) {
        this.btnLetra01 = btnLetra01;
    }

    public String getBtnLetra02() {
        return btnLetra02;
    }

    public void setBtnLetra02(String btnLetra02) {
        this.btnLetra02 = btnLetra02;
    }

    public String getBtnLetra03() {
        return btnLetra03;
    }

    public void setBtnLetra03(String btnLetra03) {
        this.btnLetra03 = btnLetra03;
    }

    public String getBtnLetra04() {
        return btnLetra04;
    }

    public void setBtnLetra04(String btnLetra04) {
        this.btnLetra04 = btnLetra04;
    }

    public String getBtnLetra05() {
        return btnLetra05;
    }

    public void setBtnLetra05(String btnLetra05) {
        this.btnLetra05 = btnLetra05;
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

    public String getTxtPregunta01() {
        return txtPregunta01;
    }

    public void setTxtPregunta01(String txtPregunta01) {
        this.txtPregunta01 = txtPregunta01;
    }

    public String getTxtPregunta02() {
        return txtPregunta02;
    }

    public void setTxtPregunta02(String txtPregunta02) {
        this.txtPregunta02 = txtPregunta02;
    }

    public String getTxtPregunta03() {
        return txtPregunta03;
    }

    public void setTxtPregunta03(String txtPregunta03) {
        this.txtPregunta03 = txtPregunta03;
    }

    public String getTxtPregunta04() {
        return txtPregunta04;
    }

    public void setTxtPregunta04(String txtPregunta04) {
        this.txtPregunta04 = txtPregunta04;
    }

    public String getTxtPregunta05() {
        return txtPregunta05;
    }

    public void setTxtPregunta05(String txtPregunta05) {
        this.txtPregunta05 = txtPregunta05;
    }

    public String getRdbP011() {
        return rdbP011;
    }

    public void setRdbP011(String rdbP011) {
        this.rdbP011 = rdbP011;
    }

    public String getRdbP012() {
        return rdbP012;
    }

    public void setRdbP012(String rdbP012) {
        this.rdbP012 = rdbP012;
    }

    public String getRdbP013() {
        return rdbP013;
    }

    public void setRdbP013(String rdbP013) {
        this.rdbP013 = rdbP013;
    }

    public String getRdbP021() {
        return rdbP021;
    }

    public void setRdbP021(String rdbP021) {
        this.rdbP021 = rdbP021;
    }

    public String getRdbP022() {
        return rdbP022;
    }

    public void setRdbP022(String rdbP022) {
        this.rdbP022 = rdbP022;
    }

    public String getRdbP023() {
        return rdbP023;
    }

    public void setRdbP023(String rdbP023) {
        this.rdbP023 = rdbP023;
    }

    public String getRdbP031() {
        return rdbP031;
    }

    public void setRdbP031(String rdbP031) {
        this.rdbP031 = rdbP031;
    }

    public String getRdbP032() {
        return rdbP032;
    }

    public void setRdbP032(String rdbP032) {
        this.rdbP032 = rdbP032;
    }

    public String getRdbP033() {
        return rdbP033;
    }

    public void setRdbP033(String rdbP033) {
        this.rdbP033 = rdbP033;
    }

    public String getRdbP041() {
        return rdbP041;
    }

    public void setRdbP041(String rdbP041) {
        this.rdbP041 = rdbP041;
    }

    public String getRdbP042() {
        return rdbP042;
    }

    public void setRdbP042(String rdbP042) {
        this.rdbP042 = rdbP042;
    }

    public String getRdbP043() {
        return rdbP043;
    }

    public void setRdbP043(String rdbP043) {
        this.rdbP043 = rdbP043;
    }

    public String getRdbP051() {
        return rdbP051;
    }

    public void setRdbP051(String rdbP051) {
        this.rdbP051 = rdbP051;
    }

    public String getRdbP052() {
        return rdbP052;
    }

    public void setRdbP052(String rdbP052) {
        this.rdbP052 = rdbP052;
    }

    public String getRdbP053() {
        return rdbP053;
    }

    public void setRdbP053(String rdbP053) {
        this.rdbP053 = rdbP053;
    }

    public void setPre011(int pre011) {
        this.pre011 = pre011;
    }

    public int getPre011() {
        return pre011;
    }

    public int getPre012() {return pre012;}

    public void setPre012(int pre012) {
        this.pre012 = pre012;
    }

    public int getPre013() {
        return pre013;
    }

    public int getPre021() {
        return pre021;
    }

    public int getPre022() {
        return pre022;
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

    public int getPre032() {
        return pre032;
    }

    public void setPre032(int pre032) {
        this.pre032 = pre032;
    }

    public int getPre033() {
        return pre033;
    }

    public int getPre041() {
        return pre041;
    }

    public int getPre042() {
        return pre042;
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

    public int getPre052() {
        return pre052;
    }

    public int getPre053() {
        return pre053;
    }
    public void setPre053(int pre053) {
        this.pre053 = pre053;
    }

    public void setPre052(int pre052) {
        this.pre052 = pre052;
    }

    public void setPre051(int pre051) {
        this.pre051 = pre051;
    }

    public void setPre042(int pre042) {
        this.pre042 = pre042;
    }

    public void setPre041(int pre041) {
        this.pre041 = pre041;
    }

    public void setPre033(int pre033) {
        this.pre033 = pre033;
    }

    public void setPre031(int pre031) {
        this.pre031 = pre031;
    }

    public void setPre022(int pre022) {
        this.pre022 = pre022;
    }

    public void setPre021(int pre021) {
        this.pre021 = pre021;
    }

    public void setPre013(int pre013) {
        this.pre013 = pre013;
    }
}
