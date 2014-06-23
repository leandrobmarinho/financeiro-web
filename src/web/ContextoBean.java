package web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import conta.Conta;
import conta.ContaRN;
import usuario.Usuario;
import usuario.UsuarioRN;

@ManagedBean(name = "contextoBean")
@SessionScoped
public class ContextoBean {

	private Usuario usuarioLogado = null;
	private Conta contaAtiva = null;

	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();

		if (this.usuarioLogado == null
				|| !login.equals(this.usuarioLogado.getLogin())) {

			if (login != null) {
				UsuarioRN usuarioRN = new UsuarioRN();
				this.usuarioLogado = usuarioRN.buscarPorLogin(login);
				this.contaAtiva = null;

				/*
				String[] info = this.usuarioLogado.getIdioma().split("_");
				Locale locale = new Locale(info[0], info[1]);
				context.getViewRoot().setLocale(locale);*/
			}
		}
		return usuarioLogado;
	}

	public Conta getContaAtiva() {
		if (this.contaAtiva == null) {
			Usuario usuario = this.getUsuarioLogado();
			
			System.out.println(usuario.getCodigo() + " " + usuario.getLogin() + " usuariologado");

			ContaRN contaRN = new ContaRN();
			this.contaAtiva = contaRN.buscarFavorita(usuario);
			
			System.out.println(this.contaAtiva + " conta ativa");

			if (this.contaAtiva == null) {
				
				List<Conta> contas = contaRN.listar(usuario);
				if (contas != null) {
					System.out.println(4 + " " + contas);
					for (Conta conta : contas) {
						this.contaAtiva = conta;
						break;						
					}
				}
			}
		}
		return this.contaAtiva;
	}

	public void setContaAtiva(ValueChangeEvent event) {

		Integer conta = (Integer) event.getNewValue();

		ContaRN contaRN = new ContaRN();
		this.contaAtiva = contaRN.carregar(conta);
	}

	public void setUsuarioLogado(Usuario usuario) {
		this.usuarioLogado = usuario;
	}
}
