package com.uol.ms.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class CodinameService {
    private Environment env;
    private  final RestTemplate restTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    private List<String> avengersCodinameList = new ArrayList<>();
    private List<String> justiceLeagueCodinameList = new ArrayList<>();


    public List<String> getAvengersCodinameList () {
        return this.avengersCodinameList;
    }

    public List<String> getJusticeLeagueCodinameList () {
        return this.justiceLeagueCodinameList;
    }


    public CodinameService(Environment env, RestTemplate restTemplate) {
        this.env = env;
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void loadJsonData(){

        try {
            String response = restTemplate.getForObject(env.getProperty("avangers"), String.class);
            JsonNode node = objectMapper.readTree(response);
            ArrayNode avengers = (ArrayNode) node.get("vingadores");

            for (JsonNode item: avengers){
                this.avengersCodinameList.add(item.get("codinome").asText());

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void loadXMLData(){

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder  = factory.newDocumentBuilder();
            Document document = builder.parse(env.getProperty("justice.league"));


            NodeList list = document.getElementsByTagName("codiname");

            for (int i = 0; i < list.getLength(); i++) {
                Element e = (Element) list.item(i);
                String cod = e.getTextContent();
                this.justiceLeagueCodinameList.add(cod);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
