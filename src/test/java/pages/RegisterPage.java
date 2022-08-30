package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class RegisterPage extends BaseClass {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    By NombreInput = By.xpath("//input[@id='nombre']");
    By ApellidoInput = By.xpath("//input[@id='apellido']");
    By TelefonoInput = By.xpath("//input[@id='telefono']");
    By EmailInput = By.xpath("//input[@id='email']");
    By ConfirmarBoton = By.xpath("//button[contains(text(),'Confirmar')]");
    By RegistroError = By.xpath("//body/main[@id='registro']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/ul[1]/li[1]");
    By RegistroErrorMail = By.xpath("//li[contains(text(),'La dirección de Email que ingresaste está asociada')]");

    public String obtenerErrorRegistro(){return obtenerTexto(esperaExplicita(RegistroError));};
    public String obtenerErrorRegistroMail(){return obtenerTexto(esperaExplicita(RegistroErrorMail));};

    public void registro(String nombre, String apellido, String telefono, String email){
        agregarTexto(esperaExplicita(NombreInput), nombre);
        agregarTexto(esperaExplicita(ApellidoInput), apellido);
        agregarTexto(esperaExplicita(TelefonoInput), telefono);
        agregarTexto(esperaExplicita(EmailInput), email);
        click(esperaExplicita(ConfirmarBoton));
    }


}
