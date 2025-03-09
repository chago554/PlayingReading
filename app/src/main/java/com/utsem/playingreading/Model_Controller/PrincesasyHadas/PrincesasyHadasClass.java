package com.utsem.playingreading.Model_Controller.PrincesasyHadas;

import com.utsem.playingreading.R;

public class PrincesasyHadasClass {

    private final String [] titulos= {
            "La Bella Durmiente",
            "Cenicienta",
            "La Sirenita",
            "Blancanieves",
            "El Hada Azul"
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
                setParrafo("Una princesa nació bendecida por hadas, pero también maldecida por una hada enojada. Al cumplir 16 años, se pincharía con un huso y caería en un sueño eterno. El rey hizo todo lo posible para evitarlo.");
                setAudio(R.raw.labelladurmiente01);
                setImagen(R.drawable.hadamalvada);
                break;
            case 1:
                setParrafo(" Cenicienta vivía maltratada por su madrastra y hermanastras. Mientras ellas se derrochaban en lujos, ella cumplía con las tareas del hogar sin descanso. Su corazón, sin embargo, era puro y lleno de sueños.");
                setAudio(R.raw.cenicienta01);
                setImagen(R.drawable.chica);
                break;
            case 2:
                setParrafo("Ariel, la joven sirena, soñaba con conocer la vida en la superficie. Su corazón latía por el príncipe que vio durante un naufragio. Con anhelo, deseaba convertirse en humana para amarlo.");
                setAudio(R.raw.sirenita01);
                setImagen(R.drawable.sirena);
                break;
            case 3:
                setParrafo("Blancanieves era la princesa de inigualable belleza y dulzura. Su madrastra, consumida por la envidia, planeó eliminarla. La reina ordenó que la joven fuera llevada al bosque para no volver a verla.");
                setAudio(R.raw.blancanieves01);
                setImagen(R.drawable.blancanieves1);
                break;
            case 4:
                setParrafo(" El Hada Azul era una criatura mágica que surgía en momentos de necesidad. Ayudaba a niños y jóvenes a cumplir sus sueños con un toque de su varita. Su luz y bondad inspiraban esperanza en el reino.");
                setAudio(R.raw.elhadaazul01);
                setImagen(R.drawable.hadaazul1);
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }

    public void avance40(){
        switch (this.cuentoSelecto) {
            case 0:
                setParrafo("A pesar de destruir todos los husos, la maldición se cumplió. La princesa se pinchó y cayó en un profundo sueño. Todo el reino se sumió en la quietud y la tristeza.");
                setAudio(R.raw.labelladurmiente02);
                setImagen(R.drawable.huso);
                setImgAct01(R.drawable.casa1);

                //actividad 1: Hogar
                setBtnLetra01("G");
                setBtnLetra02("H");
                setBtnLetra03("O");
                setBtnLetra04("R");
                setBtnLetra05("A");
                break;
            case 1:
                setParrafo("Un día, se anunció un gran baile en el palacio. Las hermanastras se alistaron, impidiéndole a Cenicienta asistir. La tristeza se apoderaba de ella, hasta que apareció su hada madrina.");
                setAudio(R.raw.cenicienta02);
                setImagen(R.drawable.hadamadrina);
                setImgAct01(R.drawable.mano);

                //actividad 1: Tacto
                setBtnLetra01("C");
                setBtnLetra02("T");
                setBtnLetra03("T");
                setBtnLetra04("O");
                setBtnLetra05("A");
                break;
            case 2:
                setParrafo("Para lograrlo, hizo un trato con la bruja del mar: a cambio de su voz, obtendría piernas. El precio era alto, pues si el príncipe no correspondía su amor, se perdería en la espuma del mar.");
                setAudio(R.raw.sirenita02);
                setImagen(R.drawable.bruja);

                setImgAct01(R.drawable.trabajadores);
                //actividad 1: Grupo
                setBtnLetra01("R");
                setBtnLetra02("O");
                setBtnLetra03("U");
                setBtnLetra04("P");
                setBtnLetra05("G");
                break;
            case 3:
                setParrafo("El cazador, compadecido, dejó a Blancanieves escapar en el bosque. Perdida pero valiente, encontró refugio en una cabaña solitaria. Allí vivían siete enanitos, trabajadores y bondadosos.");
                setAudio(R.raw.blancanieves02);
                setImagen(R.drawable.cazador);

                setImgAct01(R.drawable.enano1);

                //actividad 1: enano
                setBtnLetra01("N");
                setBtnLetra02("A");
                setBtnLetra03("E");
                setBtnLetra04("O");
                setBtnLetra05("N");
                break;

            case 4:
                setParrafo("Un niño deseaba que su muñeco se convirtiera en un amigo de verdad. Luchaba por demostrar su valor y sinceridad. El Hada Azul observó con atención su esfuerzo constante.");
                setAudio(R.raw.elhadaazul02);
                setImagen(R.drawable.muneco);

                setImgAct01(R.drawable.magia);
                //actividad 1: Magia
                setBtnLetra01("G");
                setBtnLetra02("M");
                setBtnLetra03("I");
                setBtnLetra04("A");
                setBtnLetra05("A");
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }

    }

