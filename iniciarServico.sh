#!/bin/bash

# Iniciar o PostgreSQL primeiro
/etc/init.d/postgresql start

# Aguardar até que o PostgreSQL esteja pronto para aceitar conexões (pode variar dependendo da sua configuração)
while ! pg_isready -h localhost -p 5432 > /dev/null 2> /dev/null; do
    sleep 1
done

# Iniciar a aplicação Spring Boot
java -jar /app/sua-aplicacao.jar