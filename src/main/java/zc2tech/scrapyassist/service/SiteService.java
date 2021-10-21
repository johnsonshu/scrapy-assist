package zc2tech.scrapyassist.service;


import java.util.List;

import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import zc2tech.scrapyassist.entity.Site;


//@Service
public class SiteService {
    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoTemplate mongoTemplate;

    // private final RoomRepository roomRepository;

    public SiteService() {
        // this.roomRepository = roomRepository;
    }

    public List<Site> getAllSites(){
        MongoOperations mongoOps = mongoTemplate;
        List<Site> result = mongoOps.findAll(Site.class);

        // return roomRepository.findAll();
        return result;
    }

    public Site getById(long id) {
        // return roomRepository.findById(id).get();
        return null;
    }
}
