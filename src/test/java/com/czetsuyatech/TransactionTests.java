package com.czetsuyatech;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.czetsuyatech.services.BookManagerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class TransactionTests {

  @Autowired
  private BookManagerService bookManagerService;

  @Test
  void whenFindInSameTx() {
    var output = bookManagerService.createAndFindInSameTx();
    assertTrue(output.isPresent());
  }

  @Test
  void whenFindInAnotherTx() {
    var output = bookManagerService.createAndFindInAnotherTx();
    assertTrue(output.isPresent());
  }

  @Test
  void superLongTx() {

    String tx = bookManagerService.superLongTransaction();
    Assertions.assertNotNull(tx);
  }
}

