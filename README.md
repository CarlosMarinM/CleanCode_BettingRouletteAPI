# Clean Code
## Betting Roulette API
Esta API fue desarrollada en lenguaje Java 1.8 con Spring Boot 2.2.6. La persistencia de datos se realizó con Redis 3.2.1 y Jedis 3.1.0. A continuación, se listan los endpoints disponibles en el servicio.
#### Creación de nueva ruleta
`http://"host_domain"/ruleta`
> Tipo: POST
> Body: No requiere
> Response: Identificador de la ruleta
#### Abrir apuestas para un ID de ruleta
`http://"host_domain"/ruleta/{idRoulette}/abrirApuestas`
> Tipo: PUT
> Body: No requiere
#### Cerrar apuestas para un ID de ruleta
`http://"host_domain"/ruleta/{idRoulette}/cerrarApuestas`
> Tipo: PUT
> Body: No requiere
#### Buscar todas las ruletas creadas con sus estados
`http://"host_domain"/ruleta`
> Tipo: GET
> Body: No requiere
> Response: Listado de ruletas
#### Apostar a un numero una cantidad determinada de dinero a una ruleta abierta
`http://"host_domain"/apuesta/ruleta/{idRoulette}`
> Tipo: PUT
> Body: Requerido
```
{
	"user": {
		"id": "e7938491-b251-47aa-8746-270d747ced98"
	},
	"quantity": 5000.0,
	"number": 15
}
```
#### Creación de nuevo usuario
`http://"host_domain"/usuario`
> Tipo: PUT
> Body: No requiere
> Response: Identificador del usuario