package com.manuelhg.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data //GENERA GETTERS Y SETTERS//
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Module {

    private String Code;
    private String name;

}
