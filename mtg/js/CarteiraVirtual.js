// import LS from './LS.js'
import firebaseStorage from './firebaseStorage.js'

export default class CarteiraVirtual extends firebaseStorage {
    constructor() {
        super()
    }

    removerItem = (index) => {
        console.log(this);
        let atuais = this.getAll()
        
        atuais.splice(index, 1)
        this.addAll = atuais
    }
}
