package stream;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Streams<T> {

    private Stream<? extends T> stream;

    public Streams(Collection<? extends T> collection) {
        this.stream = collection.stream();
    }

    public static <T> Streams<T> of(Collection<T> collection) {
            return new Streams<>(collection);
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        this.stream = this.stream.filter(predicate);
        return this;
    }

    public Streams<T> transform(UnaryOperator<T> function) {
        this.stream = this.stream.map(function);
        return this;
    }

    public Map toMap(Function<? super T, ?> key, Function<? super T, ?> value) {
        return this.stream.collect(Collectors.toMap(key, value));
    }
    public List<T> toLIst(){
        return this.stream.collect(toList());
    }
}

