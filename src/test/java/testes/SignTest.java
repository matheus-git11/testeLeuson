package testes;

import org.junit.Assert ;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignTest {

    @Test
    public void testPassarValorDoJogoTrue(){
        System.setProperty("webdriver.chrome.driver" , "/home/matheus/Downloads/ses/chromedriver_linux64/chromedriver");
        WebDriver navegador = new ChromeDriver();

        navegador.get("https://www.playstation.com/pt-br/");
        navegador.findElement(By.id("menu-button-primary--msg-shop")).click();
        navegador.findElement(By.id("link-secondary--msg-ps-store")).click();
        navegador.findElement(By.id("d4e24945-fe66-11ea-aadc-062143ad1e8d-b1e2f0ba-b436-11ec-9932-1a1c5f7f109b")).click();
        String preço = navegador.findElement(By.className("psw-t-title-m")).getText();

        Assert.assertEquals("R$ 299,90", preço);
    }

    @Test
    public void testJogoBannerHorizonTrue(){
        System.setProperty("webdriver.chrome.driver" , "/home/matheus/Downloads/ses/chromedriver_linux64/chromedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get("https://www.playstation.com/pt-br/");
        navegador.findElement(By.className("page-banner__keyart-anchor")).click();

       String nome = navegador.findElement(By.className("game-title")).getText();

        Assert.assertEquals("Horizon Forbidden West", nome);

    }

    @Test
    public void StatusServidorFalse(){
        System.setProperty("webdriver.chrome.driver" , "/home/matheus/Downloads/ses/chromedriver_linux64/chromedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        navegador.get("https://www.playstation.com/pt-br/");
        navegador.findElement(By.id("menu-button-primary--msg-support")).click();
        navegador.findElement(By.id("link-secondary--msg-psn-status")).click();
        String nome = navegador.findElement(By.className("offscreen")).getText();
        Assert.assertNotEquals(" os serviços Não estão em funcionamento", nome);

    }





}
