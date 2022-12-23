package co.com.choucair.cetification.startsharp.tasks;

import co.com.choucair.cetification.startsharp.models.CrearReunionModel;
import co.com.choucair.cetification.startsharp.userinterfaces.ReunionPage;
import co.com.choucair.cetification.startsharp.userinterfaces.UnidadNegocioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

import java.util.List;


public class BucarReunion implements Task {
    private List<CrearReunionModel> crearReunionModels;

    public BucarReunion(List<CrearReunionModel> crearReunionModels) {
        this.crearReunionModels = crearReunionModels;
    }

    public static BucarReunion creada(List<CrearReunionModel> crearReunionModels) {
        return Tasks.instrumented(BucarReunion.class, crearReunionModels);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ReunionPage.INPUT_BUSCAR),
                Enter.theValue(crearReunionModels.get(0).getStrNombreReunion()).into(ReunionPage.INPUT_BUSCAR),
                Hit.the(Keys.ENTER).into(UnidadNegocioPage.INPUT_BUSCAR)

        );
    }
}
