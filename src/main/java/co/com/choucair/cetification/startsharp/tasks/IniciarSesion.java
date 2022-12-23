package co.com.choucair.cetification.startsharp.tasks;

import co.com.choucair.cetification.startsharp.models.CredencialesModel;
import co.com.choucair.cetification.startsharp.userinterfaces.InicioSesionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

public class IniciarSesion implements Task {

    private List<CredencialesModel> credencialesModels;

    public IniciarSesion(List<CredencialesModel> credencialesModels) {
        this.credencialesModels = credencialesModels;
    }


    public static IniciarSesion conLosDatos(List<CredencialesModel> credencialesModels) {
        return Tasks.instrumented(IniciarSesion.class,credencialesModels);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(InicioSesionPage.TXT_NOMBRE_USUARIO),
                Clear.field(InicioSesionPage.TXT_CLAVE),
                Enter.theValue(credencialesModels.get(0).getStrUsuario()).into(InicioSesionPage.TXT_NOMBRE_USUARIO),
                Enter.theValue(credencialesModels.get(0).getStrClave()).into(InicioSesionPage.TXT_CLAVE),
                Click.on(InicioSesionPage.BTN_INICIAR_SESION)

        );
    }
}
