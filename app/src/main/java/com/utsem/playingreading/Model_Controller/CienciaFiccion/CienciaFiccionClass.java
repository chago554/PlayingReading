package com.utsem.playingreading.Model_Controller.CienciaFiccion;

import com.utsem.playingreading.R;

public class CienciaFiccionClass {

    private final String [] titulos= {
            "El Gigante de Hierro",
            "La guerra de los mundos",
            "Planeta rojo",
            "Viaje al centro de la Tierra",
            "El niño Estrella"
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
                setParrafo("Hogarth, un niño curioso, descubrió un enorme robot en el bosque. Aunque al principio sintió miedo, pronto vio su nobleza. El gigante parecía inofensivo y se hizo su amigo.");
                setAudio(R.raw.elgigantedehierro01);
                setImagen(R.drawable.robot);
                break;
            case 1:
                setParrafo("De repente, enormes máquinas alienígenas descendieron del cielo. La Tierra se sumió en el caos al ver destruirse ciudades con rayos de calor. La humanidad se encontró indefensa ante la invasión.");
                setAudio(R.raw.laguerradelosmundos01);
                setImagen(R.drawable.ovni);
                break;
            case 2:
                setParrafo("En una misión a Marte, el astronauta Daniel quedó atrapado tras una violenta tormenta. Sus compañeros creyeron que había perecido y regresaron a la Tierra. Solo, en un planeta inhóspito, tuvo que sobrevivir.");
                setAudio(R.raw.planetarojo01);
                setImagen(R.drawable.regreso);
                break;
            case 3:
                setParrafo("El profesor Lidenbrock halló un manuscrito antiguo con indicaciones para llegar al centro de la Tierra. Junto a su sobrino Axel y un guía, se embarcó en una aventura sin precedentes. La emoción llenaba cada paso del descenso.");
                setAudio(R.raw.viajealcentrodelatierra01);
                setImagen(R.drawable.manuscrito);
                break;
            case 4:
                setParrafo("En una noche silenciosa, una estrella cayó del cielo y se transformó en un niño. Fue encontrado por un leñador, quien lo adoptó con amor. El pequeño creció con la creencia de ser especial y único.");
                setAudio(R.raw.elninoestrella01);
                setImagen(R.drawable.estrellafugaz);
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }

    public void avance40(){
        switch (this.cuentoSelecto) {
            case 0:
                setParrafo("El ejército, al enterarse del robot, creyó que era una amenaza. Soldados y tanques llegaron para destruirlo sin escuchar a Hogarth. El miedo cegó a los adultos.");
                setAudio(R.raw.elgigantedehierro02);
                setImagen(R.drawable.tanque);
                setImgAct01(R.drawable.creatividad);

                //actividad 1: Creer
                setBtnLetra01("E");
                setBtnLetra02("C");
                setBtnLetra03("E");
                setBtnLetra04("R");
                setBtnLetra05("R");
                break;
            case 1:
                setParrafo("Los ejércitos lucharon sin lograr detener a los invasores, cuya tecnología parecía invencible. El miedo se extendía y la esperanza parecía desvanecerse. La supervivencia pendía de un hilo.");
                setAudio(R.raw.laguerradelosmundos02);
                setImagen(R.drawable.soldado);
                setImgAct01(R.drawable.mundo);

                //actividad 1: libro //acabar las categorias, cambiar imagenes, actividades, y audios
                setBtnLetra01("M");
                setBtnLetra02("D");
                setBtnLetra03("N");
                setBtnLetra04("U");
                setBtnLetra05("O");
                break;
            case 2:
                setParrafo("Usando su ingenio, Daniel cultivó alimentos y extrajo agua del hielo subterráneo. Con recursos escasos, cada día era una lucha por la vida. La soledad era su única compañera.");
                setAudio(R.raw.planetarojo02);
                setImagen(R.drawable.plantarojo);
                setImgAct01(R.drawable.avion);

                //actividad 1: Viaje
                setBtnLetra01("E");
                setBtnLetra02("V");
                setBtnLetra03("J");
                setBtnLetra04("I");
                setBtnLetra05("A");
                break;
            case 3:
                setParrafo("Atravesaron un volcán en Islandia y descubrieron un mundo subterráneo fascinante. Había mares ocultos, bosques luminescentes y criaturas prehistóricas. El ambiente era tan misterioso como peligroso.");
                setAudio(R.raw.viajealcentrodelatierra02);
                setImagen(R.drawable.volcanerupcion);
                setImgAct01(R.drawable.papel);

                //actividad 1: Papel
                setBtnLetra01("A");
                setBtnLetra02("P");
                setBtnLetra03("L");
                setBtnLetra04("P");
                setBtnLetra05("E");
                break;

            case 4:
                setParrafo("Con el tiempo, el niño se volvió arrogante, despreciando a quienes consideraba inferiores. Se burlaba de los pobres y olvidaba sus orígenes humildes. Su corazón se endurecía con el paso de los años.");
                setAudio(R.raw.elninoestrella02);
                setImagen(R.drawable.arrogante);
                setImgAct01(R.drawable.tiemporapido);

                //actividad 1: Veloz
                setBtnLetra01("E");
                setBtnLetra02("L");
                setBtnLetra03("Z");
                setBtnLetra04("V");
                setBtnLetra05("O");
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }

    }

