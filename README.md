# persistence-demo

Spring Boot 4.1 + Spring MVC + MyBatis + PostgreSQL. Java 25.

## Run

1. Start Postgres (or point at an existing one via `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`):

   ```bash
   docker compose up -d
   ```

2. Start the app (creates the `book` table from `schema.sql` on startup):

   ```bash
   mvn spring-boot:run
   ```

## API

| Method | Path                    | Notes                        |
|--------|-------------------------|------------------------------|
| GET    | `/api/books?author=...` | `author` filter is optional  |
| GET    | `/api/books/{id}`       | 404 if missing               |
| POST   | `/api/books`            | 201 + `Location` header      |
| PUT    | `/api/books/{id}`       |                              |
| DELETE | `/api/books/{id}`       | 204                          |

```bash
curl -X POST localhost:8080/api/books -H "Content-Type: application/json" \
  -d '{"title":"Dune","author":"Frank Herbert","isbn":"9780441013593","price":9.99}'
```

## Layout

- `mapper/BookMapper.java` – MyBatis `@Mapper` interface
- `resources/mapper/BookMapper.xml` – the SQL (dynamic `<where>`/`<if>` filter, generated keys)
- `service/BookService.java` – transactional service
- `web/BookController.java` – REST controller, validation, ProblemDetail errors
