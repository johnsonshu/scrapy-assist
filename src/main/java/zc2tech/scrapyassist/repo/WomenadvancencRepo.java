package zc2tech.scrapyassist.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import zc2tech.scrapyassist.entity.Site;
import zc2tech.scrapyassist.entity.WomenAdvanceNc;

public interface WomenadvancencRepo extends MongoRepository<WomenAdvanceNc,String> {
    Site findByTitle(String title);
}
