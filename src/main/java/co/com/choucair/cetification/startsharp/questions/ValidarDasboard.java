package co.com.choucair.cetification.startsharp.questions;

import co.com.choucair.cetification.startsharp.userinterfaces.InicioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarDasboard implements Question<String> {


    public static ValidarDasboard pagina() {
        return new ValidarDasboard();
    }




    @Override
    public String answeredBy(Actor actor) {
        return Text.of(InicioPage.LBL_DASHBOARD).viewedBy(actor).asString();
    }
}