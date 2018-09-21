
/**
 * Implementação de Lista Simplesmente Encadeada.
 *
 */
public class Lista {

    /**
     * Nó de início da lista.
     */
    private No inicio;

    /**
     * Construtor sem parâmetro.
     *
     */
    public Lista() {
        this.inicio = null; //Inicializa o início da lista com null
    }

    /**
     * Recuperador de início.
     *
     * @return O nó do início da lista.
     */
    public No getInicio() {
        return inicio;
    }

    /**
     * Modificador de início.
     *
     * @param inicio Um nó a ser atribuído ao início da lista.
     */
    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    /**
     * Retorna o valor em String da lista.
     *
     * @return Uma string com o valor do início da lista.
     */
    public String paraString() {
        return "OID: " + this + " / início: " + getInicio();
    }

    /**
     * Insere um nó no início da lista.
     *
     * @param valor Um novo valor de um nó a ser inserido na lista.
     * @return Verdadeiro se conseguiu incluir o nó no início da lista.
     */
    public boolean inserirInicio(int valor) {
        //Instancia o novo nó
        No novo = new No();
        //Atribui o dado ao nó
        novo.setDado(valor);
        //Coloca o primeiro no proximo do novo
        novo.setProximo(getInicio()); 
        //Coloca o novo nó em início
        setInicio(novo); 
        return true;
    }

    /**
     * Insere um nó em uma posição especifica da lista.
     *
     * @param valor Um novo valor de um nó a ser inserido na lista.
     * @param k Posição a ser inserida o valor.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public boolean inserirPosicao(int valor, int k) {
        if (k > 0) {
            if (k > 1) {
                int cont = 1;
                //Recupera o início da lista
                No atual = getInicio(); 
                No anterior = null;
                while ((atual != null) && (cont != k)) {
                    anterior = atual;
                    atual = atual.getProximo();
                    cont = cont + 1;
                }
                if (anterior != null) {
                    //Instancia o novo nó
                    No novo = new No();
                    //Atribui o dado ao nó
                    novo.setDado(valor);
                    novo.setProximo(anterior.getProximo());
                    anterior.setProximo(novo);
                    return true;
                } else {
                    return false;
                }
            } else {
                //Instancia o novo nó
                No novo = new No();
                novo.setDado(valor);
                novo.setProximo(getInicio()); // Coloca o primeiro no proximo do novo
                setInicio(novo); // Coloca o novo no inicio
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * Insere um nó no final da lista.
     *
     * @param valor Um novo valor de um nó a ser inserido na lista.
     * @return Verdadeiro se conseguiu incluir o nó no final da lista.
     */
    public boolean inserirFim(int valor) {
        //Verifica se a lista não está vazia
        if (getInicio() == null) {
            //Instancia o novo nó
            No novo = new No();
            //Atribui o dado ao nó
            novo.setDado(valor);
            setInicio(novo);
            return true;
        } else {
            //Recupera o início da lista
            No atual = getInicio();
            //Para no último nó da lista
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            //Instancia o novo nó
            No novo = new No();
            //Atribui o dado ao nó
            novo.setDado(valor);
            atual.setProximo(novo);
            return true;
        }
    }

    /**
     * Excluir um nó do início da lista.
     *
     * @return Verdadeiro ou falso se excluiu o valor do início.
     */
    public boolean excluirInicio() {
        if (getInicio() != null) {//Verifica se a lista nao esta vazia
            No temp = getInicio(); //Guarda o elemento a ser removido
            setInicio(getInicio().getProximo()); // pula o elemento a ser removido
            temp = null;
            System.gc(); //Desaloca o elemento
            return true;
        } else {
            System.out.println("Excluir início - Lista vazia.");
            return false;
        }
    }

    /**
     * Excluir um Nó da lista pela posição.
     *
     * @param k Posição do nó a ser excluído da lista.
     * @return Verdadeiro ou falso se excluiu o valor da posição.
     */
    public boolean excluirPosicao(int k) {
        if (getInicio() != null) { //Verifica se a lista nao esta vazia
            No temp = null;
            if ((getInicio().getProximo() != null) && (k > 1)) {
                //Recupera o início da lista
                No atual = getInicio(); 
                No anterior = null;
                int cont = 1;
                while ((atual.getProximo() != null) && (cont != k)) {
                    anterior = atual;
                    atual = atual.getProximo();
                    cont = cont + 1;
                }
                temp = atual; //Guarda o elemento a ser removido
                anterior.setProximo(atual.getProximo()); // pula o elemento a ser removido
            } else {
                if (k == 1) {
                    temp = getInicio(); //Guarda o elemento a ser removido
                    setInicio(getInicio().getProximo()); // pula o elemento a ser removido
                }
            }
            temp = null;
            System.gc(); //Desaloca o elemento
            return true;
        } else {
            System.out.println("Excluir posição - Lista vazia.");
            return false;
        }
    }

