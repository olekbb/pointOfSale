package main;

/**
 * Created by Olek on 24.03.2017.
 */
public class Product
{
    private String name;
    private double price;
    private String code;

    public Product (String name, double price, String code)
    {
        this.name = name;
        this.price = price;
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public String getCode()
    {
        return code;
    }

    public String getPrintablePrice()
    {
        return "$" + price;
    }
}
