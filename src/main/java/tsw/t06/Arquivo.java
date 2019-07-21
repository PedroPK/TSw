/*
 * Este arquivo � propriedade da Secretaria da Fazenda do Estado
 * de Pernambuco (Sefaz-PE). Nenhuma informa��o nele contida pode ser
 * reproduzida, mostrada ou revelada sem permiss�o escrita da Sefaz-PE.
 */
package tsw.t06;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.Date;

import javax.activation.MimetypesFileTypeMap;

/**
 * 
 */
public class Arquivo implements Serializable, IntfObjetoSessao {
	//~ Atributos/inicializadores estaticos ----------------------------------------------------------------------------------------

	/**
	 * 
	 */
	public static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * -
	 */
	public static final String ID_OBJETO = "util.arquivo";

	//~ Atributos de instancia -----------------------------------------------------------------------------------------------------

	private transient BufferedReader aBufferedReader;
	private transient FileInputStream aFileInputStream;
	private transient FileOutputStream aFileOutputStream;
	private transient FileReader aFileReader;
	private File aArquivo;
	private String aNmArquivo;
	private boolean aInGeradoOnLine;
	private boolean aInGeradoOnLineAlterado;
	private long aUltimaModificacao;

	//~ Construtores ---------------------------------------------------------------------------------------------------------------

/**
         * Cria um novo objeto Arquivo.
         *
         * @param pArquivo
         *
         * @throws ExcecaoParametroInvalido
         */
	public Arquivo(File pArquivo) throws ExcecaoParametroInvalido {
		if (pArquivo == null) {
			throw new ExcecaoParametroInvalido("O par�metro pArquivo n�o pode ser nulo | Classe: Arquivo | M�todo: construtor");
		}

		this.aArquivo = pArquivo;
		this.aUltimaModificacao = this.aArquivo.lastModified();
	}

/**
         * Cria um novo objeto Arquivo.
         *
         * @param pNmCompletoArquivo
         *
         * @throws ExcecaoParametroInvalido
         */
	public Arquivo(String pNmCompletoArquivo) throws ExcecaoParametroInvalido {
		if (pNmCompletoArquivo == null) {
			throw new ExcecaoParametroInvalido(
				"O par�metro pNmCompletoArquivo n�o pode ser nulo | Classe: Arquivo | M�todo: construtor");
		}

		this.aArquivo = new File(pNmCompletoArquivo);
		this.aUltimaModificacao = this.aArquivo.lastModified();
	}

	//~ Metodos --------------------------------------------------------------------------------------------------------------------

	/**
	 * -
	 *
	 * @return
	 */
	public boolean existe() {
		return this.aArquivo.isFile();
	}

	/**
	 * -
	 */
	public void fechar() {
		try {
			if (this.aFileInputStream != null) {
				this.aFileInputStream.close();
				this.aFileInputStream = null;
			}

			if (this.aFileOutputStream != null) {
				this.aFileOutputStream.close();
				this.aFileOutputStream = null;
			}

			if (this.aFileReader != null) {
				this.aFileReader.close();
				this.aFileReader = null;
			}

			if (this.aBufferedReader != null) {
				this.aBufferedReader.close();
				this.aBufferedReader = null;
			}
		} catch (Exception e) {
		}
	}

	/**
	 * -
	 */
	public void prepararPastaFileSystem() {
		File pasta = new File(this.getNmPasta());
		pasta.mkdirs();
	}

