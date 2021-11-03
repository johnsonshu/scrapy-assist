package zc2tech.scrapyassist.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import zc2tech.scrapyassist.entity.Site;

import java.util.List;


public interface SiteRepo extends MongoRepository<Site,String> {
    Site findByTitle(String title);

    @Query(value = "{ $or: [ { title : /?0/ }, { url : /?0/ } ] }")
    List<Site> queryByKeyword(String keyword);
}
