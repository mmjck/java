package com.btg.orders_ms.adapters.persistence;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;
import com.btg.orders_ms.application.port.outgoing.LoadOrderPort;
import com.btg.orders_ms.application.port.outgoing.SaveOrderPort;
import com.btg.orders_ms.entity.OrderEntity;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Component
public class OrderRepository implements LoadOrderPort, SaveOrderPort {
    private final SpringDataOrderRepository repository;
    private final MongoTemplate mongoTemplate;

    public OrderRepository(SpringDataOrderRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;

    }


    @Override
    public OrderEntity save(OrderEntity entity) {
        return this.repository.save(entity);
    }
    
    @Override
    public BigDecimal findTotalOnOrdersByCustomerId(Long customerId){
        var aggregations = newAggregation(
            match(
                Criteria.where("customerId").is(customerId)),
            group().sum("total").as("total")
        );

        var response = mongoTemplate.aggregate(aggregations, "tb_orders", Document.class);

        return new BigDecimal(response.getUniqueMappedResult().get("total").toString());
    }


    @Override
    public Optional<OrderEntity> findById(Long id) {
        return repository.findById(id);
    }


    @Override
    public List<OrderEntity> findAll() {
        return repository.findAll();
    }


    @Override
    public Page<OrderEntity> findAllByCustomerId(Long customerId, PageRequest pageRequest) {
        var orders =  repository.findAllByCustomerId(customerId, pageRequest);
        return orders;
        // return orders.map(OrderResponse::fromEntity);
    }



}
