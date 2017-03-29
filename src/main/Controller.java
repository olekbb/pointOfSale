package main;

import main.io.BarCodeScanner;
import main.io.Display;
import main.io.Printer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Olek on 24.03.2017.
 */
public class Controller
{
    private BarCodeScanner barCodeScanner;
    private Display display;
    private Printer printer;
    private Database database;
    private BufferedReader stdin;
    private String receipt;
    private double sum;

    public Controller() throws IOException
    {
        barCodeScanner = new BarCodeScanner();
        display = new Display();
        printer = new Printer();
        database = new Database();
        receipt = "";
        sum = 0.0;
        stdin = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException
    {
        for (int i = 0; i < 4; i ++)
        {
            scan();
        }

        while(true)
        {
            display.display(">");
            String cmd = stdin.readLine();
            if (cmd.equals("exit"))
            {
                printer.print(receipt + "\nTotal: $" + sum);
                break;
            }
            else
            {
                display.display("No such command.");
            }
        }
    }
    private void scan()
    {
        String code = barCodeScanner.scan();
        if (code.equals(""))
        {
            display.display("Invalid bar-code.");
        } else
        {
            Product product = database.findProductByCode(code);
            if (product != null)
            {
                String itemData = "\nItem name: " + product.getName() + "\n" + "Item price: " +
                        product.getPrintablePrice();
                display.display(itemData);
                receipt += itemData;
                sum += product.getPrice();
            }
            else
            {
                display.display("Product not found.");
            }
        }
    }
}
