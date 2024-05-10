package kr.co.petfriends.library;

import java.util.UUID;
import kr.co.petfriends.library.pg.PayPreparePort;
import kr.co.petfriends.library.pg.domain.PayMethod;
import kr.co.petfriends.library.pg.domain.PayPrepareRequest;
import kr.co.petfriends.library.pg.domain.PayPrepareResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final PayPreparePort payPreparePort;

    @GetMapping("/pg/prepare")
    public ResponseEntity<PayPrepareResponse> prepare() {
        PayPrepareRequest request = PayPrepareRequest.builder()
            .payMethod(PayMethod.KAKAO_PAY)
            .payKey(UUID.randomUUID().toString())
            .build();
        PayPrepareResponse prepare = payPreparePort.prepare(request);

        return ResponseEntity.ok(prepare);
    }

}
