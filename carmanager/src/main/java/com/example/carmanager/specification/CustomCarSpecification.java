package com.example.carmanager.specification;

import com.example.carmanager.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class CustomCarSpecification implements Specification<Car> {
    private String field; // colum
    private Object value; // gia tri
    public CustomCarSpecification(String field, Object value){
        this.value=value;
        this.field=field;
    }


    @Override
    public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(field.equalsIgnoreCase("carName")) {
            return criteriaBuilder.like(root.get("carName"), "%" + value.toString() + "%");
        }
        if(field.equalsIgnoreCase("licensePlate")) {
            return criteriaBuilder.like(root.get("licensePlate"), "%" + value.toString() + "%");
        }
        if(field.equalsIgnoreCase("companyName")) {
            return criteriaBuilder.like(root.get("company").get("companyName"), "%" + value.toString() + "%");//acc.getdep().getName()
        }
    return null;
    }
}