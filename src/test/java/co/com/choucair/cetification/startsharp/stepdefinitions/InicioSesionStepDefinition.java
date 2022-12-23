package co.com.choucair.cetification.startsharp.stepdefinitions;

import co.com.choucair.cetification.startsharp.models.CredencialesModel;
import co.com.choucair.cetification.startsharp.questions.ValidarDasboard;
import co.com.choucair.cetification.startsharp.tasks.AbrirPagina;
import co.com.choucair.cetification.startsharp.tasks.IniciarSesion;
import cucumber.api.java.Before;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import java.util.List;

public class InicioSesionStepDefinition {


    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario se encuentra en la pagina web$")
    public void queElUsuarioSeEncuentraEnLaPaginaWeb() {
    OnStage.theActorCalled("Nilo").wasAbleTo(AbrirPagina.starSharp());
    }
    @Cuando("^ingresa sus credenciales$")
    public void ingresaSusCredenciales(List<CredencialesModel> credencialesModels) {
        OnStage.theActorCalled("Nilo").wasAbleTo(
                IniciarSesion.conLosDatos(credencialesModels)
        );
    }
    @Entonces("^podra visualizar su (.*)$")
    public void podraVisualizarSuDashboard(String mensaje) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarDasboard.pagina(), Matchers.equalTo(mensaje)));

    }




}
