package zc2tech.scrapyassist.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import zc2tech.scrapyassist.entity.Site;

public interface SiteMongoRepository extends MongoRepository<Site,String> {
    Site findByTitle(String title);
}
