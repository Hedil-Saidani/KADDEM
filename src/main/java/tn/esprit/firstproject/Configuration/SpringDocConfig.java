package tn.esprit.firstproject.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("TP KADDEM")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("Hedil Saidani 4SAE6")
                .email("hedil.saidani@esprit.tn")
                .url("https://www.linkedin.com/in/**********/");
        return contact;
    }


    @Bean
    public GroupedOpenApi ContratPublicApi() {
        return GroupedOpenApi.builder()
                .group("Gestion des contrats  uniquement")
                .pathsToMatch("/contrat/**")
                .pathsToExclude("**")
                .build();
    }


    @Bean
    public GroupedOpenApi DepartmentPublicApi() {
        return GroupedOpenApi.builder()
                .group("Gestion des départements  uniquement")
                .pathsToMatch("/department/**")
                .pathsToExclude("**")
                .build();
    }


    @Bean
    public GroupedOpenApi EquipePublicApi() {
        return GroupedOpenApi.builder()
                .group("Gestion des équipes  uniquement")
                .pathsToMatch("/equipe/**")
                .pathsToExclude("**")
                .build();
    }



    @Bean
    public GroupedOpenApi DetailEquipePublicApi() {
        return GroupedOpenApi.builder()
                .group("Gestion des détails équipes uniquement")
                .pathsToMatch("/detailequipe/**")
                .pathsToExclude("**")
                .build();
    }



    @Bean
    public GroupedOpenApi EtudiantPublicApi() {
        return GroupedOpenApi.builder()
                .group("Gestion des étudiants uniquement")
                .pathsToMatch("/etudiant/**")
                .pathsToExclude("**")
                .build();
    }


    @Bean
    public GroupedOpenApi UniversitePublicApi() {
        return GroupedOpenApi.builder()
                .group("Gestion des universités uniquement")
                .pathsToMatch("/universite/**")
                .pathsToExclude("**")
                .build();
    }

}
