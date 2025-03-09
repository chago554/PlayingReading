package com.utsem.playingreading.Model_Controller.MisterioyDetectives;

import com.utsem.playingreading.R;


public class MisteriosyDetectivesClass {

    private final String [] titulos= {
            "Lia Sombra",
            "Tom Flash",
            "Nico Pista",
            "Vera Clave",
            "Sam Ojo"
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
                setParrafo("Lía Sombra era una joven detective con una mente aguda. En su vecindario, resolvía misterios con precisión y dedicación. Su reputación crecía con cada caso resuelto.");
                setAudio(R.raw.liasombra01);
                setImagen(R.drawable.detective);
                break;
            case 1:
                setParrafo("Tom Flash era un reportero intrépido, siempre en busca de la verdad. Su rapidez y agudeza lo llevaban a descubrir historias ocultas. No temía adentrarse en lugares peligrosos para informar.");
                setAudio(R.raw.tomflash01);
                setImagen(R.drawable.reportero);
                break;
            case 2:
                setParrafo("Nico Pista era un joven dotado para resolver acertijos. Su curiosidad lo impulsaba a descubrir misterios en la escuela y el barrio. Nadie podía igualar su habilidad para hallar pistas.");
                setAudio(R.raw.nicopista01);
                setImagen(R.drawable.chico1);
                break;
            case 3:
                setParrafo("Vera Clave poseía una habilidad innata para descifrar códigos. Desde pequeña, se fascinaba con mensajes secretos y acertijos complejos. Siempre estaba dispuesta a ayudar a quienes se perdían en enigmas.");
                setAudio(R.raw.veraclave01);
                setImagen(R.drawable.codigos);
                break;
            case 4:
                setParrafo("Sam Ojo tenía una vista muy aguda y observaba detalles ignorados por otros. Siempre notaba lo que parecía insignificante en su vecindario. Su atención era su mayor fortaleza como observador.");
                setAudio(R.raw.samojo01);
                setImagen(R.drawable.detallesojo);
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }

    public void avance40(){
        switch (this.cuentoSelecto) {
            case 0:
                setParrafo("Un día, un valioso cuadro desapareció del museo local. Lía inspeccionó cada rincón en busca de pistas. Su atención a los detalles reveló huellas ignoradas por otros.");
                setAudio(R.raw.liasombra02);
                setImagen(R.drawable.pintura);

                setImgAct01(R.drawable.museo);
                //actividad 1: Museo
                setBtnLetra01("E");
                setBtnLetra02("S");
                setBtnLetra03("M");
                setBtnLetra04("O");
                setBtnLetra05("U");
                break;
            case 1:
                setParrafo("En una noche oscura, observó luces extrañas en una fábrica abandonada. Con su cámara en mano, se aventuró a investigar el misterio. Su instinto le mostró detalles que otros pasaban por alto.");
                setAudio(R.raw.tomflash02);
                setImagen(R.drawable.camara);

                setImgAct01(R.drawable.papel);
                //actividad 1: notas
                setBtnLetra01("T");
                setBtnLetra02("O");
                setBtnLetra03("N");
                setBtnLetra04("S");
                setBtnLetra05("A");
                break;
            case 2:
                setParrafo("En el examen final, notó que alguien alteró las respuestas. Analizó cada hoja y detectó marcas inusuales en una de ellas. Su intuición lo llevó a sospechar de un fraude.");
                setAudio(R.raw.nicopista02);
                setImagen(R.drawable.examen);

                setImgAct01(R.drawable.paso);
                //actividad 1: Pista
                setBtnLetra01("I");
                setBtnLetra02("S");
                setBtnLetra03("P");
                setBtnLetra04("T");
                setBtnLetra05("A");
                break;
            case 3:
                setParrafo("Un día, una carta misteriosa llegó a su escuela, llena de símbolos y números. Nadie podía entenderla, pero Vera sintió la urgencia de descifrarla. Su determinación la impulsó a comenzar la investigación.");
                setAudio(R.raw.veraclave02);
                setImagen(R.drawable.carta);

                setImgAct01(R.drawable.juegosdecartas);
                //actividad 1: carta
                setBtnLetra01("R");
                setBtnLetra02("T");
                setBtnLetra03("A");
                setBtnLetra04("C");
                setBtnLetra05("A");
                break;

            case 4:
                setParrafo("Un día, vio a un hombre dejar un paquete sospechoso en el parque. Sin dudarlo, siguió la pista con cautela y precisión. Sabía que detrás de ese acto se escondía un misterio.");
                setAudio(R.raw.samojo02);
                setImagen(R.drawable.paquetesospechoso);

                setImgAct01(R.drawable.perro);
                //actividad 1: perro
                setBtnLetra01("R");
                setBtnLetra02("E");
                setBtnLetra03("P");
                setBtnLetra04("R");
                setBtnLetra05("O");
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }

    }

