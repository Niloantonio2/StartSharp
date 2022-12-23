package co.com.choucair.cetification.startsharp.questions;

import co.com.choucair.cetification.startsharp.userinterfaces.UnidadNegocioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarUnidadPadre implements Question<String> {


    public static ValidarUnidadPadre creada() {
        return new ValidarUnidadPadre();
    }


    @Override
    public String answeredBy(Actor actor) {
        return Text.of(UnidadNegocioPage.LABEL_UNIDAD_PADRE).viewedBy(actor).asString();
    }
}
