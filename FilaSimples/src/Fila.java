public class Fila<T> {

//    private No<T>[] no;
    private int tamanho;
    private No<T> inicio;
    private No<T> fim;
//    private final int TAMANHOINICIAL = 10;

    public Fila() {
        this.tamanho = 0;
//        this.no = new No[TAMANHOINICIAL];
    }

    public int getTamanho() {
        return tamanho;
    }

    public T getInicio() {
        return inicio.getConteudo();
    }

    public T getFim() {
        return fim.getConteudo();
    }



    public void adicionar(No<T> no){
//        this.noCheio();

        if (this.tamanho == 0) {
            this.inicio = no;

        } else{
            this.fim.setProximo(no);
            //            this.no[tamanho] = no;

        }
        this.fim = no;
        tamanho++;

    }

    public T espiar(int posicao) throws Exception {
        filaVazia();

        if(posicao > tamanho) {
            throw new Exception("Posição inválida");

        }else if (posicao == 1) {
            return this.inicio.getConteudo();

        } else{
            No<T> auxPosicao = this.inicio;

            for (int i = 0; i < posicao; i++) {
                if (i != posicao-1) {
                    auxPosicao = auxPosicao.getProximo();
                }
            }
            return auxPosicao.getConteudo();
        }
    }

    public String procurar(T conteudo){
        int busca = busca(conteudo);
        if (busca == -1) {

            return "Conteudo não existe.";
        } else {
            return String.valueOf(busca);
        }
    }
    private int busca(T conteudo){
        No<T> auxPosicao = this.inicio;
        int i = 0;
        for (; i < tamanho; i++) {
            if (auxPosicao.getConteudo().equals(conteudo)) {
                return i+1;
            } else {
                auxPosicao = auxPosicao.getProximo();
            }
        }
        return -1;
    }

    public void avancarFila() throws Exception {
        filaVazia();
        if (tamanho == 1){
            this.removeInicio();

        }else{
            No<T> aux = this.inicio;
            this.inicio = aux.getProximo();
            aux.setProximo(null);
        }
        this.tamanho--;

    }

    public void remover(int posicao) throws Exception {

        filaVazia();
        if(posicao > tamanho) {
            throw new Exception("Posição inválida");

        }else if (tamanho == 1) {
            this.removeInicio();

        } else if (posicao == 1) {
            No<T> aux = this.inicio;
            this.inicio = aux.getProximo();
            aux.setProximo(null);
            this.tamanho--;

        }else{
            No<T> auxPosicao = this.inicio;
            No<T> auxAnterior = null;

            for (int i = 0; i < posicao; i++) {
                if (i != posicao-1) {
                    auxAnterior = auxPosicao;
                    auxPosicao = auxPosicao.getProximo();
                }
            }
            auxAnterior.setProximo(auxPosicao.getProximo());
            auxPosicao.setProximo(null);
            this.tamanho--;
        }
    }

    private void removeInicio(){
        this.inicio = null;
        this.fim = null;
        this.tamanho --;
    }

    private void filaVazia() throws Exception {
        if (tamanho == 0){
            throw new Exception("Fila Vazia");

        }
    }

/*
    private void noCheio(){
        if (this.tamanho == this.no.length){
            No<T>[] novoNo = new No[this.no.length*2];

            for (int i = 0; i < no.length; i++) {
                novoNo[i] = no[i];
            }

            this.no = novoNo;
        }
    }
*/

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("Inicio-> {");
        b.append(inicio);
        b.append("}");

        return b.toString();
    }
}
