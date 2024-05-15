Objetivo:

- [ ] Entregar el diseño (diagrama de clases) 
- [ ] y la implementación en Java de la narrativa que se detalla a continuación:

- [ ] Una facultad requiere de un soporte informático para el manejo de los planes de estudio y de los alumnos de sus carreras.

    - [ ] El sistema debe proveer los siguientes servicios:
        - [X] Agregar carreras.
        - [X] Definir el Plan de Estudios para cada carrera.
        - [X] Inscripción de alumnos a una carrera:
            - [X] Inscripción de alumnos a las materias de acuerdo al plan de estudios de la carrera. 
            - [X] Inscribir un alumno en una materia si la puede cursar.
        - [ ] Informar al alumno cuales son las materias que está en condiciones de cursar.
        - [X] Verificar si el alumno finalizo la carrera.

        - [X] Cada carrera incluye materias obligatorias y materias optativas. 
        - [X] Para graduarse un alumno debe aprobar todas las materias obligatorias de la carrera y aprobar una cierta cantidad de materias optativas (no la totalidad de las materias optativas). La cantidad de materias optativas depende de la carrera.

    - [X] Para aprobar una materia se debe rendir primero un parcial y luego un final. Adicionalmente existe un régimen de promoción para algunas materias para aquellos alumnos que aprobaran la cursada (parcial).

    - [X] Tenga en cuenta que las condiciones para que un alumno pueda cursar una materia varían de acuerdo al plan de estudios de la carrera:
    - [X] Plan A: aprobó las cursadas de las correlativas
    - [X] Plan B: aprobó los finales de las correlativas
    - [X] Plan C: aprobó las cursadas de las correlativas y los finales de todas las materias de 5 cuatrimestres previos al que se quiere anotar
    - [X] Plan D: aprobó las cursadas de las correlativas y los finales de todas las materias de 3 cuatrimestres previos al que se quiere anotar
    - [X] Plan E: aprobó los finales de las correlativas y los finales de todas las materias de 3 cuatrimestres previos.

    - [X] Funcionalidad mínima a ser entregada.
        - [X] Interface visual (swing) para los siguientes puntos:
            - [X] Alta de alumnos.
            - [X] Alta de carreras y Planes de Estudio.
            - [X] Inscripción de un alumno a una carrera.
            - [X] Inscripción de un alumno a una materia.
            - [X] Verificar si un alumno terminó la carrera.

    - [ ] Configure de manera estática alumnos, carreras y planes de estudio, para poder demostrar el funcionamiento del sistema.