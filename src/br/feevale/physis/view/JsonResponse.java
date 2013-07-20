package br.feevale.physis.view;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.util.MetadataUtils;

public class JsonResponse {

	private Object response;
	
	public JsonResponse(Object response) {
		this.response = response;
	}
	
	public void respond(HttpServletResponse response) throws IOException {
		String json = MetadataUtils.fromObjecToJson(this.response);
		response.getWriter().write(json);
	}

}
