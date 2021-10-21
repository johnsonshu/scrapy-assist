package zc2tech.scrapyassist.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.Arrays;

//@Configuration
public class MongoConfig {
    Logger log = LoggerFactory.getLogger(MongoConfig.class);
    private final MongoProperties properties;

    public MongoConfig(MongoProperties properties) {
        this.properties = properties;
    }

    //@Bean
    public MongoClient mongo() throws IOException {
        log.info("Creating mongo client. Database: {}, Host: {}",
                properties.getDatabase(), properties.getHost()
        );
        // MongoCredential credential = MongoCredential.createCredential(properties.getUsername(), properties.getDatabase(), readPassword(properties.getPasswordFilePath()).toCharArray());

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToClusterSettings(builder ->
                        builder.hosts(
                                Arrays.asList(new ServerAddress(properties.getHost(), properties.getPort()))))
                .build();

        return MongoClients.create(settings);
    }

    //@Bean
    public MongoTemplate mongoTemplate() throws IOException {
        return new MongoTemplate(mongo(), properties.getDatabase());
    }

    //@PreDestroy
    public void destroy() throws IOException {
        mongo().close();
    }

    private String readPassword(String path) throws IOException {
        // return Files.readString(Paths.get(path));
        return "****";
    }
}
