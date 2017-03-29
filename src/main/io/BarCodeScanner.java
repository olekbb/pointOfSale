package main.io;

/**
 * Created by Olek on 24.03.2017.
 */
public class BarCodeScanner
{
    private String[] codes;
    private int codeIterator;

    public BarCodeScanner()
    {
        codes = new String[10];
        codes[0] = "0001";
        codes[1] = "0002";
        codes[2] = "";
        codes[3] = "0003";
        codeIterator = 0;
    }
    public String scan()
    {
        String codeToReturn = codes[codeIterator++ % 4];
        return codeToReturn;
    }
}
