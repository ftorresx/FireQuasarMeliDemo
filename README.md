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
Esta API fue contruida con el modulo Spring del Eco-Sistema o Framework Spring que permite ligera y rapidamente desplegar los casos de usos dispuestos junto con el lenguaje de programación Java 
* [Spring Boot](https://spring.io/)
* [Java](https://www.java.com/es/)


<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* npm
```sh
npm install npm@latest -g
```

### Installation

1. Get a free API Key at [https://example.com](https://example.com)
2. Clone the repo
```sh
git clone https://github.com/your_username_/Project-Name.git
```
3. Install NPM packages
```sh
npm install
```
4. Enter your API in `config.js`
```JS
const API_KEY = 'ENTER YOUR API';
```



<!-- USAGE EXAMPLES -->
## Usage

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_



<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/othneildrew/Best-README-Template/issues) for a list of proposed features (and known issues).



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### QuickStart

  - **bootRun**: Corre la aplicaci&oacute;n.
  - **test**: Corre los test unitarios.
  
  Para Demo Omline usar el siguiente Payload
  

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

Your Name - [@your_twitter](https://twitter.com/your_username) - email@example.com

Project Link: [https://github.com/your_username/repo_name](https://github.com/your_username/repo_name)



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
