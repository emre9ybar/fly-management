package com.flyroute.fly.service;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T,R,X,P,Y> {
    T save(R t);


    T update(X x);

    List<P> findAll();

    Optional<Y> findById(int id);

    void deleteById(int id);

}
