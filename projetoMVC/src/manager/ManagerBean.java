package manager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.Usuario;
import persistence.UsuarioDao;

@ManagedBean(name="mb")
@RequestScoped
public class ManagerBean {
 //mb.usuario.nome
	private Usuario usuario; //Unidade
	private List<Usuario> usuarios; //Grupo
  
	@PostConstruct
	 public void init() {
	    this.usuario = new Usuario();
	 }
	 public void gravar() {
  FacesContext fc = FacesContext.getCurrentInstance();
	   try{
		   String resposta = this.usuario.firewall();
		   //valida
		    if (resposta.length()==0) {
		    	//grava
		  	new UsuarioDao().create(this.usuario);
		    	//limpa
		  	this.usuario = new Usuario();
		  	//mensagem
      fc.addMessage(null, new FacesMessage("Dados Gravados"));
		    }
		    else {
 fc.addMessage(null,
  new FacesMessage("Error Validacao:" + resposta));
		    }
	    }catch(Exception ex) {
fc.addMessage(null, new FacesMessage("Error no Banco:" + ex.getMessage()));
	    }
	 }
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	// usuarios -> (ManagerBean)  
	public List<Usuario> getUsuarios() {
		 if (this.usuarios==null) {
			 this.usuarios = new ArrayList<Usuario>();
		 }
		try {
			 usuarios = new UsuarioDao().findAll();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
