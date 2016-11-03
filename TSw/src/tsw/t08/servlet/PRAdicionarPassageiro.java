package tsw.t08.servlet;

import java.io.IOException;

import tsw.t08.fachada.FachadaLinhasAereas;
import tsw.t08.fachada.IFachadaLinhasAereas;
import tsw.util.BibliotecaFuncoes;
import tsw.util.ConstantesGerais;

/**
 * Servlet implementation class AdicionarPassageiro
 */
public class PRAdicionarPassageiro {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PRAdicionarPassageiro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void service() throws IOException {
		String nome								= ConstantesGerais.ID_REQ_Nome;
		String email							= ConstantesGerais.ID_REQ_eMail;
		String cpf 								= ConstantesGerais.ID_REQ_CPF;
		String dataNascimento					= ConstantesGerais.ID_REQ_DataNascimento;
		String isPortadorNecessidadesEspeciais	= ConstantesGerais.ID_REQ_IsPortadorNecessidadesEspeciais;
		
		StringBuffer sb;
		if ( 
				BibliotecaFuncoes.isStringValida(nome)				&&
				BibliotecaFuncoes.isStringValida(email)				&&
				BibliotecaFuncoes.isStringValida(cpf)				&&
				BibliotecaFuncoes.isStringValida(dataNascimento)		
		) {
			IFachadaLinhasAereas fachada = new FachadaLinhasAereas();
			fachada.inserirPassageiro(
				nome,
				cpf,
				email,
				dataNascimento,
				isPortadorNecessidadesEspeciais
			);
			
			sb = getMensagemHTML("Passageiro criado com sucesso!");
		} else {
			sb = getMensagemHTML("Dados para criação de Passageiro inconsistentes");
		}
		
		//RequestDispatcher rd = pRequest.getRequestDispatcher("/visualizar.jsp");
		//rd.forward(pRequest, pResponse);
	}

	private StringBuffer getMensagemHTML(String pMensagem) {
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesGerais.HTML_TAG_INICIO);
		sb.append(ConstantesGerais.BODY_TAG_INICIO);
		sb.append(pMensagem);
		sb.append(ConstantesGerais.BODY_TAG_FIM);
		sb.append(ConstantesGerais.HTML_TAG_FIM);
		return sb;
	}
	
}