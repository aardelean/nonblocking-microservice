package home.microservice.nonblocking;

import co.paralleluniverse.fibers.jdbc.FiberDataSource;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class JOOQConfiguration {

    @Bean
    public DSLContext context(DataSource dataSource) throws SQLException {
        return DSL.using(FiberDataSource.wrap(dataSource)
                .getConnection());
    }

}
