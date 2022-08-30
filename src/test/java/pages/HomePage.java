package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

import javax.swing.*;

public class HomePage extends BaseClass{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    By IniciarSesionBoton = By.xpath("//header/div[@id='menu-buscador']/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]");
    By PerfilSesion = By.xpath("//a[@id='dLabel']");
    By DestinoBoton = By.xpath("//header/div[@id='menu-buscador']/div[1]/form[1]/div[1]/div[1]/a[1]");
    By DesdeInput = By.xpath("//header/div[@id='menu-buscador']/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]");
    By HastaInput = By.xpath("//header/div[@id='menu-buscador']/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/input[1]");
    By BuscarBoton = By.xpath("//header/div[@id='menu-buscador']/div[1]/form[1]/div[1]/div[2]/div[1]/button[1]");
    By InfoGralBoton = By.xpath("//header/nav[1]/div[2]/div[1]/ul[1]/li[3]/a[1]");
    By ItemDestino = By.xpath("/html[1]/body[1]/div[3]/div[1]/label[1]");
    By SeleccionarDestinoBoton = By.xpath("//a[contains(text(),'Seleccionar destinos')]");
    By SalirBoton = By.xpath("//header/div[@id='menu-buscador']/div[1]/div[1]/div[1]/ul[1]/li[5]/ul[1]/li[4]/a[1]");
    By TituloSinDestino = By.xpath("/html[1]/body[1]/div[1]/div[1]/h4[1]");
    By TituloSinFecha = By.xpath("/html[1]/body[1]/div[1]/div[1]/h4[1]");

    public void irAIniciarSesion(){
        click(esperaExplicita(IniciarSesionBoton));
    }

    public void irAInfoGral(){ click(esperaExplicita(InfoGralBoton));}

    public void busquedaSinDestino(String fechaDesde, String fechaHasta){
        agregarTexto(esperaExplicita(DesdeInput),fechaDesde);
        agregarTexto(esperaExplicita(HastaInput),fechaHasta);
        click(esperaExplicita(BuscarBoton));
    }
    public void busquedaSinFecha(){
        click(esperaExplicita(DestinoBoton));
        click(esperaExplicita(ItemDestino));
        click(esperaExplicita(SeleccionarDestinoBoton));
        click(esperaExplicita(BuscarBoton));
    }
    public String obtenerNombrePerfilSesion(){return obtenerTexto(esperaExplicita(PerfilSesion));};

    public String obtenerTituloSinDestino(){return obtenerTexto(esperaExplicita(TituloSinDestino));};
    public String obtenerTituloSinFecha(){return obtenerTexto(esperaExplicita(TituloSinFecha));};
    public String obtenerEstadoInicioSesion(){return obtenerTexto(esperaExplicita(IniciarSesionBoton));};

    public void cerrarSesion(){
        click(esperaExplicita(PerfilSesion));
        click(esperaExplicita(SalirBoton));
    }
}
