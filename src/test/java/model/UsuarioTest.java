/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jr
 */
public class UsuarioTest {
    
    public UsuarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSenhaUsuario method, of class Usuario.
     */
    @Test
    public void testGetSenhaUsuario() {
        System.out.println("getSenhaUsuario");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.getSenhaUsuario();
        //assertEquals(expResult, result);
    }

    /**
     * Test of setSenhaUsuario method, of class Usuario.
     */
    @Test
    public void testSetSenhaUsuario() {
        System.out.println("setSenhaUsuario");
        String senhaUsuario = "";
        Usuario instance = new Usuario();
        instance.setSenhaUsuario(senhaUsuario);
    }

    /**
     * Test of getSenhaUsuarioNaoCriptografada method, of class Usuario.
     */
    @Test
    public void testGetSenhaUsuarioNaoCriptografada() {
        System.out.println("getSenhaUsuarioNaoCriptografada");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.getSenhaUsuarioNaoCriptografada();
        //assertEquals(expResult, result);
    }

    /**
     * Test of setSenhaUsuarioNaoCriptografada method, of class Usuario.
     */
    @Test
    public void testSetSenhaUsuarioNaoCriptografada() {
        System.out.println("setSenhaUsuarioNaoCriptografada");
        String senhaUsuarioNaoCriptografada = "";
        Usuario instance = new Usuario();
        instance.setSenhaUsuarioNaoCriptografada(senhaUsuarioNaoCriptografada);
    }

}
