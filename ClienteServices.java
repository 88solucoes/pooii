package br.senac.ads.model;

import java.util.ArrayList;
import java.util.List;

public class ClienteServices {

    private List<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(int id, String nome, String telefone) {

        if (nome == null || nome.isEmpty()) {
            System.out.println("Nome do cliente não pode ser vazio.");
            return;
        }

        if (buscarClientePorId(id) != null) {
            System.out.println("Já existe um cliente com esse ID.");
            return;
        }

        Cliente cliente = new Cliente(id, nome, telefone);
        clientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso.");
    }

    public void listarClientes() {

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (Cliente cliente : clientes) {
            cliente.exibirCliente();
            System.out.println("---------------------");
        }
    }

    public Cliente buscarClientePorId(int id) {

        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }

        return null;
    }

    public void removerClientePorId(int id) {

        Cliente cliente = buscarClientePorId(id);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        clientes.remove(cliente);
        System.out.println("Cliente removido com sucesso.");
    }
}