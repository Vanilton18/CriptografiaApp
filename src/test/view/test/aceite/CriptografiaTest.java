package view.test.aceite;

import static org.junit.Assert.assertNotNull;

import java.awt.EventQueue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import view.Main;

public class CriptografiaTest {

	Screen screen = new Screen();

	@Before
	public void setUp() throws Exception {
		Settings.BundlePath = "pictures"; 
		Settings.MinSimilarity = 0.90; 
		Settings.Highlight = false; 
		Settings.DefaultHighlightTime = (float) 1.0; 
		Settings.LogTime = true; 
		
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
		screen.wait("sha1.PNG", 10);
	}

	@Test
	public void CriptografarSHA1() throws FindFailed {
		screen.click("combo_seta.PNG");
		screen.click("sha1.PNG");
		screen.type("input.PNG", "123");
		screen.click("bt_criptografar.png");
		assertNotNull(screen.find("result_sha1_123.PNG"));
	}

	@Test
	public void CriptografarMD5Fail() throws FindFailed {
		screen.click("combo_seta.PNG");
		screen.click("md5.PNG");
		screen.type("input.PNG", "123");
		screen.click("bt_criptografar.png");
		assertNotNull(screen.find("result_sha1_123.PNG"));
	}

	@Test
	public void CriptografarMD5Passed() throws FindFailed {
		screen.click("combo_seta.PNG");
		screen.click("md5.PNG");
		screen.type("input.PNG", "123");
		screen.click("bt_criptografar.png");
		assertNotNull(screen.find("result_md5_123.PNG"));
	}

	@Test
	public void TesteBotaoLimpar() throws FindFailed {
		screen.click("combo_seta.PNG");
		screen.click("md5.PNG");
		screen.type("input.PNG", "123");
		screen.click("bt_criptografar.png");
		assertNotNull(screen.find("result_md5_123.PNG"));
		screen.click("bt_limpar.PNG");
		assertNotNull(screen.find("campo_result_vazio.png"));
		assertNotNull(screen.type("input.PNG"));

	}

	@Test
	public void TesteHintFecharApp() throws FindFailed {
		Pattern menu_file = new Pattern("menu_file.PNG"); // criando um pattern
		screen.click(menu_file.similar((float) 0.9)); // definindo uma
														// similaridade para uma
														// única imagem no caso
														// de 99%
		screen.wait("sair.PNG");
		screen.hover("sair.PNG");
		assertNotNull(screen.find("hint_fecharapp.png"));
		screen.type(Key.ESC);
	}

	@AfterClass
	public static void tearDown() throws FindFailed {
		System.out.println("Testes Finalizados");

	}
}
