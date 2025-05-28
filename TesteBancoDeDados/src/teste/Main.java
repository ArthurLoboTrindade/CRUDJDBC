/*
PRIMEIRO CRIE SEU BANCO DE DADOS E ABRA ELE, CRIE SEU BANCO E ALTERE OS DADOS NAS OUTRAS CLASSES
CRIE A TABELA PELO SEU POSTGRES OU PGADMIN 
*/
package teste;

import java.io.IOException;
import java.util.List;

import entidade.CreateTable;
import entidade.Pessoa;
import entidade.PessoaDAO;

public class Main {
    public static void main(String[] args) throws IOException {   	
    	PessoaDAO dao = new PessoaDAO();
        CreateTable tableManager = new CreateTable();
        
        System.out.println("CRIANDO TABELA NO BANCO SELECIONADO..."); // MUDE O BANCO NA CLASSE CONEXÃO
        //CREATE TABLE NO BANCO 
        tableManager.createPessoaTable();
        System.out.println("");
        System.out.println("INICIANDO CRUD...");
        System.out.println("");

        System.out.println("INSERINDO DADOS NA TABELA PESSOA");

        // CREATE
        Pessoa nova = new Pessoa();
        nova.setNome("João");
        nova.setEmail("joao@email.com");
        dao.criar(nova);
        System.out.println("Aperte enter para próxima etapa");
        System.in.read();

        // READ
        System.out.println("LISTANDO");
        List<Pessoa> lista = dao.listar();
        for (Pessoa p : lista) {
            System.out.println(p.getId() + " - " + p.getNome() + " - " + p.getEmail());
        }
        System.out.println("Aperte enter para próxima etapa");
        System.in.read();

        // UPDATE
        System.out.println("UPDATE");
        if (!lista.isEmpty()) {
            Pessoa primeira = lista.get(0);
            primeira.setNome("João Atualizado");
            dao.atualizar(primeira);
        }
        System.out.println("Aperte enter para próxima etapa");
        System.in.read();
        
        // DELETE
        if (!lista.isEmpty()) {
            dao.deletar(lista.get(0).getId());
        }
        System.out.println("FINALIZADO");
    }
}

