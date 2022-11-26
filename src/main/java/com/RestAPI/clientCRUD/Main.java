package com.RestAPI.clientCRUD;

//<author> EltonJCS </author>
//<github> github.com/eltonjcs </github>

public class Main {
	public static void main(String[] args) {
		new ClientController(new ClientService());
	}
}
