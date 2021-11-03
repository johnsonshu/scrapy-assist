package zc2tech.scrapyassist.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import zc2tech.scrapyassist.repo.WomenadvancencRepo;

@Service
public class BeanFactoryDynamicAutowireService {
    private static final String SERVICE_NAME_SUFFIX = "repoService";
    private final BeanFactory beanFactory;

    @Autowired
    public BeanFactoryDynamicAutowireService(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     *
     * @param urlShortContext "www-womenadvancenc-org"
     * @return
     */
    public MongoRepository getRepo(String urlShortContext) {

        MongoRepository repo = null;

        switch(urlShortContext) {
            case "www-womenadvancenc-org":
                repo = beanFactory.getBean(WomenadvancencRepo.class);
                break;
        }

        return repo;
    }

    private String getRegionServiceBeanName(String isoCountryCode) {
        return isoCountryCode + SERVICE_NAME_SUFFIX;
    }
}
