<h1 align="center">
  Spring Boot Clean Architecture Client
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Youtube&message=@jppreti&color=8257E5&labelColor=000000" alt="@jppreti" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Demo&color=8257E5&labelColor=000000" alt="Demo" />
</p>

Demo para ilustrar como implementar um cliente CLI.

# 1. Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Shell]()

# 2. Como Executar

- Clonar repositório git:
```shell
git clone https://github.com/ifmt-cba/spring-boot-cleanarch-client-cli.git
```

## 2.1 Sem o uso de contêiner

- Construir o projeto:
```shell
./mvnw clean package
```
- Executar:
```shell
java -jar ./target/spring-boot-cleanarch-client-cli-v1.0.jar
help
```

## 2.2. Com Docker

- Construir os projetos:
```shell
./build.sh
```
- Executar:
```shell
docker run --name cli -it br.edu.ifmt/cleanarch-cli
help
```