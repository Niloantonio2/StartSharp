package co.com.choucair.cetification.startsharp.tasks;

import co.com.choucair.cetification.startsharp.models.CrearReunionModel;
import co.com.choucair.cetification.startsharp.userinterfaces.InicioPage;
import co.com.choucair.cetification.startsharp.userinterfaces.ReunionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.Keys;

import java.util.List;

public class CreaNuevaRunion implements Task {

    private List<CrearReunionModel> crearReunionModels;

    public CreaNuevaRunion(List<CrearReunionModel> crearReunionModels) {
        this.crearReunionModels = crearReunionModels;
    }

    public static CreaNuevaRunion conNegocio(List<CrearReunionModel> crearReunionModels) {
        return Tasks.instrumented(CreaNuevaRunion.class,crearReunionModels);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InicioPage.BTN_REUNION),
                Click.on(InicioPage.BTN_REUNIONES),
                Click.on(InicioPage.BTN_NUEVA_REUNION),

                Enter.theValue(crearReunionModels.get(0).getStrNombreReunion()).into(ReunionPage.INPUT_NOMBRE_REUNION),
                Enter.theValue(crearReunionModels.get(0).getIntNumeroReunion()).into(ReunionPage.INPUT_NUMERO_REUNION),
                Click.on(ReunionPage.DROPDOWN_TIPO_REUNION),
                Enter.theValue(crearReunionModels.get(0).getStrTipo()).into(ReunionPage.INPUT_TIPO_REUNION).thenHit(Keys.ENTER),
                Enter.theValue(crearReunionModels.get(0).getDateFechaInicio()).into(ReunionPage.INPUT_FECHA_INICIO),
                Enter.theValue(crearReunionModels.get(0).getDateFechaFin()).into(ReunionPage.INPUT_FECHA_FIN),
                SelectFromOptions.byVisibleText(crearReunionModels.get(0).getStrHoraInicio()).from(ReunionPage.SELECT_HORA_INICIO),
                SelectFromOptions.byVisibleText(crearReunionModels.get(0).getStrHoraFin()).from(ReunionPage.SELECT_HORA_FIN),
                Click.on(ReunionPage.DROPDOWN_UBICACION),
                Enter.theValue(crearReunionModels.get(0).getStrUbicacion()).into(ReunionPage.INPUT_UBICACION).thenHit(Keys.ENTER),
                Click.on(ReunionPage.DROPDOWN_ORGANIZADOR),
                Enter.theValue(crearReunionModels.get(0).getStrOrganizador()).into(ReunionPage.INPUT_ORGANIZADOR).thenHit(Keys.ENTER),
                Click.on(ReunionPage.DROPDOWN_UNIDAD),
                Enter.theValue(crearReunionModels.get(0).getStrUnidadPadre()).into(ReunionPage.INPUT_UNIDAD).thenHit(Keys.ENTER),
                Click.on(ReunionPage.DROPDOWN_REPORTRTO),
                Enter.theValue(crearReunionModels.get(0).getStrReportero()).into(ReunionPage.INPUT_REPORTERO).thenHit(Keys.ENTER),
                Click.on(ReunionPage.DROPDOWN_ASISTENTE),
                Enter.theValue(crearReunionModels.get(0).getStrAsistentes()).into(ReunionPage.INPUT_ASISTENTE).thenHit(Keys.ENTER),
                Click.on(ReunionPage.BTN_GUARDAR)


        );
    }
}
