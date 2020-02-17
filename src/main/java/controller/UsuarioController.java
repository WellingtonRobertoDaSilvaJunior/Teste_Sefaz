package controller;

import model.Usuario;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import facade.UsuarioFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.Application;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ActionEvent;
import org.primefaces.PrimeFaces;

@Named("usuarioController")
@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private facade.UsuarioFacade ejbFacade;
    private List<Usuario> items = null;
    private Usuario selected;
    private boolean hidenMenu = true;
    private String mailLogin;
    private String nameSenha;
    private boolean loggedIn = false;

    public UsuarioController() {
    }

    public Usuario getSelected() {
        return selected;
    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }

    public UsuarioFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(UsuarioFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public boolean isHidenMenu() {
        return hidenMenu;
    }

    public void setHidenMenu(boolean hidenMenu) {
        this.hidenMenu = hidenMenu;
    }

    public String getMailLogin() {
        return mailLogin;
    }

    public void setMailLogin(String mailLogin) {
        this.mailLogin = mailLogin;
    }

    public String getNameSenha() {
        return nameSenha;
    }

    public void setNameSenha(String nameSenha) {
        this.nameSenha = nameSenha;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UsuarioFacade getFacade() {
        return ejbFacade;
    }

    public Usuario prepareCreate() {
        selected = new Usuario();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UsuarioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UsuarioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UsuarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void cancel() {
        this.selected = new Usuario();
    }

    public List<Usuario> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Usuario getUsuario(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public Usuario getUsuario(java.lang.String email) {
        return getFacade().find(email);
    }

    public List<Usuario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Usuario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Usuario.class)
    public static class UsuarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuarioController controller = (UsuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioController");
            return controller.getUsuario(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Usuario) {
                Usuario o = (Usuario) object;
                return getStringKey(o.getIdUsuario());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Usuario.class.getName()});
                return null;
            }
        }

    }

    // PROVISÓRIO PARA TESTE
    public void prepareLogin(ActionEvent event) {
        this.selected = new Usuario();
        this.mailLogin = "";
        this.nameSenha = "";
        this.hidenMenu = true;
        initializeEmbeddableKey();
    }

    // PROVISÓRIO PARA TESTE
    public void login(ActionEvent event) {
        FacesMessage message = null;
        this.selected = new Usuario();
        this.selected.setEmailUsuario(this.mailLogin.equals("") ? null : this.mailLogin);
        this.selected.setSenhaUsuario(this.nameSenha.equals("") ? null : this.nameSenha);
        if (this.selected.getEmailUsuario() != null && !this.selected.getEmailUsuario().equals("") && this.selected.getSenhaUsuario() != null && !this.selected.getSenhaUsuario().equals("")) {
            Usuario usuarioEncontrado = this.getUsuario(this.selected.getEmailUsuario());
            if (usuarioEncontrado != null && usuarioEncontrado.getEmailUsuario().equals(selected.getEmailUsuario())
                    && usuarioEncontrado.getSenhaUsuario().equals(selected.getSenhaUsuario())) {
                this.loggedIn = true;
                this.hidenMenu = false;
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", this.selected.getNmUsuario());
            } else {
                this.loggedIn = false;
                this.hidenMenu = true;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            }
        } else {
            this.loggedIn = false;
            this.hidenMenu = true;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
    }
}
