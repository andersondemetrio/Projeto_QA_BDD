package stepdefinitions;

import cucumber.api.java.es.Dado;
import cucumber.api.java.fr.Quand;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;
import javafx.scene.control.Alert;
import org.junit.Assert;
import util.Componentes;

public class ComponentesStep {

    Componentes componentes = new Componentes();

    @Dado("que o usuário acessou o arquivo Campo de treinamento")
    public void que_o_usuário_acessou_o_arquivo_Campo_de_treinamento() {
       componentes.inicializa();
    }
    // Começo Cenário Um
    @Quando("o usuário digitar campos nome, sobrenome, sexo, comida, escolaridade e esporte")
    public void o_usuário_digitar_campos_nome_sobrenome_sexo_comida_escolaridade_e_esporte() {
        componentes.cadastroCenario_um();
    }

    @Então("o resultado dever ser cadastrado")
    public void o_resultado_dever_ser_cadastrado() {
    componentes.Cadastro_click();
    }
    // Fim cadastro Cenário Um

    @Quando("o usuário cadastrou o campos")
    public void o_usuário_cadastrou_o_campos() {
        //componentes.Valida_RN1();
        //componentes.Valida_RN2();
        //componentes.Valida_RN3();
        //componentes.Valida_RN4();
        componentes.Valida_RN5();

        // Descomente A ordem sequencial para Verificar a validação dos Campos, Exemplo a Validação da RN3 cadastra o Nome e Sobrenome, porém não o sexo
    }
    @Então("Validar campos")
    public void validar_campos() {
        //componentes.Alerta_RN1();
        //componentes.Alerta_RN2;
        //componentes.Alerta_RN3();
        //componentes.Alerta_RN4();
        componentes.Alerta_RN5();
        // Descomente para identificar os Avisos para a validação dos Alertas
    }

    @Quando("o Usuário clicar no botão Confirm")
    public void o_Usuário_clicar_no_botão_Confirm() {
        componentes.alerta_confirm();

    }

    @Então("Validar as mensagem do botão Confirm")
    public void validar_as_mensagem_do_botão_Confirm() {
        componentes.alerta_confirm();
    }


}
