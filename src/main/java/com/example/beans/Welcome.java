package com.example.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Welcome {
public Welcome(String message) {
super();
this.message = message;
}
private final String message;
public String getMessage() {
return message;
}
}
