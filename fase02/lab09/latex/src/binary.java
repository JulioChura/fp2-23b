function busqueda_binaria (datos, valor_busqueda):
    inicio = 0
    fin = longitud (datos) - 1
    mientras inicio <= fin:
        medio = (inicio + fin) // 2
        si datos [medio] == valor_busqueda:
            devolver medio
        sino si datos [medio] < valor_busqueda:
            inicio = medio + 1
        sino:
            fin = medio - 1
    devolver -1
