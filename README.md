


# Eldar Challenge

**Ejercicio 1**

La salida se muestra en consola. Las llamadas a los métodos se encuentran en el main que lanza la aplicación de SpringBoot **EldarApplication.java** en el mismo proyecto que el ejercicio 2.

**Ejercicio 2**

La aplicación tiene activo el cliente de Swagger-ui, igualmente dejo adjunto la collection de Postman.

Dejo activado los “mensajes sensibles de error” que muestran info acerca de los objetos entre otros atributos.

Host: [https://eldarchallenge.onrender.com](https://eldarchallenge.onrender.com/v1/payments/consult-fee)

Swagger-ui: [https://eldarchallenge.onrender.com/swagger-ui/index.html](https://eldarchallenge.onrender.com/v1/payments/consult-fee)

Ejemplo de consulta de tasa

GET [https://eldarchallenge.onrender.com/v1/payments/consult-fee](https://eldarchallenge.onrender.com/v1/payments/consult-fee)

Body Json


```
    {
        "brand": "AMEX",
        "amount": 950
    }
```


Ejemplo de pago/compra

Este metodo no tiene lógica implementada pero pueden utilizarlo para verificar la validación de fecha de vencimiento al utilizar la tarjeta vencida de “Juan Perez”.

POST [https://eldarchallenge.onrender.com/v1/payments/purchase](https://eldarchallenge.onrender.com/v1/payments/consult-fee)

Body Json


```
    {
        "card": {
            "brand": "NARA",
            "number": "2222 2222 2222 2222",
            "card_holder": "Maria Almeria",
            "due_date": "2026-09-11T00:00:00.00"
        },
        "amount": 980
    }
```


**Tienen disponibles los siguientes datos en h2**

Tabla `brand_card`


<table>
  <tr>
   <td><a href="http://localhost:8080/h2-console/query.do?jsessionid=6b1155161c88e03a52366b62fdc932a4#">ID_BRAND_CARD  </a>
   </td>
   <td><a href="http://localhost:8080/h2-console/query.do?jsessionid=6b1155161c88e03a52366b62fdc932a4#">ID_FEE  </a>
   </td>
   <td><a href="http://localhost:8080/h2-console/query.do?jsessionid=6b1155161c88e03a52366b62fdc932a4#">NAME  </a>
   </td>
  </tr>
  <tr>
   <td>1
   </td>
   <td>1
   </td>
   <td>VISA
   </td>
  </tr>
  <tr>
   <td>2
   </td>
   <td>2
   </td>
   <td>NARA
   </td>
  </tr>
  <tr>
   <td>3
   </td>
   <td>3
   </td>
   <td>AMEX
   </td>
  </tr>
</table>


Tabla `cards`


<table>
  <tr>
   <td><a href="http://localhost:8080/h2-console/query.do?jsessionid=6b1155161c88e03a52366b62fdc932a4#">DUE_DATE  </a>
   </td>
   <td><a href="http://localhost:8080/h2-console/query.do?jsessionid=6b1155161c88e03a52366b62fdc932a4#">ID_BRAND  </a>
   </td>
   <td><a href="http://localhost:8080/h2-console/query.do?jsessionid=6b1155161c88e03a52366b62fdc932a4#">ID_CARDS  </a>
   </td>
   <td><a href="http://localhost:8080/h2-console/query.do?jsessionid=6b1155161c88e03a52366b62fdc932a4#">CARD_HOLDER  </a>
   </td>
   <td><a href="http://localhost:8080/h2-console/query.do?jsessionid=6b1155161c88e03a52366b62fdc932a4#">NUMBER  </a>
   </td>
  </tr>
  <tr>
   <td>2022-09-11
   </td>
   <td>1
   </td>
   <td>1
   </td>
   <td>Juan Perez
   </td>
   <td>1111 1111 1111 1111
   </td>
  </tr>
  <tr>
   <td>2026-09-11
   </td>
   <td>2
   </td>
   <td>2
   </td>
   <td>Maria Almeria
   </td>
   <td>2222 2222 2222 2222
   </td>
  </tr>
  <tr>
   <td>2026-09-11
   </td>
   <td>3
   </td>
   <td>3
   </td>
   <td>Alfonso Ortiz
   </td>
   <td>3333 3333 3333 3333
   </td>
  </tr>
</table>


Tabla `fees`


<table>
  <tr>
   <td><a href="http://localhost:8080/h2-console/query.do?jsessionid=6b1155161c88e03a52366b62fdc932a4#">ID_FEE  </a>
   </td>
   <td><a href="http://localhost:8080/h2-console/query.do?jsessionid=6b1155161c88e03a52366b62fdc932a4#">MATH_EXPRESSION  </a>
   </td>
  </tr>
  <tr>
   <td>1
   </td>
   <td>year / month
   </td>
  </tr>
  <tr>
   <td>2
   </td>
   <td>day * default_value
   </td>
  </tr>
  <tr>
   <td>3
   </td>
   <td>month * default_value
   </td>
  </tr>
</table>


Tabla `argument_expression`


<table>
  <tr>
   <td><a href="http://localhost:8080/h2-console/query.do?jsessionid=6b1155161c88e03a52366b62fdc932a4#">DEFAULT_VALUE  </a>
   </td>
   <td><a href="http://localhost:8080/h2-console/query.do?jsessionid=6b1155161c88e03a52366b62fdc932a4#">ID_ARGUMENT_EXPRESSION  </a>
   </td>
   <td><a href="http://localhost:8080/h2-console/query.do?jsessionid=6b1155161c88e03a52366b62fdc932a4#">ID_FEE  </a>
   </td>
  </tr>
  <tr>
   <td><em>null</em>
   </td>
   <td>1
   </td>
   <td>1
   </td>
  </tr>
  <tr>
   <td><em>null</em>
   </td>
   <td>2
   </td>
   <td>1
   </td>
  </tr>
  <tr>
   <td><em>null</em>
   </td>
   <td>3
   </td>
   <td>2
   </td>
  </tr>
  <tr>
   <td>0.5
   </td>
   <td>4
   </td>
   <td>2
   </td>
  </tr>
  <tr>
   <td><em>null</em>
   </td>
   <td>5
   </td>
   <td>3
   </td>
  </tr>
  <tr>
   <td>0.1
   </td>
   <td>6
   </td>
   <td>3
   </td>
  </tr>
</table>




**Ejercicio 3**

La consulta imprime el índice del cursor y nombre de los 10 primeros empleados según el orden físico de la tabla.

**Ejercicio 4**

La función **no compila** porque en su firma indica que retorna un dato de tipo numérico pero en su cuerpo falta la sentencia RETURN.

**Ejercicio 5**

El script se encuentra en el directorio /bash.
