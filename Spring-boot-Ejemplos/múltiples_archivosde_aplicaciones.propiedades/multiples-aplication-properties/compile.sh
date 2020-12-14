#!/bin/bash

case $1 in
    dev)
        mvn clean install -Pdev
        ;;
    test )
           mvn clean install -Ptest
        ;;
    pro)
            mvn clean install -Pprod
        ;;
    *)
        echo "Archivo de configuración no encontrado"
        ;;
esac