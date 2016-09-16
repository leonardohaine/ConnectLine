/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jlab.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.jlab.model.Usuario;
import br.com.jlab.service.UsuarioService;

/**
 *
 * @author Leonardo
 */
@ManagedBean(name = "usuario")
@ViewScoped
public class UsuarioController {

	private Usuario usuarios = new Usuario();
	private List<Usuario> listUsuario;
	private Usuario selectedUsuario = new Usuario();

	@ManagedProperty(value = "#{UsuarioService}")
	private UsuarioService usuarioService;

	public UsuarioController() {

	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the listUsuario
	 */
	public List<Usuario> getListUsuario() {
		listUsuario = new ArrayList<Usuario>();
		listUsuario = getUsuarioService().getUsuario();
		return listUsuario;
	}

	/**
	 * @param listUsuario
	 *            the listUsuario to set
	 */
	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}

	public String saveUpdate() {
		try {
			getUsuarioService().getUsuarioDAO().saveUsuario(usuarios);

			usuarios = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Usu�rio cadastrado com sucesso!", "Usu�rio cadastrado com sucesso!"));
			return "usuarios";
		} catch (Exception e) {
			e.printStackTrace();
			usuarios = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao cadastrar usu�rio!", "Erro ao cadastrar usu�rio! " + e));
			return "usuarios";
		}
	}
	
	public String delete() {

		try {
			getUsuarioService().getUsuarioDAO().deleteUsuario(usuarios);
			usuarios = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Usu�rio deletado com sucesso!", "Usu�rio deletado com sucesso!"));
			return "usuarios";
		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Ocorreu um erro ao deletar usu�rio " + usuarios.getNome() + "!",
							"Ocorreu um erro ao deletar usu�rio " + usuarios.getNome() + "!"));
			return "usuarios";
		}
	}

	public void selectUsuario(SelectEvent event) {
		// listCorretores = new ClienteDAO().listaClientes();

		if (event.getObject() != null) {
			Usuario usuario = (Usuario) event.getObject();
			setUsuarios(getUsuarioService().getUsuarioDAO().getUsuarioById(usuario.getCodusuario()));

		}
	}

	/**
	 * @return the selectedUsuario
	 */
	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}

	/**
	 * @param selectedUsuario
	 *            the selectedUsuario to set
	 */
	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}

	/**
	 * @return the usuarioService
	 */
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	/**
	 * @param usuarioService
	 *            the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}
