package util;

/*
import financeiro.bolsa.acao.AcaoDAO;
import financeiro.bolsa.acao.AcaoDAOHibernate;
import financeiro.categoria.CategoriaDAO;
import financeiro.categoria.CategoriaDAOHibernate;
import financeiro.cheque.ChequeDAO;
import financeiro.cheque.ChequeDAOHibernate;
import financeiro.conta.ContaDAO;
import financeiro.conta.ContaDAOHibernate;
import financeiro.lancamento.LancamentoDAO;
import financeiro.lancamento.LancamentoDAOHibernate; */
import usuario.UsuarioDAO;
import usuario.UsuarioDAOHibernate;

public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}

	/*
	public static CategoriaDAO criarCategoriaDAO() {
		CategoriaDAOHibernate categoriaDAO = new CategoriaDAOHibernate();
		categoriaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return categoriaDAO;
	}

	public static ContaDAO criarContaDAO() {
		ContaDAOHibernate contaDAO = new ContaDAOHibernate();
		contaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return contaDAO;
	}
	
	public static LancamentoDAO criarLancamentoDAO() {
		LancamentoDAOHibernate lancamentoDAO = new LancamentoDAOHibernate();
		lancamentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return lancamentoDAO;
	}

	public static ChequeDAO criarChequeDAO() {
		ChequeDAOHibernate chequeDAO = new ChequeDAOHibernate();
		chequeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return chequeDAO;
	}
	
	public static AcaoDAO criarAcaoDAO() {
		AcaoDAOHibernate acaoDAO = new AcaoDAOHibernate();
		acaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return acaoDAO;
	} */
}