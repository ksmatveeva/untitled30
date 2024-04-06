import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.CatFact;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String json = "[\n" +
                "  {\n" +
                "    \"id\": \"5b4910ae0508220014ccfe90\",\n" +
                "    \"text\": \"Кошки могут слышать ультразвук и коммуницировать с дельфинами.\",\n" +
                "    \"type\": \"cat\",\n" +
                "    \"user\": \"Alex Petrov\",\n" +
                "    \"upvotes\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5b4910ae0508220014ccfe91\",\n" +
                "    \"text\": \"Кошки могуть создавать более 100 разных звуков, тогда как собаки только около 10.\",\n" +
                "    \"type\": \"cat\",\n" +
                "    \"user\": \"Alex Petrov\",\n" +
                "    \"upvotes\": null\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5b4910ae0508220014ccfe92\",\n" +
                "    \"text\": \"В настоящее время в мире насчитывается около 600 миллионов домашних кошек.\",\n" +
                "    \"type\": \"cat\",\n" +
                "    \"user\": \"Maxim Semenov\",\n" +
                "    \"upvotes\": null\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5b4910ae0508220014ccfe93\",\n" +
                "    \"text\": \"Самой долгоживущей кошкой из всех когда-либо зарегистрированных считается Крим Пафф, прожившая 38 лет и 3 дня.\",\n" +
                "    \"type\": \"cat\",\n" +
                "    \"user\": \"Maxim Semenov\",\n" +
                "    \"upvotes\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5b4910ae0508220014ccfe94\",\n" +
                "    \"text\": \"Обоняние у кошек примерно в 14 раз сильнее человеческого, что позволяет им чувствовать запахи, о которых человек даже не подозревает.\",\n" +
                "    \"type\": \"cat\",\n" +
                "    \"user\": \"Elena Ivanova\",\n" +
                "    \"upvotes\": 9\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5b4910ae0508220014ccfe95\",\n" +
                "    \"text\": \"В то время как в большинстве стран чёрная кошка считается символом несчастья, в Великобритании и Австралии, они, наоборот, рассматриваются как животные, приносящие удачу.\",\n" +
                "    \"type\": \"cat\",\n" +
                "    \"user\": \"Elena Ivanova\",\n" +
                "    \"upvotes\": 3\n" +
                "  }\n" +
                "]";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<CatFact> catFacts = objectMapper.readValue(json, new TypeReference<List<CatFact>>() {});
            for (CatFact catFact : catFacts) {
                System.out.println(catFact.getText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
