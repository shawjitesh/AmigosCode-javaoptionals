import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> hello = Optional.of("Hello");
        Optional<String> empty = Optional.empty();

        System.out.println(hello.isPresent());
        System.out.println(empty.isEmpty());

        System.out.println(hello.orElse("world"));
        System.out.println(empty.orElse("there"));

        System.out.println(hello.map(String::toUpperCase)
                .orElseGet(() -> {
                    // ... extra computation to retrieve the value
                    return "world";
                }));

        try {
            System.out.println(empty.map(String::toLowerCase)
                    .orElseThrow(IllegalStateException::new));
        } finally {
            empty.ifPresent(System.out::println);

            empty.ifPresentOrElse(System.out::println, () -> System.out.println("empty"));
        }
    }
}
