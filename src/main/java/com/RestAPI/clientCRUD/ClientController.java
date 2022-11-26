package com.RestAPI.clientCRUD;

import com.google.gson.Gson;
import static spark.Spark.*;


//Classe responsável por lidar com as solicitações recebidas, utilizando o Spark para roteamento
public class ClientController {

	public ClientController(final ClientService clientService) {

		get("/clients", (req, res) -> new Gson().toJson(clientService.getAllClients()));

		get("/clients/:id", (req, res) -> {
			String id = req.params(":id");
			Client client = clientService.getClient(id);
			if (client != null) {
				return new Gson().toJson(client);
			}
			res.status(400);
			return "Nenhum cliente com o id igual a '"+id+"' foi encontrado.";
		});

		post("/clients", (req, res) -> {
			Client client = clientService.createClient(
					req.queryParams("name"),
					req.queryParams("cpf"),
					req.queryParams("address"),
					req.queryParams("city"),
					req.queryParams("state")
			);
			return new Gson().toJson(client);
		});

		put("/clients/:id", (req, res) -> {
			Client client = clientService.updateClient(
					req.params(":id"),
					req.queryParams("name"),
					req.queryParams("cpf"),
					req.queryParams("address"),
					req.queryParams("city"),
					req.queryParams("state")
			);
			return new Gson().toJson(client);
		});

		delete("/clients/:id", (req, res) -> {
			String client = clientService.deleteClient(
					req.params(":id")
			);
			return new Gson().toJson(client);
		});

		//Filtro que define o conteúdo de resposta para o tipo JSON
		after((req, res) -> res.type("application/json"));

		//Manipulador de exceção que é chamado se uma exceção de argumento ilegal for lançada
		exception(IllegalArgumentException.class, (e, req, res) -> {
			res.status(400);
			res.body(new Gson().toJson(e.getMessage()));
		});
	}
}
