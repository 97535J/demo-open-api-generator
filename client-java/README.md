Étapes pour réaliser la démo

1. Ajouter le plugin open-api-generator en mode client dans le pom.xml
et preciser dans le inputSpec l'url de la spec open api servie par le serveur
```
<plugin>
    <groupId>org.openapitools</groupId>
    <artifactId>openapi-generator-maven-plugin</artifactId>
    <version>7.10.0</version>
    <executions>
        <execution>
            <id>generate-client</id>
            <goals>
                <goal>generate</goal>
            </goals>
            <configuration>
                <inputSpec>http://localhost:8080/petstore-open-api.yaml</inputSpec>
                <generatorName>java</generatorName>
                <library>resttemplate</library>
                <output>${project.build.directory}/generated-sources/openapi</output>
                <modelPackage>com.example.client.model</modelPackage>
                <apiPackage>com.example.client.api</apiPackage>
                <invokerPackage>com.example.client.invoker</invokerPackage>
                <configOptions>
                    <dateLibrary>java8</dateLibrary>
                    <serializableModel>true</serializableModel>
                    <useSpringBoot3>true</useSpringBoot3>
                    <generateBuilders>true</generateBuilders>
                    <skipDefaultInterface>true</skipDefaultInterface>
                    <useJakartaEe>true</useJakartaEe>
                </configOptions>
            </configuration>
        </execution>
    </executions>
</plugin>
```

2. Clean + install pour générer les classes.

3. Tester en utilisant les classes clientes générées (via un CommandLineRunner par exemple)

```
public void run(String... args) throws Exception {
   PetApi petApi = new PetApi();
   Pet pet = petApi.getPetById(22L);
   System.out.println(pet);
}
```
