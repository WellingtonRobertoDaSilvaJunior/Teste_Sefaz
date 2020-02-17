/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Usuario;
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
public class UsuarioControllerTest {
    
    public UsuarioControllerTest() {
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
     * Test of getSelected method, of class UsuarioController.
     */
    @Test
    public void testGetSelected() {
        System.out.println("getSelected");
        UsuarioController instance = new UsuarioController();
        Usuario expResult = null;
        //Usuario result = instance.getSelected();
        //assertEquals(expResult, result);
    }

    /**
     * Test of initializeEmbeddableKey method, of class UsuarioController.
     */
    @Test
    public void testInitializeEmbeddableKey() {
        System.out.println("initializeEmbeddableKey");
        UsuarioController instance = new UsuarioController();
        //instance.initializeEmbeddableKey();
    }

    /**
     * Test of prepareCreate method, of class UsuarioController.
     */
    @Test
    public void testPrepareCreate() {
        System.out.println("prepareCreate");
        UsuarioController instance = new UsuarioController();
        Usuario expResult = null;
        //Usuario result = instance.prepareCreate();
        //assertEquals(expResult, result);
    }

    /**
     * Test of create method, of class UsuarioController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        UsuarioController instance = new UsuarioController();
        //instance.create();
    }

    /**
     * Test of update method, of class UsuarioController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        UsuarioController instance = new UsuarioController();
        //instance.update();
    }

    /**
     * Test of destroy method, of class UsuarioController.
     */
    @Test
    public void testDestroy() {
        System.out.println("destroy");
        UsuarioController instance = new UsuarioController();
        //instance.destroy();
    }

    /**
     * Test of getItems method, of class UsuarioController.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        UsuarioController instance = new UsuarioController();
        List<Usuario> expResult = null;
        //List<Usuario> result = instance.getItems();
        //assertEquals(expResult, result);
    }

    /**
     * Test of getUsuario method, of class UsuarioController.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        Integer id = null;
        UsuarioController instance = new UsuarioController();
        Usuario expResult = null;
        //Usuario result = instance.getUsuario(id);
        //assertEquals(expResult, result);
    }

    /**
     * Test of getItemsAvailableSelectMany method, of class UsuarioController.
     */
    @Test
    public void testGetItemsAvailableSelectMany() {
        System.out.println("getItemsAvailableSelectMany");
        UsuarioController instance = new UsuarioController();
        List<Usuario> expResult = null;
        //List<Usuario> result = instance.getItemsAvailableSelectMany();
        //assertEquals(expResult, result);
    }

    /**
     * Test of getItemsAvailableSelectOne method, of class UsuarioController.
     */
    @Test
    public void testGetItemsAvailableSelectOne() {
        System.out.println("getItemsAvailableSelectOne");
        UsuarioController instance = new UsuarioController();
        List<Usuario> expResult = null;
        //List<Usuario> result = instance.getItemsAvailableSelectOne();
        //assertEquals(expResult, result);
    }
    
}
