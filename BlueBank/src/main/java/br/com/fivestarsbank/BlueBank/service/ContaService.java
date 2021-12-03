package br.com.fivestarsbank.BlueBank.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fivestarsbank.BlueBank.models.Cliente;
import br.com.fivestarsbank.BlueBank.models.Conta;
import br.com.fivestarsbank.BlueBank.models.Movimentacao;
import br.com.fivestarsbank.BlueBank.models.Saldo;
import br.com.fivestarsbank.BlueBank.models.DTO.ExtratoDTO;
import br.com.fivestarsbank.BlueBank.models.enums.StatusConta;
import br.com.fivestarsbank.BlueBank.repositories.ContaRepository;
import br.com.fivestarsbank.BlueBank.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repo;
	@Autowired
	private ClienteService cli_service;
	@Autowired
	private SaldoService saldo_service;

	public Conta buscar(Long id) {
		Optional<Conta> conta = repo.findById(id);
		return conta.orElseThrow(() -> new ObjetoNaoEncontradoException("Conta - Id: " + id));
	}

	public List<Conta> listar() {
		return repo.findAll();
	}

	public Conta salvar(Conta conta) {
		return repo.save(conta);
	}

	public Conta cadastrar(Long id) {
		Cliente cliente = cli_service.buscar(id);

		Random random = new Random();

		Integer numero_conta = geradorNumeroConta(random);
		Integer digito_conta = random.nextInt(9);
		Integer agencia = 1;
		Integer codigo_banco = 623;

		Conta conta = new Conta(digito_conta, agencia, codigo_banco, StatusConta.toEnum(1), numero_conta, cliente);
		conta.setData_abertura(LocalDate.now());
		cliente.getContas().add(conta);

		salvar(conta);

		Saldo saldo = new Saldo(LocalDate.now().minusDays(1), conta, 0.00);
		saldo_service.salvar(saldo);

		return conta;
	}

	private Integer geradorNumeroConta(Random random) {
		String num;
		Integer numero;
		List<Conta> lista = new ArrayList<>();

		do {
			num = "";
			for (int i = 0; i < 6; i++) {
				num += Integer.toString(random.nextInt(9));
			}

			numero = Integer.parseInt(num);
			for (Conta i : listar()) {
				if (i.getNumero_conta() == numero) {
					lista.add(i);
				}
			}

		} while (!lista.isEmpty());

		return numero;
	}

	public void inativarConta(Long id) {
		Conta conta = buscar(id);

		conta.setStatus(StatusConta.toEnum(2)); // 2 = INATIVA
		conta.setData_fechamento(LocalDate.now());

		salvar(conta);
	}

	public ExtratoDTO exibirExtrato(Long id, Integer periodo) {
		Conta conta = buscar(id);

		LocalDate data_inicial = verificarDatas(conta, periodo);

		Saldo saldo = saldo_service.buscar(data_inicial, conta);

		List<Movimentacao> listaMovi = listarMovimentações(periodo, conta);
		Double saldoFinal = calcularSaldoFinal(listaMovi , saldo.getSaldo());

		ExtratoDTO extrato = new ExtratoDTO();
		extrato.setConta(conta);
		extrato.setSaldo_inicial(saldo.getSaldo());
		extrato.getListaMovi().addAll(listaMovi);
		extrato.setSaldo_final(saldoFinal);
		extrato.setPeriodo(periodo);
		extrato.setData(LocalDate.now());

		return extrato;

	}

	private LocalDate verificarDatas(Conta conta, Integer periodo) {
		LocalDate dataSaldo = conta.getData_abertura().minusDays(1);
		LocalDate dataInicioPeriodo = LocalDate.now().minusDays(periodo);

		LocalDate data = (dataSaldo.isAfter(dataInicioPeriodo)) ? dataSaldo : dataInicioPeriodo;

		return data;
	}

	private List<Movimentacao> listarMovimentações(Integer periodo, Conta conta) {
		List<Movimentacao> lista = new ArrayList<>();
		
		//trocar
		for (int i = 0; i < periodo; i++) {
			LocalDate data = LocalDate.now().minusDays(i);

			for (Movimentacao movi : conta.getTransacoes()) {
				if (movi.getData_transacao().equals(data))
					lista.add(movi);
			}
		}

		return lista;
	}

	private Double calcularSaldoFinal(List<Movimentacao> movi, Double saldo) {
		for(Movimentacao i : movi) {
			if(i.getCredito_debito().getCod().equals(1)) {
				saldo -= i.getValor();
			} else {
				saldo += i.getValor();
			}
		}

		return saldo;
	}

}
