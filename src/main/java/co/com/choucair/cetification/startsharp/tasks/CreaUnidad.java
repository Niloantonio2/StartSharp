package co.com.choucair.cetification.startsharp.tasks;

import co.com.choucair.cetification.startsharp.models.CrearUnidadModel;
import co.com.choucair.cetification.startsharp.models.CredencialesModel;
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

public class CreaUnidad implements Task {

    private List<CrearUnidadModel> crearUnidadModels;

    public CreaUnidad(List<CrearUnidadModel> crearUnidadModels) {
        this.crearUnidadModels = crearUnidadModels;
    }

    public static CreaUnidad deNegocio(List<CrearUnidadModel> crearUnidadModels) {
        return Tasks.instrumented(CreaUnidad.class,crearUnidadModels );
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(crearUnidadModels.get(0).getStrNombreUnidad()).into(UnidadNegocioPage.INPUT_NOMBRE),
                Click.on(UnidadNegocioPage.DROPDOWN_UNIDAD_PADRE),
                Enter.theValue(crearUnidadModels.get(0).getStrUnidadPadre()).into(UnidadNegocioPage.INPUT_UNIDAD_PADRE),
                Hit.the(Keys.ENTER).into(UnidadNegocioPage.INPUT_UNIDAD_PADRE),
                Click.on(UnidadNegocioPage.BTN_GUARDAR)

        );
    }
}
