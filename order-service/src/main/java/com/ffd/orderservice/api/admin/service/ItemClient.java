package com.ffd.orderservice.api.admin.service;

import com.ffd.orderservice.api.model.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "item-service", url = "http://localhost:8081") // item-service는 호출하려는 서비스의 이름, url은 해당 서비스의 주소입니다.
public interface ItemClient {

    @GetMapping("/items/{itemId}") // item-service에서 Item 상세 정보를 가져오는 엔드포인트의 경로입니다.
    Item findDetail(@PathVariable("itemId") Long itemId);

    @PostMapping("/items/{itemId}/decreaseStock") // 재고를 감소시키는 엔드포인트의 경로입니다.
    void decreaseStock(@PathVariable("itemId") Long itemId, @RequestBody Long stock);
}
