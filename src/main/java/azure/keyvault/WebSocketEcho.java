package azure.keyvault;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public final class WebSocketEcho extends WebSocketListener {

	private String webSocketHost;
	
	public WebSocket start() {
		OkHttpClient client = new OkHttpClient.Builder()
				.readTimeout(0,  TimeUnit.MILLISECONDS)
				.build();

		Request request = new Request.Builder()
				.url(this.webSocketHost)
				.build();
		WebSocket ws = client.newWebSocket(request, this);
		// Trigger shutdown of the dispatcher's executor so this process can exit cleanly.
		client.dispatcher().executorService().shutdown();
		return ws;
	}

	@Override public void onOpen(WebSocket webSocket, Response response) {

	}

	@Override public void onMessage(WebSocket webSocket, String text) {
		//System.out.println("MESSAGE: " + text);
	}

	@Override public void onClosing(WebSocket webSocket, int code, String reason) {
		webSocket.close(1000, reason);
		System.out.println("CLOSE: " + code + " " + reason);
	}

	@Override public void onFailure(WebSocket webSocket, Throwable t, Response response) {
		t.printStackTrace();
	}
	
	public void setWebSocketHost(String webSocketHost) {
		this.webSocketHost = webSocketHost;
	}

}