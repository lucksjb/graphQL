# GraphQL and Spring Boot




## Conceitos   
Resolvers :
* Mutation - faz alterações de estado na aplicação. Deve implementar a interface GraphQLMutationResolver e ser um @Component spring   
* Query - faz as pesquisas. Devem implementar a interface GraphQLQueryResolver e ser um @Component spring   

## GraphQL e spring  
* [Cria-se um arquivo de definição dos mutations e querys](src/main/resources/schema.graphqls)   
* [Cria-se um ou mais resolver para os mutations](src/main/java/com/example/graphqldemo/resolvers/EntityMutationResolver.java)   
* [Cria-se um ou mais resolver para as querys](src/main/java/com/example/graphqldemo/resolvers/EntityQueryResolver.java)   

## No [application.properties](src/main/resources/application.properties)
### Configuração do GraphQL   
```
graphql.servlet.mapping=/graphql
graphql.servlet.enabled=true
graphql.servlet.exception-handlers-enabled= true
graphql.servlet.contextSetting= PER_REQUEST_WITH_INSTRUMENTATION
```

### Configuração do GraphiQL (ui para consulta no navegador)   
```
graphiql.mapping= /graphiql
graphiql.endpoint.graphql= /graphql
graphiql.static.basePath= /
graphiql.enabled= true
graphiql.pageTitle= GraphiQL
graphiql.props.resources.defaultQuery= schema.graphqls
graphiql.props.variables.editorTheme= "solarized light"
```


## [Dependências necessárias](/pom.xml)
```
<!-- GraphQL -->
		<dependency>
			<groupId>com.graphql-java-kickstart</groupId>
			<artifactId>graphql-spring-boot-starter</artifactId>
			<version>7.0.1</version>
		</dependency>
		<!-- to embed GraphiQL tool -->
		<dependency>
			<groupId>com.graphql-java-kickstart</groupId>
			<artifactId>graphiql-spring-boot-starter</artifactId>
			<version>7.0.1</version>
			<scope>runtime</scope>
		</dependency>
```
### Para acessar   
http://localhost:8080/graphiql  


## Artigos

[GraphQL API Server using Spring Boot & Spring Data JPA: A How-to Guide | Medium](https://medium.com/@md.ali.azam/graphql-api-server-using-spring-boot-jpa-41ac1f6ad1c)

[A Gentle Introduction To Graph Theory | by Vaidehi Joshi | basecs | Medium](https://medium.com/basecs/a-gentle-introduction-to-graph-theory-77969829ead8)

[Part 1\] | by Vaidehi Joshi | basecs | Medium](https://medium.com/basecs/whats-a-linked-list-anyway-part-1-d8b7e6508b9d#.3zvtp22ui)

[GraphQL | A query language for your API](https://graphql.org/)
[Sobre querys no GraphQL] https://graphql.org/learn/queries/   

https://github.com/graphql-java-kickstart   
[Ferramenta para testar](https://www.electronjs.org/apps/graphiql)   
[GraphQL with Postman](https://learning.postman.com/docs/postman/sending-api-requests/graphql/)   
[Ferramenta GraphiQL - utilizada como interface de pesquisa](https://github.com/graphql/graphiql)   

