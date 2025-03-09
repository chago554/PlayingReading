package com.utsem.playingreading.Model_Controller.Superheroes;

import com.utsem.playingreading.R;

public class SuperheroesClass {


    private final String [] titulos= {
            "El Hombre Araña",
            "Superman",
            "Batman y el Joker",
            "Mujer Maravilla",
            "Flash"
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
                setParrafo("Peter, un joven estudiante, fue picado por una araña radiactiva. Desde ese instante, adquirió poderes extraordinarios. Su vida cambió al descubrir que podía trepar muros y lanzar telarañas.");
                setAudio(R.raw.elhombrearana01);
                setImagen(R.drawable.hombre);
                break;
            case 1:
                setParrafo("Kal-El, enviado desde un planeta lejano, llegó a la Tierra como un bebé. Adoptado por una familia terrícola, creció con poderes asombrosos. La humanidad encontró en él un salvador lleno de nobleza.");
                setAudio(R.raw.superman01);
                setImagen(R.drawable.kalel);
                break;
            case 2:
                setParrafo("Batman era el vigilante enmascarado de Gotham City. Dedicaba sus noches a luchar contra el crimen y a proteger a los inocentes. Con inteligencia y valentía, enfrentaba peligros que otros no se atrevían a encarar.");
                setAudio(R.raw.batman01);
                setImagen(R.drawable.logobatman);
                break;
            case 3:
                setParrafo(" La Mujer Maravilla provenía de la isla oculta de las Amazonas. Allí aprendió el valor de la justicia y la fuerza de la hermandad. Su espíritu noble la impulsó a defender a los débiles en el mundo exterior.");
                setAudio(R.raw.lamujermaravilla01);
                setImagen(R.drawable.mujermaravilla1);
                break;
            case 4:
                setParrafo("Flash era el hombre más rápido del mundo, gracias a la Fuerza de la Velocidad. Su vida cambió tras un accidente en su laboratorio, que le otorgó la habilidad de correr a velocidades imposibles.");
                setAudio(R.raw.flash01);
                setImagen(R.drawable.flash1);
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }

