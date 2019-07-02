
export default class LS {
    constructor() {
      this.storageName = 'carteira-virtual'
    }
    o2s = (obj) => {
      return JSON.stringify(obj)
    }
    s2o = (str) => {
      return JSON.parse(str)
    }
    set add(registro) {
      let current = this.s2o(localStorage.getItem(this.storageName)) || []
      current.push(registro)
      localStorage.setItem(this.storageName, this.o2s(current))
    }
    set addAll(registros) {
      localStorage.setItem(this.storageName, this.o2s(registros))
    }
    getAll() {
      return this.s2o(localStorage.getItem(this.storageName)) || []
    }
  }
  window.getAll = getAll
