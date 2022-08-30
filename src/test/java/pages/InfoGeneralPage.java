package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class InfoGeneralPage extends BaseClass{
    public InfoGeneralPage(WebDriver driver) {
        super(driver);
    }

    By CoberturaBoton = By.xpath("//a[contains(text(),'Cobertura de Salud')]");
    By CoberturaTitulo = By.xpath("//h2[contains(text(),'Cobertura de Salud')]");

    public void irACoberturaSeccion(){
        click(esperaExplicita(CoberturaBoton));
    }
    public String obtenerTituloSeccion(){return obtenerTexto(esperaExplicita(CoberturaTitulo));};
}
