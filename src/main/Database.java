package main;

/**
 * Created by Olek on 24.03.2017.
 */
public class Database
{
    private Product[] products;
    private int size;

    public Database()
    {
        products = new Product[10];
        size = 0;
        populate();
    }

    public void addProduct(Product product)
    {
        if (size < 10)
        {
            products[size] = product;
            size ++;
        }
    }

    private void populate()
    {
        addProduct(new Product("Apple", 0.19, "0001"));
        addProduct(new Product("Pear", 0.29, "0003"));
        addProduct(new Product("Orange", 0.39, "0004"));
    }

    public Product findProductByCode(String code)
    {
        for (int i = 0; i < size; i ++)
        {
            if (products[i].getCode().equals(code))
            {
                return products[i];
            }
        }
        return null;
    }
}
