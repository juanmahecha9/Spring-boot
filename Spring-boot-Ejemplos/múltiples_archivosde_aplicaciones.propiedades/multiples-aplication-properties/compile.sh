#!/bin/bash

case $1 in
    dev)
        mvn clean install -Pdev
        ;;
    test )
           mvn clean install -Ptest
        ;;
    prod)
            mvn clean install -Pprod
        ;;
    *)
        echo "Archivo de configuración no encontrado"
        ;;
esac