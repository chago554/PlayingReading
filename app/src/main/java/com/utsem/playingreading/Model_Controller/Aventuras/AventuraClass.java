package com.utsem.playingreading.Model_Controller.Aventuras;

import android.media.MediaPlayer;
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

    public void avance20(){
        setTituloCuentoSelecto(titulos[this.cuentoSelecto]);

        switch (this.cuentoSelecto){
            case 0:
                setParrafo("Había tres cerditos que decidieron construir sus casas. El primero, perezoso, usó paja; el segundo, un poco más trabajador, usó madera; y el tercero, precavido, usó ladrillos. Cada uno confiaba en su elección.");
                setAudio(R.raw.lostrescerditos01);
                setImagen(R.drawable.casa);
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
}