    public void avance60(){
        switch (this.cuentoSelecto){
            case 0:
                setParrafo("Cuando un misil se dirigió hacia la ciudad, el robot tomó una decisión heroica. Voló hasta el cielo y se estrelló contra el misil para salvar a todos. La explosión resonó en el aire.");
                setAudio(R.raw.elgigantedehierro03);
                setImagen(R.drawable.misill);

                setImg01Act02(R.drawable.ayuda);
                setImg02Act02(R.drawable.abrazo);
                setImg03Act02(R.drawable.apoyosocial);
                setImg04Act02(R.drawable.corazones);

                setPalabra01("Arte");
                setPalabra02("Risas");
                setPalabra03("Apoyo");
                setPalabra04("Ciencia");
                break;
            case 1:
                setParrafo("Sin previo aviso, los alienígenas comenzaron a fallar uno tras otro. No fue una arma humana lo que los venció, sino la simple acción de unas bacterias terrestres. La naturaleza intervino.");
                setAudio(R.raw.laguerradelosmundos03);
                setImagen(R.drawable.bacteria);

                setImg01Act02(R.drawable.mundo1);
                setImg02Act02(R.drawable.paz);
                setImg03Act02(R.drawable.banderapaz);
                setImg04Act02(R.drawable.mundo);

                setPalabra01("Aves");
                setPalabra02("Paz");
                setPalabra03("Mar");
                setPalabra04("Aire");
                break;
            case 2:
                setParrafo("Mientras tanto, la NASA descubrió que aún vivía y organizó una misión de rescate. La espera se alargó por años en condiciones extremas. La esperanza se mezclaba con la incertidumbre.");
                setAudio(R.raw.planetarojo03);
                setImagen(R.drawable.satelite);

                setImg01Act02(R.drawable.gotadeagua);
                setImg02Act02(R.drawable.beberagua);
                setImg03Act02(R.drawable.ahorraragua);
                setImg04Act02(R.drawable.vasodeagua);

                setPalabra01("Valor");
                setPalabra02("Crecer");
                setPalabra03("Agua");
                setPalabra04("Luna");
                break;
            case 3:
                setParrafo("Durante su travesía, fueron atacados por enormes reptiles que custodiaban los secretos del interior. Huyeron y encontraron un río subterráneo que los condujo a otra caverna. El camino era incierto y desafiante.");
                setAudio(R.raw.viajealcentrodelatierra03);
                setImagen(R.drawable.dinosaurio);

                setImg01Act02(R.drawable.iguana);
                setImg02Act02(R.drawable.iguana1);
                setImg03Act02(R.drawable.tilogo);
                setImg04Act02(R.drawable.iguana2);

                setPalabra01("Iguana");
                setPalabra02("Dioses");
                setPalabra03("Lo mejor");
                setPalabra04("Ingenieros");
                break;
            case 4:
                setParrafo("Un día, una mujer mendiga le pidió ayuda, pero él la rechazó sin piedad. Para su sorpresa, descubrió que esa mujer era su verdadera madre. La revelación le hizo sufrir profundamente.");
                setAudio(R.raw.elninoestrella03);
                setImagen(R.drawable.mendiga);

                setImg01Act02(R.drawable.humildad);
                setImg02Act02(R.drawable.amor);
                setImg03Act02(R.drawable.corazones);
                setImg04Act02(R.drawable.ayuda);

                setPalabra01("Pelota");
                setPalabra02("Cocos");
                setPalabra03("Caida");
                setPalabra04("Ayudar");
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }

    public void avance80(){
        switch (this.cuentoSelecto){
            case 0:
                setParrafo("Hogarth quedó desconsolado, pensando que había perdido a su amigo. Pero una noche, encontró una pequeña pieza del robot moviéndose sola. La esperanza se encendió en su corazón.");
                setAudio(R.raw.elgigantedehierro04);
                setImagen(R.drawable.engrane);
                //actividad 3
                setLetra_Act3_01("C");
                setLetra_Act3_02("__");
                setLetra_Act3_03("N");
                setLetra_Act3_04("__");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");
                setBtn01Act03("O");
                setBtn02Act03("I");
                setBtn03Act03("A");
                setBtn04Act03("F");


                break;
            case 1:
                setParrafo("Las máquinas dejaron de funcionar y los extraterrestres murieron. La humanidad, asombrada, encontró en su propia biología la salvación. Un inesperado héroe surgió de lo pequeño.");
                setAudio(R.raw.laguerradelosmundos04);
                setImagen(R.drawable.pensando);

                //actividad 3: Dormir
                setLetra_Act3_01("D");
                setLetra_Act3_02("__");
                setLetra_Act3_03("R");
                setLetra_Act3_04("__");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn01Act03("I");
                setBtn02Act03("R");
                setBtn03Act03("M");
                setBtn04Act03("O");
                break;
            case 2:
                setParrafo("Daniel enfrentó tormentas de arena y fallos en su equipo, pero nunca perdió la determinación. Sus mensajes a la Tierra eran llenos de coraje y resiliencia. La fe en su rescate crecía día a día.");
                setAudio(R.raw.planetarojo04);
                setImagen(R.drawable.astronautaenmarte);

                //actividad 3: Equipo
                setLetra_Act3_01("__");
                setLetra_Act3_02("Q");
                setLetra_Act3_03("__");
                setLetra_Act3_04("I");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn01Act03("P");
                setBtn02Act03("U");
                setBtn03Act03("O");
                setBtn04Act03("E");
                break;
            case 3:
                setParrafo("Una erupción volcánica los impulsó de regreso a la superficie, desembocando en una isla remota. Habían vivido aventuras que parecían de otro mundo. La experiencia los transformó para siempre.");
                setAudio(R.raw.viajealcentrodelatierra04);
                setImagen(R.drawable.volcan);

                //actividad 3: Cuidar
                setLetra_Act3_01("C");
                setLetra_Act3_02("__");
                setLetra_Act3_03("I");
                setLetra_Act3_04("__");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn01Act03("R");
                setBtn02Act03("U");
                setBtn03Act03("A");
                setBtn04Act03("D");

                break;
            case 4:
                setParrafo("Arrepentido, emprendió un viaje en busca de redención. Ayudó a muchos en su camino, aprendiendo el valor de la bondad y la humildad. Poco a poco, su corazón se transformó.");
                setAudio(R.raw.elninoestrella04);
                setImagen(R.drawable.ninoayudando);

                //actividad 3: Ayuda
                setLetra_Act3_01("__");
                setLetra_Act3_02("Y");
                setLetra_Act3_03("__");
                setLetra_Act3_04("D");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn01Act03("A");
                setBtn02Act03("U");
                setBtn03Act03("A");
                setBtn04Act03("R");

                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }

    public void avance100(){
        switch (this.cuentoSelecto){
            case 0:
                setParrafo("Con paciencia, esperó el día en que todas las partes se reunieran. Sabía que el gigante volvería a ser completo y juntos reanudarían su amistad. La fe en lo imposible prevaleció.");
                setAudio(R.raw.elgigantedehierro05);
                setImagen(R.drawable.robott);

                setTxtPregunta01("¿Dónde encontró Hogarth al gigante por primera vez?");
                setRdbP011("a) En el bosque");//corecta
                setRdbP012("b) En la playa");
                setRdbP013("c) En la ciudad");
                setPre011(1);

                setTxtPregunta02("¿Por qué el ejército quería destruir al gigante?");
                setRdbP021("a) Porque pensaban que era una amenaza");//correcta
                setRdbP022("b) Porque era malo");
                setRdbP023("c) Porque era muy ruidoso");
                setPre021(1);


                setTxtPregunta03("¿Qué hizo el gigante para salvar la ciudad?");
                setRdbP031("a) Se escondió");
                setRdbP032("b) Destruyó los tanques");
                setRdbP033("c) Se estrelló contra un misil");//correcta
                setPre033(1);

                setTxtPregunta04("¿Qué encontró Hogarth que le dio esperanza?");
                setRdbP041("a) Una carta del gigante");
                setRdbP042("b) Una pequeña pieza del robot");//correcta
                setRdbP043("c) Un dibujo del gigante");
                setPre042(1);

                setTxtPregunta05("¿Cómo describió Hogarth al gigante?");
                setRdbP051("a) Peligroso");
                setRdbP052("b) Egoísta");
                setRdbP053("c) Noble");//correcta
                setPre053(1);

                break;
            case 1:
                setParrafo("La lección quedó clara: la vida y la naturaleza pueden ser la defensa más poderosa. La Tierra se salvó y la guerra se convirtió en historia para contar.");
                setAudio(R.raw.laguerradelosmundos05);
                setImagen(R.drawable.planta);

                setTxtPregunta01("¿Qué tipo de máquinas llegaron del cielo?");
                setRdbP011("a) Aviones");
                setRdbP012("b) Submarinos");
                setRdbP013("c) Naves espaciales");//corecta
                setPre013(1);

                setTxtPregunta02("¿Qué arma usaron los alienígenas para destruir las ciudades?");
                setRdbP021("a) Rayos de calor");//correcta
                setRdbP022("b) Bombas");
                setRdbP023("c) Misiles");
                setPre021(1);


                setTxtPregunta03("¿Qué venció a los alienígenas?");
                setRdbP031("a) El ejército");
                setRdbP032("b) Bacterias terrestres");;//correcta
                setRdbP033("c) Un virus");
                setPre032(1);

                setTxtPregunta04("¿Qué sintió la humanidad al principio de la invasión?");
                setRdbP041("a) Alegría");
                setRdbP042("b) Curiosidad");
                setRdbP043("c) Miedo");;//correcta
                setPre043(1);

                setTxtPregunta05("¿Qué aprendió la humanidad sobre la naturaleza?");
                setRdbP051("a) Que es la defensa más poderosa");//correcta
                setRdbP052("b) Que es débil");
                setRdbP053("c) Que es peligrosa");
                setPre051(1);

                break;
            case 2:
                setParrafo("Finalmente, en una arriesgada maniobra, una nave lo alcanzó. Con lágrimas y júbilo, fue rescatado y regresó a casa como un héroe de la supervivencia.");
                setAudio(R.raw.planetarojo05);
                setImagen(R.drawable.corazones);

                setTxtPregunta01("¿En qué planeta quedó atrapado el astronauta Daniel?");
                setRdbP011("a) Marte");//corecta
                setRdbP012("b) Venus");
                setRdbP013("c) Júpiter");
                setPre011(1);

                setTxtPregunta02("¿Qué creyeron los compañeros de Daniel que le había pasado?");
                setRdbP021("a) Que se había perdido");
                setRdbP022("b) Que había sido capturado");
                setRdbP023("c) Que había muerto");//correcta
                setPre023(1);


                setTxtPregunta03("¿Qué usó Daniel para sobrevivir en Marte?");
                setRdbP031("a) Su fuerza");
                setRdbP032("b) Su suerte");
                setRdbP033("c) Su ingenio");//correcta
                setPre033(1);

                setTxtPregunta04("¿Quién organizó la misión de rescate de Daniel?");
                setRdbP041("a) Sus amigos");
                setRdbP042("b) La NASA");//correcta
                setRdbP043("c) La marina");
                setPre042(1);

                setTxtPregunta05("¿Qué tipo de tormentas enfrentó Daniel en Marte?");
                setRdbP051("a) Tormentas de nieve");
                setRdbP052("b) Tormentas de lluvia");
                setRdbP053("c) Tormentas de arena");//correcta
                setPre053(1);
                break;
            case 3:
                setParrafo("Regresaron a casa con pruebas y relatos increíbles. Aunque pocos creyeron su historia, ellos sabían que habían descubierto un secreto ancestral. La hazaña se convirtió en leyenda.");
                setAudio(R.raw.viajealcentrodelatierra05);
                setImagen(R.drawable.narracionn);

                setTxtPregunta01("¿Qué encontró el profesor Lidenbrock que lo llevó a la aventura?");
                setRdbP011("a) Un manuscrito antiguo");//corecta
                setRdbP012("b) Un mapa");
                setRdbP013("c) Un tesoro");
                setPre011(1);

                setTxtPregunta02("¿Por dónde entraron al centro de la Tierra?");
                setRdbP021("a) Un río");
                setRdbP022("b) Un volcán");//correcta
                setRdbP023("c) Una cueva");
                setPre022(1);

                setTxtPregunta03("¿Qué tipo de criaturas encontraron en el mundo subterráneo?");
                setRdbP031("a) Dragones");
                setRdbP032("b) Hadas");
                setRdbP033("c) Reptiles gigantes");//correcta
                setPre033(1);

                setTxtPregunta04("¿Cómo regresaron a la superficie?");
                setRdbP041("a) Por un túnel\n");
                setRdbP042("b) Por un río subterráneo");
                setRdbP043("c) Por una erupción volcánica");//correcta
                setPre043(1);

                setTxtPregunta05("¿Qué tipo de mundo descubrieron en el centro de la Tierra?");
                setRdbP051("a) Un mundo subterráneo con mares y bosques");//correcta
                setRdbP052("b) Un mundo de hielo");
                setRdbP053("c) Un mundo de fuego");
                setPre051(1);

                break;
            case 4:
                setParrafo("Al reencontrarse con su madre, su rostro volvió a reflejar belleza y compasión. El Niño Estrella comprendió que la verdadera grandeza reside en el alma. Su cambio inspiró a todo un reino.");
                setAudio(R.raw.elninoestrella05);
                setImagen(R.drawable.ninomama);

                setTxtPregunta01("¿De dónde vino el Niño Estrella?");
                setRdbP011("a) Del mar");
                setRdbP012("b) De un árbol");
                setRdbP013("c) Del cielo");//corecta
                setPre013(1);

                setTxtPregunta02("¿Quién encontró al Niño Estrella?");
                setRdbP021("a) Un leñador");//correcta
                setRdbP022("b) Un gidante");
                setRdbP023("c) Una bruja");
                setPre021(1);


                setTxtPregunta03("¿Cómo se volvió el Niño Estrella con el tiempo?");
                setRdbP031("a) Amable");
                setRdbP032("b) Temeroso");
                setRdbP033("c) Arrogante");//correcta
                setPre033(1);

                setTxtPregunta04("¿A quién rechazó el Niño Estrella sin piedad?");
                setRdbP041("a) A su madre");//correcta
                setRdbP042("b) A su amigo");
                setRdbP043("c) A un animal");
                setPre041(1);

                setTxtPregunta05("¿Qué aprendió el Niño Estrella al final de su viaje?");
                setRdbP051("a) El valor de la bondad y la humildad");//correcta
                setRdbP052("b) El valor de la fama");
                setRdbP053("c) El valor de la riqueza");
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
