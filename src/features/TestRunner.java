package features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/features/Componentes.feature"},
        glue = {""},
        tags = {"@cadastro_cenario_um"}
       // tags = {"@validar_cenario_um"}
        //tags = {"@alerta_confirm"}
        // Descomente para Testar os cenários
)
public class TestRunner {

}
