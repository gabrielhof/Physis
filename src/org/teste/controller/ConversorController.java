package org.teste.controller;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.teste.enums.Moedas;
import org.teste.util.DecimalUtils;

public class ConversorController implements DefaultController {

	private DecimalFormat decimalFormat = new DecimalFormat("#.###");
	
	@Override
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Moedas source = Moedas.value(request.getParameter("moeda_origem"));
		Moedas dest = Moedas.value(request.getParameter("moeda_destino"));

		Double valor = DecimalUtils.parseDouble(request.getParameter("valor"));

		if (source == null) {
			response.getWriter().println("Moeda de Origem Invalida: " + request.getParameter("moeda_origem"));
			return;
		}

		if (dest == null) {
			response.getWriter().println("Moeda de Destino Invalida: " + request.getParameter("moeda_destino"));
			return;
		}

		if (valor == null) {
			response.getWriter().println("Valor Invalido: " + request.getParameter("valor"));
			return;
		}

		double cotacao = source.getMoeda().getCotacao(dest);
		double valorConvertido = cotacao * valor.doubleValue();

		response.getWriter().println("Valor Convertido: " + decimalFormat.format(valorConvertido));
	}

}
