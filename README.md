``` mermaid

stateDiagram-v2
    [*] --> E1

    state "E1: Idle" as E1
    state "E2: Selección de bebida (botones 1-6)" as E2
    state "E3: No hay bebida" as E3
    state "E4: ¿Añadir azúcar? (Sí/No)" as E4
    state "E5: Preparación sin azúcar" as E5
    state "E6: Selección de azúcar (niveles 1-5)" as E6
    state "E7: Error: no hay azúcar" as E7
    state "E8: Preparación con azúcar" as E8
    state "E9: Recoger café" as E9

    E1 --> E2: Introducir moneda
    E2 --> E3: Seleccionar bebida / no disponible
    E3 --> E1: Mostrar aviso y volver a Idle
    E2 --> E4: Seleccionar bebida / disponible

    E4 --> E5: Elegir No
    E4 --> E6: Elegir Sí

    E5 --> E9: Preparación terminada
    E6 --> E7: Seleccionar nivel 1-5 / no hay azúcar
    E7 --> E4: Mostrar error y volver a elegir
    E6 --> E8: Seleccionar nivel 1-5 / hay azúcar

    E8 --> E9: Preparación terminada
    E9 --> E1: Café recogido

```

| Estado | Nombre | Función |
|---|---|---|
| E1 | Idle | Espera a que el usuario introduzca una moneda. |
| E2 | Selección de bebida | Permite elegir una bebida usando uno de los botones del 1 al 6. |
| E3 | No hay bebida | Informa que la bebida seleccionada no está disponible y vuelve a E1. |
| E4 | Selección de azúcar | Pregunta si se desea añadir azúcar (sí o no). |
| E5 | Preparación sin azúcar | Prepara el café sin azúcar y, al terminar, pasa a E9. |
| E6 | Selección de cantidad de azúcar | Permite elegir un nivel de azúcar del 1 al 5. |
| E7 | Error: no hay azúcar | Informa que no hay azúcar y vuelve a E4. |
| E8 | Preparación con azúcar | Prepara el café con la cantidad de azúcar elegida y, al terminar, pasa a E9. |
| E9 | Recoger café | Espera a que se recoja el café y después vuelve a E1. |


| Estado de origen | Transición / condición | Estado de destino |
|---|---|---|
| E1: Idle | Se introduce una moneda | E2: Selección de bebida |
| E2: Selección de bebida | La bebida seleccionada no está disponible | E3: No hay bebida |
| E3: No hay bebida | Se muestra el aviso | E1: Idle |
| E2: Selección de bebida | La bebida seleccionada está disponible | E4: Selección de azúcar |
| E4: Selección de azúcar | Se elige «No» | E5: Preparación sin azúcar |
| E4: Selección de azúcar | Se elige «Sí» | E6: Selección de cantidad de azúcar |
| E5: Preparación sin azúcar | Termina la preparación | E9: Recoger café |
| E6: Selección de cantidad de azúcar | Se elige un nivel del 1 al 5 y hay azúcar disponible | E8: Preparación con azúcar |
| E6: Selección de cantidad de azúcar | Se elige un nivel del 1 al 5 y no hay azúcar | E7: Error: no hay azúcar |
| E7: Error: no hay azúcar | Se muestra el error | E4: Selección de azúcar |
| E8: Preparación con azúcar | Termina la preparación | E9: Recoger café |
| E9: Recoger café | Se recoge el café | E1: Idle |