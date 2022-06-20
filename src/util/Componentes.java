package util;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class Componentes {
    private WebDriver driver;

    public void inicializa(){
        String chromeDriver = System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/resources/componentes.html");
    }

    public  void fecharNavegador(){
        driver.quit();
    }

//    Cadastro Cenário 1
    public void cadastroCenario_um(){
            driver.findElement(By.id("elementosForm:nome")).sendKeys("Anderson");
            driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Demetrio");
            driver.findElement(By.id("elementosForm:sexo:0")).click();
            driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
            new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Superior");
            new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Futebol");
            driver.findElement(By.id("elementosForm:cadastrar")).click();
            Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
            Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Anderson"));
            Assert.assertEquals("Sobrenome: Demetrio", driver.findElement(By.id("descSobrenome")).getText());
            Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
            Assert.assertEquals("Comida: Carne", driver.findElement(By.id("descComida")).getText());
            Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
            Assert.assertEquals("Esportes: Futebol", driver.findElement(By.id("descEsportes")).getText());
    }
    public void Cadastro_click() {
        driver.findElement(By.id("elementosForm:cadastrar")).click();
    }

    // Validação Regra de Negócio Testes

    public void Valida_RN1() {
            driver.findElement(By.id("elementosForm:cadastrar")).click();
        }
    public void Alerta_RN1(){
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Nome eh obrigatorio", alert.getText());

    }
    public void Valida_RN2(){
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Anderson");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
    }

    public void Alerta_RN2(){
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
    }

    public void Valida_RN3(){
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Anderson");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Demetrio");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
    }
    public void Alerta_RN3(){
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
    }
    public void Valida_RN4(){

            driver.findElement(By.id("elementosForm:nome")).sendKeys("Anderson ");
            driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Demetrio Plácido");
            driver.findElement(By.id("elementosForm:sexo:0")).click();
            driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
            driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
            driver.findElement(By.id("elementosForm:cadastrar")).click();
    }
public void Alerta_RN4(){
    Alert alert = driver.switchTo().alert();
    Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
}

    public void Valida_RN5(){

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Anderson");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Demetrio Placido");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
        combo.selectByVisibleText("Futebol");
        combo.selectByVisibleText("O que eh esporte?");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
    }

    public void Alerta_RN5(){
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
    }


    public void botao_confirm(){

        driver.findElement(By.id("confirm")).click();
    }
    public void alerta_confirm(){

            driver.findElement(By.id("confirm")).click();
            Alert aviso = driver.switchTo().alert();
            Assert.assertEquals("Confirm Simples", aviso.getText());
             aviso.accept();
            Assert.assertEquals("Confirmado", aviso.getText());
            aviso.accept();

            driver.findElement(By.id("confirm")).click();
            Alert aviso2 = driver.switchTo().alert();
            Assert.assertEquals("Confirm Simples", aviso2.getText());
             aviso2.dismiss();
            Assert.assertEquals("Negado", aviso2.getText());
            aviso2.dismiss();
    }

}





