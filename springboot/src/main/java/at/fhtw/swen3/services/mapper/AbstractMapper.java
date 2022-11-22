package at.fhtw.swen3.services.mapper;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Slf4j
public abstract class AbstractMapper<S,T> implements Mapper<S, T> {
    public List<T> mapToTarget(Collection<S> object){
        List<T> target = new ArrayList<>();
        object.forEach(o -> target.add(mapToTarget(o)));
        log.info("target:\n{}", target);
        return target;
    }

    public List<S> mapToSource(Collection<T> object){
        List<S> source = new ArrayList<>();
        object.forEach(o -> source.add(mapToSource(o)));
        log.info("source:\n{}", source);
        return source;
    }
}
