# Proyecto enfocado a los microservicios

## ¿Qué son los microservicos y para qué se usan?
_El enfoque tradicional para el diseño de aplicaciones se centraba en la arquitectura monolítica, en que todos los elementos
que pueden implementarse estaban contenidos en una sola aplicación. Este enfoque tiene sus desventajas: cuanto más grande es
la aplicación, más difícil es solucionar los problemas que se presentan y agregar funciones nuevas rápidamente. En cambio, si
las aplicaciones se diseñan con microservicios, se resuelven dichos problemas y se impulsa el desarrollo y la capacidad de respuesta._

Los microservicios son tanto un estilo de arquitectura como un modo de programar software. Con los microservicios,
las aplicaciones se dividen en sus elementos más pequeños e independientes entre sí. A diferencia del enfoque tradicional
y monolítico de las aplicaciones, en el que todo se compila en una sola pieza, los microservicios son elementos independientes
que funcionan en conjunto para llevar a cabo las mismas tareas. Cada uno de esos elementos o procesos es un microservicio.
Este enfoque de desarrollo de software valora el nivel de detalle, la sencillez y la capacidad para compartir un proceso similar
en varias aplicaciones. Es un elemento fundamental de la optimización del desarrollo de aplicaciones hacia un modelo nativo de la nube.

En resumen, un micro servicio se define como una unidad funcional y concreta que traban juntas para ofrecer la funcionalidad general de
una aplicación. Los microservicios pueden ser actualizados sin que esto afecte la **DISPONIBILIDAD** de las demás unidades. (Una practica recomendable
es que cada microservico posea su propia base de datos, para no afectar a las demás unidades), los microservicios derivan de equipos de trabajo que poseen
una ubicacion geografica diferente, donde cada desarrollador está encargado de una tarea en especifico, por ello se requiere o se aconseja
que poseen una base diferente para sus funcionalidades, su ventaja es la optimización de las respuestas pero puede derivar en problemas tales como:
* las bases de datos pueden ser tanto NoSQL o SQL dependiendo de la aplicabilidad del servicio, no obstante se puede requerir cierto consumo de datos
  de un servicio a otro, pero esto puede ser solucionado ocn un JOIN que enlaza base de datos como lo es el API FACADE COMPOSITION, y las transacciones distribuidas
  se pueden solucionar con un BROKER o el patrón SAGA.
* Cada microservicio se encuentra en un servidor diferente, lo cual es una ventaja grande a comparación de las aplicaciones monoliticas.
    * Un codigo monolito, presente un fuerte acoplamiento arquitectonico entre sus componentes funcionales; al ejecutarse la aplicación como un único sistema lógico,
      no es posible introducir mejoras en un componente sin tener que re-desplegar la aplicación.
    * Un código monolito, hay que escalar la aplicación completa independientemente si las necesidades de la aplicación las tenemos en un solo modulo.
    * La resiliencia o tolerancia a fallos es menor, dado a que si llega a fallar un modulo, todos los modulos pueden fallar.

  A comparación de una aplicación de microservios donde:
    * El código fuente será mucho menor.
    * Mayor resiliencia de la aplicación.
    * Cada modulo se despliega de manera independiente al resto.
    * Cada equipo de desarrollo es responsable de todo el ciclo de un servicio.
    * Los microservicios permiten la interoperabilidad, es decir se pueden trabajar em diferentes tecnologias (Java, Node.Js, .NET, etc). lo que no limita la aplicación
      en su fase de desarrollo.


# ¿Qué se pretende desarrollar en este proyecto?
- La implemntación de microservicios los cuales, permitan el uso de un CRUD básico donde: se esta restringiendo el manejo de las rutas y peticiones si se tiene una autenticación o no.


