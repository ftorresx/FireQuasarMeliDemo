[![LinkedIn][linkedin-shield]][linkedin-url]
<p style="text-align:justify">
  <h3 align="center">Demo API Fuego de Quasar Mercado Libre </h3>
  <p>
    Entregable del challenge  Fuego Quasar Demo, desarrollo de API REST en el lenguaje de programación Java; de acuerdo a los requerimientos técnicos, consta de dos métodos principales <b>GetLocation</b> que recibe como parámetros la distancia de tres puntos o (Satélites) respecto a un punto o (Nave) especifica, que permite calcular la absica y ordenada (X , Y) de la posición de dicho punto o (Nave) en un cuadrante del plano cartesiano.  Para dar solución a este caso de uso se utilizo un método matemático  que permite calcular esta información con los rangos y distancias de por lo menos dos puntos o (Satélites). 
    El otro método <b>GetMessage</b> permite consolidar un mensaje que viene en un vector o matriz unidimensional  de 5 elementos  de cada uno de los puntos o (Satélites) que tienen una posición fija en un lambda de tiempo, para dar solución a este caso de uso se creo un método utilitario que permite fijar la posición del mensaje y consolidar la información para entregarla como respuesta en un tipo de dato String. 
  </p>
</p>

### Arquitectura

Aplicación construida siguiendo los principios de la [Arquitectura Limpia](https://www.freecodecamp.org/news/a-quick-introduction-to-clean-architecture-990c014448d2/), se han 
sugerido los siguientes modulos:  

 - **Config**: Modulo que permite agregar configuración y perfilamiento de la aplicación.
 - **Controller**: Modulo que guarda los posibles controladores de la aplicación.
 - **Enums**: Modulo que guarda los Enums de la aplicación.
 - **Exeption**: Modulo que guarda el manejo dela expection de respuesta al cliente de la aplicación.
 - **Impl**: Modulo que representa la implemntacion de la interface de del dominio de la aplicación.
 - **Misc**: Modulo que permite guardar los miscelaneos y funciones utiliratias de la aplicación.
 - **Model**: Modulo que representa la transformacion de data del dominio.
 - **Service**: Modulo que representa la interface de del dominio de la aplicación.
 - **Usecase**: Modulo que representa los casos de uso del demo.
 


### Construido Con
Esta API fue contruida con el modulo Spring-Boot del Eco-Sistema o Framework Spring que permite ligera y rapidamente desplegar implicitament con TomCat los casos de usos dispuestos; Usando los principios S.O.L.I.D con el lenguaje de programación Java. 
* [Spring Boot](https://spring.io/)
* [Java](https://www.java.com/es/)
* [S.O.L.I.D](https://profile.es/blog/principios-solid-desarrollo-software-calidad/)


## Funcionamiento

A continuacion se realizan unas consideraciones para ejecutar y usar el API local y publicamente.

### Pre-Requisitos e Instalación Local

JDK 8 o Mayor, IDE IntelliJ u otro que permita importar y configurar el archivo   

```build.gradle```

Considerar realizar pruebas en con una herramienta como Postman o Similar para realizar la Peticiones POST y/o GET

## Uso

<b>Caso de Uso Obtener coordenadas dado distancia de 3 satelites </b> 

URL Local :
```http://localhost/topsecret ```

URL AWS Publica  :
```http://ec2-3-15-185-6.us-east-2.compute.amazonaws.com/topsecret```

Para obtener las coordenadas de la (Nave) se debe enviar el en Payload la siguiente información con el metodo POST:

```
{
    "satellites": [
        {
            "name": "kenobi",
            "distance": 670.00,
            "message": [
                "este",
                "MAS",
                "",
                "mensaje",
                ""
            ]
        },
        {
            "name": "skywalker",
            "distance": 200.00,
            "message": [
                "",
                "es",
                "",
                "",
                "secreto"
            ]
        },
        {
            "name": "sato",
            "distance": 400,
            "message": [
                "este",
                "",
                "un",
                "",
                ""
            ]
        }
    ]
}
```
<b>Ejemplo de la respuesta</b> 
```
{
    "position": {
        "x": 99.08368318371419,
        "y": 99.99790089771481
    },
    "message": "este  un mensaje secreto "
}
```

<b>Caso de Uso Obtener coordenadas dado distancia de 1 satelites </b> 

URL Local :
```http://localhost/topsecret_split/?satellite_name=kenobi ```

URL AWS Publica  :
```http://ec2-3-15-185-6.us-east-2.compute.amazonaws.com/topsecret_split/?satellite_name=kenobi```

Para obtener las coordenadas de la (Nave) se debe enviar el en Payload la siguiente información con el metodo POST o GET como se prefira:

```
{
   "distance": 670.00,
            "message": [
                "este",
                "",
                "",
                "mensaje",
                ""
            ]
}
```

## Autor
 <b>Fernando Torres</b> Ingeniero de Software
 
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
* [Img Shields](https://shields.io)
* [Choose an Open Source License](https://choosealicense.com)
* [GitHub Pages](https://pages.github.com)
* [Animate.css](https://daneden.github.io/animate.css)
* [Loaders.css](https://connoratherton.com/loaders)
* [Slick Carousel](https://kenwheeler.github.io/slick)
* [Smooth Scroll](https://github.com/cferdinandi/smooth-scroll)
* [Sticky Kit](http://leafo.net/sticky-kit)
* [JVectorMap](http://jvectormap.com)
* [Font Awesome](https://fontawesome.com)

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=flat-square
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=flat-square
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=flat-square
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=flat-square
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=flat-square
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/ftorresx/
