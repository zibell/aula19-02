class Gasto {
  constructor(valor, data, categoria, descricao){
    this.valor=valor;
    this.data=data;
    this.categoria=categoria;
    this.descricao=descricao;
  }
  adicionar() {
    console.log(this.valor);
  }
}

var g = new Gasto(10, 'a',2,'c');
g.adicionar();
