package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By EmailInput = By.xpath("//input[@id='username']");
    By ContraInput = By.xpath("//input[@id='password']");
    By LoginBoton = By.xpath("//button[contains(text(),'Ingresar')]");
    By LoginError = By.xpath("//strong[contains(text(),'Error')]");
    By BotonRegistro = By.xpath("//body/main[@id='login']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/a[1]");
    
    public void iniciarSesion(String email,String pass){
        agregarTexto(esperaExplicita(EmailInput),email);
        agregarTexto(esperaExplicita(ContraInput),pass);
        click(esperaExplicita(LoginBoton));
    }

    public String obtenerErrorLogin(){
        return obtenerTexto(esperaExplicita(LoginError));
    }

    public void IrARegistro(){
        click(esperaExplicita(BotonRegistro));
    }
}