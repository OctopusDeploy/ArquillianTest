package org.example.arquilliantest;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class StartupService {
    @EJB
    private EnterpriseJavaBean enterpriseJavaBean;

    @PostConstruct
    public void postConstruct() {
        for (int i = 0; i < 10; ++i) {
            enterpriseJavaBean.writeToConsole();
        }
        System.out.println("All Done");
    }
}
