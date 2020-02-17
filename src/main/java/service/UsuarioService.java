/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import model.Usuario;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 *
 * @author Jr
 */
@Stateless
public class UsuarioService extends AbstractService<Usuario> {

    public UsuarioService() {
        super(Usuario.class);
    }

    @Override
    public Usuario create(Usuario entity) {
       Usuario thisUsuario = entity;
       SimpleHash hash = new SimpleHash("md5", thisUsuario.getSenhaUsuarioNaoCriptografada());
       thisUsuario.setSenhaUsuario(hash.toHex());
       
       return thisUsuario;
    }

    @Override
    public Usuario edit(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario remove(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
