package vn.edu.tvu.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("prod")
public class DatabaseConfig {
    
    @Bean
    public DataSource dataSource() {
        String databaseUrl = System.getenv("DATABASE_URL");
        
        if (databaseUrl != null && databaseUrl.startsWith("postgres://")) {
            // Render format: postgres://user:pass@host:port/db
            // Convert to JDBC format: jdbc:postgresql://user:pass@host:port/db
            databaseUrl = databaseUrl.replace("postgres://", "jdbc:postgresql://");
        } else if (databaseUrl != null && databaseUrl.startsWith("postgresql://")) {
            // Also handle postgresql:// format
            databaseUrl = "jdbc:" + databaseUrl;
        }
        
        return DataSourceBuilder
            .create()
            .url(databaseUrl)
            .build();
    }
}
