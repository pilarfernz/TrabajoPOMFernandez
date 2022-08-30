package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.InfoGeneralPage;
import utils.DataDriven;
import utils.PropertiesDriven;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Tests {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ArrayList<String> dataCPs;
    private RegisterPage registerPage;
    private InfoGeneralPage infoGeneralPage;

    @AfterMethod
    public void cerrarPrueba(){
        loginPage.cerrarBrowser();
    };

    @BeforeMethod
    public void prePrueba(){
        dataCPs = new ArrayList<String>();
        homePage = new HomePage(driver);
        homePage.conexionDriver
                (PropertiesDriven.getProperty("browser"),
                        PropertiesDriven.getProperty("rutaDriver"),
                        PropertiesDriven.getProperty("propertyDriver"));

        loginPage = new LoginPage(homePage.getDriver());
        registerPage = new RegisterPage(homePage.getDriver());
        infoGeneralPage = new InfoGeneralPage(homePage.getDriver());

        homePage.cargarSitio(PropertiesDriven.getProperty("url"));
        homePage.maximizarBrowser();
    }

    //Caso 1 Login fallido
    @Test
    public void CP01_login_fallido(){
        dataCPs = DataDriven.getData("CP01_login_fallido");

        homePage.irAIniciarSesion();
        loginPage.iniciarSesion(dataCPs.get(1),dataCPs.get(2));
        Assert.assertEquals(loginPage.obtenerErrorLogin(),dataCPs.get(3));
    }

    //Caso 2 Registro fallido por mail mal escrito
    @Test
    public void CP02_registro_fallido(){
        dataCPs = DataDriven.getData("CP02_registro_fallido");

        homePage.irAIniciarSesion();
        loginPage.IrARegistro();
        registerPage.registro(dataCPs.get(1),dataCPs.get(2),dataCPs.get(3),dataCPs.get(4));
        Assert.assertEquals(registerPage.obtenerErrorRegistro(), dataCPs.get(5));
    }

    //Caso 3 Registro fallido por mail ya existente
    @Test
    public void CP03_registro_con_mail_existente(){
        dataCPs = DataDriven.getData("CP03_registro_con_mail_existente");
        homePage.irAIniciarSesion();
        loginPage.IrARegistro();
        registerPage.registro(dataCPs.get(1), dataCPs.get(2), dataCPs.get(3), dataCPs.get(4));
        Assert.assertEquals(registerPage.obtenerErrorRegistroMail(),dataCPs.get(5));
    }

    //Caso 4 Login exitoso
    @Test
    public void CP04_login_exitoso(){
        dataCPs = DataDriven.getData("CP04_login_exitoso");
        homePage.irAIniciarSesion();
        loginPage.iniciarSesion(dataCPs.get(1), dataCPs.get(2));
        Assert.assertEquals(homePage.obtenerNombrePerfilSesion(), dataCPs.get(3));

    }

    //Caso 5 Navegar hasta pantalla Cobertura Social
    @Test
    public void CP05_ir_pantalla_cobertura_social(){
        dataCPs = DataDriven.getData("CP05_ir_pantalla_cobertura_social");
        homePage.irAInfoGral();
        infoGeneralPage.irACoberturaSeccion();
        Assert.assertEquals(infoGeneralPage.obtenerTituloSeccion(), dataCPs.get(1));
    }

    //Caso 6 Hacer una busqueda sin destino
    @Test
    public void CP06_busqueda_sin_destino(){
        dataCPs = DataDriven.getData("CP06_busqueda_sin_destino");
        homePage.busquedaSinDestino(dataCPs.get(1), dataCPs.get(2));
        Assert.assertEquals(homePage.obtenerTituloSinDestino(), dataCPs.get(3));
    }

    //Caso 7 Hacer una busqueda sin fechas
    @Test
    public void CP07_busqueda_sin_fecha(){
        dataCPs = DataDriven.getData("CP07_busqueda_sin_fecha");
        homePage.busquedaSinFecha();
        Assert.assertEquals(homePage.obtenerTituloSinFecha(),dataCPs.get(1));
    }

    //Caso 8 Cerrar la sesion
    @Test
    public void CP08_cerrar_sesion(){
        dataCPs = DataDriven.getData("CP08_cerrar_sesion");
        homePage.irAIniciarSesion();
        loginPage.iniciarSesion(dataCPs.get(1),dataCPs.get(2));
        Assert.assertEquals(homePage.obtenerNombrePerfilSesion(),dataCPs.get(3));
        homePage.cerrarSesion();
        Assert.assertEquals(homePage.obtenerEstadoInicioSesion(),dataCPs.get(4));
    }
}
