package br.feevale.physis.business.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.SacadorAvalista;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;

import br.feevale.physis.business.model.bean.Payment;
import br.feevale.physis.business.model.bean.Person;
import br.feevale.physis.business.model.dao.PaymentDAO;
import br.feevale.physis.business.model.dao.PersonDAO;
import br.feevale.physis.business.model.enums.Role;
import br.feevale.physis.controller.CrudController;
import br.feevale.physis.dao.HibernateDAOImpl;
import br.feevale.physis.util.RequestUtils;
import br.feevale.physis.view.View;

public class PaymentController extends CrudController<Payment> {

	@Resource
	private PaymentDAO paymentDAO;
	
	@Resource
	private PersonDAO personDAO;

	@Override
	protected HibernateDAOImpl<Payment> getDao() {
		return paymentDAO;
	}

	@Override
	protected String getListVarName() {
		return "payments";
	}

	@Override
	protected String getBeanVarName() {
		return "payment";
	}

	@Override
	protected String getControllerName() {
		return "payment";
	}

	@Override
	protected String getListViewName() {
		return "paymentList";
	}

	@Override
	protected String getViewName() {
		return "payment";
	}

	@Override
	protected void buildVariables(View view) throws Exception {
		view.setVariable("people", personDAO.findFor(Role.USER));
	}

	protected String generateSlipBank(){
		// Apenas voltar para a lista
		return "paymentList";
	}	
	
	protected String getGenerateSlipBank(){
		return "paymentList";
	}

	public void generateSlipBankAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Payment payment = null;
		
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id)) {
			payment = paymentDAO.get(new Integer(id));
		}
		
		if (payment == null) {
			RequestUtils.redirect(request, response, "payment");
		}
		
		Person person = payment.getPerson();
		
		Cedente cedente = new Cedente("Physis", "00.000.208/0001-00");

        /*
         * INFORMANDO DADOS SOBRE O SACADO.
         */
        Sacado sacado = new Sacado(String.format("%s %s", person.getName(), person.getLastName()), person.getCpf());

        // Informando o endere�o do sacado.
        Endereco enderecoSac = new Endereco();
        enderecoSac.setUF(UnidadeFederativa.valueOfSigla(person.getAddress().getState().getValue()));
        enderecoSac.setLocalidade(person.getAddress().getCity());
        enderecoSac.setCep(new CEP(person.getAddress().getCep()));
        enderecoSac.setBairro(person.getAddress().getDistrict());
        enderecoSac.setLogradouro(person.getAddress().getAddress());
        enderecoSac.setNumero(person.getAddress().getNumber().toString());
        sacado.addEndereco(enderecoSac);

        /*
         * INFORMANDO DADOS SOBRE O SACADOR AVALISTA.
         */
        SacadorAvalista sacadorAvalista = new SacadorAvalista("Physis", "00.000.000/0001-91");

        // Informando o endere�o do sacador avalista.
        Endereco enderecoSacAval = new Endereco();
        enderecoSacAval.setUF(UnidadeFederativa.RS);
        enderecoSacAval.setLocalidade("Novo Hamburgo");
        enderecoSacAval.setCep(new CEP("93336-220"));
        enderecoSacAval.setBairro("Ideal");
        enderecoSacAval.setLogradouro("Rua Marechal Câmara");
        enderecoSacAval.setNumero("22");
        sacadorAvalista.addEndereco(enderecoSacAval);

        /*
         * INFORMANDO OS DADOS SOBRE O T�TULO.
         */
        
        // Informando dados sobre a conta banc�ria do t�tulo.
        ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.BANCO_BRADESCO.create());
        contaBancaria.setNumeroDaConta(new NumeroDaConta(123456, "0"));
        contaBancaria.setCarteira(new Carteira(30));
        contaBancaria.setAgencia(new Agencia(1234, "1"));
        
        Calendar vencimento = Calendar.getInstance();
        vencimento.setTime(payment.getIssueDate());
        vencimento.add(Calendar.DATE, 10);
        
        Titulo titulo = new Titulo(contaBancaria, sacado, cedente, sacadorAvalista);
        titulo.setNumeroDoDocumento("123456");
        titulo.setNossoNumero("99345678912");
        titulo.setDigitoDoNossoNumero("5");
        titulo.setValor(new BigDecimal(payment.getValue()));
        titulo.setDataDoDocumento(payment.getIssueDate());
        titulo.setDataDoVencimento(vencimento.getTime());
        titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
//        titulo.setAceite(Aceite.A);
        titulo.setDesconto(BigDecimal.ZERO);
        titulo.setDeducao(BigDecimal.ZERO);
        titulo.setMora(BigDecimal.ZERO);
        titulo.setAcrecimo(BigDecimal.ZERO);
        titulo.setValorCobrado(titulo.getValor());

        /*
         * INFORMANDO OS DADOS SOBRE O BOLETO.
         */
        Boleto boleto = new Boleto(titulo);
        
        boleto.setLocalPagamento("Pag�vel preferencialmente na Rede X ou em " +
                        "qualquer Banco at� o Vencimento.");
        boleto.setInstrucaoAoSacado("Senhor sacado, sabemos sim que o valor " +
                        "cobrado n�o � o esperado, aproveite o DESCONT�O!");
        boleto.setInstrucao1("PARA PAGAMENTO 1 at� Hoje n�o cobrar nada!");
        boleto.setInstrucao2("PARA PAGAMENTO 2 at� Amanh� N�o cobre!");
        boleto.setInstrucao3("PARA PAGAMENTO 3 at� Depois de amanh�, OK, n�o cobre.");
        boleto.setInstrucao4("PARA PAGAMENTO 4 at� 04/xx/xxxx de 4 dias atr�s COBRAR O VALOR DE: R$ 01,00");
        boleto.setInstrucao5("PARA PAGAMENTO 5 at� 05/xx/xxxx COBRAR O VALOR DE: R$ 02,00");
        boleto.setInstrucao6("PARA PAGAMENTO 6 at� 06/xx/xxxx COBRAR O VALOR DE: R$ 03,00");
        boleto.setInstrucao7("PARA PAGAMENTO 7 at� xx/xx/xxxx COBRAR O VALOR QUE VOC� QUISER!");
        boleto.setInstrucao8("AP�S o Vencimento, Pag�vel Somente na Rede X.");

        /*
         * GERANDO O BOLETO BANC�RIO.
         */
        // Instanciando um objeto "BoletoViewer", classe respons�vel pela
        // gera��o do boleto banc�rio.
        BoletoViewer boletoViewer = new BoletoViewer(boleto);

        // Gerando o arquivo. No caso o arquivo mencionado ser� salvo na mesma
        // pasta do projeto. Outros exemplos:
        // WINDOWS: boletoViewer.getAsPDF("C:/Temp/MeuBoleto.pdf");
        // LINUX: boletoViewer.getAsPDF("/home/temp/MeuBoleto.pdf");
        byte[] data = boletoViewer.getPdfAsByteArray();
        response.setContentType("application/pdf");
        response.getOutputStream().write(data);
	}
}
