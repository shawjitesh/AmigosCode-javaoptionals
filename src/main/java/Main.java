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

            Person jitesh = new Person("Jitesh", "jiteshshaw93@gmail.com");
            System.out.println("Email: " + jitesh.getEmail().map(String::toUpperCase).orElse("email not provided"));
            Person pawan = new Person("Pawan", null);
            System.out.println("Email: " + pawan.getEmail().map(String::toUpperCase).orElse("email not provided"));

            // unwrapping Optional
            if(pawan.getEmail().isPresent()) {
                String email = pawan.getEmail().get();
                System.out.println("Email: " + email.toUpperCase());
            } else {
                System.out.println("Email: email not provided");
            }
        }
    }
}

class Person {
    private final String name;
    private final String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}