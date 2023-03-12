package hello.core.member;

public record Member(
        Long id,
        String name,
        Grade grade
) { }
