
export default class firebaseStorage {
    constructor() {
      this.storageName = 'registros'
      this.database = firebase.database()

      this.database.ref(this.storageName).on('value', (snapshot) => {
        if (snapshot.val() != null) {
          let dados = Object.values(snapshot.val())
          gerarHtmlHistorico(dados)
        }
      })
    }
    
    set add(registro) {
      let novoRegistro = this.database.ref(this.storageName).push()
      novoRegistro.set(registro)
    }
  }
