package dao;

import domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements IClienteDAO{

    private Map<Long, Cliente> map;

    public ClienteMapDAO(){
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())) {
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }


    @Override
    public Cliente excluir(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);

        if (clienteCadastrado != null){
            this.map.remove(clienteCadastrado.getCpf(),clienteCadastrado);
        }
        return clienteCadastrado;
    }
    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteAlterar = this.map.get(cliente.getCpf());

        if (clienteAlterar != null){
            clienteAlterar.setNome(cliente.getNome());
            clienteAlterar.setTel(cliente.getTel());
            clienteAlterar.setCidade(cliente.getCidade());
            clienteAlterar.setEnd(cliente.getEnd());
            clienteAlterar.setNumero(cliente.getNumero());
            clienteAlterar.setEstado(cliente.getEstado());
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}
