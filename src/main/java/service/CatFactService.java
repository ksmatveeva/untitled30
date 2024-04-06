package service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.CatFact;

public class CatFactService {

    public List<CatFact> fetchCatFacts() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats");
        CloseableHttpResponse response = httpClient.execute(request);
        ObjectMapper objectMapper = new ObjectMapper();
        List<CatFact> catFacts = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<List<CatFact>>() {});
        httpClient.close();
        return catFacts;
    }

    public List<CatFact> filterCatFactsByUpvotes(List<CatFact> catFacts) {
        return catFacts.stream()
                .filter(fact -> fact.getUpvotes() != null && fact.getUpvotes() > 0)
                .collect(Collectors.toList());
    }
}

