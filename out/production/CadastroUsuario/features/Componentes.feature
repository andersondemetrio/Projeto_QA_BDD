#language:pt
@acessar_varioscomponenteshtml
Funcionalidade: Acessar vários componentes html

  Contexto:
    Dado que o usuário acessou o arquivo Campo de treinamento
  @cadastro_cenario_um
    Cenario:Preencher campos de cadastro
    Quando o usuário digitar campos nome, sobrenome, sexo, comida, escolaridade e esporte
    Então o resultado dever ser cadastrado

  @validar_cenario_um
  Cenário: Validar Campos nome, sobrenome, sexo, comida, escolaridade e esporte
    Quando o usuário cadastrou o campos
    Então Validar campos

  @alerta_confirm
  Cenário: Validar botão Confirm
    Quando o Usuário clicar no botão Confirm
    Então Validar as mensagem do botão Confirm
