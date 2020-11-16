mvn clean compile liquibase:generateChangeLog

mvn clean compile liquibase:diff

# shellcheck disable=SC1083
mvn clean compile liquibase:rollback -Dliquibase.rollbackTag=%{tag}

mvn clean compile liquibase:rollback -Dliquibase.rollbackDate=%{date:'yyyy-MM-ddTHH:mm:ss','yyyy-MM-dd'}