    public void avance60(){
        switch (this.cuentoSelecto){
            case 0:
                setParrafo("Interrogó a varios empleados y descubrió comportamientos sospechosos. Una pista la condujo a un empleado deshonesto del museo. La verdad se iba forjando con cada indagación.");
                setAudio(R.raw.liasombra03);
                setImagen(R.drawable.empleado);

                setImg01Act02(R.drawable.lienzo);
                setImg02Act02(R.drawable.creatividad1);
                setImg03Act02(R.drawable.mascarasdeteatro);
                setImg04Act02(R.drawable.pasatiempo);

                setPalabra01("Arte");
                setPalabra02("Rosa");
                setPalabra03("Colombia");
                setPalabra04("Viajar");
                break;
            case 1:
                setParrafo("Descubrió que la fábrica era escenario de intercambios ilegales. Tom documentó cada movimiento y anotó todo con precisión. Su reportaje prometía desenmascarar una red de corrupción.");
                setAudio(R.raw.tomflash03);
                setImagen(R.drawable.ilegal);

                setImg01Act02(R.drawable.smarttv);
                setImg02Act02(R.drawable.satelite);
                setImg03Act02(R.drawable.celular);
                setImg04Act02(R.drawable.portatil);

                setPalabra01("Futuro");
                setPalabra02("Tecnología");
                setPalabra03("Alto");
                setPalabra04("Volar");
                break;
            case 2:
                setParrafo("Siguió la pista hasta descubrir que un estudiante tramaba hacer trampa. Reunió pruebas irrefutables de su engaño. Con determinación, informó a los maestros de lo ocurrido.");
                setAudio(R.raw.nicopista03);
                setImagen(R.drawable.estudiantetrampa);

                setImg01Act02(R.drawable.lupa);
                setImg02Act02(R.drawable.evaluacion);
                setImg03Act02(R.drawable.buscar);
                setImg04Act02(R.drawable.evaluar);

                setPalabra01("Saludo");
                setPalabra02("Encender");
                setPalabra03("Buscar");
                setPalabra04("Caer");
                break;
            case 3:
                setParrafo("Con paciencia, fue interpretando cada símbolo y descubrió pistas sobre un tesoro escondido. Convenció a algunos compañeros para buscar en la biblioteca antigua. La aventura se volvió un proyecto compartido.");
                setAudio(R.raw.veraclave03);
                setImagen(R.drawable.tesoro);

                setImg01Act02(R.drawable.tiranosauriorex);
                setImg02Act02(R.drawable.dinosaurio);
                setImg03Act02(R.drawable.iguana2);
                setImg04Act02(R.drawable.iguana1);

                setPalabra01("Reptiles");
                setPalabra02("Piedras");
                setPalabra03("Verdes");
                setPalabra04("Casas");
                break;
            case 4:
                setParrafo("Se acercó al paquete y observó que temblaba ligeramente, indicando movimiento. Con intuición, se dio cuenta de que algo importante estaba ocurriendo. Decidió actuar sin demora.");
                setAudio(R.raw.samojo03);
                setImagen(R.drawable.paquetetemblor);

                setImg01Act02(R.drawable.gato);
                setImg02Act02(R.drawable.perro1);
                setImg03Act02(R.drawable.cuidadodemascotas);
                setImg04Act02(R.drawable.perro);

                setPalabra01("Pelota");
                setPalabra02("Pelusa");
                setPalabra03("Ganso");
                setPalabra04("Mascotas");
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }

    public void avance80(){
        switch (this.cuentoSelecto){
            case 0:
                setParrafo("El empleado confesó haber robado el cuadro para venderlo en el mercado negro. Lía recuperó la obra y la entregó a las autoridades. La justicia prevaleció gracias a su perspicacia.");
                setAudio(R.raw.liasombra04);
                setImagen(R.drawable.empleadoratero);

                //actividad 3 cuadro
                setLetra_Act3_01("C");
                setLetra_Act3_02("__");
                setLetra_Act3_03("A");
                setLetra_Act3_04("__");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");
                setBtn01Act03("D");
                setBtn02Act03("U");
                setBtn03Act03("R");
                setBtn04Act03("O");


                break;
            case 1:
                setParrafo("Publicó su historia en el periódico local, generando conmoción en la comunidad. La policía actuó de inmediato y detuvo a los involucrados. Su valentía renovó la fe en la justicia.");
                setAudio(R.raw.tomflash04);
                setImagen(R.drawable.fabrica);

                //actividad 3: verdad
                setLetra_Act3_01("V");
                setLetra_Act3_02("__");
                setLetra_Act3_03("R");
                setLetra_Act3_04("__");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn01Act03("D");
                setBtn02Act03("E");
                setBtn03Act03("D");
                setBtn04Act03("A");
                break;
            case 2:
                setParrafo("La verdad se impuso y el estudiante fue sancionado. La justicia restaurada llenó de orgullo a Nico y a sus compañeros. Su ingenio se convirtió en leyenda en la escuela.");
                setAudio(R.raw.nicopista04);
                setImagen(R.drawable.detectivenico);

                //actividad 3: mundos
                setLetra_Act3_01("M");
                setLetra_Act3_02("U");
                setLetra_Act3_03("__");
                setLetra_Act3_04("__");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn01Act03("N");
                setBtn02Act03("D");
                setBtn03Act03("S");
                setBtn04Act03("O");
                break;
            case 3:
                setParrafo("Entre libros polvorientos, hallaron un diario que confirmaba la existencia del tesoro. La búsqueda unió a todos y despertó el interés por la historia de la escuela. La emoción era palpable.");
                setAudio(R.raw.veraclave04);
                setImagen(R.drawable.diario);

                //actividad 3: tesoro
                setLetra_Act3_01("T");
                setLetra_Act3_02("__");
                setLetra_Act3_03("S");
                setLetra_Act3_04("__");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn01Act03("O");
                setBtn02Act03("O");
                setBtn03Act03("R");
                setBtn04Act03("E");

                break;
            case 4:
                setParrafo("Llamó a la policía y explicó lo sucedido con detalle. La investigación reveló que el paquete contenía a un perrito abandonado. Su acción salvó una vida inocente.");
                setAudio(R.raw.samojo04);
                setImagen(R.drawable.policia);

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
                setParrafo("La comunidad aclamó su dedicación y astucia. Su ejemplo inspiró a otros a buscar la verdad sin rendirse. Lía Sombra se convirtió en símbolo de integridad y justicia.");
                setAudio(R.raw.liasombra05);
                setImagen(R.drawable.detectivefinal);

                setTxtPregunta01("¿Qué tipo de trabajo realizaba Lía Sombra?");
                setRdbP011("a) Era una doctora");
                setRdbP012("b) Era una detective"); // Correcta
                setRdbP013("c) Era una maestra");
                setPre012(1);

                setTxtPregunta02("¿Qué objeto valioso desapareció del museo?");
                setRdbP021("a) Un cuadro"); // Correcta
                setRdbP022("b) Una escultura");
                setRdbP023("c) Una joya");
                setPre021(1);

                setTxtPregunta03("¿A quién condujo una pista a Lía?");
                setRdbP031("a) A un turista");
                setRdbP032("b) A un policía");
                setRdbP033("c) A un empleado deshonesto del museo"); // Correcta
                setPre033(1);

                setTxtPregunta04("¿Qué hizo el empleado con el cuadro?");
                setRdbP041("a) Lo escondió en su casa");
                setRdbP042("b) Lo robó para venderlo en el mercado negro"); // Correcta
                setRdbP043("c) Lo donó a otro museo");
                setPre042(1);

                setTxtPregunta05("¿Qué se convirtió Lía Sombra en la comunidad?");
                setRdbP051("a) En un símbolo de integridad y justicia"); // Correcta
                setRdbP052("b) En una alcaldesa");
                setRdbP053("c) En una artista famosa");
                setPre051(1);
                break;

            case 1:
                setParrafo("Tom Flash se consolidó como un faro de integridad periodística. Sus investigaciones inspiraron a la comunidad a luchar contra la injusticia. Su legado se convirtió en ejemplo de verdad y coraje.");
                setAudio(R.raw.tomflash05);
                setImagen(R.drawable.periodico);

                setTxtPregunta01("¿Qué tipo de trabajo realizaba Tom Flash?");
                setRdbP011("a) Era un reportero"); // Correcta
                setRdbP012("b) Era un policía");
                setRdbP013("c) Era un bombero");
                setPre011(1);

                setTxtPregunta02("¿Qué observó Tom Flash en la fábrica abandonada?");
                setRdbP021("a) Un incendio");
                setRdbP022("b) Luces extrañas"); // Correcta
                setRdbP023("c) Una fiesta");
                setPre022(1);

                setTxtPregunta03("¿Qué descubrió Tom Flash en la fábrica?");
                setRdbP031("a) Un tesoro escondido");
                setRdbP032("b) Un laboratorio secreto");
                setRdbP033("c) Intercambios ilegales"); // Correcta
                setPre033(1);

                setTxtPregunta04("¿Qué hizo Tom Flash con su descubrimiento?");
                setRdbP041("a) Lo guardó en secreto");
                setRdbP042("b) Lo vendió a un desconocido");
                setRdbP043("c) Publicó su historia en el periódico"); // Correcta
                setPre043(1);

                setTxtPregunta05("¿Qué se consolidó Tom Flash en la comunidad?");
                setRdbP051("a) En un alcalde");
                setRdbP052("b) En un faro de integridad periodística"); // Correcta
                setRdbP053("c) En un empresario exitoso");
                setPre052(1);
                break;

            case 2:
                setParrafo("Así, Nico Pista se destacó como el detective del colegio. Su capacidad de análisis y observación marcó la diferencia. Inspiró a otros a buscar siempre la verdad.");
                setAudio(R.raw.nicopista05);
                setImagen(R.drawable.genio);

                setTxtPregunta01("¿Qué habilidad especial tenía Nico Pista?");
                setRdbP011("a) Correr rápido");
                setRdbP012("b) Dibujar");
                setRdbP013("c) Resolver acertijos"); // Correcta
                setPre013(1);

                setTxtPregunta02("¿Qué descubrió Nico en el examen final?");
                setRdbP021("a) Un libro perdido");
                setRdbP022("b) Que alguien alteró las respuestas"); // Correcta
                setRdbP023("c) Un mensaje secreto");
                setPre022(1);

                setTxtPregunta03("¿Qué hizo Nico con la información del fraude?");
                setRdbP031("a) Informó a los maestros"); // Correcta
                setRdbP032("b) Lo guardó para sí mismo");
                setRdbP033("c) Lo publicó en un blog");
                setPre031(1);

                setTxtPregunta04("¿Qué le pasó al estudiante que hizo trampa?");
                setRdbP041("a) Ganó un premio");
                setRdbP042("b) Fue sancionado"); // Correcta
                setRdbP043("c) Se hizo famoso");
                setPre042(1);

                setTxtPregunta05("¿Cómo se destacó Nico Pista en la escuela?");
                setRdbP051("a) Como el mejor deportista");
                setRdbP052("b) Como el mejor músico");
                setRdbP053("c) Como el detective del colegio"); // Correcta
                setPre053(1);
                break;


            case 3:
                setParrafo("El tesoro resultó ser un cofre con recuerdos y cartas antiguas. Vera ayudó a restaurar la memoria del lugar y su hazaña quedó en la historia. Su talento y perseverancia dejaron huella en todos.");
                setAudio(R.raw.veraclave05);
                setImagen(R.drawable.pista);

                setTxtPregunta01("¿Qué habilidad innata poseía Vera Clave?");
                setRdbP011("a) Pintar cuadros");
                setRdbP013("c) Cantar ópera");
                setPre012(1);

                setTxtPregunta02("¿Qué llegó a la escuela que nadie podía entender?");
                setRdbP021("a) Una carta misteriosa"); // Correcta
                setRdbP022("b) Un mapa antiguo");
                setRdbP023("c) Un mensaje en clave morse");
                setPre021(1);

                setTxtPregunta03("¿Qué encontraron Vera y sus compañeros en la biblioteca?");
                setRdbP031("a) Un libro de hechizos");
                setRdbP032("b) Un espejo mágico");
                setRdbP033("c) Un diario que confirmaba la existencia del tesoro"); // Correcta
                setPre033(1);

                setTxtPregunta04("¿Qué resultó ser el tesoro escondido?");
                setRdbP041("a) Un cofre de oro");
                setRdbP042("b) Un cofre con recuerdos y cartas antiguas"); // Correcta
                setRdbP043("c) Una corona de diamantes");
                setPre042(1);

                setTxtPregunta05("¿Qué dejó la hazaña de Vera en la escuela?");
                setRdbP051("a) Una huella en la historia"); // Correcta
                setRdbP052("b) Un mural gigante");
                setRdbP053("c) Una estatua de bronce");
                setPre051(1);
                break;

            case 4:
                setParrafo("Sam Ojo fue aclamado por su atención y valentía. Su capacidad para notar lo pequeño marcó la diferencia en el caso. La comunidad lo reconoció como un verdadero héroe.");
                setAudio(R.raw.samojo05);
                setImagen(R.drawable.heroe);

                setTxtPregunta01("¿Qué habilidad especial tenía Sam Ojo?");
                setRdbP011("a) Correr muy rápido");
                setRdbP012("b) Escuchar muy bien");
                setRdbP013("c) Una vista muy aguda"); // Correcta
                setPre013(1);

                setTxtPregunta02("¿Qué vio Sam Ojo en el parque?");
                setRdbP021("a) Un robo");
                setRdbP022("b) Un hombre dejando un paquete sospechoso"); // Correcta
                setRdbP023("c) Un accidente");
                setPre022(1);

                setTxtPregunta03("¿Qué contenía el paquete sospechoso?");
                setRdbP031("a) Un perrito abandonado"); // Correcta
                setRdbP031("b) Dinero robado");
                setRdbP023("c) Explosivos");
                setPre031(1);

                setTxtPregunta04("¿Qué hizo Sam Ojo con el paquete sospechoso?");
                setRdbP041("a) Lo abrió él mismo");
                setRdbP042("b) Llamó a la policía"); // Correcta
                setRdbP043("c) Lo escondió");
                setPre042(1);

                setTxtPregunta05("¿Cómo fue reconocido Sam Ojo por la comunidad?");
                setRdbP051("a) Como un atleta famoso");
                setRdbP052("b) Como un empresario exitoso");
                setRdbP053("c) Como un verdadero héroe"); // Correcta
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