	/**
	 * -
	 *
	 * @param pNmCompletoArquivo
	 */
	public static void prepararPastaFileSystem(String pNmCompletoArquivo) {
		File arquivo = new File(pNmCompletoArquivo);
		File pasta = new File(arquivo.getParent());
		pasta.mkdirs();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmArquivo() {
		String nmArquivo = this.aNmArquivo;

		if (nmArquivo == null) {
			this.aNmArquivo = nmArquivo = this.aArquivo.getName();
		}

		return nmArquivo;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmArquivoSemExtensao() {
		String nmArquivoSemExtensao;

		nmArquivoSemExtensao = this.getNmArquivo();

		if (this.temExtensao()) {
			nmArquivoSemExtensao = nmArquivoSemExtensao.substring(0, nmArquivoSemExtensao.lastIndexOf("."));
		}

		return nmArquivoSemExtensao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmExtensao() {
		String nmExtensao = "";

		if (this.temExtensao()) {
			nmExtensao = this.getNmArquivo();
			nmExtensao = nmExtensao.substring(nmExtensao.lastIndexOf(".") + 1);
		}

		return nmExtensao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean temExtensao() {
		boolean temExtensao = false;

		if (this.getNmArquivo().lastIndexOf(".") > -1) {
			temExtensao = true;
		}

		return temExtensao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmCompletoArquivo() {
		return this.aArquivo.getPath();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmCompletoArquivoSemExtensao() {
		String nmCompletoArquivoSemExtensao;

		nmCompletoArquivoSemExtensao = this.getNmCompletoArquivo();

		if (this.temExtensao()) {
			nmCompletoArquivoSemExtensao = nmCompletoArquivoSemExtensao.substring(0, nmCompletoArquivoSemExtensao.lastIndexOf("."));
		}

		return nmCompletoArquivoSemExtensao;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public long getTamanhoArquivo() {
		return this.aArquivo.length();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getNmPasta() {
		return this.aArquivo.getParent();
	}

	/**
	 * -
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public FileInputStream getFileInputStream() throws ExcecaoParametroInvalido {
		try {
			if (this.aFileInputStream == null) {
				this.aFileInputStream = new FileInputStream(this.aArquivo);
			}
		} catch (Exception e) {
			throw new ExcecaoParametroInvalido("Erro obtendo FileInputStream (" + this.getNmCompletoArquivo() +
				") | Classe: Arquivo | M�todo: getFileInputStream", e);
		}

		return this.aFileInputStream;
	}

	/**
	 * -
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public void inicializarFileInputStream() throws ExcecaoParametroInvalido {
		this.aFileInputStream = null;
	}

	/**
	 * -
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public void inicializarBufferedReader() throws ExcecaoParametroInvalido {
		this.aFileReader = null;
		this.aBufferedReader = null;
	}

	/**
	 * -
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public FileOutputStream getFileOutputStream() throws ExcecaoParametroInvalido {
		try {
			if (this.aFileOutputStream == null) {
				this.aFileOutputStream = new FileOutputStream(this.aArquivo);
			}
		} catch (Exception e) {
			throw new ExcecaoParametroInvalido("Erro obtendo FileOutputStream (" + this.getNmCompletoArquivo() +
				") | Classe: Arquivo | M�todo: getFileOutputStream", e);
		}

		return this.aFileOutputStream;
	}

	/**
	 * -
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public FileOutputStream getFileOutputStreamUsandoAppend()
		throws ExcecaoParametroInvalido {
		if (this.aFileOutputStream == null) {
			try {
				this.aFileOutputStream = new FileOutputStream(this.aArquivo.getPath(), true);
			} catch (Exception e) {
				throw new ExcecaoParametroInvalido("Erro obtendo FileOutputStream (" + this.getNmCompletoArquivo() +
					") | Classe: Arquivo | M�todo: getFileOutputStreamUsandoAppend", e);
			}
		}

		return this.aFileOutputStream;
	}

	/**
	 * -
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public void inicializarFileOutputStream() throws ExcecaoParametroInvalido {
		this.aFileOutputStream = null;
	}

	/**
	 * -
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public FileReader getFileReader() throws ExcecaoParametroInvalido {
		try {
			if (this.aFileReader == null) {
				this.aFileReader = new FileReader(this.aArquivo);
			}
		} catch (Exception e) {
			throw new ExcecaoParametroInvalido("Erro obtendo FileReader (" + this.getNmCompletoArquivo() +
				") | Classe: Arquivo | M�todo: getFileReader", e);
		}

		return this.aFileReader;
	}

	/**
	 * -
	 *
	 * @return
	 *
	 * @throws ExcecaoParametroInvalido
	 */
	public BufferedReader getBufferedReader() throws ExcecaoParametroInvalido {
		try {
			if (this.aBufferedReader == null) {
				this.aBufferedReader = new BufferedReader(this.getFileReader());
			}
		} catch (Exception e) {
			throw new ExcecaoParametroInvalido("Erro obtendo BufferedReader (" + this.getNmCompletoArquivo() +
				") | Classe: Arquivo | M�todo: getBufferedReader", e);
		}

		return this.aBufferedReader;
	}

	/**
	 * -
	 *
	 * @param pInGeradoOnLine
	 */
	public void setInGeradoOnLine(boolean pInGeradoOnLine) {
		this.aInGeradoOnLine = pInGeradoOnLine;
		this.aInGeradoOnLineAlterado = true;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isInGeradoOnLineAlterado() {
		return this.aInGeradoOnLineAlterado;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isGeradoOnLine() {
		return this.aInGeradoOnLine;
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean isModificadoFileSystem() {
		if (this.aArquivo.lastModified() != this.aUltimaModificacao) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * -
	 */
	public void atualizarUltimaModificacao() {
		this.aUltimaModificacao = this.aArquivo.lastModified();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public boolean apagar() {
		boolean resultado;

		resultado = this.aArquivo.delete();

		return resultado;
	}

	/**
	 * -
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoSistema
	 */
	public boolean criar() throws ExcecaoGenerica {
		boolean resultado = false;

		try {
			resultado = this.aArquivo.createNewFile();
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro criando arquivo (" + this.getNmCompletoArquivo() +
				") | Classe: Arquivo | M�todo: criar", e);
		}

		return resultado;
	}

	/**
	 * -
	 *
	 * @param pNmCompletoArquivoDestino
	 * @param pInOverwrite
	 * @param pInPreserveLastModified
	 *
	 * @throws ExcecaoSistema
	 */
	public void copiar(String pNmCompletoArquivoDestino, boolean pInOverwrite, boolean pInPreserveLastModified)
		throws ExcecaoSistema {
		Arquivo arquivoDestino = null;

		try {
			arquivoDestino = new Arquivo(pNmCompletoArquivoDestino);

			if (pInOverwrite || !arquivoDestino.existe()) {
				if (arquivoDestino.existe()) {
					arquivoDestino.apagar();
				} else {
					arquivoDestino.prepararPastaFileSystem();
				}

				FileInputStream in = null;
				FileOutputStream out = null;

				try {
					in = this.getFileInputStream();
					out = arquivoDestino.getFileOutputStream();

					byte[] buffer = new byte[8 * 1024];
					int count = 0;

					do {
						out.write(buffer, 0, count);
						count = in.read(buffer, 0, buffer.length);
					} while (count != -1);
				} finally {
					if (out != null) {
						out.close();
					}

					if (in != null) {
						in.close();
					}
				}

				if (pInPreserveLastModified) {
					arquivoDestino.setLastModified(this.aArquivo.lastModified());
				}
			}
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro copiando arquivo (" + this.getNmCompletoArquivo() + ") para '" +
				pNmCompletoArquivoDestino + "' | Classe: Arquivo | M�todo: copiar", e);
		}
	}

	/**
	 * -
	 *
	 * @param pNmArquivoDestino
	 * @param pSgSistema
	 * @param pInComControleData
	 *
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoSistema
	 */
	public void copiarParaEntrada(String pNmArquivoDestino, String pSgSistema, boolean pInComControleData)
		throws ExcecaoGenerica {
		String nmCompletoArquivoDestino = "";

		try {
			nmCompletoArquivoDestino = Constantes.NM_PATH_ENTRADA;
			nmCompletoArquivoDestino += (File.separator + pSgSistema.toLowerCase());

			if (pInComControleData) {
				nmCompletoArquivoDestino += (File.separator +
					BibliotecaFuncoesDataHora.getDataComoStringInvertida(BibliotecaFuncoesDataHora.getDataHoje()));
			}
			nmCompletoArquivoDestino += (File.separator + pNmArquivoDestino);

			this.copiar(nmCompletoArquivoDestino, true, true);
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro movendo arquivo (" + this.getNmCompletoArquivo() + ") para diret�rio de Entrada" +
				" | Classe: Arquivo | M�todo: moverParaEntrada", e);
		}
	}

	/**
	 * -
	 *
	 * @param pTimeMillis
	 *
	 * @throws ExcecaoSistema
	 */
	public void setLastModified(long pTimeMillis) throws ExcecaoSistema {
		if (pTimeMillis < 0) {
			this.aArquivo.setLastModified(System.currentTimeMillis());
		} else {
			this.aArquivo.setLastModified(pTimeMillis);
		}
	}

	/**
	 * -
	 *
	 * @param pNmCompletoArquivoDestino
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoSistema
	 */
	public boolean mover(String pNmCompletoArquivoDestino)
		throws ExcecaoGenerica {
		File arquivoDestino = null;
		boolean resultado = true;

		try {
			Arquivo.prepararPastaFileSystem(pNmCompletoArquivoDestino);
			arquivoDestino = new File(pNmCompletoArquivoDestino);

			resultado = this.aArquivo.renameTo(arquivoDestino);

			if (!resultado) {
				this.copiar(pNmCompletoArquivoDestino, true, true);

				resultado = this.apagar();

				if (!resultado) {
					throw new ExcecaoSistema("Erro apagando arquivo (" + this.getNmCompletoArquivo() +
						") | Classe: Arquivo | M�todo: mover");
				}
			}

			this.fechar();
			this.aArquivo = arquivoDestino;
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro movendo arquivo (" + this.getNmCompletoArquivo() + ") para '" +
				pNmCompletoArquivoDestino + "' | Classe: Arquivo | M�todo: mover", e);
		}

		return resultado;
	}

	/**
	 * -
	 *
	 * @param pNmArquivoDestino
	 * @param pSgSistema
	 * @param pInComControleData
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoSistema
	 */
	public boolean moverParaEntrada(String pNmArquivoDestino, String pSgSistema, boolean pInComControleData)
		throws ExcecaoGenerica {
		String nmCompletoArquivoDestino = "";

		try {
			nmCompletoArquivoDestino = Constantes.NM_PATH_ENTRADA;
			nmCompletoArquivoDestino += (File.separator + pSgSistema.toLowerCase());

			if (pInComControleData) {
				nmCompletoArquivoDestino += (File.separator +
					BibliotecaFuncoesDataHora.getDataComoStringInvertida(BibliotecaFuncoesDataHora.getDataHoje()));
			}
			nmCompletoArquivoDestino += (File.separator + pNmArquivoDestino);

			return this.mover(nmCompletoArquivoDestino);
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro movendo arquivo (" + this.getNmCompletoArquivo() + ") para diret�rio de Entrada" +
				" | Classe: Arquivo | M�todo: moverParaEntrada", e);
		}
	}

	/**
	 * -
	 *
	 * @param pNmArquivoDestino
	 * @param pSgSistema
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoSistema
	 */
	public boolean moverParaSincronizacaoEntrada(String pNmArquivoDestino, String pSgSistema)
		throws ExcecaoGenerica {
		String nmCompletoArquivoDestino = "";

		try {
			nmCompletoArquivoDestino = Constantes.NM_PATH_COMUM;
			nmCompletoArquivoDestino += (File.separator + pSgSistema.toLowerCase());
			nmCompletoArquivoDestino += (File.separator + pNmArquivoDestino);

			return this.mover(nmCompletoArquivoDestino);
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro movendo arquivo (" + this.getNmCompletoArquivo() + ") para diret�rio de Entrada" +
				" | Classe: Arquivo | M�todo: moverParaEntrada", e);
		}
	}

	/**
	 * -
	 *
	 * @return
	 */
	public Date getDataUltimaAlteracao() {
		return new Date(this.aArquivo.lastModified());
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String getContentType() {
		String retorno = null;

		MimetypesFileTypeMap mime = new MimetypesFileTypeMap();
		retorno = mime.getContentType(this.aArquivo);

		if (retorno == null) {
			retorno = "";
		}

		return retorno;
	}
	
	/**
	 * -
	 *
	 * @return
	 *
	 * @throws ExcecaoGenerica
	 * @throws ExcecaoSistema
	 */
	public String toURL() throws ExcecaoGenerica {
		try {
			return this.aArquivo.toURL().toString();
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro obtendo URL do arquivo (" + this.getNmCompletoArquivo() +
				") | Classe: Arquivo | M�todo: toURL", e);
		}
	}

	/**
	 * -
	 *
	 * @return
	 */
	public String toString() {
		return "NmCompletoArquivo=" + this.aArquivo.getPath();
	}

	/**
	 * -
	 *
	 * @throws ExcecaoGerenciadorSessao
	 */
	public void limparObjeto() throws ExcecaoGerenciadorSessao {
		try {
			if (this.isGeradoOnLine()) {
				this.apagar();
			}
		} catch (Exception e) {
			throw new ExcecaoGerenciadorSessao("Erro apagando arquivo", e);
		}
	}

	/**
	 * L� o conte�do do arquivo indicado na constru��o do objeto.
	 *
	 * @return Array de bytes que representa o conte�do do arquivo
	 *
	 * @throws ExcecaoSistema
	 */
	public byte[] lerConteudo() throws ExcecaoSistema {
		byte[] conteudo = null;

		try {
			FileInputStream fis = new FileInputStream(this.aArquivo);

			try {
				ByteArrayOutputStream bos = new ByteArrayOutputStream();

				try {
					byte[] buf = new byte[512];
					int tam = 0;

					while ((tam = fis.read(buf)) != -1) {
						bos.write(buf, 0, tam);
					}

					bos.flush();

					conteudo = bos.toByteArray();
				} finally {
					bos.close();
				}
			} finally {
				fis.close();
			}
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro lendo arquivo (" + this.getNmCompletoArquivo() +
				") | Classe: Arquivo | M�todo: lerConteudo", e);
		}

		return conteudo;
	}

	/**
	 * L� o conte�do do arquivo texto.
	 *
	 * @param charset Indica o charset em que o arquivo est� codificado (Ex. UTF-8, ISO-8859-1)
	 *
	 * @return String que representa o texto do arquivo.
	 *
	 * @throws ExcecaoSistema
	 */
	public String lerConteudoComoTexto(String charset)
		throws ExcecaoSistema {
		String conteudo = null;

		try {
			FileInputStream fis = new FileInputStream(this.aArquivo);

			InputStreamReader isr = new InputStreamReader(fis, charset);

			try {
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(bos, charset);

				try {
					char[] buf = new char[1024];
					int i = 0;

					while ((i = isr.read(buf)) != -1) {
						osw.write(buf, 0, i);
					}

					osw.flush();

					conteudo = bos.toString(charset);
				} finally {
					osw.close();
				}
			} finally {
				isr.close();
			}
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro lendo arquivo (" + this.getNmCompletoArquivo() + "), encode: '" + charset +
				"' | Classe: Arquivo | M�todo: lerConteudo", e);
		}

		return conteudo;
	}

	/**
	 * L� o conte�do do arquivo texto codificado com charset padr�o
	 *
	 * @return String que representa o texto do arquivo.
	 *
	 * @throws ExcecaoSistema
	 *
	 * @see {@link #DEFAULT_CHARSET}
	 */
	public String lerConteudoComoTexto() throws ExcecaoSistema {
		return lerConteudoComoTexto(Arquivo.DEFAULT_CHARSET);
	}

	/**
	 * Escreve o conte�do no arquivo indicado na constru��o do objeto
	 *
	 * @param conteudo Array de byte que representa o conte�do do arquivo que ser� gravado.
	 *
	 * @throws ExcecaoSistema
	 */
	public void escreverConteudo(byte[] conteudo) throws ExcecaoSistema {
		try {
			FileOutputStream fos = new FileOutputStream(this.aArquivo);

			try {
				fos.write(conteudo);
			} finally {
				fos.close();
			}
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro lendo arquivo (" + this.getNmCompletoArquivo() +
				") | Classe: Arquivo | M�todo: escreverConteudo", e);
		}
	}

	/**
	 * Escreve o conte�do no arquivo indicado na constru��o do objeto, como texto e codificado no charset indicado.
	 *
	 * @param conteudo String que representa o conte�do do arquivo que ser� gravado.
	 * @param charset Indica o charset em que o arquivo ser� codificado (Ex. UTF-8, ISO-8859-1)
	 *
	 * @throws ExcecaoSistema
	 */
	public void escreverConteudoTexto(String conteudo, String charset)
		throws ExcecaoSistema {
		try {
			FileOutputStream fos = new FileOutputStream(this.aArquivo);

			OutputStreamWriter osw = new OutputStreamWriter(fos, charset);

			try {
				osw.write(conteudo);
			} finally {
				osw.close();
			}
		} catch (Exception e) {
			throw new ExcecaoSistema("Erro lendo arquivo (" + this.getNmCompletoArquivo() + "), encode: '" + charset +
				"' | Classe: Arquivo | M�todo: escreverConteudo", e);
		}
	}

	/**
	 * Escreve o conte�do no arquivo indicado na constru��o do objeto, como texto e codificado no charset padr�o
	 *
	 * @param conteudo String que representa o conte�do do arquivo que ser� gravado.
	 *
	 * @throws ExcecaoSistema
	 *
	 * @see {@link #DEFAULT_CHARSET}.
	 */
	public void escreverConteudoTexto(String conteudo)
		throws ExcecaoSistema {
		escreverConteudoTexto(conteudo, Arquivo.DEFAULT_CHARSET);
	}

	/**
	 * -
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Arquivo arquivo = new Arquivo("c:/temps");
			System.out.println(arquivo.existe());

			arquivo = new Arquivo("c:/temp/lixo.txt");
			System.out.println(arquivo.getNmArquivoSemExtensao());
			System.out.println(arquivo.getNmExtensao());
			arquivo.mover("c:/lixo.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
