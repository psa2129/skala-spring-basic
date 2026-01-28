package com.skala.basic.data;

import lombok.Data;

@Data
public class HelloRequest {
  private int id;
  private String name;
  private String address;

 /*@NotBlank
  private String name;

  @Email
  private String email;

  @Min(18)
  private int age; */
}
