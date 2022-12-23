package co.com.choucair.cetification.startsharp.tasks;

import co.com.choucair.cetification.startsharp.models.CrearUnidadModel;
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

public class BucarUnidad implements Task {
    private List<CrearUnidadModel> crearUnidadModels;

    public BucarUnidad(List<CrearUnidadModel> crearUnidadModels) {
        this.crearUnidadModels = crearUnidadModels;
    }

    public static BucarUnidad deNegocio(List<CrearUnidadModel> crearUnidadModels) {
        return Tasks.instrumented(BucarUnidad.class, crearUnidadModels);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(UnidadNegocioPage.INPUT_BUSCAR),
                Enter.theValue(crearUnidadModels.get(0).getStrNombreUnidad()).into(UnidadNegocioPage.INPUT_BUSCAR),
                Hit.the(Keys.ENTER).into(UnidadNegocioPage.INPUT_BUSCAR),
                Click.on(UnidadNegocioPage.LABEL_ID)
        );
    }
}
