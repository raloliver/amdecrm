# README

### Configurar arquivo application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/dbname?useTimezone=true&serverTimezone=Europe/Lisbon
spring.datasource.username=username
spring.datasource.password=password
```

**define a forma como o db vai atualizar as tabelas**
`spring.jpa.hibernate.ddl-auto=update`
**imprime no console a sql gerada a partir das alterações no db**
`spring.jpa.show-sql=true`~

### Porta 8080 em uso

```
netstat -ano | findstr 8080
taskkill /F /PID *<pid>*
```

# DEMO (vídeo)

![DEMO video](https://i.imgur.com/uN84DEx.png "Demo em vídeo")