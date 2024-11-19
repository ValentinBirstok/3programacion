package clase13;

public class actividad131 {
    
 /*1) . Ejemplos de Acciones posibles del atacante
-Inyección SQL: El atacante intenta manipular la base de datos introduciendo consultas maliciosas a través de formularios web.
-Fuerza bruta de contraseñas: Intentos repetidos de adivinar la contraseña de una cuenta.
-Ataque de denegación de servicio (DoS): Enviar una gran cantidad de solicitudes para saturar el servidor y dejarlo inoperativo.
-Phishing: Intentar engañar a los usuarios para que proporcionen información confidencial mediante páginas falsas.
-Acceso no autorizado: Intentar explotar vulnerabilidades para acceder a áreas restringidas sin permiso.

2) Funciones del Sistema de Detección
-Monitoreo de tráfico: Analizar el tráfico entrante y saliente en busca de patrones sospechosos.
-Detección de anomalías: Identificar comportamientos inusuales que se desvían de los patrones normales de uso.
-Filtrado de IP: Bloquear direcciones IP conocidas por realizar ataques.
-Inspección de paquetes: Examinar el contenido de los paquetes de datos en busca de patrones maliciosos.


Técnicas y herramientas para detectar ataques
-IDS/IPS (Sistemas de Detección y Prevención de Intrusiones): Herramientas como Snort o Suricata pueden detectar patrones conocidos de ataques en el tráfico.
-Firewalls: Para bloquear tráfico no autorizado y escaneo de puertos.
-Análisis de registros: Herramientas como Splunk o ELK Stack para revisar patrones en los registros.
-Análisis de reputación: Evaluar la reputación de direcciones IP, dominios o usuarios

3) Aplicación de la Poda Alfa-Beta en la Detección de Ciberataques
La poda alfa-beta optimiza la detección de ciberataques al evitar analizar rutas innecesarias. El sistema evalúa posibles amenazas y respuestas utilizando un árbol de decisiones:

Alfa--> es la mejor defensa mínima encontrada. Si se identifica una defensa efectiva, alfa se actualiza.
Beta--> es el peor ataque que puede realizar un atacante antes de ser detenido. Beta se ajusta si se detecta un ataque más peligroso

4)                                Inicio
                                  |
       ---------------------------------------------------
      |                     |                    |                    |
Inyección SQL      Fuerza Bruta          DoS                Phishing
      |                     |                    |                    |
  ----------------   ---------------      ------------      ----------------
 |               |   |             |     |          |    |                |
Filtrar IP   Inspección   Restringir   Analizar Logs  Bloquear IP    Filtrar IP
                Paquetes        IP Fuente





    
*/}
