package azure.keyvault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SampleApplication implements CommandLineRunner {
	
	private static final int maxUser = 1000;
	private static final int fromUser = 1;
	private static final ObjectMapper mapper = new ObjectMapper();
	private static final String HTTP_HOST = "http://20.198.248.43:8080";
	private static final String WEBSOCKET_HOST = "ws://52.230.99.5:18090";
	
	private static final String LOGIN_URL = "/salus-backend/api/no-auth/authenticate";
	private static final String FIGHTING_ROOM = "FIGHTING_ROOM";
	private static final String BATTLE_ROOM = "BATTLE_ROOM";
	
	@Value("${jdbcUrl}")
	private String jdbcUrl;
	
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}
	public void run(String... varl) throws Exception {        
		System.out.println("Value of key jdbcUrl: " + jdbcUrl);
//		for(int userNumber = fromUser; userNumber <= maxUser; userNumber++) {
//			ResponseLogin response = login(userNumber);
//			conectWebsocket("accesstoken");
//			Thread.sleep(150);
//		}
	}

	
	
	
//	private ResponseLogin login(int userNumber) throws IOException {
//		OkHttpClient client = new OkHttpClient().newBuilder()
//				.build();
//		MediaType mediaType = MediaType.parse("application/json");
//		RequestLoginModel loginModel = buildBody(userNumber);
//		RequestBody body = RequestBody.create(mediaType, mapper.writeValueAsString(loginModel));
//		Request request = new Request.Builder()
//				.url(HTTP_HOST + LOGIN_URL)
//				.method("POST", body)
//				.addHeader("Content-Type", "application/json")
//				.build();
//		ResponseBody response =  client.newCall(request).execute().body();
//		return mapper.readValue(response.string(), ResponseLogin.class);
//	}
//
//	private void conectWebsocket(final String accessToken) throws JsonProcessingException{
//		WebSocketEcho wsEcho = new WebSocketEcho();
//		wsEcho.setWebSocketHost(WEBSOCKET_HOST);
//		WebSocket ws = wsEcho.start();
//		RequestWSLogin wsLogin = new RequestWSLogin();
//		wsLogin.setType(8);
//		wsLogin.addSource(accessToken);
//		wsLogin.addSource(BATTLE_ROOM);
//		ws.send(mapper.writeValueAsString(wsLogin));
//	}
//
//	private RequestLoginModel buildBody(int i) {
//		RequestLoginModel loginModel = new RequestLoginModel();
//		loginModel.setUsername("salus_user"  + i);
//		loginModel.setPassword("Salus@1234");
//		return loginModel;
//	}

}