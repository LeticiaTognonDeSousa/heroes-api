package com.digitalinnovationone.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import static com.digitalinnovationone.heroesapi.constans.HeroesConstant.REGION_DYNAMO;
import static com.digitalinnovationone.heroesapi.constans.HeroesConstant.ENDPOINT_DYNAMO;

public class HeroesData {
    public static void main(String[] args) throws Exception{
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO,REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Table");
        Item hero1 = new Item()
                .withPrimaryKey("id", 1)
                .withString("Name", "Viúva Negra")
                .withString("Universe", "Marvel")
                .withNumber("Films", 5);

        Item hero2= new Item()
                .withPrimaryKey("id", 2)
                .withString("Name", "Mulher-Maravilha")
                .withString("Universe", "DC Comics")
                .withNumber("Films", 4);

        PutItemOutcome outcome1 = table.putItem(hero1);
        PutItemOutcome outcome2 = table.putItem(hero2);
    }
}
