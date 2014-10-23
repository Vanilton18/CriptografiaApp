package view.test.glue;

import static org.junit.Assert.assertNotNull;

import java.awt.EventQueue;

import view.Main;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions extends StepDef {
	
	@Given("^Estou com o aplicativo Criptografias aberto$")
	public static void estou_com_o_aplicativo_Criptografias_aberto() throws Throwable {
			EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	@When("^Seleciono a opção \"(.*?)\"$")
	public void seleciono_a_opção(String tx) throws Throwable {
		screen.click("combo_seta.PNG");
		screen.click(tx + ".PNG");
	}

	@When("^Digito \"(.*?)\" para criptografar$")
	public void digito_para_criptografar(String tx) throws Throwable {
		screen.type("input.PNG", tx);
	}

	@When("^Clico no botão \"(.*?)\"$")
	public void clico_no_botão(String tx) throws Throwable {
		screen.click("bt_" + tx + ".png");
	}

	@Then("^Verifico o resultado da criptografia \"(.*?)\" para \"(.*?)\"$")
	public void verifico_o_resultado_da_criptografia_para(String txcript,
			String txresult) throws Throwable {
		assertNotNull(screen
				.find("result_" + txcript + "_" + txresult + ".PNG"));
	}

}
