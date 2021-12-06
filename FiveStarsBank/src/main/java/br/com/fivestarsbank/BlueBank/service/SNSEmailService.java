package br.com.fivestarsbank.BlueBank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

import br.com.fivestarsbank.BlueBank.models.Cliente;

@Service
public class SNSEmailService {

	@Autowired
	private AmazonSNSClient snsClient;

	public String criarTopico(Long id) {
		String idCliente = Long.toString(id);
		CreateTopicRequest request = new CreateTopicRequest(idCliente);
		return snsClient.createTopic(request).getTopicArn();
	}

	public void adicionarAssinaturaTopico(Cliente cli, String topic_arn) {
		String email = cli.getContatos().get(0).getEmail();
		SubscribeRequest request = new SubscribeRequest(topic_arn, "email", email);
		snsClient.subscribe(request);
	}

	public void enviarEmailCliente(String topic_arn, String menssagem, String assunto) {
		PublishRequest publishRequest = new PublishRequest(topic_arn, menssagem, assunto);
		snsClient.publish(publishRequest);
	}
	
	public void enviarEmailMovi(String topic_arn, String menssagem, String assunto) {
		PublishRequest publishRequest = new PublishRequest(topic_arn, menssagem, assunto);
		snsClient.publish(publishRequest);
	}

}
