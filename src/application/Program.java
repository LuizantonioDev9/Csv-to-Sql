package application;

import model.entities.Sql;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        List<Sql> list = new ArrayList<>();

        System.out.println("Entre com o caminho do arquivo: ");
        //formato .csv
        String sourceFolderStr = sc.nextLine();
        File sourceFile = new File(sourceFolderStr);

        //caminho da pasta
        String sourceFileStr = sourceFile.getParent();

        //criar a pasta
        boolean success = new File(sourceFileStr + "\\out").mkdir();

        String targetSourceFile = sourceFileStr + "\\out\\newTable.sql";

        try(BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            String itemCsv = br.readLine();
            while(itemCsv != null) {
                String[] folders = itemCsv.split(",");
                Integer codigo = Integer.parseInt(folders[0]);
                double price = Double.parseDouble(folders[1]);
                list.add(new Sql(codigo,price));
                System.out.println(itemCsv);
                itemCsv = br.readLine();
            }

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetSourceFile))) {
                for(Sql item : list) {
                    bw.write("INSERT INTO TABELA_PRECO_AUX VALUES('" + item.getCodigo() + "'," + item.getPrice() + ");");
                    bw.newLine();
                }
            }
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
