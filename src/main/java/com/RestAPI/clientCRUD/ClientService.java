package com.RestAPI.clientCRUD;

import java.util.*;

//Serviço que providência funcionalidade CRUD (criar, ler, atualizar e deletar)
public class ClientService {

	//Array que armazena itens em pares "chave/valor"
	private Map<String, Client> clients = new HashMap<>();
	//Retorna uma lista de todos os clientes
	public List<Client> getAllClients() {
		return new ArrayList<>(clients.values());
	}
	//Retorna as informações de um cliente que possui o id informado
	public Client getClient(String id) {
		return clients.get(id);
	}

	//Cria um novo cliente
	public Client createClient(String name, String cpf, String address, String city, String state) {
		failIfInvalid(name, cpf);
		Client client = new Client(name, cpf, address, city, state);
		cpfAlreadyExists(cpf);
		clients.put(client.getId(), client);
		return client;
	}

	//Atualiza as informações de um cliente que possui o id informado
	public Client updateClient(String id, String name, String cpf, String address, String city, String state) {
		Client client = clients.get(id);
		if (client == null) {
			throw new IllegalArgumentException("Nenhum cliente com o id igual a '" + id + "' foi encontrado");
		}
		failIfInvalid(name, cpf);
		client.setName(name);
		client.setCpf(cpf);
		client.setAddress(address);
		client.setCity(city);
		client.setState(state);
		return client;
	}

	//Remove o cliente que possui o id informado
	public String deleteClient(String id) {
		Client client = clients.get(id);
		if (client == null) {
			throw new IllegalArgumentException("Nenhum cliente com o id igual a '" + id + "' foi encontrado");
		}
		clients.remove(id);
		return "O cliente " + client.getName() + ", com o id de " + client.getId() + ", foi removido com sucesso.";
	}

	//Verifica se o parâmetro de nome está vazio e se o cpf é válido
	private void failIfInvalid(String name, String cpf) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("O parâmetro 'name' não pode ser vazio.");
		}
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Valor do CPF é inválido.");
		}
	}

	//Verifica se o cpf já foi cadastrado
	private void cpfAlreadyExists(String cpf) {
		List<Client> clients = getAllClients();
		for (int i = 0; i < clients.size(); i++) {
			if (Objects.equals(clients.get(i).getCpf(), cpf)) {
				throw new IllegalArgumentException("O cpf '" + cpf + "' já está cadastrado.");
			}
		}
	}
}
