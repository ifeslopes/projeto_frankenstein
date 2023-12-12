
FROM adoptopenjdk/openjdk11:alpine

RUN adduser -S appuser
USER appuser

VOLUME /tmp

ENV SERVER_PORT 8080

EXPOSE 8081

ARG DEPENDENCY=target/dependency

COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib

COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT java -cp app:app/lib/* \
    -Dspring.profiles.active="dev" \
    com.home.crudPessoa.CrudPessoaApplication
#FROM openjdk:17-jdk-slim
#
## Copie os arquivos necessários (aplicação, script de inicialização)
#COPY target/crudPessoa-0.0.1-SNAPSHOT.jar /app/crudPessoa-0.0.1-SNAPSHOT.jar
#COPY iniciarServico.sh /app/iniciarServico.sh
#
#
## Instalação do PostgreSQL
#RUN apt-get update && \
#    apt-get install -y postgresql && \
#    apt-get clean && \
#    rm -rf /var/lib/apt/lists/*
#
## Configuração do PostgreSQL
#ENV POSTGRES_DB=pessoacrud
#ENV POSTGRES_USER=lopes
#ENV POSTGRES_PASSWORD=123
#ENV POSTGRES_HOST=localhost
#ENV POSTGRES_PORT=5432
#
## Define a porta que a aplicação expõe
#EXPOSE 8080
#
## Comando para iniciar a aplicação quando o contêiner for executado
#CMD ["/bin/bash", "/app/iniciarServico.sh"]