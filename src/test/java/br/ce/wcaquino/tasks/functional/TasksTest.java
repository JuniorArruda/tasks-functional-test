package br.ce.wcaquino.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	
	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://192.168.0.247:8080/tasks/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		
		try {
		
		// clicar em add todo
		driver.findElement(By.id("addTodo")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		// escrever a descriçao
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		// escrever data
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		
		//clicar salvar
		driver.findElement(By.id("saveButton")).click();
				
		// validar mensagem success!!
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", message);
		
		} finally {
		
		// fechar o browser
		driver.quit();
		}
				
	}	
	
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
		WebDriver driver = acessarAplicacao();
		
		try {
		
		// clicar em add todo
		driver.findElement(By.id("addTodo")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				
		// escrever data
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		
		//clicar salvar
				driver.findElement(By.id("saveButton")).click();
				
		// validar mensagem success!!
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the task description", message);
		
		} finally {
		
		// fechar o browser
				driver.quit();
		}
				
	}
	
	
	@Test
	public void naoDeveSalvarTarefaSemData() {
		WebDriver driver = acessarAplicacao();
		
		try {
		
		// clicar em add todo
		driver.findElement(By.id("addTodo")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		// escrever a descriçao
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		//clicar salvar
		driver.findElement(By.id("saveButton")).click();
				
		// validar mensagem success!!
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the due date", message);
		
		} finally {
		
		// fechar o browser
		driver.quit();
		}
				
	}	
	
	@Test
	public void naoDeveSalvarTarefaComDataPassada() {
		WebDriver driver = acessarAplicacao();
		
		try {
		
		// clicar em add todo
		driver.findElement(By.id("addTodo")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		// escrever a descriçao
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		// escrever data
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2010");
		
		//clicar salvar
		driver.findElement(By.id("saveButton")).click();
				
		// validar mensagem success!!
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Due date must not be in past", message);
		
		} finally {
		
		// fechar o browser
		driver.quit();
		}
				
	}	
	
	
	

}
