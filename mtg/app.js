const app = document.querySelector("#app")

const componentDate = () => {
  let template = `<input type="date" format="dd/MM/yyyy"/>`
  let element = document.createRange().createContextualFragment(template)
  element.querySelector('input').value = new Date().toISOString().substr(0, 10);
  return element
}

const componentValor = () => {
  let template = `<input type="number" placeholder="R$">`
  let element = document.createRange().createContextualFragment(template)
  return element
}

const componentCategorias = () => {
  let template = `<input type="text" placeholder="Categorias">`
  let element = document.createRange().createContextualFragment(template)
  return element
}
const componentDescricao = () => {
  let template = `<input type="text" placeholder="Descricao">`
  let element = document.createRange().createContextualFragment(template)
  return element
}

const componentSalvar = () => {
  let template = `<button>Salvar</button>`
  let element = document.createRange().createContextualFragment(template)
  return element

}

app.appendChild(componentDate())
