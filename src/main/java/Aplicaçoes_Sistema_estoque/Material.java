package Aplicaçoes_Sistema_estoque;

public class Material {
    private int id_material;
    private String descricao_curta;
    private String descricao_Longa;
    private int quantidade;
    private String unidade_Medida;
    private String deposito;

    public Material(int id_material, String descricao_curta, String descricao_Longa, int quantidade, String unidade_Medida, String deposito){
        this.id_material = id_material;
        this.descricao_curta = descricao_curta;
        this.descricao_Longa = descricao_Longa;
        this.quantidade = quantidade;
        this.unidade_Medida = unidade_Medida;
        this.deposito = deposito;
    }

    public String getDeposito() {

        return deposito;
    }

    public void setDeposito(String deposito) {

        this.deposito = deposito;
    }

    public String getUnidade_Medida() {

        return unidade_Medida;
    }

    public void setUnidade_Medida(String unidade_Medida) {

        this.unidade_Medida = unidade_Medida;
    }

    public int getQuantidade() {

        return quantidade;
    }

    public void setQuantidade(int quantidade) {

        this.quantidade = quantidade;
    }

    public String getDescricao_Longa() {

        return descricao_Longa;
    }

    public void setDescricao_Longa(String descricao_Longa) {

        this.descricao_Longa = descricao_Longa;
    }

    public String getDescricao_curta() {

        return descricao_curta;
    }

    public void setDescricao_curta(String descricao_curta) {

        this.descricao_curta = descricao_curta;
    }

    public int getId_material() {

        return id_material;
    }

    public void setId_material(int id_material) {

        this.id_material = id_material;
    }

    @Override
    public String toString() {
        return "Produto-\n" +
                "ID: " + id_material + "\n" +
                "Nome do Material: " + descricao_curta + "\n"+
                "Descriçaõ do Material: " + descricao_Longa + "\n" +
                "Unidade de Medida: " + unidade_Medida + "\n" +
                "Quantidade do Material: " + quantidade + "\n" +
                "Deposito: " + deposito + "\n";
    }

}


