package aplicacao;

import entidades.Aluno;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        
        /* O programa pede ao usuario quantos alunos vão fazer matricula, armazena em uma lista e no final cria um relatorio.txt
        para guardar as informaçoes desses cadastros */
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Aluno> lista = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Quantos alunos vão fazer matricula? ");
        int x = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < 3; i++){
            int id = lista.size() + 1;
            System.out.print("Nome do aluno: ");
            String nome = sc.nextLine();
            System.out.print("Data da matricula no formato (dd/MM/yyyy):");
            Date data = sdf.parse(sc.next());
            sc.nextLine();
            lista.add(new Aluno(id,nome,data));
            System.out.println("----------");
        }
        
        Collections.sort(lista);
        
        System.out.print("Informe o caminho para guardar as informações: ");
        String caminho = sc.nextLine();
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))){
            for(Aluno a : lista){
                bw.write(a.toString());
                bw.newLine();
            }
        }
        catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        finally{
            if(sc != null){
                sc.close();
            }
        }
    }
    
}
