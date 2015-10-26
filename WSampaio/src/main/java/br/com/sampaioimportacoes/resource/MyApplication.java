package br.com.sampaioimportacoes.resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Application;

public class MyApplication extends Application{

	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<>();
		// Configura o pacote para fazer scan das classes com serviçoes Rest
		properties.put("jersey.config.server.provider.packages", "br.com.sampaioimportacoes");
		return properties;
	}
}