    public void avance60(){
        switch (this.cuentoSelecto){
            case 0:
                setParrafo("Una de las hadas benignas profetizó que solo un beso de amor verdadero podría despertarla. Así, el castillo entero quedó envuelto en un letargo mágico. La esperanza persistía en un lejano futuro.");
                setAudio(R.raw.labelladurmiente03);
                setImagen(R.drawable.beso);

                setImg01Act02(R.drawable.evaluar);
                setImg02Act02(R.drawable.ocurrencia);
                setImg03Act02(R.drawable.pensando);
                setImg04Act02(R.drawable.idea);

                setPalabra01("Caer");
                setPalabra02("Pensar");
                setPalabra03("Seguir");
                setPalabra04("Correr");
                break;
            case 1:
                setParrafo("Con magia, el hada transformó su ropa en un espléndido vestido y creó una carroza a partir de una calabaza. La magia, no obstante, tenía un límite: se disiparía a medianoche.");
                setAudio(R.raw.cenicienta03);
                setImagen(R.drawable.carruaje);

                setImg01Act02(R.drawable.chat);
                setImg02Act02(R.drawable.telefonointeligente);
                setImg03Act02(R.drawable.cel);
                setImg04Act02(R.drawable.celular);

                setPalabra01("Comer");
                setPalabra02("Reloj");
                setPalabra03("Larva");
                setPalabra04("Celular");
                break;
            case 2:
                setParrafo("Aterrizada pero decidida, Ariel vivió en la tierra, enfrentando un mundo nuevo y extraño. Sin su voz, luchaba por revelar su verdadera identidad y sentimientos.");
                setAudio(R.raw.sirenita03);
                setImagen(R.drawable.chica1);

                setImg01Act02(R.drawable.lasolasdelmar);
                setImg02Act02(R.drawable.marina);
                setImg03Act02(R.drawable.productosdelmar);
                setImg04Act02(R.drawable.conchas);

                setPalabra01("Sol");
                setPalabra02("Largo");
                setPalabra03("Noche");
                setPalabra04("Mar");
                break;
            case 3:
                setParrafo("Con el tiempo, la envidiosa madrastra descubrió que Blancanieves aún vivía. Disfrazada, le ofreció una manzana envenenada para acabar con ella. La inocente princesa cayó en un sueño profundo.");
                setAudio(R.raw.blancanieves03);
                setImagen(R.drawable.manzanaenvenenada);

                setImg01Act02(R.drawable.diadelatierra);
                setImg02Act02(R.drawable.planta2);
                setImg03Act02(R.drawable.planta2);
                setImg04Act02(R.drawable.reciclar);

                setPalabra01("Azul");
                setPalabra02("Agua");
                setPalabra03("Ambiente");
                setPalabra04("Manzana");
                break;
            case 4:
                setParrafo("En una noche estrellada, el hada apareció en su habitación. Con un toque mágico, transformó el muñeco en un niño de carne y hueso. La sorpresa y la alegría inundaron el ambiente.");
                setAudio(R.raw.elhadaazul03);
                setImagen(R.drawable.chico1);

                setImg01Act02(R.drawable.fuente);
                setImg02Act02(R.drawable.fuente2);
                setImg03Act02(R.drawable.fuente1);
                setImg04Act02(R.drawable.fuente3);

                setPalabra01("Fauna");
                setPalabra02("Llora");
                setPalabra03("Fuente");
                setPalabra04("Piedra");
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }

    public void avance80(){
        switch (this.cuentoSelecto){
            case 0:
                setParrafo("Años después, un valiente príncipe atravesó la espesura del olvido. Encontró a la princesa dormida en su lecho, rodeada de un silencio encantado. Con determinación, se acercó para romper el hechizo.");
                setAudio(R.raw.labelladurmiente04);
                setImagen(R.drawable.principe);

                //actividad 3 Unidos
                setLetra_Act3_01("U");
                setLetra_Act3_02("__");
                setLetra_Act3_03("__");
                setLetra_Act3_04("D");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");
                setBtn01Act03("S");
                setBtn02Act03("I");
                setBtn03Act03("O");
                setBtn04Act03("N");

                break;
            case 1:
                setParrafo("En el baile, el príncipe quedó cautivado por su gracia. Bailaron juntos y la conexión fue inmediata, pero cuando el reloj marcó la medianoche, Cenicienta huyó apresurada.");
                setAudio(R.raw.cenicienta04);
                setImagen(R.drawable.reloj);

                //actividad 3: Amable
                setLetra_Act3_01("A");
                setLetra_Act3_02("__");
                setLetra_Act3_03("A");
                setLetra_Act3_04("__");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn01Act03("B");
                setBtn02Act03("L");
                setBtn03Act03("M");
                setBtn04Act03("E");
                break;
            case 2:
                setParrafo("La bruja intentó impedir su felicidad, pero Ariel encontró fuerza en su interior. Con la ayuda de sus amigos, enfrentó el peligro y superó el hechizo.");
                setAudio(R.raw.sirenita04);
                setImagen(R.drawable.fuerzas);

                //actividad 3: JUSTOS
                setLetra_Act3_01("__");
                setLetra_Act3_02("U");
                setLetra_Act3_03("__");
                setLetra_Act3_04("T");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn01Act03("S");
                setBtn02Act03("J");
                setBtn03Act03("O");
                setBtn04Act03("S");
                break;
            case 3:
                setParrafo("Los enanitos, afligidos, protegieron a Blancanieves mientras esperaba ayuda. La noticia del triste destino se esparció por el reino. La esperanza de su rescate no se desvaneció.");
                setAudio(R.raw.blancanieves04);
                setImagen(R.drawable.enano);

                //actividad 3: Virtud
                setLetra_Act3_01("__");
                setLetra_Act3_02("I");
                setLetra_Act3_03("__");
                setLetra_Act3_04("__");
                setLetra_Act3_05("U");
                setLetra_Act3_06("__");

                setBtn01Act03("R");
                setBtn02Act03("V");
                setBtn03Act03("D");
                setBtn04Act03("T");

                break;
            case 4:
                setParrafo("El hada le enseñó la importancia de la honestidad y el valor personal. Le explicó que la verdadera magia reside en el corazón. El niño aprendió a creer en sí mismo.");
                setAudio(R.raw.elhadaazul04);
                setImagen(R.drawable.corazones);

                //actividad 3: Duende
                setLetra_Act3_01("__");
                setLetra_Act3_02("U");
                setLetra_Act3_03("E");
                setLetra_Act3_04("__");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn01Act03("N");
                setBtn02Act03("D");
                setBtn03Act03("D");
                setBtn04Act03("E");

                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }

    public void avance100(){
        switch (this.cuentoSelecto){
            case 0:
                setParrafo("Al besarla, la magia se disipó y la princesa despertó. La maldición se rompió y el reino volvió a la vida. Unidos en amor, vivieron felices por siempre.");
                setAudio(R.raw.labelladurmiente05);
                setImagen(R.drawable.amor1);
                setTxtPregunta01("¿Qué le pasó a la princesa cuando cumplió 16 años?");
                setRdbP011("a) Se casó con un príncipe");
                setRdbP012("b) Se pinchó con un huso y cayó en un sueño eterno"); // Correcta
                setRdbP013("c) Se convirtió en reina");
                setPre012(1);

                setTxtPregunta02("¿Quién maldijo a la princesa?");
                setRdbP021("a) Un hada enojada"); // Correcta
                setRdbP022("b) Un mago");
                setRdbP023("c) Un dragón");
                setPre021(1);

                setTxtPregunta03("¿Cómo se rompió el hechizo?");
                setRdbP031("a) Con una espada mágica");
                setRdbP022("b) Con lágrimas de tristeza");
                setRdbP033("c) Con un beso de amor verdadero"); // Correcta
                setPre033(1);

                setTxtPregunta04("¿Qué hizo el rey para tratar de evitar la maldición?");
                setRdbP041("a) Encerró a la princesa en una torre");
                setRdbP042("b) Destruyó todos los husos del reino"); // Correcta
                setRdbP043("c) Huyó del reino");
                setPre042(1);

                setTxtPregunta05("¿Quién despertó a la princesa?");
                setRdbP051("a) Un leñador");
                setRdbP052("b) Un caballero");
                setRdbP053("c) Un príncipe valiente"); // Correcta
                setPre053(1);

                break;
            case 1:
                setParrafo("Dejó atrás un zapato de cristal, la única pista del príncipe. Buscó a la dueña del zapato y, al probarlo, quedó claro que era ella. Se casaron y ella dejó atrás la vida de tristeza.");
                setAudio(R.raw.cenicienta05);
                setImagen(R.drawable.zapatodecenicienta);

                setTxtPregunta01("¿Cómo era tratada Cenicienta por su madrastra y hermanastras?");
                setRdbP011("a) Con mucho cariño");
                setRdbP012("b) Con indiferencia");
                setRdbP013("c) Con maltrato"); // Correcta
                setPre013(1);

                setTxtPregunta02("¿Quién ayudó a Cenicienta a ir al baile?");
                setRdbP021("a) El príncipe");
                setRdbP022("b) Su hada madrina"); // Correcta
                setRdbP023("c) Un ratón");
                setPre022(1);

                setTxtPregunta03("¿Qué dejó Cenicienta al huir del baile?");
                setRdbP031("a) Un guante");
                setRdbP032("b) Un zapato de cristal"); // Correcta
                setRdbP033("c) Un collar");
                setPre032(1);

                setTxtPregunta04("¿Cómo se rompió el hechizo del hada madrina?");
                setRdbP041("a) A medianoche"); // Correcta
                setRdbP042("b) Con un beso");
                setRdbP043("c) Con el amanecer");
                setPre041(1);

                setTxtPregunta05("¿Con quién se casó Cenicienta?");
                setRdbP051("a) Con un rey");
                setRdbP052("b) Con un caballero");
                setRdbP053("c) Con un príncipe"); // Correcta
                setPre053(1);
                break;
            case 2:
                setParrafo("Finalmente, el príncipe reconoció su nobleza y se enamoró de ella. El hechizo se rompió, y Ariel recuperó su voz y su alegría. Juntos, unieron dos mundos en amor.");
                setAudio(R.raw.sirenita05);
                setImagen(R.drawable.amors);

                setTxtPregunta01("¿Qué soñaba Ariel, la joven sirena?");
                setRdbP011("a) Con tener un tesoro");
                setRdbP012("b) Con conocer la vida en la superficie"); // Correcta
                setRdbP013("c) Con ser reina del mar");
                setPre012(1);

                setTxtPregunta02("¿Qué hizo Ariel para convertirse en humana?");
                setRdbP021("a) Hizo un trato con la bruja del mar"); // Correcta
                setRdbP022("b) Pidió un deseo a una estrella");
                setRdbP023("c) Robó una poción mágica");
                setPre021(1);

                setTxtPregunta03("¿Qué precio tuvo que pagar Ariel por sus piernas?");
                setRdbP031("a) Su cola de sirena");
                setRdbP032("b) Su memoria");
                setRdbP033("c) Su voz"); // Correcta
                setPre033(1);

                setTxtPregunta04("¿Quién intentó impedir la felicidad de Ariel?");
                setRdbP041("a) El príncipe");
                setRdbP042("b) La bruja del mar"); // Correcta
                setRdbP043("c) Un monstruo marino");
                setPre042(1);

                setTxtPregunta05("¿Cómo terminó la historia de Ariel?");
                setRdbP051("a) Se casó con el príncipe"); // Correcta
                setRdbP052("b) Regresó al mar sola");
                setRdbP053("c) Se convirtió en una bruja");
                setPre051(1);
                break;

            case 3:
                setParrafo("Un príncipe valiente llegó y, con un beso de amor verdadero, despertó a Blancanieves. La maldad fue castigada y el amor triunfó, cambiando el destino del reino para siempre.");
                setAudio(R.raw.blancanieves05);
                setImagen(R.drawable.besod);

                setTxtPregunta01("¿Quién planeó eliminar a Blancanieves?");
                setRdbP011("a) Su madrastra"); // Correcta
                setRdbP012("b) El príncipe");
                setRdbP013("c) Los enanitos");
                setPre011(1);

                setTxtPregunta02("¿Quién encontró Blancanieves en el bosque?");
                setRdbP021("a) Un cazador"); // Correcta
                setRdbP022("b) Un príncipe");
                setRdbP023("c) Un lobo");
                setPre021(1);

                setTxtPregunta03("¿Qué le ofreció la madrastra a Blancanieves?");
                setRdbP031("a) Una flor");
                setRdbP032("b) Una manzana envenenada"); // Correcta
                setRdbP033("c) Un anillo");
                setPre032(1);

                setTxtPregunta04("¿Quién despertó a Blancanieves de su sueño?");
                setRdbP041("a) Un hada");
                setRdbP042("b) Los enanitos");
                setRdbP043("c) Un príncipe valiente"); // Correcta
                setPre043(1);

                setTxtPregunta05("¿Dónde encontró refugio Blancanieves?");
                setRdbP051("a) En una cabaña solitaria"); // Correcta
                setRdbP052("b) En un castillo");
                setRdbP053("c) En una cueva");
                setPre051(1);
                break;

            case 4:
                setParrafo("Luego, el Hada Azul desapareció dejando un rastro luminoso en el cielo. El niño creció recordando esa lección mágica. La bondad se extendió por todo el reino.");
                setAudio(R.raw.elhadaazul05);
                setImagen(R.drawable.rastroluminoso);

                setTxtPregunta01("¿Qué tipo de criatura era el Hada Azul?");
                setRdbP011("a) Un dragón");
                setRdbP012("b) Una criatura mágica"); // Correcta
                setRdbP013("c) Un gigante");
                setPre012(1);

                setTxtPregunta02("¿Qué deseaba el niño?");
                setRdbP021("a) Tener un castillo");
                setRdbP022("b) Que su muñeco se convirtiera en un amigo de verdad"); // Correcta
                setRdbP023("c) Volar");
                setPre022(1);

                setTxtPregunta03("¿Qué transformó el Hada Azul?");
                setRdbP031("a) Un muñeco en un niño"); // Correcta
                setRdbP032("b) Un árbol");
                setRdbP033("c) Una piedra");
                setPre031(1);

                setTxtPregunta04("¿Qué le enseñó el hada al niño?");
                setRdbP041("a) A ser invisible");
                setRdbP042("b) A controlar el clima");
                setRdbP043("c) La importancia de la honestidad y el valor personal"); // Correcta

                setPre043(1);

                setTxtPregunta05("¿Qué dejó el Hada Azul al desaparecer?");
                setRdbP051("a) Un rastro luminoso en el cielo"); // Correcta
                setRdbP052("b) Una varita mágica");
                setRdbP053("c) Un espejo mágico");
                setPre051(1);
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
