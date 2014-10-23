#Encoding: Cp1252
Feature: Example of Feature with Sikuli api

Background: 
	Given Estou com o aplicativo Criptografias aberto

@CriptografiaSha1
Scenario: Realizar uma criptografia Sha1
	    When Seleciono a opção "sha1"
	    And Digito "123" para criptografar
	    And Clico no botão "criptografar"
	    Then Verifico o resultado da criptografia "sha1" para "123"
	    	