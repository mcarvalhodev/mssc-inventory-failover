package guru.springframework.msscinventoryfailover.web;

import guru.springframework.msscinventoryfailover.model.BeerInventoryDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class InventoryHandler {

  public Mono<ServerResponse> list(ServerRequest request) {
    final BeerInventoryDto dto =
        BeerInventoryDto.builder()
            .id(UUID.randomUUID())
            .beerId(UUID.fromString("0000000-00000-000000-000-000000000"))
            .quantityOnHand(999)
            .createdDate(OffsetDateTime.now())
            .lastModifiedDate(OffsetDateTime.now())
            .build();
    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_STREAM_JSON)
        .body(Mono.just(Arrays.asList(dto)), List.class);
  }
}
