
import Modelos.DBData;
import Modelos.ModeloClientes;
import Clases.clsCliente;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


public class PruebasReto {
    DBData dbData;
    
    @InjectMocks
    ModeloClientes modeloClientes;
    
    @InjectMocks
    clsCliente clsCliente; 
    
    public PruebasReto() {
        dbData = new DBData();
        modeloClientes = new ModeloClientes(); 
        clsCliente = Mockito.mock(clsCliente.class);
        
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void getDriver() {
        assertEquals("com.mysql.jdbc.Driver",dbData.getDriver());
    }
    @Test
    public void getUser() {
        assertEquals("root",dbData.getUser());
    }
    @Test
    public void getPassword() {
        assertEquals("",dbData.getPassword());
    }
    @Test
    public void getUrl() {
        assertEquals("jdbc:mysql://localhost:3306/sim",dbData.getUrl());
    }
    @Test
    public void getCliente(){
        String documento="111111";
        assertEquals(null,modeloClientes.getCliente(documento));
    }
    
}
