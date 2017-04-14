{
    class FilmSearchController {
        constructor($http, history) {
            this._http = $http;
            this._history = history;
            this.resultC = '';
            this.title = "";
            this.year = 1900;
            this.res = '';

        }

        search() {
            let res = this._history.getResult(this.year, this.title);

            if (res) {
                this.resultC = res.data;
                return;
            }

            let that = this;
            this._http.get(`http://www.omdbapi.com/?t=${this.title}&y=${this.year}`)
                .then(function (result) {
                    that._history.setResult(that.year, that.title, result);
                    console.log("success", result.data);
                    that.resultC = result.data;
                },
                function () {
                    console.log("error");
                });

        }
    }

    angular
        .module("app")
        .component(
        "filmSearchComponent",
        {
            controller: FilmSearchController,
            controllerAs: "ex",
            templateUrl: "app/components/filmsearch/filmsearch.component.html"
        });
}
