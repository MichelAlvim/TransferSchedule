# TransferSchedule

### Descrição

- Api responsável por agendamentos de transferencias.
 

### Pré-requisitos 

- Necessário ter o *Maven*, *Docker*, *JAVA 11*, *GIT* instalado.    

### Clonar o projeto

- git clone git@github.com:macedo2300/cvc-teste-api.git
- Entrar na pasta "cvc-teste-api/conect-new-broker-api"


Para rodar o projeto localmente com o maven executar o comando:
- `mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8080` - Este comando irá rodar a aplicação pelo maven

Para rodar o projeto localmente com o docker executar o comando:
- `mvn clean package` - Este comando irá limpar e criar o jar da aplicação.
- `docker build -t cvc .` - Este comando irá criar uma imagem da aplicação.
- `docker run -p 8080:8080 -e PORT=8080 cvc` - Este comando irá exrcutar o conteiner da aplicação

#Exemplo:
(POST)http://localhost:8080/cvc-bank/api/v1/finTransfer
{
	"originAccount": "123456",
    "destinationAccount": "654321",
    "value": 100020.00,
    "schedulingDate": "05/12/2021"
}


(GET)http://localhost:8080/cvc-bank/api/v1/finTransfer?originAccount=123456
 
### Documentação

[SWAGGER DO PROJETO LOCAL](http://localhost:8080/cvc-bank/swagger-ui.html)





