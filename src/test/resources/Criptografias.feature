#Encoding: Cp1252
Feature: Como usu�rio do aplicativo Criptografia
		 Gostaria de realizar criptografia para Sha1
		 Ent�o poderei criptografar minhas informa��es
		 
Background: 
	Given Estou com o aplicativo Criptografias aberto

@CriptografiaSha1
Scenario: Realizar uma criptografia Sha1
	    When Seleciono a op��o "sha1"
	    And Digito "123" para criptografar
	    And Clico no bot�o "criptografar"
	    Then Verifico o resultado da criptografia "sha1" para "123"
	    	