package com.tang.interviewprovider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(MockitoExtension.class)
class InterviewProviderApplicationTest {

  private InterviewProviderApplication application;

  @BeforeEach
  void setUp() {
    application = new InterviewProviderApplication();
  }

  @Test
  void provider() {
    assertThat(application).isNotNull();
  }
}