    public void avance40(){
        switch (this.cuentoSelecto) {
            case 0:
                setParrafo("Decidido a combatir el crimen, se entrenó con rigor y determinación. La ciudad necesitaba un héroe, y él asumió la responsabilidad. Con cada rescate, demostraba su gran valor.");
                setAudio(R.raw.elhombrearana02);
                setImagen(R.drawable.crimen);
                setImgAct01(R.drawable.heroe);

                //actividad 1: heroe
                setBtnLetra01("H");
                setBtnLetra02("R");
                setBtnLetra03("E");
                setBtnLetra04("O");
                setBtnLetra05("E");
                break;
            case 1:
                setParrafo("Con fuerza sobrehumana, velocidad y visión de calor, Superman protegía a los inocentes. Su corazón bondadoso y su sentido de la justicia lo hacían único. Se convirtió en un puente entre dos mundos.");
                setAudio(R.raw.superman02);
                setImagen(R.drawable.planeta);
                setImgAct01(R.drawable.calor);

                //actividad 1: Calor
                setBtnLetra01("C");
                setBtnLetra02("R");
                setBtnLetra03("O");
                setBtnLetra04("L");
                setBtnLetra05("A");
                break;
            case 2:
                setParrafo("Su mayor rival era el Joker, un villano impredecible y cruel. Cuando el Joker escapó del Asilo Arkham, la ciudad tembló de miedo. Sus planes retorcidos amenazaban la paz y la cordura de Gotham.");
                setAudio(R.raw.batman02);
                setImagen(R.drawable.jokerdc);
                setImgAct01(R.drawable.nubes);

                //actividad 1: Nubes
                setBtnLetra01("B");
                setBtnLetra02("U");
                setBtnLetra03("N");
                setBtnLetra04("S");
                setBtnLetra05("E");
                break;
            case 3:
                setParrafo("Armada con el Lazo de la Verdad y brazaletes indestructibles, enfrentaba amenazas que ponían en peligro la paz. Su valentía inspiraba a héroes y civiles por igual.");
                setAudio(R.raw.lamujermaravilla02);
                setImagen(R.drawable.lazodelaverdad);
                setImgAct01(R.drawable.juegosdecartas);

                //actividad 1: Juego
                setBtnLetra01("G");
                setBtnLetra02("E");
                setBtnLetra03("U");
                setBtnLetra04("O");
                setBtnLetra05("J");
                break;

            case 4:
                setParrafo("Con sus nuevos poderes, decidió proteger Central City del crimen. Atrapar ladrones en segundos se volvió su rutina diaria. Su optimismo y humor lo convertían en un héroe muy querido.");
                setAudio(R.raw.flash02);
                setImagen(R.drawable.ladron);
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
                setParrafo("Aprendió que con gran poder viene gran responsabilidad. Enfrentó villanos que amenazaban la paz con astucia y coraje. La gente lo admiraba, aunque su identidad permaneciera oculta.");
                setAudio(R.raw.elhombrearana03);
                setImagen(R.drawable.mascara);

                setImg01Act02(R.drawable.responsabilidad);
                setImg02Act02(R.drawable.listadeverificacion);
                setImg03Act02(R.drawable.responsabilidad1);
                setImg04Act02(R.drawable.responsabilidad2);

                setPalabra01("Respirar");
                setPalabra02("Reciclar");
                setPalabra03("Respensabilidad");
                setPalabra04("Querer");
                break;
            case 1:
                setParrafo("El recuerdo de Krypton y la pérdida de su planeta lo impulsaban a luchar por la paz. En cada desafío, demostraba que la fuerza verdadera reside en el alma. Con humildad, enfrentaba cada obstáculo.");
                setAudio(R.raw.superman03);
                setImagen(R.drawable.poderes);

                setImg01Act02(R.drawable.fuerza);
                setImg02Act02(R.drawable.ejercicio);
                setImg03Act02(R.drawable.aptitudfisica);
                setImg04Act02(R.drawable.peso);

                setPalabra01("Fuerza");
                setPalabra02("Pesado");
                setPalabra03("Luz");
                setPalabra04("Calor");
                break;
            case 2:
                setParrafo("Batman usó su ingenio para seguir las pistas del villano. A pesar de la locura del Joker, mantenía la esperanza de detenerlo. Noche tras noche, los enfrentamientos eran cada vez más intensos.");
                setAudio(R.raw.batman03);
                setImagen(R.drawable.batman2);

                setImg01Act02(R.drawable.villano1);
                setImg02Act02(R.drawable.villano);
                setImg03Act02(R.drawable.villano2);
                setImg04Act02(R.drawable.villano3);

                setPalabra01("Mascara");
                setPalabra02("Mal");
                setPalabra03("Noche");
                setPalabra04("Villano");
                break;
            case 3:
                setParrafo("Cuando surgían conflictos globales, ella era la primera en actuar. Creía en la igualdad y la compasión como herramientas para la armonía. Su determinación superaba cualquier obstáculo que se interpusiera.");
                setAudio(R.raw.lamujermaravilla03);
                setImagen(R.drawable.amazonas);

                setImg01Act02(R.drawable.puntualidad);
                setImg02Act02(R.drawable.correr);
                setImg03Act02(R.drawable.tiemporapido);
                setImg04Act02(R.drawable.entregarapida);

                setPalabra01("Camina");
                setPalabra02("Contar");
                setPalabra03("Puntual");
                setPalabra04("Luna");
                break;
            case 4:
                setParrafo("Sin embargo, no todo era sencillo. Villanos con poderes similares y amenazas temporales ponían a prueba sus límites. Cada día, Flash se esforzaba por usar su velocidad con sabiduría.");
                setAudio(R.raw.flash03);
                setImagen(R.drawable.flashg);

                setImg01Act02(R.drawable.carrodeportivo);
                setImg02Act02(R.drawable.coche);
                setImg03Act02(R.drawable.f1);
                setImg04Act02(R.drawable.cochedecarreras);

                setPalabra01("Rojo");
                setPalabra02("Gas");
                setPalabra03("LLanta");
                setPalabra04("Auto");
                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }

    public void avance80(){
        switch (this.cuentoSelecto){
            case 0:
                setParrafo("Con el tiempo, Peter se convirtió en leyenda bajo el alias de El Hombre Araña. Su máscara escondía su verdadera identidad, protegiendo a los que amaba. La justicia guiaba cada uno de sus pasos.");
                setAudio(R.raw.elhombrearana04);
                setImagen(R.drawable.hombrearana1);
                //actividad 3
                setLetra_Act3_01("__");
                setLetra_Act3_02("O");
                setLetra_Act3_03("M");
                setLetra_Act3_04("__");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");
                setBtn01Act03("E");
                setBtn02Act03("H");
                setBtn03Act03("R");
                setBtn04Act03("B");

                break;
            case 1:
                setParrafo("Sus hazañas inspiraron a millones y le ganaron el respeto global. A pesar de sus poderes, se mostraba sensible y generoso. El emblema de la \"S\" en su pecho simbolizaba esperanza y verdad.");
                setAudio(R.raw.superman04);
                setImagen(R.drawable.sman);

                //actividad 3: Global
                setLetra_Act3_01("__");
                setLetra_Act3_02("L");
                setLetra_Act3_03("__");
                setLetra_Act3_04("__");
                setLetra_Act3_05("A");
                setLetra_Act3_06("__");

                setBtn01Act03("B");
                setBtn02Act03("L");
                setBtn03Act03("G");
                setBtn04Act03("O");
                break;
            case 2:
                setParrafo("En un gran choque, el Joker colocó bombas por toda la ciudad. Batman, con ayuda del comisionado Gordon, logró desactivar varias. El caos se apoderó de las calles, pero el héroe no se rindió.");
                setAudio(R.raw.batman04);
                setImagen(R.drawable.bombas);

                //actividad 3: bombas
                setLetra_Act3_01("__");
                setLetra_Act3_02("O");
                setLetra_Act3_03("__");
                setLetra_Act3_04("B");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn01Act03("A");
                setBtn02Act03("M");
                setBtn03Act03("S");
                setBtn04Act03("B");
                break;
            case 3:
                setParrafo("Luchó contra dioses y villanos con la misma firmeza. Cada batalla reforzaba su compromiso con la verdad y la justicia. Su corazón compasivo la convertía en una líder innata.");
                setAudio(R.raw.lamujermaravilla04);
                setImagen(R.drawable.villana);

                //actividad 3: Tiempo
                setLetra_Act3_01("T");
                setLetra_Act3_02("__");
                setLetra_Act3_03("E");
                setLetra_Act3_04("__");
                setLetra_Act3_05("__");
                setLetra_Act3_06("__");

                setBtn01Act03("P");
                setBtn02Act03("I");
                setBtn03Act03("O");
                setBtn04Act03("M");

                break;
            case 4:
                setParrafo("Ayudado por sus amigos y su inteligencia, superaba retos difíciles. Resolver problemas requería más que correr rápido: se necesitaba ingenio y determinación.");
                setAudio(R.raw.flash04);
                setImagen(R.drawable.inteligencia);

                //actividad 3: Correr
                setLetra_Act3_01("__");
                setLetra_Act3_02("__");
                setLetra_Act3_03("R");
                setLetra_Act3_04("__");
                setLetra_Act3_05("E");
                setLetra_Act3_06("__");

                setBtn01Act03("R");
                setBtn02Act03("C");
                setBtn03Act03("R");
                setBtn04Act03("O");

                break;
            default: setParrafo("Creo que este cuento se acabo...");
        }
    }

    public void avance100(){
        switch (this.cuentoSelecto){
            case 0:
                setParrafo("Siempre arriesgando su vida por el bien común, se ganó el cariño y respeto de la ciudad. El símbolo de su valentía perduró en la memoria de todos. Su historia inspiró a generaciones futuras.");
                setAudio(R.raw.elhombrearana05);
                setImagen(R.drawable.hombrearana2);

                setTxtPregunta01("¿Qué animal picó a Peter?");
                setRdbP011("a) Una hormiga");
                setRdbP012("b) Una araña");//corecta
                setRdbP013("c) Un escorpión");
                setPre012(1);

                setTxtPregunta02("¿Qué poderes adquirió Peter?");
                setRdbP021("a) Volar y lanzar rayos\n");
                setRdbP022("b) Leer la mente");
                setRdbP023("c) Trepar muros y lanzar telarañas");//correcta
                setPre023(1);

                setTxtPregunta03("¿Cuál es el alias de Pedro cuando combate el crimen?");
                setRdbP031("a) El Hombre Araña");//correcta
                setRdbP032("b) El Hombre Murciélago");
                setRdbP033("c) El Hombre de Hierro");
                setPre031(1);

                setTxtPregunta04("¿Qué protege la máscara de Peter?");
                setRdbP041("a) Su casa");
                setRdbP042("b) Su identidad");//correcta
                setRdbP043("c) Su dinero");
                setPre042(1);

                setTxtPregunta05("¿Qué valor guía los pasos del Hombre Araña?");
                setRdbP051("a) La riqueza");
                setRdbP052("b) La justicia");//correcta
                setRdbP053("c) La fama");
                setPre052(1);

                break;
            case 1:
                setParrafo("Superman volaba por los cielos, velando por la humanidad. Su leyenda perdura como el héroe por excelencia, un símbolo eterno de justicia y compasión.");
                setAudio(R.raw.superman05);
                setImagen(R.drawable.superman1);

                setTxtPregunta01("¿De qué planeta vino Superman?");
                setRdbP011("b) Krypton"); // Correcta
                setRdbP012("c) Marte");
                setRdbP013("a) La Tierra");
                setPre011(1);

                setTxtPregunta02("¿Qué tipo de poderes tiene Superman?");
                setRdbP021("b) Invisibilidad y telepatía");
                setRdbP022("c) Cambiar de forma y controlar el clima");
                setRdbP023("a) Fuerza sobrehumana, velocidad y visión de calor");// Correcta
                setPre023(1);

                setTxtPregunta03("¿Qué simboliza la 'S' en el pecho de Superman?");
                setRdbP031("b) Poder");
                setRdbP032("c) Esperanza y verdad");// Correcta
                setRdbP033("a) Riqueza");
                setPre032(1);

                setTxtPregunta04("¿Cómo fue criado Superman en la Tierra?");
                setRdbP041("b) Por una familia terrícola");
                setRdbP042("c) Por un científico"); // Correcta
                setRdbP043("a) Por una familia real");
                setPre042(1);

                setTxtPregunta05("¿Qué valor principal guía las acciones de Superman?");
                setRdbP051("b) La ambicion");
                setRdbP052("c) La fama");
                setRdbP053("a) La justicia");// Correcta
                setPre053(1);
                break;
            case 2:
                setParrafo("Finalmente, Batman capturó al Joker y lo devolvió al asilo. La ciudad recuperó un poco de calma, aunque la amenaza nunca se fue del todo. Gotham siguió contando con su protector, el Caballero de la Noche.");
                setAudio(R.raw.batman05);
                setImagen(R.drawable.logoviejobatman);

                setTxtPregunta01("¿Qué ciudad protege Batman?");
                setRdbP011("a) Metrópolis");
                setRdbP012("b) Ciudad Gótica"); // Correcta
                setRdbP013("c) Central City");
                setPre012(1);

                setTxtPregunta02("¿Quién es el mayor rival de Batman?");
                setRdbP021("a) El Joker ");// Correcta
                setRdbP022("b) El Pingüino");
                setRdbP023("c) Dos Caras");
                setPre021(1);

                setTxtPregunta03("¿De dónde escapó el Joker?");
                setRdbP031("a) De la prisión de Blackgate");
                setRdbP032("b) Del Asilo Arkham"); // Correcta
                setRdbP033("c) De la guarida secreta");
                setPre032(1);

                setTxtPregunta04("¿Quién ayudó a Batman a desactivar las bombas?");
                setRdbP041("a) Alfred");
                setRdbP042("b) Robin");
                setRdbP043("c) El comisionado Gordon");// Correcta
                setPre043(1);

                setTxtPregunta05("¿Cómo es conocido Batman en Ciudad Gótica?");
                setRdbP051("a) El Hombre Murciélago");
                setRdbP052("b) El Vigilante de la Oscuridad");
                setRdbP053("c) El Caballero de la Noche "); // Correcta
                setPre053(1);
                break;

            case 3:
                setParrafo("La Mujer Maravilla representaba la esperanza de un futuro mejor. Donde reinaban la guerra y la injusticia, ella llevaba la paz. Su legado de amor y coraje perduraba en la memoria de todos.");
                setAudio(R.raw.lamujermaravilla05);
                setImagen(R.drawable.mujermaravillalogo);

                setTxtPregunta01("¿De dónde proviene la Mujer Maravilla?");
                setRdbP011("a) De Metrópolis");
                setRdbP012("b) De Ciudad Gótica");
                setRdbP013("c) De la isla oculta de las Amazonas ");// Correcta
                setPre013(1);

                setTxtPregunta02("¿Qué tipo de arma usa la Mujer Maravilla para hacer que la gente diga la verdad?");
                setRdbP021("a) Un escudo");
                setRdbP022("b) Un lazo"); // Correcta
                setRdbP023("c) Una espada");
                setPre022(1);

                setTxtPregunta03("¿Qué valor principal promueve la Mujer Maravilla?");
                setRdbP031("a) La igualdad y la compasión ");// Correcta
                setRdbP032("b) La riqueza");
                setRdbP033("c) El poder");
                setPre031(1);

                setTxtPregunta04("¿Qué tipo de amenaza enfrenta la Mujer Maravilla?");
                setRdbP041("a) Amenazas que ponen en peligro la paz "); // Correcta
                setRdbP042("b) Solo a los villanos humanos");
                setRdbP043("c) Solo desastres naturales");
                setPre041(1);

                setTxtPregunta05("¿Qué representan los brazaletes de la Mujer Maravilla?");
                setRdbP051("a) Riqueza");
                setRdbP052("b) Belleza");
                setRdbP053("c) Indestructibilidad ");// Correcta
                setPre053(1);
                break;

            case 4:
                setParrafo("Al final, Flash recordaba la importancia de la familia y la amistad. Con su velocidad, llevaba esperanza a su ciudad. Su legado como héroe veloz perduraba en el corazón de la gente.");
                setAudio(R.raw.flash05);
                setImagen(R.drawable.logoflah);

                setTxtPregunta01("¿Qué le dio a Flash sus poderes?");
                setRdbP011("a) Un anillo mágico");
                setRdbP012("b) Un accidente de laboratorio"); // Correcta
                setRdbP013("c) Un traje espacial");
                setPre012(1);

                setTxtPregunta02("¿Qué ciudad protege Flash?");
                setRdbP021("a) Ciudad Gótica");
                setRdbP022("b) Metrópolis");
                setRdbP023("c) Ciudad Central"); // Correcta
                setPre023(1);

                setTxtPregunta03("¿Qué tipo de villanos enfrenta Flash?");
                setRdbP031("a) Solo ladrones comunes");
                setRdbP032("b) Villanos con poderes similares y amenazas temporales"); // Correcta
                setRdbP033("c) Solo desastres naturales");
                setPre032(1);

                setTxtPregunta04("¿Qué valor principal destaca en la historia de Flash?");
                setRdbP041("a)La familia y la amistad "); // Correcta
                setRdbP042("b) La velocidad");
                setRdbP043("c) La riqueza");
                setPre041(1);

                setTxtPregunta05("¿De dónde obtiene Flash su velocidad?");
                setRdbP051("a) De un cinturón especial");
                setRdbP052("b) De la Fuerza de la Velocidad"); // Correcta
                setRdbP053("c) De un hechizo mágico");
                setPre052(1);
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
