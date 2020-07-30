package guru.springframework.msscinventoryfailover.web;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class RouterConfig {

  @Bean
  public RouterFunction inventoryFunction(InventoryHandler handler) {
    return route(GET("/inventory-failover").and(accept(MediaType.APPLICATION_JSON)), handler::list);
  }
}
