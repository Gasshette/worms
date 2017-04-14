{
    class History {
        constructor() {
            this.requestBuffer = {};
        }

        getBuffer(){
            return this.requestBuffer;
        }
        getResult(date, titre){
            console.log(this.getBuffer());
            let hash = date + titre;
            return this.requestBuffer[hash];
        }

        setRequest(date, titre) {
            let hash = date + titre;
            this.requestBuffer[hash] = null;
        }

        setResult(date, titre, result) {
            let hash = date + titre;
            this.requestBuffer[hash] = result;
        }

    }

    angular
        .module("app")
        .service('history', History);
}