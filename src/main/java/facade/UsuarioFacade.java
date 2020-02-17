/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Usuario;
import service.UsuarioService;

/**
 *
 * @author Jr
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @EJB
    private UsuarioService usuarioService;

    @PersistenceContext(unitName = "wellington_Desafio_Sefaz_war_3.6.3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void create(Usuario entity) {
        getEntityManager().persist(this.usuarioService.create(entity));
    }

    public Usuario find(String email) {
        return getEntityManager()
                .createNamedQuery("Usuario.findByEmailUsuario", Usuario.class)
                .setParameter("emailUsuario", email)
                .getSingleResult();
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

}
