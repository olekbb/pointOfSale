package test;

import main.Database;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by Olek on 24.03.2017.
 */
public class DatabaseTest
{
    Database database;

    @Before
    public void initialize()
    {
        database = new Database();
    }

    @Test
    public void shouldNotFindProductWithWrongCode()
    {

        Assert.assertEquals(null, database.findProductByCode("This is a wrong product code"));
    }

    @Test
    public void shouldFindProduct()
    {
        Assert.assertNotNull(database.findProductByCode("0001"));
    }
}
