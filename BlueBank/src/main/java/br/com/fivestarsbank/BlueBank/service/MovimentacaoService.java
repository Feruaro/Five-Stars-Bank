package br.com.fivestarsbank.BlueBank.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fivestarsbank.BlueBank.models.Conta;
import br.com.fivestarsbank.BlueBank.models.Movimentacao;
import br.com.fivestarsbank.BlueBank.models.DTO.MovimentacaoDTO;
import br.com.fivestarsbank.BlueBank.models.enums.DebitoCredito;
import br.com.fivestarsbank.BlueBank.models.enums.TipoTransacao;
import br.com.fivestarsbank.BlueBank.repositories.MovimentacaoRepository;
import br.com.fivestarsbank.BlueBank.service.exceptions.ContaInativaException;
import br.com.fivestarsbank.BlueBank.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository repo;
	@Autowired
	private ContaService conta_service;

	public Movimentacao buscar(Long id) {
		Optional<Movimentacao> movi = repo.findById(id);
		return movi.orElseThrow(() -> new ObjetoNaoEncontradoException("Movimentação - Id: " + id));
	}

	public List<Movimentacao> listar(Long id) {
		Conta conta = conta_service.buscar(id);
		return conta.getTransacoes();
	}
	
	private Movimentacao converterDTO(MovimentacaoDTO movi) {
		return new Movimentacao(movi.getId_transacao(), TipoTransacao.toEnum(movi.getTipo()), movi.getValor(), DebitoCredito.toEnum(movi.getCredito_debito()), movi.getDescricao());
	}

	public Movimentacao incluir(MovimentacaoDTO movi, Long id) {
		Conta conta = conta_service.buscar(id);
		Movimentacao mov = converterDTO(movi);
		
		// Utilizar essa linha se quiser testar movimentações com outros datas (simular
		// extratos):
		// LocalDate data = (movi.getData_transacao() == null) ? LocalDate.now() :
		// movi.getData_transacao();

		if (contaAtiva(conta)) {
			mov.setData_transacao(LocalDate.now());
			mov.setConta(conta);

			conta.getTransacoes().add(mov);
		} else {
			throw new ContaInativaException(id);
		}

		return repo.save(mov);
	}

	private boolean contaAtiva(Conta conta) {
		return (conta.getStatus().getCod() == 1) ? true : false;
	}

	public String gerarAssuntoEmail(Movimentacao movi) {
		return "Houve um " + movi.getCredito_debito().getDescrição() + " na conta " + movi.getConta().getNumero_conta()
				+ "-" + movi.getConta().getDigito_conta();
	}

	public String gerarMensagemEmail(Movimentacao movi) {
		return "Id transação: " + movi.getId_transacao() + "\nValor: " + movi.getValor();
	}

}
