package Aplicaçoes_Sistema_estoque;

public class Requisicao {
    private int id_requisicao;
    private int id_usuario;
    private int id_material;
    private int quantidade;

    public Requisicao(int id_requisicao, int id_usuario, int id_material, int quantidade) {
        this.id_requisicao = id_requisicao;
        this.id_usuario = id_usuario;
        this.id_material = id_material;
        this.quantidade = quantidade;
    }

    public int getId_requisicao() {
        return id_requisicao;
    }

    public void setId_requisicao(int id_requisicao) {
        this.id_requisicao = id_requisicao;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

