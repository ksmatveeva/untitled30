package service;
import model.CatFact;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CatFactsTest {

    private CloseableHttpClient httpClient;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        httpClient = HttpClientBuilder.create().build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testFetchCatFacts() throws IOException {
        HttpGet request = new HttpGet("https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats");
        CloseableHttpResponse response = httpClient.execute(request);
        assertNotNull(response);

        List<CatFact> catFacts = objectMapper.readValue(response.getEntity().getContent(), objectMapper.getTypeFactory().constructCollectionType(List.class, CatFact.class));
        assertNotNull(catFacts);
        assertFalse(catFacts.isEmpty());

        response.close();
    }

    @Test
    public void testFilterCatFactsByUpvotes() throws IOException {
        HttpGet request = new HttpGet("https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats");
        CloseableHttpResponse response = httpClient.execute(request);
        List<CatFact> catFacts = objectMapper.readValue(response.getEntity().getContent(), objectMapper.getTypeFactory().constructCollectionType(List.class, CatFact.class));

        assertNotNull(catFacts);
        assertFalse(catFacts.isEmpty());

        List<CatFact> filteredCatFacts = catFacts.stream()
                .filter(fact -> fact.getUpvotes() != null && fact.getUpvotes() > 0)
                .toList();

        assertFalse(filteredCatFacts.isEmpty());
        assertTrue(filteredCatFacts.stream().allMatch(fact -> fact.getUpvotes() != null && fact.getUpvotes() > 0));

        response.close();
    }
}
