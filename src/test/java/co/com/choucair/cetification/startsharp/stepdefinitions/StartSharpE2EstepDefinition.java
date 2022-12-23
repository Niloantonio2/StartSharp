package co.com.choucair.cetification.startsharp.stepdefinitions;

import co.com.choucair.cetification.startsharp.models.CrearReunionModel;
import co.com.choucair.cetification.startsharp.models.CrearUnidadModel;
import co.com.choucair.cetification.startsharp.models.CredencialesModel;
import co.com.choucair.cetification.startsharp.questions.ValidarNombreUnidad;
import co.com.choucair.cetification.startsharp.questions.ValidarReunion;
import co.com.choucair.cetification.startsharp.questions.ValidarUnidadPadre;
import co.com.choucair.cetification.startsharp.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.es.*;


import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;


import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class StartSharpE2EstepDefinition {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario se encuentra en la pagina$")
    public void queElUsuarioSeEncuentraEnLaPagina() {
        OnStage.theActorCalled("Nilo").wasAbleTo(AbrirPagina.starSharp());
    }


    @Cuando("^ingresa sus credenciales de ingreso$")
    public void ingresaSusCredencialesDeIngreso(List<CredencialesModel> credencialesModels) {
        OnStage.theActorCalled("Nilo").wasAbleTo(IniciarSesion.conLosDatos(credencialesModels));
    }


    @Cuando("^que el usuario crea una unidad de negocio$")
    public void queElUsuarioCreaUnaUnidadDeNegocio() throws InterruptedException {
        OnStage.theActorCalled("Nilo").attemptsTo(AbrirUnidad.deNegocio());
        Thread.sleep(3000);

    }


    @Cuando("^ingresa los datos$")
    public void ingresaLosDatos(List<CrearUnidadModel> crearUnidadModels) throws InterruptedException {
        OnStage.theActorCalled("Nilo").attemptsTo(CreaUnidad.deNegocio(crearUnidadModels));
        Thread.sleep(5000);
    }

    @Entonces("^se visualizara unidad creada$")
    public void seVisualizaraUnidadCreada(List<CrearUnidadModel> crearUnidadModels) throws InterruptedException {
        OnStage.theActorCalled("Nilo").attemptsTo(BucarUnidad.deNegocio(crearUnidadModels));
        Thread.sleep(2000);
        OnStage.theActorInTheSpotlight().should(seeThat("Validar que exista unidad creada", ValidarNombreUnidad.creada(), Matchers.equalTo(crearUnidadModels.get(0).getStrNombreUnidad())));
        Thread.sleep(2000);
    }
    @Cuando("^el usuario crea nueva reunion$")
    public void elUsuarioCreaNuevaReunion(List<CrearReunionModel> crearReunionModels) throws InterruptedException {
        OnStage.theActorCalled("Nilo").attemptsTo(CreaNuevaRunion.conNegocio(crearReunionModels));
        Thread.sleep(2000);
    }



    @Entonces("^podra ver creada la reunion$")
    public void podraVerCreadaLaReunion(List<CrearReunionModel> crearReunionModels) throws InterruptedException {
        OnStage.theActorCalled("Nilo").attemptsTo(BucarReunion.creada(crearReunionModels));
        Thread.sleep(2000);
        OnStage.theActorInTheSpotlight().should(seeThat("Validar que exista reunion programada", ValidarReunion.programada(), Matchers.equalTo(crearReunionModels.get(0).getStrNombreReunion())));

    }



}


