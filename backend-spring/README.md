Étapes pour réaliser la démo

1. Créer un fichier de spécification OpenAPI
Crée un fichier de spécifications OpenAPI dans le dossier src/main/resources/static pour décrire ton API.
Par exemple, tu peux utiliser un fichier petstore-open-api.yaml à cette adresse :

https://github.com/97535J/petstore-open-api-spec/blob/main/petstore-open-api.yaml

Emplacement du fichier :
src/main/resources/static/petstore-open-api.yaml

2. Ajouter les dépendances dans le pom.xml
Dans ton fichier pom.xml,
ajoute les dépendances nécessaires pour OpenAPI Generator.

2.1 Ajouter OpenAPI Generator comme plugin
Dans la section <build> de ton pom.xml, ajoute le plugin OpenAPI Generator :
```
<plugin>
    <groupId>org.openapitools</groupId>
    <artifactId>openapi-generator-maven-plugin</artifactId>
    <version>7.10.0</version>
    <executions>
        <execution>
            <goals>
                <goal>generate</goal>
            </goals>
            <configuration>
                <skipValidateSpec>true</skipValidateSpec>
                <inputSpec>./src/main/resources/static/petstore-open-api.yaml</inputSpec>
                <generatorName>spring</generatorName>
                <configOptions>
                    <openApiNullable>false</openApiNullable>
                    <interfaceOnly>true</interfaceOnly>
                    <useSpringBoot3>true</useSpringBoot3>
                    <generateBuilders>true</generateBuilders>
                    <skipDefaultInterface>true</skipDefaultInterface>
                    <useJakartaEe>true</useJakartaEe>
                    <apiPackage>application.openapi.generated.api</apiPackage>
                    <modelPackage>application.openapi.generated.classes</modelPackage>
                    <useTags>true</useTags>
                    <languageSpecificPrimitives>boolean</languageSpecificPrimitives>
                </configOptions>
            </configuration>
        </execution>
    </executions>
</plugin>
```
2.2 Tu peux aussi ajouter ces dependances pour la prise en charge des certaines annotations (@Operations, @Tag ...) :

```
<dependency>
    <groupId>io.swagger.core.v3</groupId>
    <artifactId>swagger-annotations</artifactId>
    <version>2.2.15</version>
</dependency>
<dependency>
    <groupId>jakarta.validation</groupId>
    <artifactId>jakarta.validation-api</artifactId>
    <version>3.0.2</version>
</dependency>
```
3. Configurer Swagger UI (optionnel)
Télécharge swagger UI depuis le github : https://github.com/swagger-api/swagger-ui/releases
Décompresse le ZIP et copie le contenu du dossier dist dans : src/main/resources/static/swagger-ui/
Dans src/main/resources/static/swagger-ui/index.html (ou swagger-initializer), modifie l’URL de la spec => /petstore-open-api.yaml

vérifie le fonctionnement : http://localhost:8080/swagger-ui/index.html

4. Maven clean + install pour générer les classes

5. implementer un endpoint

implementer un controlleur. Par exemple getPetById de PetApi pour renvoyer un objet Pet avec le même ID.
@Override
    public ResponseEntity<Pet> getPetById(Long petId) {
        Pet pet = new Pet();
        return ResponseEntity.ok(pet.id(petId));
    }