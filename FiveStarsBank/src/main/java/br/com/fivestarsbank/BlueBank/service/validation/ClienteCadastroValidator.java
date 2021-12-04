package br.com.fivestarsbank.BlueBank.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fivestarsbank.BlueBank.controllers.exceptions.FieldMessage;
import br.com.fivestarsbank.BlueBank.models.Cliente;
import br.com.fivestarsbank.BlueBank.models.Contato;
import br.com.fivestarsbank.BlueBank.models.DTO.ClienteDTO;
import br.com.fivestarsbank.BlueBank.models.enums.TipoCliente;
import br.com.fivestarsbank.BlueBank.service.ClienteService;
import br.com.fivestarsbank.BlueBank.service.ContatoService;
import br.com.fivestarsbank.BlueBank.service.validation.utils.ValidaDocumentosCPF_CNPJ;

public class ClienteCadastroValidator implements ConstraintValidator<ClienteCadastro, ClienteDTO> {
	
	@Autowired
	private ContatoService contato_service;
	@Autowired
	private ClienteService cliente_service;
	
	@Override
	public void initialize(ClienteCadastro ann) {
	}

	@Override
	public boolean isValid(ClienteDTO cli, ConstraintValidatorContext context) {
		List<FieldMessage> lista = new ArrayList<>();

		//VALIDAÇÕES
		
		//Validação CPF:
		if (cli.getTipo().equals(TipoCliente.PF.getCod()) && !ValidaDocumentosCPF_CNPJ.isValidCPF(cli.getCpf_cnpj())) {
			lista.add(new FieldMessage("cpf_cnpj", "CPF inválido!"));
		}

		//Validação CNPJ:
		if (cli.getTipo().equals(TipoCliente.PJ.getCod()) && !ValidaDocumentosCPF_CNPJ.isValidCNPJ(cli.getCpf_cnpj())) {
			lista.add(new FieldMessage("cpf_cnpj", "CNPJ inválido!"));
		}
        
        //Validação Telefone: DDD válido | cel = DDD + 9 | fixo = DDD + 8
        final String[] ddd = {"11", "12", "13", "14", "15", "16", "17", "18" , "19", "21", "22", "24", "27", "28", 
        		              "31", "32", "33", "34", "35", "37", "38", "41", "42", "43", "44", "45", "46", "47", "48","49",
        		              "51", "53", "54", "55", "61", "62", "63" , "64", "65", "66", "67", "68", "69", "71", "73", "74", "75", "77",
        		              "79", "81", "82", "83", "84", "85", "86", "87", "88", "89", "91", "92", "93", "94", "95", "96",
        		              "97", "98", "99"};
        
        String[] arrayTel = cli.getTelefone().split("");
        String dddTel = arrayTel[0] + arrayTel[1];
        Integer tam = arrayTel.length;
        boolean valido = false;
        
        for(int i=0; i<ddd.length; i++) {
        	if(dddTel.equals(ddd[i]) && (tam == 10 || tam == 11)) {
        		valido = true;
        		break;
            }
        }
        
        if(!valido) {
        	lista.add(new FieldMessage("telefone", "Telfone inválido! Digite o DDD + telefone, somente números"));
        }
         
                 
        //VALIDAÇÃO DE CAMPO ÚNICO:
         
        //Validação e-mail:    	    		
     	for(Contato i : contato_service.listar()) {
     		if(i.getEmail().equals(cli.getEmail()))
     			lista.add(new FieldMessage("email", "E-mail já registrado!"));
     	}

     	//Validação CPF / CNPJ: 
     	for(Cliente i : cliente_service.listar()) {
     		if(i.getCpf_cnpj().equals(cli.getCpf_cnpj())) 
     			lista.add(new FieldMessage("cpf_cnpj", "CPF / CNPJ já registrado!"));
     	}
     	
     	//Validação RG / IE: 
     	for(Cliente i : cliente_service.listar()) {
     		if(i.getRg_ie().equals(cli.getRg_ie())) 
     			lista.add(new FieldMessage("rg_ie", "RG / IE já registrado!"));
     	}
         
         

        //CASO ALGUM TESTE RETORNE TRUE = RETORNA OS CAMPOS E ERROS
		for (FieldMessage e : lista) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem_erro()).addPropertyNode(e.getNome_campo())
					.addConstraintViolation();
		}

		return lista.isEmpty();
	}
}