    /**
     * Excluir um nó do final da lista.
     *
     * @return Verdadeiro ou falso se excluiu o valor do final.
     */
    public boolean excluirFim() {
        if (getInicio() != null) { //Verifica se a lista não esta vázia
            No temp = null;
            if (getInicio().getProximo() != null) { //Com mais de um nó
                //Recupera o início da lista
                No atual = getInicio(); 
                No anterior = null;
                while (atual.getProximo() != null) {
                    anterior = atual;
                    atual = atual.getProximo();
                }
                temp = atual; //Guarda o elemento a ser removido
                anterior.setProximo(atual.getProximo()); // pula o elemento a ser removido
            } else {
                temp = getInicio(); //Guarda o elemento a ser removido
                setInicio(getInicio().getProximo()); // pula o elemento a ser removido
            }
            temp = null;
            System.gc(); //Desaloca o elemento
            return true;
        } else {
            System.out.println("Excluir fim - Lista vazia.");
            return false;
        }
    }

    /**
     * Altera o valor de um Nó da lista pela posição.
     *
     * @param valor Um valor a ser atualizado na posição k da lista.
     * @param k Posição do nó a ser alterado da lista.
     * @return Verdadeiro ou falso se alterou o valor da posição.
     */
    public boolean alterarPosicao(int valor, int k) {
        if (getInicio() != null) {
            //Recupera o início da lista
            No atual = getInicio(); 
            int cont = 1;
            while ((atual.getProximo() != null) && (cont != k)) {
                atual = atual.getProximo();
                cont = cont + 1;
            }
            if (cont == k) {
                atual.setDado(valor);
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Alterar posição - Lista vazia.");
            return false;
        }
    }

    /**
     * Procura lista pela posição.
     *
     * @param k Posição do nó a ser consultada na lista.
     * @return O dado de uma posição k ou -1.
     */
    public int procurarPosicao(int k) {
        if (getInicio() != null) {
            //Recupera o início da lista
            No atual = getInicio(); 
            int cont = 1;
            while ((atual.getProximo() != null) && (cont != k)) {
                atual = atual.getProximo();
                cont = cont + 1;
            }
            if (cont == k) {
                return atual.getDado();
            } else {
                return -1;
            }
        } else {
            System.out.println("Procurar posição - Lista vazia.");
            return -1;
        }
    }
    
    /**
     * Procura o nó da lista pela posição.
     *
     * @param chave Valor a a ser consultado na lista.
     * @return A posição do dado na lista ou -1.
     */
    public int procurarValor(int chave) {
        if (getInicio() != null) {
            //Recupera o início da lista
            No atual = getInicio();             
            int contador = 1;
            while ((atual != null) && (atual.getDado() != chave)) {
                atual = atual.getProximo();                
                contador = contador + 1;
            }
            if (atual != null) {
                return contador;
            } else {
                return -1;
            }
        } else {
            System.out.println("Procurar valor - Dado não existe.");
            return -1;
        }
    }
    
    /**
     * Lista os dados da lista.
     *
     * @return Uma String com os dados da lista.
     */
    public String listar() {
        //Recupera o início da lista
        No atual = getInicio();
        int cont = 0;
        //String de retorno
        String temp = "";
        while (atual != null) {
            cont = cont + 1;
            temp = temp + (cont) + "-" + atual.getDado() + "\n";
            atual = atual.getProximo();
        }
        return temp;
    }

    /**
     * Lista os dados da lista.
     *
     * @return Uma String com os dados da lista e seus endereços.
     */
    public String listarEndereco() {
        //Recupera o início da lista
        No atual = getInicio();
        int cont = 0;
        //String de retorno
        String temp = "";
        temp = temp + "Início = " + atual + "\n";
        while (atual != null) {
            cont = cont + 1;
            temp = temp + (cont) + "- Dado = " + atual.getDado() + " / Endereço = " + atual + " / Próximo = " + atual.getProximo() + "\n";
            atual = atual.getProximo();
        }        
        return temp;
    }

    /**
     * Retorna a quantidade de nós da lista.
     *
     * @return A quantidade de nós da lista.
     */
    public int getQuantidade() {
        int cont = 0;
        //Verifica se a lista não esta vazia
        if (getInicio() != null) {
            //Recupera o início da lista
            No atual = getInicio();
            while (atual != null) {
                cont = cont + 1;
                atual = atual.getProximo();
            }
        }
        return cont;
    }

    /**
     * Retorna se a lista esta vazia.
     *
     * @return Verdadeiro ou falso se a lista está vazia.
     */
    public boolean estaVazia() {
        return getInicio() == null;
    }
}
