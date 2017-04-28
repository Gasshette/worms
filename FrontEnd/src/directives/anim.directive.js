{
    "use strict";
    function animCloud($interval) {
        return {
            scope: {
                nbr: "<",
                max: '<',
                min: '<'
            },

            restrict: 'EA',
            link: function (scope, elements, attrs) {
                const HEIGHT = 168, WIDTH = 296;

                let clouds = [],
                    el = elements[0], //directive tag
                    parent = el.parentNode, //jumbotron
                    cloudImage = el.querySelector("img"), //cloud image inside the directive
                    max = scope.max,
                    min = scope.min,
                    diff = max - min;

                // set default styles
                parent.style.position = 'relative';
                el.style.position = 'absolute';



                // create clones
                for (var index = 0; index < scope.nbr; index++) {

                    let defaultRand = Math.random(),
                        speed = null,
                        coeff = Math.random() * diff + (max - diff),
                        height = coeff * HEIGHT,
                        width = coeff * WIDTH,
                        clone = el.cloneNode(true),
                        x = 0,
                        y = 0;

                    let defaultSpeed = defaultRand < 0.3 ? 0.3 : defaultRand;
                    speed = defaultSpeed*300;

                    //Ser the ramdom position of the clone inside the header
                    clone.style.height = height + 'px';
                    clone.style.width = width + 'px';
                    clone.style.opacity = coeff-0.2;
                    x = Math.random() * parent.offsetWidth - (width/2);
                    y = Math.random() * parent.offsetHeight- (height);

                    parent.appendChild(clone);
                    clone.style.left = x + 'px';
                    clone.style.top = y + 'px';
                    clone.style.display = 'inline-block';
                    clouds.push(clone);

                    //Execute lamba method running every random miliseecond to make the cloud moving from left to right
                    //If the cloud get out of the screen then he come back from the left side
                    $interval(() => {
                        x = (x >= parent.offsetWidth) ? -width : x+1 ;
                        clone.style.left = x + 'px';
                    }, speed);
                }
            },
        };

    }

    angular
        .module("app")
        .directive('animCloud', ['$interval', animCloud]);
}