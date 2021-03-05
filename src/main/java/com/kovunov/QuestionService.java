package com.kovunov;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class QuestionService {
    private List<String> results;

    @PostConstruct
    private void populateMap() {
        results = new ArrayList<>();
        results.add("T3R0YXdh");
        results.add("Q2FwZSBEZXpobmV2");
        results.add("TWF1bmEgS2Vh");
        results.add("U2FyZ2Fzc28gc2Vh");
        results.add("U3VkYW4=");
        results.add("RWN1YWRvciBhbmQgQ2hpbGU=");
    }

    public List<String> getResults() {
        return results;
    }
}
